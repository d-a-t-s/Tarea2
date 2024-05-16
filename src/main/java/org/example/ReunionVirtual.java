package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class ReunionVirtual extends Reunion {
    private String enlace;

    // Constructor
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace, TipoReunion tipoReunion) {
        super(organizador, fecha, horaPrevista, duracionPrevista, tipoReunion);
        if (enlace == null || enlace.isEmpty()){
            throw new CampoVacioException("El enlace de la reunión virtual no puede estar vacío.");
        }
        this.enlace = enlace;
    }

    @Override
    public void agregarNota(String texto) {
        Nota nota = new Nota(texto);
        notas.add(nota);
    }

    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        invitados.add(invitacion);
    }

    public void ingresarReunion(Invitacion invitacion){
        Asistencia asistencia = new Asistencia(invitacion.getInvitado(), EstadoAsistencia.AUSENTE);
        if(Instant.now().isBefore(horaFin) && !Instant.now().isAfter(horaInicio)){
            asistencia.setEstado(EstadoAsistencia.PRESENTE);
            asistentesPresentes.add(asistencia);
        }else if(Instant.now().isBefore(horaFin)){
            asistencia.setEstado(EstadoAsistencia.TARDE);
            asistentesTarde.add(asistencia);
        }
    }

    @Override
    public List<Asistencia> obtenerAsistencia() {
        return asistentesPresentes;
    }

    @Override
    public List<Asistencia> obtenerRetrasos() {
        return asistentesTarde;
    }

    @Override
    public List<Asistencia> obtenerAusencias(){
        List<Asistencia> aux = new ArrayList<>();
        aux.addAll(asistentesPresentes);
        aux.addAll(asistentesTarde);
        for (Invitacion invitado : invitados){
            boolean val= false;
            for (Asistencia asistente : aux){
                if (invitado.getInvitado() == asistente.getEmpleado()){
                    val = true;
                }
            }
            if (val == false) {
                Asistencia ausente = new Asistencia(invitado.getInvitado(), EstadoAsistencia.AUSENTE);
                asistentesAusentes.add(ausente);
            }
        }
        return asistentesAusentes;
    }

    @Override
    public int obtenerTotalAsistencia() {
        return asistentesPresentes.size() + asistentesTarde.size();
    }

    @Override
    public float obtenerPorcentajeAsistencia(){
        int totalInvitados = invitados.size();
        int totalAsistentes = obtenerTotalAsistencia();
        return (totalAsistentes / (float) totalInvitados) * 100;
    }

    @Override
    public float calcularTiempoReal() {
        if (horaInicio == null || horaFin == null) {
            return 0;
        }
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    @Override
    public void iniciar() {
        horaInicio = Instant.now();
        LocalDateTime fechaHoraInicio = LocalDateTime.ofInstant(horaInicio, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaInicioFormateada = fechaHoraInicio.format(formateador);
        System.out.println("La reunión virtual ha comenzado a las " + horaInicioFormateada);
    }

    @Override
    public void finalizar() {

        if (horaInicio == null) {
            throw new ReunionNoIniciadaException("No se puede finalizar una reunión que no ha sido iniciada.");
        }

        horaFin = Instant.now();
        LocalDateTime fechaHoraFin = LocalDateTime.ofInstant(horaInicio, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaFinFormateada = fechaHoraFin.format(formateador);
        System.out.println("La reunión virtual ha finalizado a las" + horaFinFormateada);
    }
    public String getEnlace(){
        return enlace;
    }
}

