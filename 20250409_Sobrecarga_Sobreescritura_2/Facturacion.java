public class Facturacion
{
    public static void main(String[] args)
    {
        new Facturacion();
    }
    Facturacion()
    {
        Empleado empleado = new Empleado();

        empleado.setNombre("Juan");
        empleado.setDepartamento("Ventas");
        System.out.println(empleado.getNombre());
        System.out.println(empleado.getDepartamento());
        System.out.println("****** 1");

        Empleado empleado2 = new Empleado("Maria");
        System.out.println(empleado2.getNombre());
        System.out.println("****** 2");

    }
}   