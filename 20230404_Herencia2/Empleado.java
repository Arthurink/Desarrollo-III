public class Empleado extends Persona {
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void setNombre(String nombre) {
        super.setNombre("Emp-"+nombre);
    }
}
