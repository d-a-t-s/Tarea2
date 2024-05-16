package org.example;

class CampoVacioException extends IllegalArgumentException {
    public CampoVacioException(String campo) {
        super("El campo '" + campo + "' no puede estar vacío.");
    }
}