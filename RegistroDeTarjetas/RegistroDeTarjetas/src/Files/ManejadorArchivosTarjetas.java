/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import NumerosDeTarjeta.TarjetaDeCredito;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author marito
 */
public class ManejadorArchivosTarjetas {
    
    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
     */
    public void escribirEnArchivoTarjeta(String path, TarjetaDeCredito tarjeta) {
        ObjectOutputStream fileOut;
        try {
            fileOut = new ObjectOutputStream( //Este comando inizializa un nuevo flujo de salida
                    new FileOutputStream("binarios/"+path));                            //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeObject(tarjeta);                               //Escribe el objeto solicitud en el archivo
            fileOut.close();                                                    //Cierra el archivo
        } catch (IOException e) {                                              //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public TarjetaDeCredito leerTarjetaDeCredito(String path) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream("binarios/" + path));
            TarjetaDeCredito tarjeta = (TarjetaDeCredito) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
            return tarjeta;
        } catch (IOException e) {
            throw new AssertionError("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new AssertionError("ClassNotFound " + e.getMessage());
        }
    }
    
}
