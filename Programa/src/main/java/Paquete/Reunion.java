package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase abstracta que representa una reunión.
 */
public abstract class Reunion {

    /** Lista de invitados a la reunión */
    protected List invitados;

    /** Lista de asistencias a la reunión */
    protected List<Asistencia> asistentes;

    /** Empleado que organiza la reunión */
    protected Empleado organizador;

    /** Fecha de la reunión */
    protected LocalDate fecha;

    /** Hora prevista de la reunión */
    protected Instant horaPrevista;

    /** Duración prevista de la reunión */
    protected Duration duracionPrevista;

    /** Hora de inicio de la reunión */
    protected Instant horaInicio;

    /** Hora de fin de la reunión */
    protected Instant horaFin;

    /** Mapa de invitaciones */
    protected Map<Invitable, Invitacion> invitaciones;

    /**
     * Constructor de la clase Reunion.
     * @param organizador El empleado que organiza la reunión.
     * @param fecha La fecha de la reunión.
     * @param horaPrevista La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     */
    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista) {
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = null;
        this.horaFin = null;
        this.invitaciones = new HashMap<>();
    }

    /**
     * Método abstracto para ingresar a la reunión.
     */
    public abstract void ingresarReunion();

    /**
     * Método abstracto para obtener la lista de asistencias a la reunión.
     * @return La lista de asistencias a la reunión.
     */
    public abstract List obtenerAsistencias();

    /**
     * Método abstracto para obtener la lista de ausencias a la reunión.
     * @return La lista de ausencias a la reunión.
     */
    public abstract List obtenerAusencias();

    /**
     * Método abstracto para obtener la lista de retrasos a la reunión.
     * @return La lista de retrasos a la reunión.
     */
    public abstract List obtenerRetrasos();

    /**
     * Método abstracto para obtener el total de asistentes a la reunión.
     * @return El total de asistentes a la reunión.
     */
    public abstract int obtenerTotalAsistencia();

    /**
     * Método abstracto para obtener el porcentaje de asistencia a la reunión.
     * @return El porcentaje de asistencia a la reunión.
     */
    public abstract float obtenerPorcentajeAsistencia();

    /**
     * Método abstracto para calcular el tiempo real de la reunión.
     * @return El tiempo real de la reunión.
     */
    public abstract float calcularTiempoReal();

    /**
     * Método abstracto para iniciar la reunión.
     */
    public abstract void iniciar();

    /**
     * Método abstracto para finalizar la reunión.
     */
    public abstract void finalizar();

    /**
     * Método abstracto para agregar una invitación a la reunión.
     * @param invitado El objeto invitado a la reunión.
     * @param invitacion La invitación a la reunión.
     */
    public abstract void agregarInvitacion(Invitable invitado, Invitacion invitacion);
}
