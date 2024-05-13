package Paquete;

import java.util.ArrayList;

public class Departamento implements Invitable{
    //Propiedades
    private String nombre;
    private ArrayList departamento;
    //Metodos
    public Departamento(String nombre){
        this.nombre = nombre;
        departamento = new ArrayList();
    }
    public void addEmpleado(Empleado e){
        departamento.add(e);
    }
    public int obtenerCantidadEmpleados(){
        return departamento.size();
    }
    public void invitar(){

    }
}
