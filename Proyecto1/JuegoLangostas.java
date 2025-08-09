package Proyecto1;

import javax.swing.*;
import java.awt.*;

public class JuegoLangostas extends JFrame {

    final int FILAS = 13;
    final int COLUMNAS = 12;
    final int TOTAL = FILAS * COLUMNAS;
    JPanel panelCampo;
    JLabel labelIntentos;
    JTextField campoEnjambre;
    int posicionEnjambre;
    int intentos = 0;
    boolean visible = false;

    public JuegoLangostas() {
        setTitle("Control de Langostas - Proyecto No. 1");
        setSize(950, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelCampo = new JPanel(new GridLayout(FILAS + 1, COLUMNAS + 1));
        crearMapa();

        JPanel panelInfo = crearPanelInformacion();
        posicionEnjambre = (int) (Math.random() * TOTAL);
        campoEnjambre.setText("Oculto");

        panelPrincipal.add(panelCampo, BorderLayout.CENTER);
        panelPrincipal.add(panelInfo, BorderLayout.EAST);
        add(panelPrincipal, BorderLayout.CENTER);
        agregarPuntosCardinales();

        setVisible(true);
    }

    private JPanel crearPanelInformacion() {
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea info = new JTextArea(
            "UNIVERSIDAD TECNOLÓGICA DE PANAMÁ\n" +
            "FACULTAD DE INGENIERÍA DE SISTEMAS COMPUTACIONALES\n" +
            "CARRERA: LIC. EN DESARROLLO Y GESTIÓN DE SOFTWARE\n" +
            "ASIGNATURA: DESARROLLO III\n" +
            "FACILITADOR: RICARDO CHAN\n" +
            "ASIGNACIÓN: PROYECTO NO. 1\n" +
            "ESTUDIANTE: JONATAN VERGARA\n" +
            "CÉDULA: 8-932-2129\n" +
            "GRUPO: 1GS221\n" +
            "CORREO: jonatan.vergara@utp.ac.pa\n" +
            "FECHA ENTREGA: 8 DE JUNIO DE 2025\n"
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 10));

        labelIntentos = new JLabel("Intentos: 0");
        campoEnjambre = new JTextField(10);
        campoEnjambre.setEditable(false);
        campoEnjambre.setText("Oculto");

        JButton btnMostrar = new JButton("Mostrar/Ocultar Enjambre");
        btnMostrar.addActionListener(_ -> {
            visible = !visible;
            campoEnjambre.setText(visible ? "Posición: " + posicionEnjambre : "Oculto");
        });

        panelInfo.add(info);
        panelInfo.add(labelIntentos);
        panelInfo.add(campoEnjambre);
        panelInfo.add(btnMostrar);

        return panelInfo;
    }

    private void crearMapa() {
        panelCampo.add(new JLabel(""));
        for (int x = 1; x <= COLUMNAS; x++) {
            panelCampo.add(new JLabel(String.valueOf(x), SwingConstants.CENTER));
        }
        for (int y = FILAS; y >= 1; y--) {
            panelCampo.add(new JLabel(String.valueOf(y), SwingConstants.CENTER));
            for (int x = 1; x <= COLUMNAS; x++) {
                int numBoton = (y - 1) * COLUMNAS + (x - 1);
                JButton boton = new JButton(String.valueOf(numBoton));
                boton.setPreferredSize(new Dimension(40, 40));
                boton.addActionListener(new BotonListener(this, numBoton));
                panelCampo.add(boton);
            }
        }
    }

    private void agregarPuntosCardinales() {
        add(new JLabel("NORTE", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JLabel("SUR", SwingConstants.CENTER), BorderLayout.SOUTH);
        add(new JLabel("OESTE", SwingConstants.CENTER), BorderLayout.WEST);
        add(new JLabel("ESTE", SwingConstants.CENTER), BorderLayout.EAST);
    }

    public void procesarIntento(int numero) {
        intentos++;
        labelIntentos.setText("Intentos: " + intentos);

        if (numero == posicionEnjambre) {
            JOptionPane.showMessageDialog(this, "¡Capturaste el enjambre! Intentos: " + intentos);
            nuevoJuego();
        } else if (UtilidadesJuego.esAdyacente(numero, posicionEnjambre, COLUMNAS)) {
            JOptionPane.showMessageDialog(this, "El enjambre se asustó y se movió.");
            moverEnjambre();
        } else {
            String direccion = UtilidadesJuego.calcularDireccion(numero, posicionEnjambre, COLUMNAS);
            JOptionPane.showMessageDialog(this, "Sensor: El enjambre está al " + direccion);
        }
    }

    public void moverEnjambre() {
        int nuevo;
        do {
            nuevo = (int) (Math.random() * TOTAL);
        } while (nuevo == posicionEnjambre);
        posicionEnjambre = nuevo;
        campoEnjambre.setText(visible ? "Posición: " + posicionEnjambre : "Oculto");
    }

    public void nuevoJuego() {
        intentos = 0;
        posicionEnjambre = (int) (Math.random() * TOTAL);
        campoEnjambre.setText(visible ? "Posición: " + posicionEnjambre : "Oculto");
        labelIntentos.setText("Intentos: 0");
    }
}

