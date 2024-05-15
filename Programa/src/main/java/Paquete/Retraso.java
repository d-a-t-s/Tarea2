package Paquete;

import java.time.Instant;

public class Retraso extends Asistencia{
    //Propiedades
    private Empleado atrasado;
    private Instant hora;
    //Metodos
    public Retraso(Empleado atrasado){
        super(atrasado);
        hora = Instant.now();
    }
}
