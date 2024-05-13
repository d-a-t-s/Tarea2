package Paquete;

import java.util.ArrayList;
import java.util.List;

public class Asistencia{
    //Propiedades
    private List<Empleado> asistentes;
    //Metodos
    public Asistencia(){
        asistentes = new ArrayList();
    }
    public void addAsistente(Empleado e){
        asistentes.add(e);
    }
    public Empleado getAsistente(){
        return asistentes.remove(0);
    }
}
