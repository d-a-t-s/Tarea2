package org.example;

import java.time.Instant;

/**
 * La clase Asistencia representa la asistencia de un empleado.
 * Incluye el empleado, el estado de su asistencia y la hora de llegada.
 */
public class Asistencia {
    // Propiedades
    private Empleado empleado;
    private EstadoAsistencia estado;
    private Instant horaLlegada;

    /**
     * Constructor para crear una instancia de Asistencia.
     *
     * @param empleado El empleado asociado con esta asistencia.
     * @param estado El estado inicial de la asistencia.
     * @throws CampoVacioException si el empleado o el estado son nulos.
     */
    public Asistencia(Empleado empleado, EstadoAsistencia estado) {
        if (empleado == null) {
            throw new CampoVacioException("El empleado no puede ser nulo.");
        }
        if (estado == null) {
            throw new CampoVacioException("El estado de la asistencia no puede ser nulo.");
        }

        this.empleado = empleado;
        this.estado = estado;
        horaLlegada = Instant.now();
    }

    /**
     * Obtiene el empleado asociado con esta asistencia.
     *
     * @return el empleado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado asociado con esta asistencia.
     *
     * @param empleado El empleado a establecer.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el estado de la asistencia.
     *
     * @return el estado de la asistencia.
     */
    public EstadoAsistencia getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la asistencia.
     *
     * @param estado El estado de la asistencia a establecer.
     */
    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la hora de llegada del empleado.
     *
     * @return la hora de llegada.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Establece la hora de llegada del empleado.
     *
     * @param horaLlegada La hora de llegada a establecer.
     */
    public void setHoraLlegada(Instant horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    /**
     * Marca al empleado como llegado tarde y establece la hora de llegada.
     *
     * @param horaLlegada La hora en que el empleado llegó.
     */
    public void marcarLlegada(Instant horaLlegada) {
        this.estado = EstadoAsistencia.TARDE;
        this.horaLlegada = horaLlegada;
    }

    /**
     * Marca al empleado como ausente.
     */
    public void marcarAusente() {
        this.estado = EstadoAsistencia.AUSENTE;
    }

    /**
     * Marca al empleado como presente.
     */
    public void marcarPresente() {
        this.estado = EstadoAsistencia.PRESENTE;
    }
}
