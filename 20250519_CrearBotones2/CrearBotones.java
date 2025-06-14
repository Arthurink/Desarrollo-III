import javax.swing.*;

public class CrearBotones
{
    JFrame ventana;
    JButton btn_boton;

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

        int i;
        for (i=0;i<9;i++)
        {
            btn_boton = new JButton(String.valueOf(i));
            btn_boton.setBounds(50+55*(i%3),50+25*(i/3),50,20);
            ventana.add(btn_boton);
        }
        
        ventana.setVisible(true);
    }
}

    