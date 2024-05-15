package Paquete;

import java.time.Instant;

/**
 * Clase que representa un retraso de un empleado en una reunión.
 * Extiende de la clase Asistencia.
 */
public class Retraso extends Asistencia {

    /** Hora de llegada tarde del empleado */
    private Instant horaLlegadaTarde;

    /**
     * Constructor de la clase Retraso.
     * @param empleado El empleado que llega tarde a la reunión.
     * @param horaLlegadaTarde La hora de llegada tarde del empleado.
     */
    public Retraso(Empleado empleado, Instant horaLlegadaTarde) {
        super(empleado, EstadoAsistencia.Tarde);
        this.horaLlegadaTarde = horaLlegadaTarde;
    }

    /**
     * Obtiene la hora de llegada tarde del empleado.
     * @return La hora de llegada tarde del empleado.
     */
    public Instant getHoraLlegadaTarde() {
        return horaLlegadaTarde;
    }
}
