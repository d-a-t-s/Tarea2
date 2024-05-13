package Paquete;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

public class Departamento implements Invitable {
    //Propiedades
    private String nombre;
    private List<Empleado> empleados;

    //Metodos
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void invitar(Reunion reunion, Instant horaInvitacion) {
        for (Empleado empleado : empleados) {
            empleado.invitar(reunion, horaInvitacion);
        }
    }
}
