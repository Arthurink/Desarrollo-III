import javax.swing.*;

public class Grafico {
    JFrame ventana;
    JLabel lbl_nombre;
    JTextField tf_nombre;
    JLabel lbl_apellido;

    public static void main(String[] args) {
        new Grafico();
    }

    Grafico() {
        ventana = new JFrame("Mi ventana");
        ventana.setSize(300, 300);
        ventana.setLayout(null);
        ventana.setLocation(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lbl_nombre = new JLabel("Hola Mundo");
        //lbl_nombre.setLocation(50, 50);
        //lbl_nombre.setSize(70, 20);
        lbl_nombre.setBounds(50, 20, 70, 20); // location, size

        tf_nombre = new JTextField();
        tf_nombre.setBounds(125, 50, 100, 20);
        ventana.add(tf_nombre);

        lbl_apellido = new JLabel("Apellido");
        lbl_apellido.setBounds(50, 75, 70, 20);
        ventana.add(lbl_apellido);
        
        ventana.add(lbl_nombre);
        ventana.setVisible(true);
    }
}
