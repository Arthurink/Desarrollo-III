public class Empleado extends Persona
{
    private String departamento;
 
    Empleado()
    {
    }

    Empleado(String n)
    {
        super.setNombre(n);
    }

    Empleado(String n, String a)
    {
        super.setNombre(n);
        setApellido(a);
    }
   
    public void setNombre(String n)
    {
        super.setNombre(n+"-hija");
    }

    public void setDepartamento(String d)
    {
        departamento = d;
    }

    public String getDepartamento()
    {
        return departamento;
    }
}