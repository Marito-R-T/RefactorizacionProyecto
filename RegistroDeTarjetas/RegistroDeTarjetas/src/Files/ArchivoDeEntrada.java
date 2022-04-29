package Files;

import Files.ControladorDeArchivos;
import Instrucciones.management.FactoryInstruccion;
import Instrucciones.Instruccion;
import Instrucciones.management.EjecutorInstruccion;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class ArchivoDeEntrada implements Serializable {

    private final EjecutorInstruccion ejecutor = new EjecutorInstruccion();
    private final FactoryInstruccion factory = new FactoryInstruccion();

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
        while (archivoEntrada.hasNextLine()) {
            try {
                String line = archivoEntrada.nextLine();
                System.out.println(line);
                instrucciones.add(String.valueOf(line));
                ejecutor.setInstruccion(factory.getInstruccion(line));
                ejecutor.ejectuarInstruccion(line);
            } catch (AssertionError err) {
                System.out.println(err.getMessage());
            }
        }
    }

}//cerramos la clase ArchivoDeEntrada. 
