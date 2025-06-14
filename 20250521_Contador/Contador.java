import javax.swing.*;
import java.awt.event.*;

public class Contador implements ActionListener
{
    JFrame ventana;
    JLabel lbl_contador;
    JTextField tf_contador;
    JButton btn_contar, btn_iniciar, btn_parar;

    Timer timer = new Timer(1000, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
           tf_contador.setText(String.valueOf(Integer.parseInt(tf_contador.getText()) + 1));
        }
    });          

    public static void main(String[] args)
    {
        new Contador();
    }

    Contador()
    {
        ventana = new JFrame("Contador");
        ventana.setBounds(300,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_contador = new JLabel("Contador");
        lbl_contador.setBounds(50,50,80,20);
        ventana.add(lbl_contador);
 
        tf_contador = new JTextField("0");
        tf_contador.setBounds(135,50,50,20);
        ventana.add(tf_contador);

        btn_contar = new JButton("Contar");
        btn_contar.setBounds(190,50,90,20);
        btn_contar.addActionListener(this);
        ventana.add(btn_contar);

        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(190,75,90,20);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);

        btn_parar = new JButton("Parar");
        btn_parar.setBounds(190,100,90,20);
        btn_parar.addActionListener(this);
        ventana.add(btn_parar);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerforme");

        if (e.getSource() == btn_contar)
           tf_contador.setText(String.valueOf(Integer.parseInt(tf_contador.getText()) + 1));

        if (e.getSource() == btn_iniciar)
           timer.start();

        if (e.getSource() == btn_parar)
           timer.stop();
    }
}




