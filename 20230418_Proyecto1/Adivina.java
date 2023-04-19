import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina implements ActionListener{
    Integer x = 1;
    JFrame ventana;
    JLabel lbl_computadora, lbl_usuario, lbl_mensaje, lbl_intento;
    JTextField tf_numero, tf_intento, tf_mensaje, tf_usuario;
    JButton btn_generar, btn_validar;
    Random rnd;
    public static void main(String[] args) {
        new Adivina();
    }

    Adivina() {

        ventana = new JFrame("Adivina");
        ventana.setBounds(100, 100, 600, 600);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_computadora = new JLabel("Computadora");
        lbl_computadora.setBounds(50, 50, 100, 20);
        ventana.add(lbl_computadora);

        tf_numero = new JTextField();
        tf_numero.setBounds(155, 50, 50, 20);
        ventana.add(tf_numero);

        btn_generar = new JButton("Iniciar");
        btn_generar.setBounds(210, 50, 80, 20);
        btn_generar.addActionListener(this);
        ventana.add(btn_generar);

        lbl_usuario = new JLabel("Usuario");
        lbl_usuario.setBounds(50, 75, 100, 20);
        ventana.add(lbl_usuario);

        tf_usuario = new JTextField();
        tf_usuario.setBounds(155, 75, 50, 20);
        ventana.add(tf_usuario);

        btn_validar = new JButton("Validar");
        btn_validar.setBounds(210, 75, 80, 20);
        btn_validar.addActionListener(this);
        ventana.add(btn_validar);

        lbl_mensaje = new JLabel("Mensaje");
        lbl_mensaje.setBounds(50, 100, 100, 20);
        ventana.add(lbl_mensaje);

        tf_mensaje = new JTextField();
        tf_mensaje.setBounds(155, 100, 100, 20);
        ventana.add(tf_mensaje);

        lbl_intento = new JLabel("Intento");
        lbl_intento.setBounds(50, 125, 100, 20);
        ventana.add(lbl_intento);

        tf_intento = new JTextField();
        tf_intento.setBounds(155, 125, 50, 20);
        ventana.add(tf_intento);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn_generar){
            tf_numero.setText(String.valueOf(rnd.nextInt(1, 100)));
        } else if (e.getSource() == btn_validar && Integer.parseInt(tf_numero.getText()) > Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Muy Bajo");
            tf_intento.setText(String.valueOf(x++));
        } else if (e.getSource() == btn_validar && Integer.parseInt(tf_numero.getText()) < Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Muy Alto");
            tf_intento.setText(String.valueOf(x++));
        } else if (e.getSource() == btn_validar && Integer.parseInt(tf_numero.getText()) == Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Adivinaste!!!");
            tf_intento.setText(String.valueOf(x++));
        } else {
            tf_mensaje.setText("Introduce un valor");
        }
    }
}