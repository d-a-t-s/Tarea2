package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReunionVirtualTest {

    private Empleado empleado1;
    private Empleado empleado2;
    private Empleado empleado3;
    private Empleado empleado4;
    private Empleado empleado5;
    private Empleado empleado6;
    private Departamento departamento1;
    private Departamento departamento2;
    private ReunionVirtual reunionVirtual;

    @BeforeEach
    void setUp() {
        empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        empleado2 = new Empleado(2, "María", "Gómez", "maria@example.com");
        empleado3 = new Empleado(3, "Pedro", "López", "pedro@example.com");
        empleado4 = new Empleado(4, "Ana", "Martínez", "ana@example.com");
        empleado5 = new Empleado(5, "Luis", "Rodríguez", "luis@example.com");
        empleado6 = new Empleado(6, "Laura", "Sánchez", "laura@example.com");

        departamento1 = new Departamento("Ventas");
        departamento1.agregarEmpleado(empleado1);
        departamento1.agregarEmpleado(empleado2);
        departamento1.agregarEmpleado(empleado3);

        departamento2 = new Departamento("Marketing");
        departamento2.agregarEmpleado(empleado4);
        departamento2.agregarEmpleado(empleado5);
        departamento2.agregarEmpleado(empleado6);

        LocalDate fechaReunion = LocalDate.of(2024, 5, 16);
        Instant horaPrevista = Instant.parse("2024-05-16T09:00:00Z");
        Duration duracionPrevista = Duration.ofHours(1);
        String enlaceReunion = "https://ejemplo.com/reunion";
        reunionVirtual = new ReunionVirtual(empleado1, fechaReunion, horaPrevista, duracionPrevista, enlaceReunion, TipoReunion.MARKETING);
        departamento1.invitar(reunionVirtual);
        departamento2.invitar(reunionVirtual);
    }

    @Test
    void testMain() throws InterruptedException {
        List<Invitacion> invitaciones = reunionVirtual.getInvitados();

        reunionVirtual.ingresarReunion(invitaciones.get(0));
        reunionVirtual.ingresarReunion(invitaciones.get(1));
        reunionVirtual.iniciar();
        Thread.sleep(10000);
        reunionVirtual.agregarNota("Feliz en mi reunion :) XDXDXD");
        reunionVirtual.ingresarReunion(invitaciones.get(2));
        reunionVirtual.ingresarReunion(invitaciones.get(3));
        reunionVirtual.finalizar();

        assertEquals(4, reunionVirtual.obtenerTotalAsistencia());
        assertEquals(66.66667, reunionVirtual.obtenerPorcentajeAsistencia(), 0.00001);

        assertEquals(2, reunionVirtual.asistentesPresentes.size());
        assertEquals(2, reunionVirtual.asistentesTarde.size());

        assertTrue(reunionVirtual.getNotas().size() > 0);

        Informe informe = new Informe();
        try {
            informe.hacerInforme(reunionVirtual);
        } catch (IOException e) {
            fail("Error al generar el informe: " + e.getMessage());
        }
    }
}
