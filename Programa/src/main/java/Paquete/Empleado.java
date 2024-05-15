package Paquete;

import java.time.Instant;

/**
 * Clase que representa un empleado de la empresa.
 * Implementa la interfaz Invitable.
 */
public class Empleado implements Invitable {

    /** ID del empleado */
    private int id;

    /** Nombres del empleado */
    private String nombres;

    /** Apellidos del empleado */
    private String apellidos;

    /** Correo electrónico del empleado */
    private String correo;

    /** Departamento al que pertenece el empleado */
    private Departamento departamento;

    /**
     * Constructor de la clase Empleado.
     * @param id ID del empleado.
     * @param nombres Nombres del empleado.
     * @param apellidos Apellidos del empleado.
     * @param correo Correo electrónico del empleado.
     */
    public Empleado(int id, String nombres, String apellidos, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Obtiene el ID del empleado.
     * @return El ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene los nombres del empleado.
     * @return Los nombres del empleado.
     */
    public String getNombre() {
        return nombres;
    }

    /**
     * Obtiene los apellidos del empleado.
     * @return Los apellidos del empleado.
     */
    public String getApellido() {
        return apellidos;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     * @return El correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el departamento al que pertenece el empleado.
     * @return El departamento al que pertenece el empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Invita al empleado a una reunión.
     * @param reunion La reunión a la que se invita al empleado.
     * @param horaInvitacion La hora en la que se envía la invitación.
     */
    public void invitar(Reunion reunion, Instant horaInvitacion) {
        Invitacion invitacion = new Invitacion(horaInvitacion);
        reunion.agregarInvitacion(this, invitacion);
    }
}
