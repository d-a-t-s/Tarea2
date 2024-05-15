package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que representa una reunión virtual, extiende de la clase Reunion.
 */
public class ReunionVirtual extends Reunion {

    /** Enlace para unirse a la reunión virtual */
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     * @param organizador El empleado que organiza la reunión.
     * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param enlace El enlace para unirse a la reunión virtual.
     */
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    /**
     * Método para ingresar a la reunión virtual.
     */
    public void ingresarReunion() {
        // Implementación específica para la reunión virtual
    }

    /**
     * Método para obtener la lista de asistencias a la reunión.
     * @return La lista de asistencias a la reunión.
     */
    public List obtenerAsistencias() {
        // Implementación específica para la reunión virtual
        return null;
    }

    /**
     * Método para obtener la lista de ausencias a la reunión.
     * @return La lista de ausencias a la reunión.
     */
    public List obtenerAusencias() {
        // Implementación específica para la reunión virtual
        return null;
    }

    /**
     * Método para obtener la lista de retrasos a la reunión.
     * @return La lista de retrasos a la reunión.
     */
    public List obtenerRetrasos() {
        // Implementación específica para la reunión virtual
        return null;
    }

    /**
     * Método para obtener el total de asistentes a la reunión.
     * @return El total de asistentes a la reunión.
     */
    public int obtenerTotalAsistencia() {
        // Implementación específica para la reunión virtual
        return 0;
    }

    /**
     * Método para obtener el porcentaje de asistencia a la reunión.
     * @return El porcentaje de asistencia a la reunión.
     */
    public float obtenerPorcentajeAsistencia() {
        // Implementación específica para la reunión virtual
        return 0;
    }

    /**
     * Método para calcular el tiempo real de la reunión.
     * @return El tiempo real de la reunión.
     */
    public float calcularTiempoReal() {
        // Implementación específica para la reunión virtual
        return 0;
    }

    /**
     * Método para iniciar la reunión virtual.
     */
    public void iniciar() {
        // Implementación específica para la reunión virtual
    }

    /**
     * Método para finalizar la reunión virtual.
     */
    public void finalizar() {
        // Implementación específica para la reunión virtual
    }

    /**
     * Método para agregar una invitación a la reunión.
     * @param invitado El objeto invitado a la reunión.
     * @param invitacion La invitación a la reunión.
     */
    public void agregarInvitacion(Invitable invitado, Invitacion invitacion) {
        if (invitaciones == null) {
            invitaciones = new HashMap<>();
        }
        invitaciones.put(invitado, invitacion);
    }

}
