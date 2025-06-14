import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina implements ActionListener
{
    JFrame ventana;
    JLabel lbl_computadora;
    JTextField tf_computadora;
    JButton btn_iniciar;
    Random rnd;

    public static void main(String[] args)
    {
        new Adivina();
    }

    Adivina()
    {
        ventana = new JFrame("Adivina");
        ventana.setBounds(100,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_computadora = new JLabel("Computadora:");
        lbl_computadora.setBounds(50,50,100,20);
        ventana.add(lbl_computadora);

        tf_computadora = new JTextField();
        tf_computadora.setBounds(155,50,50,20);
        ventana.add(tf_computadora);

        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(210,50,80,20);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");

        tf_computadora.setText(String.valueOf(rnd.nextInt(100)+1));
    }
}


