package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Una reunión virtual, que extiende la clase Reunion.
 */
class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de la reunión virtual.
     *
     * @param organizador      El empleado que organiza la reunión.
     * @param fecha            La fecha de la reunión.
     * @param horaPrevista     La hora prevista de la reunión.
     * @param duracionPrevista La duración prevista de la reunión.
     * @param enlace           El enlace para unirse a la reunión virtual.
     * @param tipoReunion      El tipo de reunión.
     * @throws CampoVacioException si el enlace está vacío o nulo.
     */
    public ReunionVirtual(Empleado organizador, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String enlace, TipoReunion tipoReunion) {
        super(organizador, fecha, horaPrevista, duracionPrevista, tipoReunion);
        if (enlace == null || enlace.isEmpty()) {
            throw new CampoVacioException("El enlace de la reunión virtual no puede estar vacío.");
        }
        this.enlace = enlace;
    }

    /**
     * Agrega una nota a la reunión.
     *
     * @param texto El texto de la nota a agregar.
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
     * @param invitacion La invitación a agregar.
     */
    @Override
    public void agregarInvitacion(Empleado invitado, Invitacion invitacion) {
        invitacion.setInvitado(invitado);
        invitados.add(invitacion);
    }

    /**
     * Ingresa un invitado a la reunión, registra su asistencia y estado.
     * Si el invitado llega antes de que finalice la reunión y no es después de que comience, se registra como presente.
     * Si el invitado llega después de que la reunión haya comenzado pero antes de que finalice, se registra como llegada tarde.
     *
     * @param invitacion La invitación del invitado.
     */
    public void ingresarReunion(Invitacion invitacion) {
        // Se crea una instancia de Asistencia para el invitado de la reunión, inicialmente marcado como ausente.
        Asistencia asistencia = new Asistencia(invitacion.getInvitado(), EstadoAsistencia.AUSENTE);

        // Si la hora actual está antes de la hora de finalización y no está después de la hora de inicio, el invitado está presente.
        if (Instant.now().isBefore(horaFin) && !Instant.now().isAfter(horaInicio)) {
            asistencia.setEstado(EstadoAsistencia.PRESENTE);
            asistentesPresentes.add(asistencia); // Se agrega a la lista de asistentes presentes.
        } else if (Instant.now().isBefore(horaFin)) { // Si está antes de la hora de finalización, pero no antes de la hora de inicio, el invitado llega tarde.
            asistencia.setEstado(EstadoAsistencia.TARDE);
            asistentesTarde.add(asistencia); // Se agrega a la lista de asistentes que llegaron tarde.
        }
    }


    /**
     * Obtiene la lista de asistentes presentes en la reunión.
     *
     * @return La lista de asistentes presentes.
     */
    @Override
    public List<Asistencia> obtenerAsistencia() {
        return asistentesPresentes;
    }

    /**
     * Obtiene la lista de asistentes que llegaron tarde a la reunión.
     *
     * @return La lista de asistentes que llegaron tarde.
     */
    @Override
    public List<Asistencia> obtenerRetrasos() {
        return asistentesTarde;
    }

    /**
     * Obtiene la lista de asistencias ausentes en la reunión.
     *
     * @return La lista de asistencias ausentes.
     */
    @Override
    public List<Asistencia> obtenerAusencias() {
        // Crear una lista auxiliar para almacenar todas las asistencias, incluidas las presentes y las tardías.
        List<Asistencia> aux = new ArrayList<>();
        aux.addAll(asistentesPresentes);
        aux.addAll(asistentesTarde);

        // Iterar sobre la lista de invitados para verificar su asistencia.
        for (Invitacion invitado : invitados) {
            boolean val = false;
            // Verificar si el invitado está en la lista de asistencias.
            for (Asistencia asistente : aux) {
                if (invitado.getInvitado() == asistente.getEmpleado()) {
                    val = true;
                }
            }
            // Si el invitado no está en la lista de asistencias, agregarlo a la lista de ausentes.
            if (val == false) {
                Asistencia ausente = new Asistencia(invitado.getInvitado(), EstadoAsistencia.AUSENTE);
                asistentesAusentes.add(ausente);
            }
        }
        // Devolver la lista de asistencias ausentes.
        return asistentesAusentes;
    }


    /**
     * Calcula el total de asistentes a la reunión sumando el número de asistentes presentes y los que llegaron tarde.
     *
     * @return El número total de asistentes.
     */
    @Override
    public int obtenerTotalAsistencia() {
        return asistentesPresentes.size() + asistentesTarde.size();
    }

    /**
     * Calcula el porcentaje de asistencia a la reunión en función del número total de invitados.
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
     * @return La duración real de la reunión en minutos.
     */
    @Override
    public float calcularTiempoReal() {
        if (horaInicio == null || horaFin == null) {
            return 0;
        }
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    /**
     * Inicia la reunión estableciendo la hora de inicio y mostrando un mensaje de inicio.
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
     * Finaliza la reunión estableciendo la hora de finalización y mostrando un mensaje de finalización.
     *
     * @throws ReunionNoIniciadaException si la reunión no ha sido iniciada.
     */
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

    /**
     * Obtiene el enlace de la reunión virtual.
     *
     * @return El enlace de la reunión.
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una cadena que representa el objeto ReunionVirtual.
     */
    @Override
    public String toString() {
        return "ReunionVirtual{enlace='" + enlace + "', " + super.toString() + ", ...}";


    }
}

