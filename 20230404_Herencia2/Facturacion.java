public class Facturacion {
    public static void main(String[] args) {
        new Facturacion();
    }

    Facturacion(){
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setCargo("vendedor");
        System.out.println(empleado.getNombre());
        System.out.println(empleado.getCargo());
    }
}