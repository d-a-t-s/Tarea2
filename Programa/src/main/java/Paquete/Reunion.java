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

    public abstract List obtenerAsistencias();

    public abstract List obtenerAusencias();

    public abstract List obtenerRetrasos();

    public abstract int obtenerTotalAsistencia();

    public abstract float obtenerPorcentajeAsistencia();

    public abstract float calcularTeimpoReal();

    public abstract void iniciar();

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
