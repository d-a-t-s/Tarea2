package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Reunion{
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

    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, TipoReunion tipoReunion){
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

    //Getter
    public List<Invitacion> getInvitados(){
        return invitados;
    }
    public List<Asistencia> getAsistentesPresentes() {
        return asistentesPresentes;
    }
    public List<Asistencia> getAsistentesTarde() {
        return asistentesTarde;
    }
    public List<Asistencia> getAsistentesAusentes() {
        return asistentesAusentes;
    }
    public Empleado getOrganizador() {
        return organizador;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }
    public Instant getHoraInicio() {
        return horaInicio;
    }
    public Instant getHoraFin() {
        return horaFin;
    }
    public TipoReunion getTipoReunion(){
        return tipoReunion;
    }
    public List<Nota> getNotas(){
        return notas;
    }
    //Setters
    public void setInvitados(List<Invitacion> invitados) {
        this.invitados = invitados;
    }
    public void setAsistentesPresentes(List<Asistencia> asistentesPresentes) {
        this.asistentesPresentes = asistentesPresentes;
    }
    public void setAsistentesTarde(List<Asistencia> asistentesTarde) {
        this.asistentesTarde = asistentesTarde;
    }
    public void setAsistentesAusentes(List<Asistencia> asistentesAusentes) {
        this.asistentesAusentes = asistentesAusentes;
    }
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }
    public void setTipoReunion(TipoReunion tipoReunion){
        this.tipoReunion = tipoReunion;
    }
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}

