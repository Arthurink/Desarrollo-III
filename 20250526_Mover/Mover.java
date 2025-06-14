import javax.swing.*;
import java.awt.event.*;

public class Mover implements ActionListener
{
    JFrame ventana;
    JButton btn_boton, btn_bajar, btn_subir;
    
    public static void main(String[] args)
    {
        new Mover();
    }

    Mover()
    {
        ventana = new JFrame("Mover");
        ventana.setBounds(300,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_boton = new JButton("Boton");
        btn_boton.setBounds(200,200,80,20);
        ventana.add(btn_boton);

        btn_subir = new JButton("Subir");
        btn_subir.setBounds(300,30,70,20);
        btn_subir.addActionListener(this);
        ventana.add(btn_subir);

        btn_bajar = new JButton("Bajar");
        btn_bajar.setBounds(300,60,70,20);
        btn_bajar.addActionListener(this);
        ventana.add(btn_bajar);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");

        int x, y;
        x = btn_boton.getLocation().x;
        y = btn_boton.getLocation().y;

        if (e.getSource() == btn_subir)
           btn_boton.setLocation(x,y-10);|
 
        if (e.getSource() == btn_bajar)
            btn_boton.setLocation(x,y+10);
           

    }
}


