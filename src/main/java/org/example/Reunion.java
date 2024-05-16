package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Reunion es una clase abstracta que sirve como base para diferentes tipos de reuniones.
 */
abstract class Reunion {
    protected List<Nota> notas;
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
    protected TipoReunion tipoReunion;

    /**
     * Constructor de la clase Reunion.
     *
     * @param organizador     El organizador de la reunión.
     * @param fecha           La fecha de la reunión.
     * @param horaPrevista    La hora prevista de inicio de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param tipoReunion     El tipo de reunión.
     */
    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipoReunion) {
        notas = new ArrayList<>();
        invitados = new ArrayList<>();
        asistentesPresentes = new ArrayList<>();
        asistentesTarde = new ArrayList<>();
        asistentesAusentes = new ArrayList<>();
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = Instant.MAX;
        this.horaFin = Instant.MAX;
        this.tipoReunion = tipoReunion;
    }

    /** Métodos abstractos que deben ser implementados por las clases que extiendan Reunion */
    public abstract void agregarNota(String texto);
    public abstract void agregarInvitacion(Empleado invitado, Invitacion invitacion);
    public abstract void ingresarReunion(Invitacion inv);
    public abstract List<Asistencia> obtenerAsistencia();
    public abstract List<Asistencia> obtenerAusencias();
    public abstract List<Asistencia> obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();
    public abstract float calcularTiempoReal();
    public abstract void iniciar();
    public abstract void finalizar();

    /**
     * Obtiene la lista de invitaciones para esta reunión.
     *
     * @return La lista de invitaciones.
     */
    public List<Invitacion> getInvitados() {
        return invitados;
    }

    /**
     * Obtiene la lista de asistencias presentes en esta reunión.
     *
     * @return La lista de asistencias presentes.
     */
    public List<Asistencia> getAsistentesPresentes() {
        return asistentesPresentes;
    }

    /**
     * Obtiene la lista de asistencias llegadas tarde en esta reunión.
     *
     * @return La lista de asistencias llegadas tarde.
     */
    public List<Asistencia> getAsistentesTarde() {
        return asistentesTarde;
    }

    /**
     * Obtiene la lista de asistencias ausentes en esta reunión.
     *
     * @return La lista de asistencias ausentes.
     */
    public List<Asistencia> getAsistentesAusentes() {
        return asistentesAusentes;
    }

    /**
     * Obtiene el organizador de la reunión.
     *
     * @return El organizador de la reunión.
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    /**
     * Obtiene la fecha de la reunión.
     *
     * @return La fecha de la reunión.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene la hora prevista de la reunión.
     *
     * @return La hora prevista de la reunión.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Obtiene la duración prevista de la reunión.
     *
     * @return La duración prevista de la reunión.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Obtiene la hora de inicio de la reunión.
     *
     * @return La hora de inicio de la reunión.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Obtiene la hora de fin de la reunión.
     *
     * @return La hora de fin de la reunión.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Obtiene el tipo de reunión.
     *
     * @return El tipo de reunión.
     */
    public TipoReunion getTipoReunion() {
        return tipoReunion;
    }

    /**
     * Obtiene la lista de notas asociadas a la reunión.
     *
     * @return La lista de notas de la reunión.
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * Establece la lista de invitaciones para esta reunión.
     *
     * @param invitados La lista de invitaciones a establecer.
     */
    public void setInvitados(List<Invitacion> invitados) {
        this.invitados = invitados;
    }

    /**
     * Establece la lista de asistencias presentes en esta reunión.
     *
     * @param asistentesPresentes La lista de asistencias presentes a establecer.
     */
    public void setAsistentesPresentes(List<Asistencia> asistentesPresentes) {
        this.asistentesPresentes = asistentesPresentes;
    }

    /**
     * Establece la lista de asistencias llegadas tarde en esta reunión.
     *
     * @param asistentesTarde La lista de asistencias llegadas tarde a establecer.
     */
    public void setAsistentesTarde(List<Asistencia> asistentesTarde) {
        this.asistentesTarde = asistentesTarde;
    }

    /**
     * Establece la lista de asistencias ausentes en esta reunión.
     *
     * @param asistentesAusentes La lista de asistencias ausentes a establecer.
     */
    public void setAsistentesAusentes(List<Asistencia> asistentesAusentes) {
        this.asistentesAusentes = asistentesAusentes;
    }

    /**
     * Establece el organizador de la reunión.
     *
     * @param organizador El organizador de la reunión a establecer.
     */
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    /**
     * Establece la fecha de la reunión.
     *
     * @param fecha La fecha de la reunión a establecer.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la hora prevista de la reunión.
     *
     * @param horaPrevista La hora prevista de la reunión a establecer.
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * Establece la duración prevista de la reunión.
     *
     * @param duracionPrevista La duración prevista de la reunión a establecer.
     */
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Establece la hora de inicio de la reunión.
     *
     * @param horaInicio La hora de inicio de la reunión a establecer.
     */
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }
    /**
     * Establece la hora de fin de la reunión.
     *
     * @param horaFin La hora de fin de la reunión a establecer.
     */
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Establece el tipo de reunión.
     *
     * @param tipoReunion El tipo de reunión a establecer.
     */
    public void setTipoReunion(TipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    /**
     * Establece la lista de notas asociadas a la reunión.
     *
     * @param notas La lista de notas de la reunión a establecer.
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
