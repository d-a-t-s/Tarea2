package Paquete;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

/**
 * Clase que representa un departamento de la empresa.
 * Implementa la interfaz Invitable.
 */
public class Departamento implements Invitable {

    /** Nombre del departamento */
    private String nombre;

    /** Lista de empleados pertenecientes al departamento */
    private List<Empleado> empleados;

    /**
     * Constructor de la clase Departamento.
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado al departamento.
     * @param empleado El empleado a agregar.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Obtiene el nombre del departamento.
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la lista de empleados pertenecientes al departamento.
     * @return La lista de empleados pertenecientes al departamento.
     */
    public List<Empleado> getEmpleados(){
        return empleados;
    }

    /**
     * Obtiene la cantidad de empleados en el departamento.
     * @return La cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Invita a todos los empleados del departamento a una reunión.
     * @param reunion La reunión a la que se invita.
     * @param horaInvitacion La hora en la que se envía la invitación.
     */
    public void invitar(Reunion reunion, Instant horaInvitacion) {
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion, horaInvitacion);
        }
    }
}
