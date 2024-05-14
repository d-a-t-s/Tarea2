package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que representa una reunión presencial, extiende de la clase Reunion.
 */
public class ReunionPresencial extends Reunion {

    /** Sala donde se llevará a cabo la reunión presencial */
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial.
     * @param organizador El empleado que organiza la reunión.
     * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param sala La sala donde se llevará a cabo la reunión presencial.
     */
    public ReunionPresencial(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String sala) {
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }

    /**
     * Método para ingresar a la reunión presencial.
     */
    public void ingresarReunion() {
        // Implementación específica para la reunión presencial
    }

    /**
     * Método para obtener la lista de asistencias a la reunión.
     * @return La lista de asistencias a la reunión.
     */
    public List obtenerAsistencias() {
        // Implementación específica para la reunión presencial
        return null;
    }

    /**
     * Método para obtener la lista de ausencias a la reunión.
     * @return La lista de ausencias a la reunión.
     */
    public List obtenerAusencias() {
        // Implementación específica para la reunión presencial
        return null;
    }

    /**
     * Método para obtener la lista de retrasos a la reunión.
     * @return La lista de retrasos a la reunión.
     */
    public List obtenerRetrasos() {
        // Implementación específica para la reunión presencial
        return null;
    }

    /**
     * Método para obtener el total de asistentes a la reunión.
     * @return El total de asistentes a la reunión.
     */
    public int obtenerTotalAsistencia() {
        // Implementación específica para la reunión presencial
        return 0;
    }

    /**
     * Método para obtener el porcentaje de asistencia a la reunión.
     * @return El porcentaje de asistencia a la reunión.
     */
    public float obtenerPorcentajeAsistencia() {
        // Implementación específica para la reunión presencial
        return 0;
    }

    /**
     * Método para calcular el tiempo real de la reunión.
     * @return El tiempo real de la reunión.
     */
    public float calcularTiempoReal() {
        // Implementación específica para la reunión presencial
        return 0;
    }

    /**
     * Método para iniciar la reunión presencial.
     */
    public void iniciar() {
        // Implementación específica para la reunión presencial
    }

    /**
     * Método para finalizar la reunión presencial.
     */
    public void finalizar() {
        // Implementación específica para la reunión presencial
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
