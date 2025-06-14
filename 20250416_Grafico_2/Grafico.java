import javax.swing.*;

public class Grafico
{
    JFrame ventana;
    JLabel lbl_texto, lbl_nombre, lbl_apellido;
    JTextField tf_nombre, tf_apellido;

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

        ventana.setVisible(true);
    }
}

