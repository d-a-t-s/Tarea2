package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

abstract class Reunion {
    protected List<Empleado> invitados;
    protected List<Asistencia> asistentes;
    protected Empleado organizador;
    protected LocalDate fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFin;
    protected Map<Invitable, Invitacion> invitaciones;

    public abstract void ingresarReunion();
    public abstract List<Asistencia> obtenerAsistencia();
    public abstract List<Asistencia> obtenerAusencias();
    public abstract List<Asistencia> obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();
    public abstract float calcularTiempoReal();
    public abstract void iniciar();
    public abstract void finalizar();
}

