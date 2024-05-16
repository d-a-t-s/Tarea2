package org.example;

import java.time.Instant;

public class Invitacion {
    //Propiedades
    private Instant hora;
    private Empleado invitado;
    //Metodos
    public Invitacion(){
        hora = Instant.now();
    }

    //Getters y setters
    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }
    public Empleado getInvitado(){
        return invitado;
    }
    public void setInvitado(Empleado invitado){
        this.invitado = invitado;
    }
}
