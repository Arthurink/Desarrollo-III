import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CompuAdivina implements ActionListener
{

    JFrame ventana;
    JLabel lbl_min, lbl_max, lbl_computadora, lbl_intentos;
    JTextField tf_min, tf_max, tf_computadora, tf_intentos;
    JButton btn_inicio, btn_bajo, btn_alto, btn_correcto;
    Random rnd;

    public static void main(String[] args)
    {
        new CompuAdivina();
    }

    CompuAdivina()
    {
        ventana = new JFrame("Computadora Adivina");
        ventana.setBounds(300,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_min = new JLabel("Min");
        lbl_min.setBounds(50,50,80,20);
        ventana.add(lbl_min);

        tf_min = new JTextField("1");
        tf_min.setBounds(135,50,50,20);
        ventana.add(tf_min);

        lbl_max = new JLabel("Max");
        lbl_max.setBounds(50,75,80,20);
        ventana.add(lbl_max);

        tf_max = new JTextField("100");
        tf_max.setBounds(135,75,50,20);
        ventana.add(tf_max);

        lbl_computadora = new JLabel("Computadora");
        lbl_computadora.setBounds(50,100,80,20);
        ventana.add(lbl_computadora);

        tf_computadora = new JTextField();
        tf_computadora.setBounds(135,100,50,20);
        ventana.add(tf_computadora);

        btn_inicio = new JButton("Inicio");
        btn_inicio.setBounds(190,100,80,20);
        btn_inicio.addActionListener(this);
        ventana.add(btn_inicio);
 
        lbl_intentos = new JLabel("Intentos");
        lbl_intentos.setBounds(50,125,80,20);
        ventana.add(lbl_intentos);

        tf_intentos = new JTextField("0");
        tf_intentos.setBounds(135,125,50,20);
        ventana.add(tf_intentos);

        btn_bajo = new JButton("Bajo");
        btn_bajo.setBounds(50,150,80,20);
        btn_bajo.addActionListener(this);
        btn_bajo.setEnabled(false);
        ventana.add(btn_bajo);
      
        btn_alto = new JButton("Alto");
        btn_alto.setBounds(135,150,80,20);
        btn_alto.addActionListener(this);
        btn_alto.setEnabled(false);
        ventana.add(btn_alto);

        btn_correcto = new JButton("Correcto");
        btn_correcto.setBounds(220,150,80,20);
        btn_correcto.addActionListener(this);
        btn_correcto.setEnabled(false);
        ventana.add(btn_correcto);

        rnd = new Random();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");
        if (e.getSource() == btn_correcto)
        {
            btn_bajo.setEnabled(false);
            btn_alto.setEnabled(false);
            btn_correcto.setEnabled(false);
            btn_inicio.setEnabled(true);
        }
        else
        {
            if (e.getSource() == btn_inicio)
            {
                btn_bajo.setEnabled(true);
                btn_alto.setEnabled(true);
                btn_correcto.setEnabled(true);
                btn_inicio.setEnabled(false);
                tf_min.setText("1");
                tf_max.setText("101");
                tf_intentos.setText("0");
                tf_computadora.setText("");
            }
            else
               if (e.getSource() == btn_bajo)
                  tf_min.setText(String.valueOf(Integer.parseInt(tf_computadora.getText())+1));
               else
                  if (e.getSource() == btn_alto)
                      tf_max.setText(tf_computadora.getText());

            //tf_computadora.setText(String.valueOf(rnd.nextInt(Integer.parseInt(tf_min.getText()),Integer.parseInt(tf_max.getText()))));
            generarNumero();
            tf_intentos.setText(String.valueOf(Integer.parseInt(tf_intentos.getText()) + 1));
        }
    }

    private void generarNumero()
    {
        int min, max, valor;
        min = Integer.parseInt(tf_min.getText());
        max = Integer.parseInt(tf_max.getText());

        // variante 1
        //valor = rnd.nextInt(min,max);

        // variante 2
        valor = rnd.nextInt(max-min)+min;
        
        //tf_computadora.setText(String.valueOf(rnd.nextInt(Integer.parseInt(tf_min.getText()),Integer.parseInt(tf_max.getText()))));
        tf_computadora.setText(String.valueOf(valor));

        

    }
   
}





