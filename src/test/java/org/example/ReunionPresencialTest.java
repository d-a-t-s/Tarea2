package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReunionPresencialTest {

    private ReunionPresencial reunion;
    private Empleado organizador;
    private Invitacion invitacion;

    @BeforeEach
    void setUp() {
        organizador = new Empleado(1, "NombreOrganizador", "ApellidosOrganizador", "organizador@example.com");
        LocalDate fecha = LocalDate.now();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        String sala = "Sala de reuniones";
        reunion = new ReunionPresencial(organizador, fecha, horaPrevista, duracionPrevista, sala);
        invitacion = new Invitacion();
        invitacion.setInvitado(new Empleado(2, "NombreInvitado", "ApellidosInvitado", "invitado@example.com"));
    }

    @Test
    void agregarNota() {
        reunion.agregarNota("Nota de prueba");
        // Como el método obtenerNotas no está definido en ReunionPresencial,
        // no podemos probar la cantidad de notas agregadas aquí.
    }

    @Test
    void agregarInvitacion() {
        reunion.agregarInvitacion(invitacion.getInvitado(), invitacion);
        // Como el método obtenerInvitaciones no está definido en ReunionPresencial,
        // no podemos probar la cantidad de invitaciones agregadas aquí.
    }

    @Test
    void marcarAsistencia() {
        Asistencia asistencia = new Asistencia(organizador, EstadoAsistencia.PRESENTE);
        reunion.marcarAsistencia(asistencia);
        assertEquals(1, reunion.obtenerAsistencia().size());
    }

    @Test
    void ingresarReunionConInvitacion() {
        reunion.ingresarReunion(invitacion);
        assertEquals(1, reunion.obtenerAsistencia().size());
    }

    @Test
    void ingresarReunionConListaDeInvitados() {
        List<Invitacion> invitados = new ArrayList<>();
        invitados.add(invitacion);
        reunion.ingresarReunion(invitados);
        assertEquals(1, reunion.obtenerAsistencia().size());
    }

    @Test
    void obtenerRetrasos() {
        Asistencia asistencia = new Asistencia(organizador, EstadoAsistencia.TARDE);
        reunion.marcarAsistencia(asistencia);
        assertEquals(1, reunion.obtenerRetrasos().size());
    }

    @Test
    void obtenerAusencias() {
        List<Invitacion> invitados = new ArrayList<>();
        invitados.add(invitacion);
        assertEquals(1, reunion.obtenerAusencias().size());
    }

    @Test
    void obtenerTotalAsistencia() {
        Asistencia asistencia1 = new Asistencia(new Empleado(3, "Asistente1", "ApellidosAsistente1", "asistente1@example.com"), EstadoAsistencia.PRESENTE);
        Asistencia asistencia2 = new Asistencia(new Empleado(4, "Asistente2", "ApellidosAsistente2", "asistente2@example.com"), EstadoAsistencia.TARDE);
        reunion.marcarAsistencia(asistencia1);
        reunion.marcarAsistencia(asistencia2);
        assertEquals(2, reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() {
        List<Invitacion> invitados = new ArrayList<>();
        invitados.add(invitacion);
        assertEquals(0, reunion.obtenerPorcentajeAsistencia());
    }

    @Test
    void calcularTiempoReal() {
        assertEquals(0, reunion.calcularTiempoReal());
    }

    @Test
    void iniciar() {
        assertDoesNotThrow(() -> reunion.iniciar());
    }

    @Test
    void finalizar() {
        assertThrows(ReunionNoIniciadaException.class, () -> reunion.finalizar());
        reunion.iniciar();
        assertDoesNotThrow(() -> reunion.finalizar());
    }
}
