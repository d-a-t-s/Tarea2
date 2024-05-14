package org.example;

public class Invitacion {
    private Reunion reunion;
    private Invitable invitado;

    // Constructor
    public Invitacion(Reunion reunion, Invitable invitado) {
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
