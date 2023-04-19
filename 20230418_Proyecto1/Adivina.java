import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina implements ActionListener{
    Integer x = 1;
    JFrame ventana;
    JLabel lbl_computadora, lbl_usuario, lbl_mensaje, lbl_intento;
    JTextField tf_numero, tf_intento, tf_mensaje, tf_usuario;
    JButton btn_generar, btn_comparar;
    Random rnd;
    public static void main(String[] args) {
        new Adivina();
    }

    Adivina() {

        ventana = new JFrame("Adivina");
        ventana.setBounds(100, 100, 300, 300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_computadora = new JLabel("Computadora");
        lbl_computadora.setBounds(50, 50, 80, 20);
        ventana.add(lbl_computadora);

        tf_numero = new JTextField();
        tf_numero.setBounds(135, 50, 30, 20);
        ventana.add(tf_numero);

        lbl_usuario = new JLabel("Usuario");
        lbl_usuario.setBounds(50, 75, 80, 20);
        ventana.add(lbl_usuario);

        tf_usuario = new JTextField();
        tf_usuario.setBounds(135, 75, 30, 20);
        ventana.add(tf_usuario);

        lbl_mensaje = new JLabel("Mensaje");
        lbl_mensaje.setBounds(50, 100, 80, 20);
        ventana.add(lbl_mensaje);

        tf_mensaje = new JTextField();
        tf_mensaje.setBounds(135, 100, 120, 20);
        ventana.add(tf_mensaje);

        lbl_intento = new JLabel("Intento");
        lbl_intento.setBounds(50, 125, 80, 20);
        ventana.add(lbl_intento);

        tf_intento = new JTextField();
        tf_intento.setBounds(135, 125, 30, 20);
        ventana.add(tf_intento);

        btn_generar = new JButton("Generar");
        btn_generar.setBounds(50, 150, 80, 20);
        btn_generar.addActionListener(this);
        ventana.add(btn_generar);

        btn_comparar = new JButton("Comparar");
        btn_comparar.setBounds(135, 150, 120, 20);
        btn_comparar.addActionListener(this);
        ventana.add(btn_comparar);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn_generar){
            tf_numero.setText(String.valueOf(rnd.nextInt(1, 100)));
        } else if (e.getSource() == btn_comparar && Integer.parseInt(tf_numero.getText()) > Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Mas Alto");
            tf_intento.setText(String.valueOf(x++));
        } else if (e.getSource() == btn_comparar && Integer.parseInt(tf_numero.getText()) < Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Mas Bajo");
            tf_intento.setText(String.valueOf(x++));
        } else if (e.getSource() == btn_comparar && Integer.parseInt(tf_numero.getText()) == Integer.parseInt(tf_usuario.getText())){
            tf_mensaje.setText("Adivinaste!!!");
            tf_intento.setText(String.valueOf(x++));
        } 
    }
}