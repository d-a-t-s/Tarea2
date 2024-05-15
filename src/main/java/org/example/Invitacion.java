package org.example;

public class Invitacion {
    private Reunion reunion;
    private Invitable invitado;

    // Constructor
    public Invitacion(Reunion reunion, Invitable invitado) throws InvitacionException {
        if (reunion == null && invitado == null) {
            throw new InvitacionException("Ambos la reunión y el invitado no pueden ser nulos.");
        }
        this.reunion = reunion;
        this.invitado = invitado;
    }

    // Métodos getters y setters
    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }
}
