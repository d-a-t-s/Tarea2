package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Empleado representa a un empleado dentro de una organización.
 * Incluye información personal y una lista de reuniones a las que está invitado.
 */
public class Empleado implements Invitable {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private List<Reunion> reuniones;

    /**
     * Constructor para crear una instancia de Empleado.
     *
     * @param id El ID del empleado.
     * @param nombre El nombre del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param correo El correo electrónico del empleado.
     * @throws IllegalArgumentException si el ID es menor o igual a cero, o si cualquier otro parámetro es nulo o está vacío.
     */
    public Empleado(int id, String nombre, String apellidos, String correo) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del empleado debe ser mayor que cero.");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }
        if (apellidos == null || apellidos.isEmpty()) {
            throw new IllegalArgumentException("Los apellidos del empleado no pueden estar vacíos.");
        }
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico del empleado no puede estar vacío.");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.reuniones = new ArrayList<>();
    }

    /**
     * Obtiene el ID del empleado.
     *
     * @return el ID del empleado.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id El ID del empleado a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return el nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nombre del empleado a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Los apellidos del empleado a establecer.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return el correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo El correo electrónico del empleado a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la lista de reuniones a las que el empleado está invitado.
     *
     * @return la lista de reuniones.
     */
    public List<Reunion> getReuniones() {
        return reuniones;
    }

    /**
     * Invita al empleado a una reunión.
     *
     * @param reunion La reunión a la que se invita al empleado.
     */
    public void invitar(Reunion reunion) {
        Invitacion invitacion = new Invitacion();
        reunion.agregarInvitacion(this, invitacion);
        this.reuniones.add(reunion);
    }
}
