package Paquete;

public class Main{
    public static void main(String[] args){
        Empleado e1 = new Empleado(123456, "Juan", "Perez", "JuanPerez@gmail.com");
        Retraso r = new Retraso();
        r.addAsistente(e1);
        Empleado r1 = r.getAsistente();


    }
}
