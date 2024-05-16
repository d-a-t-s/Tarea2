package org.example;

/**
 * La interfaz Invitable define el comportamiento para objetos que pueden ser invitados a reuniones.
 */
public interface Invitable {
    /**
     * Invita a la entidad a una reunión.
     *
     * @param reunion La reunión a la que se invita a la entidad.
     */
    public void invitar(Reunion reunion);
}
