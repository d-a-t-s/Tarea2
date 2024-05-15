package Paquete;

import java.time.Instant;

import java.util.List;

public class Empleado implements Invitable{
    //Propiedades
    private int id;

    private String nombres;

    /** Apellidos del empleado */
    private String apellidos;

    /** Correo electrónico del empleado */
    private String correo;
    //Metodos
    public Empleado(int id, String nombres, String apellidos, String correo){
        this.id  = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public void invitar(Reunion reunion){
        Invitacion invitacion = new Invitacion();
        reunion.agregarInvitacion(this, invitacion);
    }
}
