package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    @Test
    void testCrearInvitacionConReunionVirtual() throws InvitacionException {
        // Crear un departamento válido para el empleado
        Departamento departamento = new Departamento("Departamento de Prueba");

        // Crear un empleado con los parámetros requeridos
        Empleado organizador = new Empleado(1, "Nombre", "Apellido", "email@example.com", departamento);

        // Crear una reunión virtual con los parámetros requeridos
        ReunionVirtual reunionVirtual = new ReunionVirtual(
                new ArrayList<>(), organizador, LocalDate.now(), Instant.now(),
                Duration.ofHours(1), "https://example.com");

        // Crear un invitado válido para la reunión
        Invitable invitado = new Invitable() {
            // No se requiere implementación para esta prueba
        };

        // Verificar que la creación de la invitación no lance excepciones
        assertDoesNotThrow(() -> new Invitacion(reunionVirtual, invitado));
    }

    @Test
    void testCrearInvitacionConReunionVirtualNula() {
        Invitable invitado = new Invitable() {
            // No se requiere implementación para esta prueba
        };

        InvitacionException exception = assertThrows(InvitacionException.class,
                () -> new Invitacion(null, invitado));
        assertEquals("La reunión no puede ser nula.", exception.getMessage());
    }

    @Test
    void testCrearInvitacionConInvitadoNulo() {
        // Crear un departamento válido para el empleado
        Departamento departamento = new Departamento("Departamento de Prueba");

        // Crear un empleado con los parámetros requeridos
        Empleado organizador = new Empleado(1, "Nombre", "Apellido", "email@example.com", departamento);

        // Crear una reunión virtual válida para la prueba
        ReunionVirtual reunionVirtual = new ReunionVirtual(
                new ArrayList<>(), organizador, LocalDate.now(), Instant.now(),
                Duration.ofHours(1), "https://example.com");

        InvitacionException exception = assertThrows(InvitacionException.class,
                () -> new Invitacion(reunionVirtual, null));
        assertEquals("El invitado no puede ser nulo.", exception.getMessage());
    }

    @Test
    void testCrearInvitacionConReunionVirtualYInvitadoNulos() {
        InvitacionException exception = assertThrows(InvitacionException.class,
                () -> new Invitacion(null, null));
        assertEquals("Ambos la reunión y el invitado no pueden ser nulos.", exception.getMessage());
    }
}
