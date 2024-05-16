package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class ReunionPresencial extends Reunion {
    private String sala;

    // Constructor
    public ReunionPresencial(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(organizador, fecha, horaPrevista, duracionPrevista);

        if (sala == null || sala.isEmpty()) {
            throw new CampoVacioException("Debe existir una sala.");
        }

        this.sala = sala;
    }

    @Override
    public void agregarNota(String texto){
        Nota nota = new Nota(texto);
        notas.add(nota);
    }

    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        invitados.add(invitacion);
    }

    // Método para marcar asistencia
    public void marcarAsistencia(Asistencia asistencia) {
        switch (asistencia.getEstado()){
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
    //Metodo para agregar a la reunion uno por uno
    @Override
    public void ingresarReunion(Invitacion invitacion){
        List<Invitacion> copiaInvitado = new ArrayList<>(invitados);
        Asistencia asistencia = new Asistencia(invitacion.getInvitado(), EstadoAsistencia.AUSENTE);
        if(asistencia.getHoraLlegada().isBefore(horaPrevista)){
            asistencia.setEstado(EstadoAsistencia.PRESENTE);
            asistentesPresentes.add(asistencia);
        } else if(asistencia.getHoraLlegada().isAfter(horaPrevista)){
            asistencia.setEstado(EstadoAsistencia.TARDE);
            asistentesTarde.add(asistencia);
        }
        copiaInvitado.remove(invitacion);
    }
    //Metodo para agregar una lista de invitados
    @Override
    public void ingresarReunion(List<Invitacion> invitados){

        if (invitados == null || invitados.isEmpty()) {
            throw new CampoVacioException("La lista de invitados no puede estar vacía o ser nula.");
        }


        for (Invitacion invitacion : invitados){
            Asistencia asistencia = new Asistencia(invitacion.getInvitado(), EstadoAsistencia.AUSENTE);
            if(asistencia.getHoraLlegada().isBefore(horaPrevista)){
                asistencia.setEstado(EstadoAsistencia.PRESENTE);
                asistentesPresentes.add(asistencia);
            }else if(asistencia.getHoraLlegada().isAfter(horaPrevista)){
                asistencia.setEstado(EstadoAsistencia.TARDE);
                asistentesTarde.add(asistencia);
            }
        }
    }

    @Override
    public List<Asistencia> obtenerAsistencia(){
        return asistentesPresentes;

    }

    @Override
    public List<Asistencia> obtenerRetrasos() {
        return asistentesTarde;
    }

    @Override
    public List<Asistencia> obtenerAusencias(){
        for (Invitacion invitado : invitados){
            boolean aux = false;
            for (Asistencia asistente : asistentesPresentes){
                if (invitado.getInvitado() == asistente.getEmpleado()){
                    aux = true;
                }
            }
            if (aux == false) {
                Asistencia ausente = new Asistencia(invitado.getInvitado(), EstadoAsistencia.AUSENTE);
                asistentesAusentes.add(ausente);
            }
        }
        return asistentesAusentes;
    }

    @Override
    public int obtenerTotalAsistencia(){
        return asistentesPresentes.size() + asistentesTarde.size();
    }

    @Override
    public float obtenerPorcentajeAsistencia() {
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

    public String getSala(){
        return sala;
    }
}
