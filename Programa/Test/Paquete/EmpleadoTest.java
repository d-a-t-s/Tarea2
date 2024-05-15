package Paquete;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void invitar() {
        Empleado empleado = new Empleado(1, "Nombre", "Apellido", "correo@example.com");
        Reunion reunion = new Reunion(); // Reemplaza ImplementacionDeReunion con tu implementación real de la interfaz Reunion
        Instant horaInvitacion = Instant.now();

        // Act
        empleado.invitar(reunion, horaInvitacion);

        // Assert
        assertTrue(reunion.agregarInvitacion(empleado, horaInvitacion)); // Ajusta el método seHaAgregadoInvitacion según la lógica de tu implementación de Reunion
    }
}