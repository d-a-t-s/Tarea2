package Paquete;

import java.time.Instant;

/**
 * Clase que representa una invitación a una reunión.
 */
class Invitacion {

    /** Hora en la que se envió la invitación. */
    private Instant hora;

    /**
     * Constructor de la clase Invitacion.
     * @param hora La hora en la que se envió la invitación.
     */
    public Invitacion(Instant hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la hora en la que se envió la invitación.
     * @return La hora en la que se envió la invitación.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Establece la hora en la que se envió la invitación.
     * @param hora La nueva hora de la invitación.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }
}
