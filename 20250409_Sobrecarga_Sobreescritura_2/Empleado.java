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