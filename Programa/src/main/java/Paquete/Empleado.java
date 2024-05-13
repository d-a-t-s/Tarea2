package Paquete;

import java.time.Instant;

public class Empleado implements Invitable{
    //Propiedades
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private Departamento departamento;
    //Metodos
    public Empleado(int id, String nombres, String apellidos, String correo){
        this.id  = id;
        this.nombres = nombres;
        this.apellidos  = apellidos;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombres;
    }

    public String getApellido() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public Departamento getDepartamento(){
        return departamento;
    }

    public void invitar(Reunion reunion, Instant horaInvitacion) {
        Invitacion invitacion = new Invitacion(horaInvitacion);
        reunion.agregarInvitacion(this, invitacion);
    }
}
