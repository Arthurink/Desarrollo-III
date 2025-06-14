import javax.swing.*;
import java.awt.event.*;

public class Calculadora implements ActionListener
{
    JFrame ventana;
    JLabel lbl_num1, lbl_num2, lbl_res;
    JTextField tf_num1, tf_num2, tf_res, tf_oper;
    JButton btn_sumar, btn_restar, btn_calcular;

    public static void main(String[] args)
    {
        new Calculadora();
    }

    Calculadora()
    {
        ventana = new JFrame("Calculadora");
        ventana.setBounds(100,100,500,500); 
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_num1 = new JLabel("Num1:");
        lbl_num1.setBounds(100,50,50,20);
        ventana.add(lbl_num1);

        tf_num1 = new JTextField();
        tf_num1.setBounds(155,50,50,20);
        ventana.add(tf_num1);

        tf_oper = new JTextField();
        tf_oper.setBounds(210,60,50,20);
        ventana.add(tf_oper);

        lbl_num2 = new JLabel("Num2:");
        lbl_num2.setBounds(100,75,50,20);
        ventana.add(lbl_num2);

        tf_num2 = new JTextField();
        tf_num2.setBounds(155,75,50,20);
        ventana.add(tf_num2);

        lbl_res = new JLabel("Res:");
        lbl_res.setBounds(100,100,50,20);
        ventana.add(lbl_res);

        tf_res = new JTextField();
        tf_res.setBounds(155,100,50,20);
        ventana.add(tf_res);

        btn_sumar = new JButton("Sumar");
        btn_sumar.setBounds(100,125,80,20);
        btn_sumar.addActionListener(this);
        ventana.add(btn_sumar);

        btn_restar = new JButton("Restar");
        btn_restar.setBounds(185,125,80,20);
        btn_restar.addActionListener(this);
        ventana.add(btn_restar);
      
        btn_calcular = new JButton("Calcular");
        btn_calcular.setBounds(270,125,100,20);
        btn_calcular.addActionListener(this);
        ventana.add(btn_calcular);

        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("en actionPerformed");
        
        int num1=0, num2=0, res=0;
        num1 = Integer.parseInt(tf_num1.getText());
        num2 = Integer.parseInt(tf_num2.getText());

        if (e.getSource() == btn_sumar)
            res = num1 + num2;
        else
            if (e.getSource() == btn_restar)
                res = num1 - num2;
            else
                if (e.getSource() == btn_calcular)
                    if (tf_oper.getText().equals("+"))
                        res = num1+num2;
                    else
                        if (tf_oper.getText().equals("-"))
                            res = num1 - num2;

        tf_res.setText(String.valueOf(res));
    }
}








