package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba para la clase Departamento.
 */
public class DepartamentoTest {

    /**
     * Prueba del constructor de Departamento.
     */
    @Test
    public void testConstructor() {
        String nombre = "Departamento de Pruebas";

        Departamento departamento = new Departamento(nombre);

        assertEquals(nombre, departamento.getNombre());
        assertTrue(departamento.getEmpleados().isEmpty());
    }

    /**
     * Prueba del constructor de Departamento con nombre nulo.
     */
    @Test
    public void testConstructor_NombreNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Departamento departamento = new Departamento(null);
        });
    }

    /**
     * Prueba del constructor de Departamento con nombre vacío.
     */
    @Test
    public void testConstructor_NombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            Departamento departamento = new Departamento("");
        });
    }

    /**
     * Prueba para agregar un empleado al departamento.
     */
    @Test
    public void testAgregarEmpleado() {
        Departamento departamento = new Departamento("Departamento de Pruebas");
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");

        departamento.agregarEmpleado(empleado);

        assertTrue(departamento.getEmpleados().contains(empleado));
    }

    /**
     * Prueba para remover un empleado del departamento.
     */
    @Test
    public void testRemoverEmpleado() {
        Departamento departamento = new Departamento("Departamento de Pruebas");
        Empleado empleado = new Empleado(1, "Juan", "Pérez", "juan@example.com");

        departamento.agregarEmpleado(empleado);
        departamento.removerEmpleado(empleado);

        assertFalse(departamento.getEmpleados().contains(empleado));
    }

    /**
     * Prueba para obtener el número de empleados del departamento.
     */
    @Test
    public void testObtenerNumeroEmpleados() {
        Departamento departamento = new Departamento("Departamento de Pruebas");
        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        Empleado empleado2 = new Empleado(2, "Ana", "García", "ana@example.com");

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        assertEquals(2, departamento.obtenerNumeroEmpleados());
    }

    /**
     * Prueba para invitar a un departamento a una reunión.
     */
    @Test
    public void testInvitar() {
        // Creamos un departamento
        Departamento departamento = new Departamento("Departamento de Pruebas");

        // Creamos algunos empleados
        Empleado empleado1 = new Empleado(1, "Juan", "Pérez", "juan@example.com");
        Empleado empleado2 = new Empleado(2, "Ana", "García", "ana@example.com");

        // Agregamos los empleados al departamento
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        // Creamos una reunión
        Reunion reunion = new ReunionVirtual(empleado1, null, null, null, "enlace",TipoReunion.MARKETING);

        // Invitamos al departamento a la reunión
        departamento.invitar(reunion);

        // Verificamos que la reunión se haya agregado correctamente a la lista de reuniones de los empleados
        assertTrue(empleado1.getReuniones().contains(reunion));
        assertTrue(empleado2.getReuniones().contains(reunion));
    }
}
