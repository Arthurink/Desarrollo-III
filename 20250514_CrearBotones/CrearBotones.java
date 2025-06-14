import javax.swing.*;
import java.awt.event.*;

public class CrearBotones implements ActionListener
{
    JFrame ventana;
    JButton btn_boton0, btn_boton1, btn_boton2, btn_boton3;
    JButton btn_boton, btn_temp;
    JLabel lbl_valor;
    JTextField tf_valor;

    public static void main(String[] args)
    {
        new CrearBotones();
    }
    
    CrearBotones()
    {
        ventana = new JFrame("Crear Botones");
        ventana.setBounds(300,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        btn_boton0 = new JButton("0");
        btn_boton0.setBounds(50,50,50,20);
        ventana.add(btn_boton0);

        btn_boton1 = new JButton("1");
        btn_boton1.setBounds(105,50,50,20);
        ventana.add(btn_boton1);

        btn_boton2 = new JButton("2");
        btn_boton2.setBounds(160,50,50,20);
        ventana.add(btn_boton2);

        btn_boton3 = new JButton("3");
        btn_boton3.setBounds(215,50,50,20);
        ventana.add(btn_boton3);
        */

        lbl_valor = new JLabel("Valor");
        lbl_valor.setBounds(50,20,50,20);
        ventana.add(lbl_valor);

        tf_valor = new JTextField();
        tf_valor.setBounds(105,20,50,20);
        ventana.add(tf_valor);
        
        int i;
        for (i=0;i<4;i++)
        {
            btn_boton = new JButton(String.valueOf(i));
            btn_boton.setBounds(50+55*i,50,50,20);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);
        }
 
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");
        //tf_valor.setText(btn_boton.getText());

        btn_temp = (JButton)e.getSource();
        tf_valor.setText(btn_temp.getText());

    }
}


