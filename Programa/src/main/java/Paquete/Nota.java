package Paquete;

/**
 * Clase que representa una nota asociada a una reunión.
 */
public class Nota {

    /** Contenido de la nota */
    private String contenido;

    /**
     * Constructor de la clase Nota.
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido de la nota.
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido de la nota.
     * @param contenido El nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve una representación en cadena de la nota.
     * @return El contenido de la nota como una cadena de caracteres.
     */
    @Override
    public String toString() {
        return contenido;
    }
}
