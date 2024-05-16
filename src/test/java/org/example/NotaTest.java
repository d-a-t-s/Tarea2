package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Nota.
 */
public class NotaTest {

    /**
     * Prueba del constructor de Nota.
     */
    @Test
    public void testConstructorNota() {
        // Arrange
        String contenido = "Contenido de la nota";

        // Act
        Nota nota = new Nota(contenido);

        // Assert
        assertEquals(contenido, nota.getContenido());
    }

    /**
     * Prueba del constructor de Nota con contenido vacío.
     */
    @Test
    public void testConstructorNotaContenidoVacio() {
        // Arrange
        String contenido = "";

        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Nota(contenido);
        });
    }

    /**
     * Prueba del constructor de Nota con contenido nulo.
     */
    @Test
    public void testConstructorNotaContenidoNulo() {
        // Arrange
        String contenido = null;

        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Nota(contenido);
        });
    }

    /**
     * Prueba del método setContenido de Nota.
     */
    @Test
    public void testSetContenido() {
        // Arrange
        String contenidoInicial = "Contenido inicial";
        String contenidoNuevo = "Contenido nuevo";
        Nota nota = new Nota(contenidoInicial);

        // Act
        nota.setContenido(contenidoNuevo);

        // Assert
        assertEquals(contenidoNuevo, nota.getContenido());
    }
}
