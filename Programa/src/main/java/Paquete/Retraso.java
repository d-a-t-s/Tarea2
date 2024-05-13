package Paquete;

import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant horaLlegadaTarde;

    public Retraso(Empleado empleado, Instant horaLlegadaTarde) {
        super(empleado, EstadoAsistencia.Tarde);
        this.horaLlegadaTarde = horaLlegadaTarde;
    }

    public Instant getHoraLlegadaTarde() {
        return horaLlegadaTarde;
    }
}
