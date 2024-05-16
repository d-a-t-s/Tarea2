package org.example;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Invitable {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Departamento departamento;
    private List<Reunion> reuniones;

    // Constructor
    public Empleado(int id, String nombre, String apellidos, String correo, Departamento departamento) {

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
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento del empleado no puede ser nulo.");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
        this.reuniones = new ArrayList<>();
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void invitar(Reunion reunion){
        Invitacion invitacion = new Invitacion();
        reunion.agregarInvitacion(this, invitacion);
        this.reuniones.add(reunion);
    }
}
