/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import Instrucciones.Instruccion;
import Instrucciones.Solicitud;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author marito
 */
public class ManejadorArchivosInstrucciones {

    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
     */
    public void escribirEnArchivoInstruccion(String path, Instruccion instruccion) {
        ObjectOutputStream fileOut;
        try {
            fileOut = new ObjectOutputStream( //Este comando inizializa un nuevo flujo de salida
                    new FileOutputStream("binarios/"+path));                            //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeObject(instruccion);                               //Escribe el objeto solicitud en el archivo
            fileOut.close();                                                    //Cierra el archivo
        } catch (IOException e) {                                              //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Solicitud leerSolicitud(String path) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream("binarios/" + path));
            Solicitud solicitud = (Solicitud) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
            return solicitud;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return null;
    }
    
}
