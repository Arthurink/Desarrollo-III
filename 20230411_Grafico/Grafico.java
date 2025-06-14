import javax.swing.*;
import java.awt.event.*;

public class Grafico implements ActionListener{
    JFrame ventana;
    JLabel lbl_nombre, lbl_apellido;
    JTextField tf_nombre, tf_apellido;
    JButton btn_escribir, btn_copiar, btn_doble;

    public static void main(String[] args) {
        new Grafico();
    }

    Grafico() {
        ventana = new JFrame("Mi ventana");
        ventana.setSize(600, 600);
        ventana.setLayout(null);
        ventana.setLocation(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lbl_nombre = new JLabel("Nombre");
        //lbl_nombre.setLocation(50, 50);
        //lbl_nombre.setSize(70, 20);
        lbl_nombre.setBounds(50, 50, 75, 20); // location, size
        ventana.add(lbl_nombre);

        lbl_apellido = new JLabel("Apellido");
        lbl_apellido.setBounds(50, 75, 70, 20);
        ventana.add(lbl_apellido);

        tf_nombre = new JTextField("salsa");
        tf_nombre.setBounds(125, 50, 100, 20);
        ventana.add(tf_nombre);

        tf_apellido = new JTextField("pal pescao");
        tf_apellido.setBounds(125, 75, 100, 20);
        ventana.add(tf_apellido);
        
        btn_escribir = new JButton("Escribir");
        btn_escribir.setBounds(50, 100, 80, 20);
        btn_escribir.addActionListener(this);
        ventana.add(btn_escribir);

        btn_copiar = new JButton("Copiar");
        btn_copiar.setBounds(135, 100, 80, 20);
        btn_copiar.addActionListener(this);
        ventana.add(btn_copiar);

        btn_doble = new JButton("Doble");
        btn_doble.setBounds(220, 100, 80, 20);
        btn_doble.addActionListener(this);
        ventana.add(btn_doble);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn_escribir){
            tf_nombre.setText("Juan");    
        } else if (e.getSource() == btn_copiar){
            tf_apellido.setText(tf_nombre.getText());
        } else if (e.getSource() == btn_doble){
            int valor;
            valor = Integer.parseInt(tf_nombre.getText());
            valor = valor * 2;
            tf_apellido.setText(String.valueOf(valor));
        }
    }
}
