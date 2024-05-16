package org.example;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear instancias de Empleado con el departamento correspondiente
        Departamento marketing = new Departamento("Marketing");
        Departamento otro = new Departamento("Otro");

        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        Empleado empleado2 = new Empleado(2, "María", "Gómez", "maria@example.com");
        Empleado empleado3 = new Empleado(3, "Pedro", "López", "pedro@example.com");
        Empleado empleado4 = new Empleado(4, "Ana", "Martínez", "ana@example.com");
        Empleado empleado5 = new Empleado(5, "Luis", "Rodríguez", "luis@example.com");
        Empleado empleado6 = new Empleado(6, "Laura", "Sánchez", "laura@example.com");

        // Crear departamentos
        Departamento departamento1 = new Departamento("Ventas");
        departamento1.agregarEmpleado(empleado1);
        departamento1.agregarEmpleado(empleado2);
        departamento1.agregarEmpleado(empleado3);

        Departamento departamento2 = new Departamento("Marketing");
        departamento2.agregarEmpleado(empleado4);
        departamento2.agregarEmpleado(empleado5);
        departamento2.agregarEmpleado(empleado6);

        // Crear reunión virtual
        LocalDate fechaReunion = LocalDate.of(2024, 5, 16);
        Instant horaPrevista = Instant.parse("2024-05-16T09:00:00Z");
        Duration duracionPrevista = Duration.ofHours(1);
        String enlaceReunion = "https://ejemplo.com/reunion";
        ReunionVirtual reunionVirtual = new ReunionVirtual(empleado1, fechaReunion, horaPrevista, duracionPrevista, enlaceReunion);

        // Invitar empleados de ambos departamentos a la reunión
        departamento1.invitar(reunionVirtual);
        departamento2.invitar(reunionVirtual);

        // Imprimir nombres de los invitados
        System.out.println("Invitados a la reunión:");
        for (Invitacion invitacion : reunionVirtual.getInvitados()) {
            System.out.println(invitacion.getInvitado().getNombre());
        }

        // Simular asistencia de los empleados
        List<Invitacion> invitaciones = reunionVirtual.getInvitados();
        for (int i = 0; i < invitaciones.size(); i++) {
            Empleado empleado = invitaciones.get(i).getInvitado();
            Asistencia asistencia;
            if (i < 3) {
                // Los primeros 3 empleados están presentes
                asistencia = new Asistencia(empleado, EstadoAsistencia.PRESENTE);
            } else if (i < 5) {
                // Los siguientes 2 empleados llegan tarde
                asistencia = new Asistencia(empleado, EstadoAsistencia.TARDE);
            } else {
                // El último empleado está ausente
                asistencia = new Asistencia(empleado, EstadoAsistencia.AUSENTE);
            }
            reunionVirtual.marcarAsistencia(asistencia);
        }

        System.out.println("");
        // Mostrar resultados de la asistencia
        System.out.println("Asistencia a la reunión:");
        List<Asistencia> asistencias = reunionVirtual.obtenerAsistencia();
        List<Asistencia> retrasos = reunionVirtual.obtenerRetrasos();
        List<Asistencia> ausencias = reunionVirtual.obtenerAusencias();
        int totalAsistentes = reunionVirtual.obtenerTotalAsistencia();
        float porcentajeAsistencia = reunionVirtual.obtenerPorcentajeAsistencia();

        System.out.println("Asistentes:");
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia.getEmpleado().getNombre() + " - " + asistencia.getEstado());
        }
        // Crear una instancia de Informe y generar el informe
        Informe informe = new Informe();
        try {
            informe.hacerInforme(reunionVirtual);
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());

            System.out.println("Retrasos:");
            for (Asistencia retraso : retrasos) {
                System.out.println(retraso.getEmpleado().getNombre() + " - " + retraso.getEstado());
            }

            System.out.println("Ausencias:");
            for (Asistencia ausencia : ausencias) {
                System.out.println(ausencia.getEmpleado().getNombre() + " - " + ausencia.getEstado());
            }

            System.out.println("Total de asistentes: " + totalAsistentes);
            System.out.println("Porcentaje de asistencia: " + porcentajeAsistencia + "%");
        }
    }
}
