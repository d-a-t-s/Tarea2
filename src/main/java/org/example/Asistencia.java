package org.example;

import java.time.Instant;

public class Asistencia {
    public enum EstadoAsistencia {
        PRESENTE,
        AUSENTE,
        TARDE
    }

    private Empleado empleado;
    private EstadoAsistencia estado;
    private Instant horaLlegadaTarde;

    // Constructor
    public Asistencia(Empleado empleado, EstadoAsistencia estado) {
        this.empleado = empleado;
        this.estado = estado;
    }

    // Métodos getters y setters
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }

    public Instant getHoraLlegadaTarde() {
        return horaLlegadaTarde;
    }

    public void setHoraLlegadaTarde(Instant horaLlegadaTarde) {
        this.horaLlegadaTarde = horaLlegadaTarde;
    }

    // Método para marcar al empleado como llegado tarde
    public void marcarLlegadaTarde(Instant horaLlegadaTarde) {
        this.estado = EstadoAsistencia.TARDE;
        this.horaLlegadaTarde = horaLlegadaTarde;
    }

    // Método para marcar al empleado como ausente
    public void marcarAusente() {
        this.estado = EstadoAsistencia.AUSENTE;
    }

    // Método para marcar al empleado como presente
    public void marcarPresente() {
        this.estado = EstadoAsistencia.PRESENTE;
    }
}
