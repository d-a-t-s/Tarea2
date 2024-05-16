package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Informe{
    FileWriter archivo;
    PrintWriter escritor;

    public Informe(){
        archivo = null;
        escritor = null;
    }

    public void InformeVirtual(ReunionVirtual reunion) throws IOException{
        try {
            archivo = new FileWriter("C:\\Users\\Daniel Tamaro\\Desktop\\Programacion\\Repositorios\\Tarea2\\Informe\\Informe.txt");
            escritor = new PrintWriter(archivo);
            escritor.println("INFORME DE LA REUNION");
            escritor.println("Fecha de la reunion: " + reunion.getFecha());
            escritor.println("Hora de inicio: " + reunion.getHoraInicio() + " Hora de fin: " + reunion.getHoraFin() + " Duracion total: " + reunion.calcularTiempoReal());
            escritor.println("Enlace: " + reunion.getEnlace());
            escritor.println("Lista de participantes: ");
            for(Asistencia asistente : reunion.asistentesPresentes){
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            for(Asistencia asistente : reunion.asistentesTarde){
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            escritor.println("Notas de la reunion: ");
            for(Nota nota : reunion.notas){
                escritor.println(nota.getContenido());
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
