/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Files;

import java.io.*;

/**
 *
 * @author kevin
 * @param <T>
 */
public abstract class ControladorDeArchivos<T> {

    public static void crearArchivo(String nombre) {
        DataOutputStream fileOut;
        try {
            fileOut = new DataOutputStream(
                    new FileOutputStream(nombre));
            fileOut.writeInt(1);
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
     */
    public void escribirEnArchivo(String path, T instruccion) {
        ObjectOutputStream fileOut;
        try {
            fileOut = new ObjectOutputStream(
                    new FileOutputStream("binarios/"+path));
            fileOut.writeObject(instruccion);
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public T leerArchivo(String path) {
        ObjectInputStream fileIn;
        try {
            fileIn = new ObjectInputStream(
                    new FileInputStream("binarios/" + path));
            T solicitud = (T) fileIn.readObject();
            fileIn.close();
            return solicitud;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return null;
    }
    
    public abstract File[] getFiles();
}
