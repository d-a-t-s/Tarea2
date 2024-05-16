package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Instant;

public class AsistenciaTest {

    @Test
    public void testConstructor() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com", new Departamento("Departamento"));
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(empleado, estado);

        assertNotNull(asistencia);
        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(estado, asistencia.getEstado());
        assertNotNull(asistencia.getHoraLlegada());
    }

    @Test
    public void testConstructor_EmpleadoNulo() {
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;

        assertThrows(CampoVacioException.class, () -> {
            Asistencia asistencia = new Asistencia(null, estado);
        });
    }

    @Test
    public void testConstructor_EstadoNulo() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com", new Departamento("Departamento"));

        assertThrows(CampoVacioException.class, () -> {
            Asistencia asistencia = new Asistencia(empleado, null);
        });
    }

    @Test
    public void testMarcarLlegada() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com", new Departamento("Departamento"));
        EstadoAsistencia estado = EstadoAsistencia.AUSENTE;
        Instant horaLlegada = Instant.now();

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarLlegada(horaLlegada);

        assertEquals(EstadoAsistencia.TARDE, asistencia.getEstado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
    }

    @Test
    public void testMarcarAusente() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com", new Departamento("Departamento"));
        EstadoAsistencia estado = EstadoAsistencia.PRESENTE;

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarAusente();

        assertEquals(EstadoAsistencia.AUSENTE, asistencia.getEstado());
    }

    @Test
    public void testMarcarPresente() {
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com", new Departamento("Departamento"));
        EstadoAsistencia estado = EstadoAsistencia.AUSENTE;

        Asistencia asistencia = new Asistencia(empleado, estado);
        asistencia.marcarPresente();

        assertEquals(EstadoAsistencia.PRESENTE, asistencia.getEstado());
    }
}
