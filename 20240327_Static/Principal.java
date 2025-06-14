public class Principal {
    public static void main(String[] args)
    {
        new Principal();
    }

    Principal()
    {
        Numero num1 = new Numero();
        Numero num2 = new Numero();

        num1.setValor(5);
        num2.setValor(100);

        System.out.println(num1.getValor());
        System.out.println(num2.getValor());
    }
}