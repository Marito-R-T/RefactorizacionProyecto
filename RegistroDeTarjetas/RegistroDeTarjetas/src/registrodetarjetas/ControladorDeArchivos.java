/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrodetarjetas;
import Instrucciones.Solicitud;
import java.io.*;
/**
 *
 * @author kevin
 */
public class ControladorDeArchivos implements Serializable {
    Solicitud solicitud;
    TarjetaDeCredito tarjeta;
    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
    */
    public static void escribirEnArchivo(String nombreDelArchivo,Object objetoAEscribir){
        ObjectOutputStream fileOut;
        try{
            fileOut = new ObjectOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
            new FileOutputStream(nombreDelArchivo));                            //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeObject(objetoAEscribir);                               //Escribe el objeto solicitud en el archivo
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                              //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    public static void crearArchivo(String nombre){
            DataOutputStream fileOut;
        try{
            fileOut = new DataOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
            new FileOutputStream(nombre));                                      //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeInt(1);
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                                  //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

public TarjetaDeCredito leerTarjetaDeCredito(String archivoEntrante){
        ObjectInputStream fileIn;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            tarjeta = (TarjetaDeCredito) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
        }
        catch (IOException e)
        {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return tarjeta;
    }

    public Solicitud leerSolicitud(String archivoEntrante){
        ObjectInputStream fileIn;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            solicitud = (Solicitud) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
        }
        catch (IOException e)
        {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return solicitud;
    }
    
    public void edicionDeReporteHTML(String textoEntrante){
    File archivo = new File("Reportes.html");
    FileOutputStream salida = null;
		try {
                        salida = new FileOutputStream(archivo,true);
			salida.write(textoEntrante.getBytes());
                        salida.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage()+" no se pudo gravar el texto");
		}
    }
}



