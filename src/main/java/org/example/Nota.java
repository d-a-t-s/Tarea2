package org.example;

/**
 * La clase Nota representa una nota con contenido.
 */
public class Nota {
    /** Contenido de la nota */
    private String contenido;

    /**
     * Constructor de la clase Nota.
     *
     * @param contenido El contenido de la nota.
     * @throws IllegalArgumentException si el contenido es nulo o está vacío.
     */
    public Nota(String contenido) {
        if (contenido == null || contenido.isEmpty()) {
            throw new IllegalArgumentException("El contenido de la nota no puede estar vacío.");
        }
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la nota.
     *
     * @param contenido El nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve una representación en cadena de la nota.
     *
     * @return El contenido de la nota como una cadena de caracteres.
     */
    @Override
    public String toString() {
        return contenido;
    }
}
