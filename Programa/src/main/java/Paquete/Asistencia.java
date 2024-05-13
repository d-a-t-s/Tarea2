package Paquete;

import java.util.ArrayList;
import java.util.List;

public class Asistencia{
    private Empleado empleado;
    private EstadoAsistencia estado;

    public Asistencia(Empleado empleado, EstadoAsistencia estado) {
        this.empleado = empleado;
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }
}
