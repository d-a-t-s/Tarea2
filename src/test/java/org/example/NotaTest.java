package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    public void testConstructorNota() {
        // Arrange
        String contenido = "Contenido de la nota";

        // Act
        Nota nota = new Nota(contenido);

        // Assert
        assertEquals(contenido, nota.getContenido());
    }

    @Test
    public void testConstructorNotaContenidoVacio() {
        // Arrange
        String contenido = "";

        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Nota(contenido);
        });
    }

    @Test
    public void testConstructorNotaContenidoNulo() {
        // Arrange
        String contenido = null;

        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Nota(contenido);
        });
    }

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
