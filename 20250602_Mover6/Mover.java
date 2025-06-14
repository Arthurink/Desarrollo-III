import javax.swing.*;
import java.awt.event.*;

public class Mover implements ActionListener
{
    JFrame ventana;
    JButton btn_boton, btn_bajar, btn_subir, btn_izq, btn_der;
    JLabel lbl_y, lbl_height;
    JTextField tf_y, tf_height;

    int diry = 0, dirx = 0;

    Timer timer = new Timer(100, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int x, y;
            x = btn_boton.getLocation().x;
            y = btn_boton.getLocation().y;
            tf_y.setText(String.valueOf(y));
            tf_height.setText(String.valueOf(ventana.getHeight()));
            if (y <= 0)
               diry = -diry;

            if (y>=ventana.getHeight())
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

        lbl_y = new JLabel("Y");
        lbl_y.setBounds(300,85,30,20);
        ventana.add(lbl_y);

        tf_y = new JTextField();
        tf_y.setBounds(335,85,40,20);
        ventana.add(tf_y);

        lbl_height = new JLabel("H");
        lbl_height.setBounds(300,110,30,20);
        ventana.add(lbl_height);

        tf_height = new JTextField();
        tf_height.setBounds(335,110,40,20);
        ventana.add(tf_height);


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


