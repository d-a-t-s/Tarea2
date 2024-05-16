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

        Empleado empleado0 = new Empleado(1, "Felipe", "Soto", "felipe@example.com");
        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        Empleado empleado2 = new Empleado(2, "María", "Gómez", "maria@example.com");
        Empleado empleado3 = new Empleado(3, "Pedro", "López", "pedro@example.com");
        Empleado empleado4 = new Empleado(4, "Ana", "Martínez", "ana@example.com");
        Empleado empleado5 = new Empleado(5, "Carlos", "García", "carlos@example.com");
        Empleado empleado6 = new Empleado(6, "Sofía", "Hernández", "sofia@example.com");
        Empleado empleado7 = new Empleado(7, "Luis", "Díaz", "luis@example.com");

        /* //Invitar a todo el departamento
        for (Empleado empleado : marketing.getEmpleados()) {
            invitados.add(empleado);
        } */



        System.out.println("Empleados del departamento " + marketing.getNombre() + ":");
        for (Empleado empleado : marketing.getEmpleados()) {
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos());
        }


        /*// Agregar empleados a la lista de invitados
        invitados.add(empleado1);
        invitados.add(empleado2);
        invitados.add(empleado3);
        invitados.add(empleado4);
        invitados.add(empleado5);
        invitados.add(empleado6);
        invitados.add(empleado7); */

        // Crear una instancia de organizador
        Empleado organizador = empleado0; // Podría ser cualquier empleado

        // Crear una fecha y hora prevista para la reunión
        LocalDate fechaReunion = LocalDate.now(); // Fecha actual
        Instant horaInicioPrevista = Instant.now(); // Hora prevista de inicio
        Duration duracionPrevista = Duration.ofHours(1); // Duración prevista de la reunión (1 hora)

        // Crear un enlace para unirse a la reunión virtual
        String enlaceReunion = "https://ejemplo.com/reunion"; // Enlace para unirse a la reunión virtual

        // Crear una instancia de ReunionVirtual
        ReunionVirtual reunionVirtual = new ReunionVirtual(organizador, fechaReunion, horaInicioPrevista, duracionPrevista, enlaceReunion);

        empleado1.invitar(reunionVirtual);
        empleado2.invitar(reunionVirtual);
        empleado3.invitar(reunionVirtual);
        empleado4.invitar(reunionVirtual);


        // Marcar la asistencia de cada empleado
        Instant horaActual = Instant.now(); // Se asume que la hora actual es cuando los empleados llegan a la reunión
        for (Empleado empleado : invitados) {
            Asistencia asistencia;
            if (empleado.getId() == 1) {
                // Marcar a empleado1 como llegada tarde
                asistencia = new Asistencia(empleado, EstadoAsistencia.TARDE);

                asistencia.setHoraLlegada(Instant.now()); // Suponiendo que llega tarde en el momento actual

                // asistencia.setHoraLlegadaTarde(Instant.now()); // Suponiendo que llega tarde en el momento actual

            } else if (empleado.getId() == 3 || empleado.getId() == 5) {
                // Marcar a empleado3 y empleado5 como presentes
                asistencia = new Asistencia(empleado, EstadoAsistencia.PRESENTE);
            } else{
                // Marcar a los demás empleados como ausentes
                asistencia = new Asistencia(empleado, EstadoAsistencia.AUSENTE);
            }
            reunionVirtual.marcarAsistencia(asistencia);
        }

        // Acceder y imprimir las listas de asistentes desde el main
        List<Asistencia> presentes = reunionVirtual.asistentesPresentes;
        List<Asistencia> ausentes = reunionVirtual.asistentesAusentes;
        List<Asistencia> tarde = reunionVirtual.asistentesTarde;

        // Imprimir el número de asistentes presentes
        System.out.println("Número de asistentes presentes: " + presentes.size());

        // Imprimir el número de asistentes ausentes
        System.out.println("Número de asistentes ausentes: " + ausentes.size());

        // Imprimir el número de asistentes que llegaron tarde
        System.out.println("Número de asistentes que llegaron tarde: " + tarde.size());

        // Mostrar la hora de llegada tarde de cada empleado que llegó tarde
        for (Asistencia asistencia : tarde) {
            System.out.println("Empleado: " + asistencia.getEmpleado().getNombre() +
                    ", Hora de llegada tarde: " + asistencia.getHoraLlegada());
        }
    }
}