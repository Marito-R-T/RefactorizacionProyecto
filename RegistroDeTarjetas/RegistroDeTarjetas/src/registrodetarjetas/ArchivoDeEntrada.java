package registrodetarjetas;

import Instrucciones.FactoryInstruccion;
import Instrucciones.Instruccion;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class ArchivoDeEntrada implements Serializable {

    Disenio actualizarInstrucciones = new Disenio();

    /*
    Este procedimiento sirve para leer el archivo de entrada 
    que contiene todas las instrucciones a ingresar al sistema.
     */
    public ArrayList<String> leerArchivo(String path) throws FileNotFoundException {
        Scanner archivoDeEntrada;
        ArrayList<String> instrucciones = new ArrayList<>();
        try {
            archivoDeEntrada = new Scanner(new FileReader(path));
            ControladorDeArchivos.crearArchivo("numeroNacionalCorriente.txt");
            ControladorDeArchivos.crearArchivo("numeroRegionalCorriente.txt");
            ControladorDeArchivos.crearArchivo("numeroInternacionalCorriente.txt");
            ejecutarInstrucciones(archivoDeEntrada, instrucciones);
            archivoDeEntrada.close(); //luego de haber abierto el archivo de entrada tambien hay que cerrarlo para 
            //que se liberen desbloquerlo y que se liberen recursos. 
            return instrucciones;
        } catch (FileNotFoundException e) { // si el archivo no existe captura la excepcion y lanza un mensaje
            throw new FileNotFoundException();
        }
    }//cerramos el procedimiento asignarArchivo

    private void ejecutarInstrucciones(Scanner archivoEntrada, ArrayList<String> instrucciones) {
        String line = null;
        FactoryInstruccion fi = new FactoryInstruccion();
        while (archivoEntrada.hasNextLine()) {
            try {
                line = archivoEntrada.nextLine();
                System.out.println(line);
                instrucciones.add(String.valueOf(line));
                Instruccion instruccion = fi.getInstruccion(line);
                instruccion.evaluarLinea(line);
            } catch (AssertionError err) {
                System.out.println("Error al ejecutar: " + err.getMessage());
            }
        }
    }

}//cerramos la clase ArchivoDeEntrada. 
