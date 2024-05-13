package Paquete;

public class Empleado implements Invitable{
    //Propiedades
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    //Metodos
    public Empleado(String id, String nombres, String apellidos, String correo){
        this.id  = id;
        this.nombres = nombres;
        this.apellidos  = apellidos;
        this.correo = correo;
    }
    public void invitar(){

    }
}
