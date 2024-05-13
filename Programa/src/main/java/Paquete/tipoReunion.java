package Paquete;

enum tipoReunion{
    TECNICA(1),
    MARKETING(2),
    OTRO(3)

    private final int valor;

    tipoReunion(int valor){
        this.value = value;
    }

    public int getReunion(){
        return valor;
    }
}