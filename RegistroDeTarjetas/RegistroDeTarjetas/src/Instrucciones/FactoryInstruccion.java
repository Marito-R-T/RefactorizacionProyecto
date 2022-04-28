/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instrucciones;

/**
 *
 * @author marito
 */
public class FactoryInstruccion {

    public Instruccion getInstruccion(String line) {
        if (line.startsWith("SOLICITUD")) {
            return new Solicitud();
        } else if (line.startsWith("MOVIMIENTO")) {
            return new Movimiento();
        } else if (line.startsWith("AUTORIZACION_TARJETA")) {
            return new Autorizacion_Tarjeta();
        } else if (line.startsWith("CANCELACION_TARJETA")) {
            return new Cancelacion_Tarjeta();
        } else if (line.startsWith("CONSULTAR_TARJETA")) {
            return new Consultar_Tarjeta();
        } else if (line.startsWith("ESTADO_CUENTA")) {
            return new Estado_Cuenta();
        } else if (line.startsWith("LISTADO_TARJETAS")) {
            return new Listado_Tarjetas();
        } else if (line.startsWith("LISTADO_SOLICITUDES")) {
            return new Listado_Solicitudes();
        } else {
            throw new AssertionError(line);
        }
    }

}
