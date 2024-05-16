package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * La clase Informe se encarga de generar informes para diferentes tipos de reuniones.
 */
public class Informe {
    FileWriter archivo;
    PrintWriter escritor;

    /**
     * Constructor de la clase Informe.
     */
    public Informe() {
        archivo = null;
        escritor = null;
    }

    /**
     * Genera un informe para una reunión virtual.
     *
     * @param reunion La reunión virtual para la cual se genera el informe.
     * @throws IOException si hay un error de entrada/salida al escribir en el archivo.
     */
    public void hacerInforme(ReunionVirtual reunion) throws IOException {
        try {
            archivo = new FileWriter("Informe\\Informe1.txt");
            escritor = new PrintWriter(archivo);
            escritor.println("INFORME DE LA REUNION");
            escritor.println("Fecha de la reunion: " + reunion.getFecha());
            escritor.println("Hora de inicio: " + reunion.getHoraInicio() + " Hora de fin: " + reunion.getHoraFin() + " Duracion total: " + reunion.calcularTiempoReal());
            escritor.println("Enlace: " + reunion.getEnlace());
            escritor.println("Lista de participantes: ");
            for (Asistencia asistente : reunion.asistentesPresentes) {
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            for (Asistencia asistente : reunion.asistentesTarde) {
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            escritor.println("Notas de la reunion: ");
            for (Nota nota : reunion.notas) {
                escritor.println(nota.getContenido());
            }
            archivo.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Genera un informe para una reunión presencial.
     *
     * @param reunion La reunión presencial para la cual se genera el informe.
     * @throws IOException si hay un error de entrada/salida al escribir en el archivo.
     */
    public void hacerInforme(ReunionPresencial reunion) throws IOException {
        try {
            archivo = new FileWriter("Informe\\Informe.txt");
            escritor = new PrintWriter(archivo);
            escritor.println("INFORME DE LA REUNION");
            escritor.println("Fecha de la reunion: " + reunion.getFecha());
            escritor.println("Hora de inicio: " + reunion.getHoraInicio() + " Hora de fin: " + reunion.getHoraFin() + " Duracion total: " + reunion.calcularTiempoReal());
            escritor.println("Enlace: " + reunion.getSala());
            escritor.println("Lista de participantes: ");
            for (Asistencia asistente : reunion.asistentesPresentes) {
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            for (Asistencia asistente : reunion.asistentesTarde) {
                escritor.println(asistente.getEmpleado().getNombre() + " " + asistente.getEmpleado().getApellidos());
            }
            escritor.println("Notas de la reunion: ");
            for (Nota nota : reunion.notas) {
                escritor.println(nota.getContenido());
            }
            archivo.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
