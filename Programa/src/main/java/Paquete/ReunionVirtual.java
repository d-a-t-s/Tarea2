package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class ReunionVirtual extends Reunion{
    //Propiedades
    private String enlace;
    //Metodos
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }


}
