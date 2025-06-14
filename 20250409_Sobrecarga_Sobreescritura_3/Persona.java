public class Persona
{
    private String nombre;
    private String apellido;
    
    public void setNombre(String n) 
    {
        nombre = n;
    }
    public String getNombre()
    {
        return nombre;
    }

    public void setApellido(String a)
    {
        apellido = a;
    }
    public String getApellido()
    {
        return apellido;
    }
    public String getNombreApellido()
    {
        return nombre+apellido;
    }

}