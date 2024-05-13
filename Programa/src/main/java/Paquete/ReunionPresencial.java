package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class ReunionPresencial extends Reunion{
    //Propiedades
    private String sala;
    //Metodos
    public ReunionPresencial(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Instant horaInicio, Instant horaFin, String sala){
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }
}
