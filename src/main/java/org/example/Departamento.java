package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;

    // Constructor
    public Departamento(String nombre) {

        if (nombre == null || nombre.isEmpty() ) {
            throw new IllegalArgumentException("El nombre del departamento no puede estar vacío.");
        }

        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // Otros métodos
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public int obtenerNumeroEmpleados() {
        return empleados.size();
    }

    public void invitar(Reunion reunion){
        for(Empleado empleado : empleados){
            empleado.invitar(reunion);
        }
    }
}

