import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Aleatorio implements ActionListener{
    JFrame ventana;
    JLabel lbl_numero;
    JTextField tf_numero;
    JButton btn_generar;
    Random rnd;
    public static void main(String[] args) {
        new Aleatorio();
    }

    Aleatorio() {
        ventana = new JFrame("Aleatorio");
        ventana.setBounds(100, 100, 300, 300);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_numero = new JLabel("Numero");
        lbl_numero.setBounds(50, 50, 80, 20);
        ventana.add(lbl_numero);

        tf_numero = new JTextField();
        tf_numero.setBounds(135, 50, 50, 20);
        ventana.add(tf_numero);

        btn_generar = new JButton("Generar");
        btn_generar.setBounds(50, 75, 80, 20);
        btn_generar.addActionListener(this);
        ventana.add(btn_generar);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(rnd.nextInt(10));
        tf_numero.setText(String.valueOf(rnd.nextInt(10)));
    }
}