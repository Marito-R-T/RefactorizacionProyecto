/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodetarjetas;

import NumerosDeTarjeta.TarjetaDeCredito;
import Instrucciones.*;
import java.io.*;

/**
 *
 * @author kevin
 */
public class ControladorDeArchivos implements Serializable {

    public static void crearArchivo(String nombre) {
        DataOutputStream fileOut;
        try {
            fileOut = new DataOutputStream( //Este comando inizializa un nuevo flujo de salida
                    new FileOutputStream(nombre));                                      //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeInt(1);
            fileOut.close();                                                    //Cierra el archivo
        } catch (IOException e) {                                                  //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }
}
