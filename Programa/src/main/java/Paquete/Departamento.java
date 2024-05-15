package Paquete;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{
    //Propiedades
    private String nombre;
    private List<Empleado> departamento;
    //Metodos
    public Departamento(String nombre){
        this.nombre = nombre;
        departamento = new ArrayList<>();
    }
    public void addEmpleado(Empleado e){
        departamento.add(e);
    }

    public Empleado getEmpleado(int pos){
        return departamento.get(pos);
    }

    public int obtenerCantidadEmpleados(){
        return departamento.size();
    }

    public void invitar(Reunion reunion){
       for(Empleado empleado : departamento){
           empleado.invitar(reunion);
       }
    }
}
