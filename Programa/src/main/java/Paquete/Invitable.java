package Paquete;

import java.time.Instant;

/**
 * Interfaz que define el comportamiento del empleado que puede ser invitado a una reunión.
 */
interface Invitable {

    /**
     * Método para invitar al empleado a una reunión.
     * @param reunion La reunión a la que se invita.
     * @param horaInvitacion La hora en la que se envía la invitación.
     */
    void invitar(Reunion reunion, Instant horaInvitacion);
}
