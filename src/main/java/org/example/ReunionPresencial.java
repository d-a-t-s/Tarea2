package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ReunionPresencial representa una reunión que se lleva a cabo en un lugar físico.
 * Extiende la clase Reunion.
 */
class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial.
     *
     * @param organizador      El organizador de la reunión.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista de inicio de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param sala             La sala donde se llevará a cabo la reunión.
     * @param tipoReunion      El tipo de reunión.
     * @throws CampoVacioException si no se proporciona una sala.
     */
    public ReunionPresencial(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String sala, TipoReunion tipoReunion) {
        super(organizador, fecha, horaPrevista, duracionPrevista, tipoReunion);
        if (sala == null || sala.isEmpty()) {
            throw new CampoVacioException("Debe existir una sala.");
        }
        this.sala = sala;
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param texto El contenido de la nota a agregar.
     */
    @Override
    public void agregarNota(String texto) {
        Nota nota = new Nota(texto);
        notas.add(nota);
    }

    /**
     * Agrega una invitación a la reunión.
     *
     * @param invitado   El empleado invitado.
     * @param invitacion La invitación enviada al empleado.
     */
    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        invitados.add(invitacion);
    }

    /**
     * Agrega a un invitado a la reunión según su invitación.
     * Si la reunión está en curso y el invitado llega a tiempo, se marca como presente.
     * Si llega después del inicio de la reunión, se marca como llegada tarde.
     *
     * @param invitacion La invitación del invitado a la reunión.
     */
    public void ingresarReunion(Invitacion invitacion) {
        Asistencia asistencia = new Asistencia(invitacion.getInvitado(), EstadoAsistencia.AUSENTE);
        if (Instant.now().isBefore(horaFin) && !Instant.now().isAfter(horaInicio)) {
            asistencia.setEstado(EstadoAsistencia.PRESENTE);
            asistentesPresentes.add(asistencia);
        } else if (Instant.now().isBefore(horaFin)) {
            asistencia.setEstado(EstadoAsistencia.TARDE);
            asistentesTarde.add(asistencia);
        }
    }

    /**
     * Retorna la lista de asistentes presentes en la reunión.
     *
     * @return La lista de asistentes presentes.
     */
    @Override
    public List<Asistencia> obtenerAsistencia() {
        return asistentesPresentes;
    }

    /**
     * Retorna la lista de asistentes que llegaron tarde a la reunión.
     *
     * @return La lista de asistentes que llegaron tarde.
     */
    @Override
    public List<Asistencia> obtenerRetrasos() {
        return asistentesTarde;
    }

    /**
     * Retorna la lista de asistentes ausentes en la reunión.
     * Los asistentes ausentes son aquellos que fueron invitados a la reunión pero no se presentaron.
     *
     * @return La lista de asistentes ausentes.
     */
    @Override
    public List<Asistencia> obtenerAusencias() {
        // Se crea una lista auxiliar para almacenar todos los asistentes presentes y llegados tarde
        List<Asistencia> aux = new ArrayList<>();
        aux.addAll(asistentesPresentes);
        aux.addAll(asistentesTarde);

        // Se recorren todas las invitaciones para comprobar si el invitado está en la lista de asistentes
        for (Invitacion invitado : invitados) {
            boolean val = false; // Se inicializa un booleano que indica si el invitado está presente o llegó tarde
            for (Asistencia asistente : aux) {
                // Si el invitado está presente o llegó tarde, se marca como encontrado
                if (invitado.getInvitado() == asistente.getEmpleado()) {
                    val = true;
                }
            }
            // Si el invitado no fue encontrado en la lista de asistentes, se considera ausente y se agrega a la lista de ausentes
            if (!val) {
                Asistencia ausente = new Asistencia(invitado.getInvitado(), EstadoAsistencia.AUSENTE);
                asistentesAusentes.add(ausente);
            }
        }
        // Se retorna la lista de asistentes ausentes
        return asistentesAusentes;
    }


    /**
     * Retorna el total de asistentes a la reunión (presentes y llegados tarde).
     *
     * @return El total de asistentes.
     */
    @Override
    public int obtenerTotalAsistencia() {
        return asistentesPresentes.size() + asistentesTarde.size();
    }

    /**
     * Calcula el porcentaje de asistencia a la reunión.
     *
     * @return El porcentaje de asistencia.
     */
    @Override
    public float obtenerPorcentajeAsistencia() {
        int totalInvitados = invitados.size();
        int totalAsistentes = obtenerTotalAsistencia();
        return (totalAsistentes / (float) totalInvitados) * 100;
    }

    /**
     * Calcula la duración real de la reunión en minutos.
     *
     * @return La duración real de la reunión.
     */
    @Override
    public float calcularTiempoReal() {
        if (horaInicio == null || horaFin == null) {
            return 0;
        }
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    /**
     * Inicia la reunión registrando la hora de inicio.
     */
    @Override
    public void iniciar() {
        horaInicio = Instant.now();
        LocalDateTime fechaHoraInicio = LocalDateTime.ofInstant(horaInicio, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaInicioFormateada = fechaHoraInicio.format(formateador);
        System.out.println("La reunión virtual ha comenzado a las " + horaInicioFormateada);
    }

    /**
     * Finaliza la reunión registrando la hora de finalización.
     *
     * @throws ReunionNoIniciadaException si la reunión no ha sido iniciada.
     */
    @Override
    public void finalizar() {
        if (horaInicio == null) {
            throw new ReunionNoIniciadaException("No se puede finalizar una reunión que no ha sido iniciada.");
        }
        horaFin = Instant.now();
        LocalDateTime fechaHoraFin = LocalDateTime.ofInstant(horaFin, ZoneId.systemDefault());
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyy");
        String horaFinFormateada = fechaHoraFin.format(formateador);
        System.out.println("La reunión virtual ha finalizado a las " + horaFinFormateada);
    }

    /**
     * Retorna el nombre de la sala de la reunión.
     *
     * @return El nombre de la sala.
     */
    public String getSala() {
        return sala;
    }
}


