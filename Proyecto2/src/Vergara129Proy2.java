package Proyecto2.src;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Vergara129Proy2 extends JFrame {
    private Vector<BotonPieza> botones = new Vector<>();
    private GestorRompecabezas gestor;
    private JLabel lblTiempo, lblMovimientos;
    private JTextField txtNombre;
    private Timer temporizador;
    private int tiempo = 0;
    private int movimientos = 0;
    private boolean juegoActivo = false;
    private JPanel panelJuego, panelInfo;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaTop;

    public Vergara129Proy2() {
        setTitle("Rompecabezas Numérico - Vergara129Proy2");
        setSize(650, 475);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        panelJuego = new JPanel(null);
        panelJuego.setBounds(300, 20, 320, 320);
        add(panelJuego);

        panelInfo = new JPanel(null);
        panelInfo.setBounds(10, 20, 280, 420);
        add(panelInfo);

        JTextArea info = new JTextArea(
                "UNIVERSIDAD TECNOLÓGICA DE PANAMÁ\n" +
                        "FACULTAD DE INGENIERÍA DE SISTEMAS COMPUTACIONALES\n" +
                        "CARRERA: LIC. EN DESARROLLO Y GESTIÓN DE SOFTWARE\n" +
                        "ASIGNATURA: DESARROLLO III\n" +
                        "FACILITADOR: RICARDO CHAN\n" +
                        "ASIGNACIÓN: PROYECTO NO. 2\n" +
                        "ESTUDIANTE: JONATAN VERGARA\n" +
                        "CÉDULA: 8-932-2129\n" +
                        "GRUPO: 1GS221\n" +
                        "CORREO: jonatan.vergara@utp.ac.pa\n" +
                        "FECHA ENTREGA: 6 DE JULIO DE 2025\n");
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 7));
        info.setBounds(10, 300, 240, 100);
        panelInfo.add(info);

        // Crear botones 1-15
        for (int i = 1; i <= 15; i++) {
            BotonPieza boton = new BotonPieza(i, i - 1);
            boton.setBounds(((i - 1) % 4) * 80, ((i - 1) / 4) * 80, 80, 80);
            boton.addActionListener(_ -> {
                if (juegoActivo) {
                    gestor.moverBoton(boton, () -> {
                        movimientos++;
                        lblMovimientos.setText("Movimientos: " + movimientos);
                        if (gestor.estaOrdenado()) {
                            juegoActivo = false;
                            temporizador.stop();
                            verificarGanador();
                        }
                    });
                }
            });

            botones.add(boton);
            panelJuego.add(boton);
        }

        gestor = new GestorRompecabezas(botones, panelJuego);

        // Etiquetas e info
        lblTiempo = new JLabel("Tiempo: 0s");
        lblTiempo.setBounds(10, 10, 150, 25);
        panelInfo.add(lblTiempo);

        lblMovimientos = new JLabel("Movimientos: 0");
        lblMovimientos.setBounds(10, 40, 150, 25);
        panelInfo.add(lblMovimientos);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 70, 100, 25);
        panelInfo.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 70, 180, 25);
        panelInfo.add(txtNombre);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(10, 110, 100, 30);
        btnIniciar.addActionListener(_ -> iniciarJuego());
        panelInfo.add(btnIniciar);

        JButton btnIniciar2 = new JButton("Iniciar2");
        btnIniciar2.setBounds(130, 110, 100, 30);
        btnIniciar2.addActionListener(_ -> {
            if (juegoActivo) {
                gestor.moverUltimo(() -> {
                    movimientos++;
                    lblMovimientos.setText("Movimientos: " + movimientos);
                });
            }
        });

        panelInfo.add(btnIniciar2);

        JButton btnTop5 = new JButton("Consultar Top 5");
        btnTop5.setBounds(10, 150, 220, 30);
        btnTop5.addActionListener(_ -> {
            modeloLista = GestorJugadores.obtenerModeloJList();
            listaTop.setModel(modeloLista);
        });

        panelInfo.add(btnTop5);

        modeloLista = new DefaultListModel<>();
        listaTop = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaTop);
        scroll.setBounds(10, 190, 240, 100);
        panelInfo.add(scroll);

        // Temporizador (1 segundo)
        temporizador = new Timer(1000, _ -> {
            tiempo++;
            lblTiempo.setText("Tiempo: " + tiempo + "s");
        });

        ajustarSegunCedula();

        setVisible(true);
    }

    private void iniciarJuego() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese su nombre.");
            return;
        }
        gestor.mezclar();
        tiempo = 0;
        movimientos = 0;
        juegoActivo = true;
        lblTiempo.setText("Tiempo: 0s");
        lblMovimientos.setText("Movimientos: 0");
        temporizador.start();
    }

    private void verificarGanador() {
        String nombre = txtNombre.getText().trim();
        GestorJugadores.guardarJugador(new Jugador(nombre, tiempo, movimientos));
        modeloLista = GestorJugadores.obtenerModeloJList();
        listaTop.setModel(modeloLista);
        JOptionPane.showMessageDialog(this, "¡Felicidades! Has completado el rompecabezas.");
    }

    private void ajustarSegunCedula() {
        // Cédula termina en impar: info izquierda, juego derecha
        int ultimoDigito = 9; // Cambia si necesitas usar otro
        if (ultimoDigito % 2 == 0) {
            // Par: juego izquierda, info derecha
            panelJuego.setBounds(10, 20, 320, 320);
            panelInfo.setBounds(340, 20, 250, 420);
        } else {
            // Impar: info izquierda, juego derecha
            panelJuego.setBounds(300, 20, 320, 320);
            panelInfo.setBounds(10, 20, 280, 420);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Vergara129Proy2());
    }
}
