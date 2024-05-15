package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Reunion{
    //Propiedades
    private List<Invitacion> invitados;
    private List<Asistencia> asistentes;
    private Empleado organizador;
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    //Metodos
    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista){
        invitados = new ArrayList<>();
        asistentes = new ArrayList<>();
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = null;
        this.horaFin = null;
    }
    public abstract void agregarInvitacion(Empleado invitado, Invitacion invitacion);

    public abstract void ingresarReunion(Invitacion invitacion);

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

    /**
     * Método abstracto para iniciar la reunión.
     */
    public abstract void iniciar();

    /**
     * Método abstracto para finalizar la reunión.
     */
    public abstract void finalizar();

    //Getters
    public List<Invitacion> getInvitados(){
        return invitados;
    }
    public Empleado getOrganizador(){
        return organizador;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    public Instant getHoraInicio(){
        return horaInicio;
    }
    public Instant getHoraFin(){
        return horaFin;
    }
}
