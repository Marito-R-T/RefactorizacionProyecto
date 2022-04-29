/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instrucciones.management;

import Instrucciones.Instruccion;

/**
 *
 * @author marito
 */
public class EjecutorInstruccion {

    private Instruccion instruccion;

    public void ejectuarInstruccion(String line) {
        try{
            instruccion.evaluarLinea(line);
        } catch(AssertionError err) {
            throw new AssertionError("Error en instruccion de tipo" + instruccion.getClass(), err.getCause());
        }  catch(NullPointerException ex) {
            throw new AssertionError("Error en instruccion de tipo" + instruccion.getClass(), ex);
        }
    }

    public Instruccion getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Instruccion instruccion) {
        this.instruccion = instruccion;
    }

}
