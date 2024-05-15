package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Reunion{
    protected List<Invitacion> invitados;
    protected List<Asistencia> asistentesPresentes;
    protected List<Asistencia> asistentesTarde;
    protected List<Asistencia> asistentesAusentes;
    protected Empleado organizador;
    protected LocalDate fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFin;

    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista){
        invitados = new ArrayList<>();
        asistentesPresentes = new ArrayList<>();
        asistentesTarde = new ArrayList<>();
        asistentesAusentes = new ArrayList<>();
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = null;
        this.horaFin = null;
    }
    public abstract void agregarInvitacion(Empleado invitado, Invitacion invitacion);
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

