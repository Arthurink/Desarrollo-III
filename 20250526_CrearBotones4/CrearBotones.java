import javax.swing.*;
import java.awt.event.*;

public class CrearBotones implements ActionListener
{
    JFrame ventana;
    JButton btn_boton, btn_tmp, btn_iniciar;
    JLabel lbl_valor, lbl_x, lbl_y;
    JTextField tf_valor, tf_x, tf_y;

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

        lbl_valor = new JLabel("Valor");
        lbl_valor.setBounds(50,20,50,20);
        ventana.add(lbl_valor);
        
        tf_valor = new JTextField();
        tf_valor.setBounds(105,20,50,20);
        ventana.add(tf_valor);

        lbl_x = new JLabel("X");
        lbl_x.setBounds(160,20,20,20);
        ventana.add(lbl_x);

        tf_x = new JTextField();
        tf_x.setBounds(185,20,40,20);
        ventana.add(tf_x);
        
        lbl_y = new JLabel("Y");
        lbl_y.setBounds(230,20,20,20);
        ventana.add(lbl_y);

        tf_y = new JTextField();
        tf_y.setBounds(255,20,40,20);
        ventana.add(tf_y);

        btn_iniciar = new JButton("Iniciar");
        btn_iniciar.setBounds(300,20,80,20);
        btn_iniciar.addActionListener(this);
        ventana.add(btn_iniciar);
       
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");
       
        btn_tmp = (JButton)e.getSource();
        tf_valor.setText(btn_tmp.getText());
        tf_x.setText(String.valueOf(btn_tmp.getLocation().x));
        tf_y.setText(String.valueOf(btn_tmp.getLocation().y));

        if (e.getSource() == btn_iniciar)
           crearBotones();
    }
   
    private void crearBotones() 
    {
        int i;
        for (i=0;i<9;i++)
        {
            btn_boton = new JButton(String.valueOf(i));
            btn_boton.setBounds(50+55*(i%3),50+25*(i/3),50,20);
            btn_boton.addActionListener(this);
            ventana.add(btn_boton);
        }
        ventana.repaint();
    }
}










    