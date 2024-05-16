package org.example;

import java.time.Instant;

/**
 * La clase Invitacion representa una invitación a una reunión para un empleado en particular.
 */
public class Invitacion {
    // Propiedades
    private Instant hora;
    private Empleado invitado;

    /**
     * Constructor para crear una instancia de Invitacion.
     * La hora de la invitación se establece en el momento de la creación.
     */
    public Invitacion() {
        hora = Instant.now();
    }

    /**
     * Obtiene la hora en que se envió la invitación.
     *
     * @return la hora de la invitación.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Establece la hora de la invitación.
     *
     * @param hora La hora de la invitación a establecer.
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el empleado invitado.
     *
     * @return el empleado invitado.
     */
    public Empleado getInvitado() {
        return invitado;
    }

    /**
     * Establece el empleado invitado.
     *
     * @param invitado El empleado invitado a establecer.
     */
    public void setInvitado(Empleado invitado) {
        this.invitado = invitado;
    }
}
