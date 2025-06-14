import javax.swing.*;
import java.awt.*;

public class TipoLetra
{
    JFrame ventana;
    JButton btn_boton;

    public static void main(String[] args)
    {
        new TipoLetra();
    }

    TipoLetra()
    {
        ventana = new JFrame("Tipo de Letra");
        ventana.setBounds(300,100,500,500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        int i;
        for (i=0;i<5;i++)
        {
            btn_boton = new JButton(String.valueOf(i+150));
            btn_boton.setBounds(50+i*55,50,25,25);
            btn_boton.setMargin(new Insets(0,0,0,0)); // margen interno Insets(arriba, izquierda, abajo, dercha)
            btn_boton.setFont(new Font("Arial",Font.PLAIN,10)); // Font.BOLD, Font.ITALIC
            ventana.add(btn_boton);
        }
        ventana.setVisible(true);
    }
}





