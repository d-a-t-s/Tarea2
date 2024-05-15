package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReunionVirtual extends Reunion {
    private String enlace;
    private Map<Invitable, Invitacion> invitaciones;

    // Constructor
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        getInvitados().add(invitacion);
    }

    // Método para marcar asistencia
    public void marcarAsistencia(Asistencia asistencia) {
        switch (asistencia.getEstado()) {
            case PRESENTE:
                getAsistentesPresentes().add(asistencia);
                break;
            case AUSENTE:
                getAsistentesAusentes().add(asistencia);
                break;
            case TARDE:
                getAsistentesTarde().add(asistencia);
                break;
        }
    }

    @Override
    public void ingresarReunion() {
        // Lógica para unirse a la reunión virtual
        System.out.println("Unirse a la reunión virtual en: " + enlace);
    }

    @Override
    public int obtenerAsistencia() {
        return getAsistentesAusentes();
    }

    @Override
    public List<Asistencia> obtenerAusencias() {
        List<Asistencia> ausencias = new ArrayList<>();
        for (Empleado invitado : invitados) {
            boolean presente = false;
            for (Asistencia asistencia : asistentesPresentes) {
                if (asistencia.getEmpleado().equals(invitado)) {
                    presente = true;
                    break;
                }
            }
            if (!presente) {
                // Si el empleado no está en la lista de asistentes presentes, se marca como ausente
                ausencias.add(new Asistencia(invitado, Asistencia.EstadoAsistencia.AUSENTE));
            }
        }
        return ausencias;
    }

    @Override
    public List<Asistencia> obtenerRetrasos() {
        List<Asistencia> retrasos = new ArrayList<>();
        for (Asistencia asistencia : asistentesTarde) {
            // Si la hora de llegada tardía está presente, se considera un retraso
            if (asistencia.getHoraLlegadaTarde() != null) {
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }

    @Override
    public int obtenerTotalAsistencia() {
        // Lógica para calcular el total de asistentes a la reunión virtual
        return asistentes.size();
    }

    @Override
    public float obtenerPorcentajeAsistencia() {
        // Lógica para calcular el porcentaje de asistencia a la reunión virtual
        return 0;
    }

    @Override
    public float calcularTiempoReal() {
        // Lógica para calcular el tiempo real de la reunión virtual
        // Puede depender de la duración de la reunión y de cualquier retraso registrado
        return 0; // Implementación temporal
    }

    @Override
    public void iniciar() {
        // Lógica para iniciar la reunión virtual
        System.out.println("La reunión virtual ha comenzado.");
        horaInicio = Instant.now();
    }

    @Override
    public void finalizar() {
        // Lógica para finalizar la reunión virtual
        System.out.println("La reunión virtual ha finalizado.");
        horaFin = Instant.now();
    }



}

