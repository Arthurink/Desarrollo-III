import javax.swing.*;
import java.awt.event.*;

public class Grafico implements ActionListener
{
    JFrame ventana;
    JLabel lbl_texto, lbl_nombre, lbl_apellido;
    JTextField tf_nombre, tf_apellido;
    JButton btn_escribir, btn_copiar, btn_doble;

    public static void main(String[] args)
    {
        new Grafico();
    }

    Grafico()
    {
        ventana = new JFrame("Mi Ventana");
        ventana.setSize(300,300);
        ventana.setLocation(200,200);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_texto = new JLabel("Hola Mundo");
        lbl_texto.setSize(100,20);
        lbl_texto.setLocation(50,40);
        ventana.add(lbl_texto);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(50,65,80,20);  // setLocation() + setSize()
        ventana.add(lbl_nombre);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(135,65,120,20);
        ventana.add(tf_nombre);

        lbl_apellido = new JLabel("Apellido:");
        lbl_apellido.setBounds(50,90,80,20);
        ventana.add(lbl_apellido);

        tf_apellido = new JTextField();
        tf_apellido.setBounds(135,90,120,20);
        ventana.add(tf_apellido);

        btn_escribir = new JButton("Escribir");
        btn_escribir.setBounds(50,115,80,20);
        btn_escribir.addActionListener(this);
        ventana.add(btn_escribir);

        btn_copiar = new JButton("Copiar");
        btn_copiar.setBounds(135,115,80,20);
        btn_copiar.addActionListener(this);
        ventana.add(btn_copiar);

        btn_doble = new JButton("Doble");
        btn_doble.setBounds(220,115,80,20);
        btn_doble.addActionListener(this);
        ventana.add(btn_doble);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");

        if (e.getSource() == btn_escribir)
            tf_nombre.setText("Juan");

        if (e.getSource() == btn_copiar)
            tf_apellido.setText(tf_nombre.getText());

        if (e.getSource() == btn_doble)
        {
            int valor;
            valor = Integer.parseInt(tf_nombre.getText());
            tf_apellido.setText(String.valueOf(valor*2));
        }
    }
}




