import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Adivina implements ActionListener
{
    JFrame ventana;
    JLabel lbl_computadora, lbl_usuario, lbl_mensaje, lbl_intentos;
    JTextField tf_computadora, tf_usuario, tf_mensaje, tf_intentos;
    JButton btn_iniciar, btn_verificar;
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
        tf_computadora.setVisible(false);
        ventana.add(tf_computadora);

        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(210,50,80,20);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);

        lbl_usuario = new JLabel("Usuario:");
        lbl_usuario.setBounds(50,75,100,20);
        ventana.add(lbl_usuario);

        tf_usuario = new JTextField();
        tf_usuario.setBounds(155,75,50,20);
        ventana.add(tf_usuario);

        btn_verificar = new JButton("Verificar");
        btn_verificar.setBounds(210,75,90,20);
        btn_verificar.addActionListener(this);
        ventana.add(btn_verificar);

        lbl_mensaje = new JLabel("Mensaje:");
        lbl_mensaje.setBounds(50,100,100,20);
        ventana.add(lbl_mensaje);

        tf_mensaje = new JTextField();
        tf_mensaje.setBounds(155,100,100,20);
        ventana.add(tf_mensaje);

        lbl_intentos = new JLabel("Intentos:");
        lbl_intentos.setBounds(50,125,100,20);
        ventana.add(lbl_intentos);

        tf_intentos = new JTextField("0");
        tf_intentos.setBounds(155,125,50,20);
        ventana.add(tf_intentos);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");

        if (e.getSource() == btn_iniciar)
        {
           tf_computadora.setText(String.valueOf(rnd.nextInt(100)+1));
           btn_iniciar.setEnabled(false);
           //tf_computadora.setText(String.valueOf(rnd.nextInt()));
           //tf_computadora.setText(String.valueOf(rnd.nextInt(5)));
           //tf_computadora.setText(String.valueOf(rnd.nextInt(5,9)));
         }
         else
             if (e.getSource() == btn_verificar)
             {
                 tf_intentos.setText(String.valueOf(Integer.parseInt(tf_intentos.getText())+1));
                 if (tf_usuario.getText().compareTo(tf_computadora.getText())>0)
                    tf_mensaje.setText("Muy Alto");
                 else
                    if (tf_usuario.getText().compareTo(tf_computadora.getText())<0)
                       tf_mensaje.setText("Muy Bajo");
                    else
                    {
                       tf_mensaje.setText("Correcto");
                       btn_iniciar.setEnabled(true);
                    }
             }                  




    }
}


