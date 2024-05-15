package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

class ReunionVirtual extends Reunion {
    private String enlace;

    // Constructor
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(organizador, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        invitados.add(invitacion);
    }

    // Método para marcar asistencia
    public void marcarAsistencia(Asistencia asistencia) {
        switch (asistencia.getEstado()) {
            case PRESENTE:
                asistentesPresentes.add(asistencia);
                break;
            case AUSENTE:
                asistentesAusentes.add(asistencia);
                break;
            case TARDE:
                asistentesTarde.add(asistencia);
                break;
        }
    }

    @Override
    public void ingresarReunion() {
        // Lógica para unirse a la reunión virtual
        System.out.println("Unirse a la reunión virtual en: " + enlace);
    }

    @Override
    public List<Asistencia> obtenerAsistencia() {
        return asistentesPresentes;
    }

    @Override
    public List<Asistencia> obtenerAusencias() {
        return asistentesAusentes;
    }

    @Override
    public List<Asistencia> obtenerRetrasos() {
        return asistentesTarde;
    }

    @Override
    public int obtenerTotalAsistencia() {
        // Lógica para calcular el total de asistentes a la reunión virtual
        return asistentesPresentes.size() + asistentesTarde.size();
    }

    @Override
    public float obtenerPorcentajeAsistencia() {
        // Lógica para calcular el porcentaje de asistencia a la reunión virtual
        int totalInvitados = invitados.size();
        int totalAsistentes = obtenerTotalAsistencia();
        return (totalAsistentes / (float) totalInvitados) * 100;
    }

    @Override
    public float calcularTiempoReal() {
        // Lógica para calcular el tiempo real de la reunión virtual
        // Puede depender de la duración de la reunión y de cualquier retraso registrado
        if (horaInicio == null || horaFin == null) {
            return 0;
        }
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    @Override
    public void iniciar() {
        // Lógica para iniciar la reunión virtual
        horaInicio = Instant.now();
        LocalDateTime fechaHoraInicio = LocalDateTime.ofInstant(horaInicio, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaInicioFormateada = fechaHoraInicio.format(formateador);
        System.out.println("La reunión virtual ha comenzado a las " + horaInicioFormateada);
    }

    @Override
    public void finalizar() {
        // Lógica para finalizar la reunión virtual
        horaFin = Instant.now();
        LocalDateTime fechaHoraFin = LocalDateTime.ofInstant(horaInicio, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaFinFormateada = fechaHoraFin.format(formateador);
        System.out.println("La reunión virtual ha finalizado a las" + horaFinFormateada);
    }



}

