package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de invitados (empleados)
        List<Empleado> invitados = new ArrayList<>();

        // Crear instancias de Empleado con el departamento correspondiente
        Departamento marketing = new Departamento("Marketing");
        Departamento otro = new Departamento("Otro");

        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com", marketing);
        Empleado empleado2 = new Empleado(2, "María", "Gómez", "maria@example.com", otro);
        Empleado empleado3 = new Empleado(3, "Pedro", "López", "pedro@example.com", marketing);
        Empleado empleado4 = new Empleado(4, "Ana", "Martínez", "ana@example.com", otro);
        Empleado empleado5 = new Empleado(5, "Carlos", "García", "carlos@example.com", marketing);
        Empleado empleado6 = new Empleado(6, "Sofía", "Hernández", "sofia@example.com", otro);
        Empleado empleado7 = new Empleado(7, "Luis", "Díaz", "luis@example.com", marketing);

        // Agregar empleados a la lista de invitados
        invitados.add(empleado1);
        invitados.add(empleado2);
        invitados.add(empleado3);
        invitados.add(empleado4);
        invitados.add(empleado5);
        invitados.add(empleado6);
        invitados.add(empleado7);

        // Crear una instancia de organizador
        Empleado organizador = empleado1; // Podría ser cualquier empleado

        // Crear una fecha y hora prevista para la reunión
        LocalDate fechaReunion = LocalDate.now(); // Fecha actual
        Instant horaInicioPrevista = Instant.now(); // Hora prevista de inicio
        Duration duracionPrevista = Duration.ofHours(1); // Duración prevista de la reunión (1 hora)

        // Crear un enlace para unirse a la reunión virtual
        String enlaceReunion = "https://ejemplo.com/reunion"; // Enlace para unirse a la reunión virtual

        // Crear una instancia de ReunionVirtual
        ReunionVirtual reunionVirtual = new ReunionVirtual(invitados, organizador, fechaReunion, horaInicioPrevista, duracionPrevista, enlaceReunion);

        // Marcar la asistencia de cada empleado
        Instant horaActual = Instant.now(); // Se asume que la hora actual es cuando los empleados llegan a la reunión
        for (Empleado empleado : invitados) {
            Asistencia asistencia;
            if (empleado.getId() == 1) {
                // Marcar a empleado1 como llegada tarde
                asistencia = new Asistencia(empleado, Asistencia.EstadoAsistencia.TARDE);
                asistencia.setHoraLlegadaTarde(Instant.now()); // Suponiendo que llega tarde en el momento actual
            } else if (empleado.getId() == 3 || empleado.getId() == 5) {
                // Marcar a empleado3 y empleado5 como presentes
                asistencia = new Asistencia(empleado, Asistencia.EstadoAsistencia.PRESENTE);
            } else {
                // Marcar a los demás empleados como ausentes
                asistencia = new Asistencia(empleado, Asistencia.EstadoAsistencia.AUSENTE);
            }
            reunionVirtual.marcarAsistencia(asistencia);
        }

        // Acceder a las listas de asistencia
        List<Asistencia> asistentesPresentes = reunionVirtual.obtenerAsistencia();
        List<Asistencia> asistentesAusentes = reunionVirtual.obtenerAusencias();
        List<Asistencia> asistentesTarde = reunionVirtual.obtenerRetrasos();

        // Imprimir el número de asistentes presentes
        System.out.println("Número de asistentes presentes: " + asistentesPresentes.size());

        // Imprimir el número de asistentes ausentes
        System.out.println("Número de asistentes ausentes: " + asistentesAusentes.size());

        // Imprimir el número de asistentes que llegaron tarde
        System.out.println("Número de asistentes que llegaron tarde: " + asistentesTarde.size());

        // Mostrar la hora de llegada tarde de cada empleado que llegó tarde
        for (Asistencia asistencia : asistentesTarde) {
            System.out.println("Empleado: " + asistencia.getEmpleado().getNombre() +
                    ", Hora de llegada tarde: " + asistencia.getHoraLlegadaTarde());
        }
    }
}
