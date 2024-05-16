package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Departamento representa un departamento dentro de una organización.
 * Incluye el nombre del departamento y una lista de empleados.
 */
public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;

    /**
     * Constructor para crear una instancia de Departamento.
     *
     * @param nombre El nombre del departamento.
     * @throws IllegalArgumentException si el nombre es nulo o está vacío.
     */
    public Departamento(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del departamento no puede estar vacío.");
        }

        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del departamento.
     *
     * @return el nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombre El nombre del departamento a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de empleados en el departamento.
     *
     * @return la lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Agrega un empleado a la lista del departamento.
     *
     * @param empleado El empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Remueve un empleado de la lista del departamento.
     *
     * @param empleado El empleado a remover.
     */
    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    /**
     * Obtiene el número de empleados en el departamento.
     *
     * @return el número de empleados.
     */
    public int obtenerNumeroEmpleados() {
        return empleados.size();
    }

    /**
     * Invita a todos los empleados del departamento a una reunión.
     *
     * @param reunion La reunión a la que se invita a los empleados.
     */
    public void invitar(Reunion reunion) {
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion);
        }
    }
}
