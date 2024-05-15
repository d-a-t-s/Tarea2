package org.example;

public class Empleado implements Invitable {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Departamento departamento;

    // Constructor
    public Empleado(int id, String nombre, String apellidos, String correo, Departamento departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.departamento = departamento;
        departamento.agregarEmpleado(this);
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

    public void invitar(Reunion reunion){
        Invitacion invitacion = new Invitacion();
        reunion.agregarInvitacion(this, invitacion);
    }
}
