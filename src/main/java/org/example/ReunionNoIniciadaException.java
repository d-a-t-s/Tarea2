package org.example;

class ReunionNoIniciadaException extends IllegalStateException {
    public ReunionNoIniciadaException(String mensaje) {
        super(mensaje);
    }
}
