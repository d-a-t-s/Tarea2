package Paquete;

/**
 * Clase que representa la asistencia de un empleado a una reunión.
 */
public class Asistencia {

    /** Empleado que asiste a la reunión */
    private Empleado empleado;

    /** Estado de la asistencia (presente, ausente, tarde) */
    private EstadoAsistencia estado;

    /**
     * Constructor de la clase Asistencia.
     * @param empleado El empleado que asiste a la reunión.
     * @param estado El estado de la asistencia.
     */
    public Asistencia(Empleado empleado, EstadoAsistencia estado) {
        this.empleado = empleado;
        this.estado = estado;
    }

    /**
     * Obtiene el empleado que asiste a la reunión.
     * @return El empleado que asiste a la reunión.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Obtiene el estado de la asistencia.
     * @return El estado de la asistencia.
     */
    public EstadoAsistencia getEstado() {
        return estado;
    }
}
