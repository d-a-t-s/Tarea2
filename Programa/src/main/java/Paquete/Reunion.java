package Paquete;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Reunion{
    //Propiedades
    private List invitados;
    private Asistencia asistentes;
    private Empleado organizador;
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private Map<Invitable, Invitacion> invitaciones;

    //Metodos
    public Reunion(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista){
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = null;
        this.horaFin = null;
    }
    public abstract void ingresarReunion();

    public abstract List obtenerAsistencias();

    public abstract List obtenerAusencias();

    public abstract List obtenerRetrasos();

    public abstract int obtenerTotalAsistencia();

    public abstract float obtenerPorcentajeAsistencia();

    public abstract float calcularTeimpoReal();

    public abstract void iniciar();

    public abstract void finalizar();

    public void agregarInvitacion(Invitable invitado, Invitacion invitacion) {
        if (invitaciones == null) {
            invitaciones = new HashMap<>();
        }
        invitaciones.put(invitado, invitacion);
    }
}
