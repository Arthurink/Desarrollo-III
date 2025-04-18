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

        Empleado empleado3 = new Empleado();
        empleado3.setNombre("Jose");
        empleado3.setApellido("Perez");
        System.out.println(empleado3.getNombre());
        System.out.println(empleado3.getApellido());
        System.out.println("***** 3");

        Empleado empleado4 = new Empleado("Ana","Gomez");
        System.out.println(empleado4.getNombre());
        System.out.println(empleado4.getApellido());
        System.out.println(empleado4.getNombreApellido());
    }
}   