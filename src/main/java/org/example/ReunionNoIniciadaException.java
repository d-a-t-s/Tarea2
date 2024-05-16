package org.example;

/**
 * La clase ReunionNoIniciadaException se utiliza para indicar que se ha intentado realizar una operación en una reunión que aún no ha sido iniciada.
 * Esta excepción se extiende de IllegalStateException.
 */
class ReunionNoIniciadaException extends IllegalStateException {
    /**
     * Constructor que acepta un mensaje descriptivo para la excepción.
     *
     * @param mensaje El mensaje descriptivo de la excepción.
     */
    public ReunionNoIniciadaException(String mensaje) {
        super(mensaje);
    }
}
