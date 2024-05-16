package org.example;

/**
 * La clase CampoVacioException se utiliza para indicar que un campo requerido está vacío.
 * Esta excepción se extiende de IllegalArgumentException.
 */
class CampoVacioException extends IllegalArgumentException {

    /**
     * Constructor que acepta el nombre del campo vacío y construye el mensaje de excepción.
     *
     * @param campo El nombre del campo que está vacío.
     */
    public CampoVacioException(String campo) {
        super("El campo '" + campo + "' no puede estar vacío.");
    }
}
