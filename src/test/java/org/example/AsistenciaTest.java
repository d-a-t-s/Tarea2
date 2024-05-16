package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Instant;

/**
 * Clase de prueba para la clase Asistencia.
 */
public class AsistenciaTest {

    /**
     * Prueba del constructor de Asistencia.
     */
    @Test
    public void testConstructor() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example9.com");
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(empleado, estado);

        assertNotNull(asistencia);
        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(estado, asistencia.getEstado());
        assertNotNull(asistencia.getHoraLlegada());
    }

    /**
     * Prueba del constructor de Asistencia con empleado nulo.
     */
    @Test
    public void testConstructor_EmpleadoNulo() {
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;

        assertThrows(CampoVacioException.class, () -> {
            Asistencia asistencia = new Asistencia(null, estado);
        });
    }

    /**
     * Prueba del constructor de Asistencia con estado nulo.
     */
    @Test
    public void testConstructor_EstadoNulo() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");

        assertThrows(CampoVacioException.class, () -> {
            Asistencia asistencia = new Asistencia(empleado, null);
        });
    }

    /**
     * Prueba para marcar la llegada a la reunión.
     */
    @Test
    public void testMarcarLlegada() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        EstadoAsistencia estado = EstadoAsistencia.AUSENTE;
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarLlegada(horaLlegada);

        assertEquals(EstadoAsistencia.TARDE, asistencia.getEstado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
    }

    /**
     * Prueba para marcar asistente como ausente.
     */
    @Test
    public void testMarcarAusente() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarAusente();

        assertEquals(EstadoAsistencia.AUSENTE, asistencia.getEstado());
    }

    /**
     * Prueba para marcar asistente como presente.
     */
    @Test
    public void testMarcarPresente() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        EstadoAsistencia estado = EstadoAsistencia.AUSENTE;

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarPresente();

        assertEquals(EstadoAsistencia.PRESENTE, asistencia.getEstado());
    }
}
