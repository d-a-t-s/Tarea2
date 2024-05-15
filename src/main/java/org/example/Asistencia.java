package org.example;

import java.time.Instant;

public class Asistencia {
    //Propiedades
    private Empleado empleado;
    private EstadoAsistencia estado;
    private Instant horaLlegada;

    // Constructor
    public Asistencia(Empleado empleado, EstadoAsistencia estado) {
        this.empleado = empleado;
        this.estado = estado;
        horaLlegada = Instant.now();
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

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Instant horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    // Método para marcar al empleado como llegado tarde
    public void marcarLlegada(Instant horaLlegada) {
        this.estado = EstadoAsistencia.TARDE;
        this.horaLlegada = horaLlegada;
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
