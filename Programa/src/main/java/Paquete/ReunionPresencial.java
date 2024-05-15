package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una reunión presencial, extiende de la clase Reunion.
 */
public class ReunionPresencial extends Reunion{

    /** Sala donde se llevará a cabo la reunión presencial */
    private String sala;
    //Metodos
    public ReunionPresencial(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }
    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion){
        invitacion.setInvitado(invitado);
        getInvitados().add(invitacion);
    }

    @Override
    public void ingresarReunion(Invitacion invitacion){

    }

    @Override
    public List obtenerAsistencias(){
        return List.of();
    }

    @Override
    public List obtenerAusencias(){
        return List.of();
    }

    @Override
    public List obtenerRetrasos(){
        return List.of();
    }

    @Override
    public int obtenerTotalAsistencia(){
        return 0;
    }

    @Override
    public float obtenerPorcentajeAsistencia(){
        return 0;
    }

    @Override
    public void iniciar(){

    }

    @Override
    public void finalizar(){

    }
    //Getter
    public String getSala(){
        return sala;
    }
}
