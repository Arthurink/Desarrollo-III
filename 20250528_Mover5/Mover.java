import javax.swing.*;
import java.awt.event.*;

public class Mover implements ActionListener
{
    JFrame ventana;
    JButton btn_boton, btn_bajar, btn_subir, btn_izq, btn_der;

    int diry = 0, dirx = 0;

    Timer timer = new Timer(100, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int x, y;
            x = btn_boton.getLocation().x;
            y = btn_boton.getLocation().y;
            if (y <= 0)
               diry = -diry;

            btn_boton.setLocation(x+dirx,y+diry);

          

        }
    });
    
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
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

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

        btn_izq = new JButton("Izq");
        btn_izq.setBounds(225,40,70,20);
        btn_izq.addActionListener(this);
        ventana.add(btn_izq);

        btn_der = new JButton("Der");
        btn_der.setBounds(375,40,70,20);
        btn_der.addActionListener(this);
        ventana.add(btn_der);

        timer.start();

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");

        int x, y;
        x = btn_boton.getLocation().x;
        y = btn_boton.getLocation().y;

        if (e.getSource() == btn_subir)
            diry--;
 
        if (e.getSource() == btn_bajar)
            diry++;

        if (e.getSource() == btn_izq)
            dirx--;
        
        if (e.getSource() == btn_der)
            dirx++;

    }
}


