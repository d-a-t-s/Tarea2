package Paquete;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args){
        Empleado e1 = new Empleado(123456, "Juan", "Perez", "JuanPerez@gmail.com");
        ReunionPresencial r1 = new ReunionPresencial(e1, LocalDate.of(2024,5,12), Instant.parse("2024-05-12T12:00:00Z"), Duration.ofMinutes(40), "411");
        System.out.println(r1.getOrganizador().getApellido());
    }
}
