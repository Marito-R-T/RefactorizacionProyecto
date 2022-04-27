package registrodetarjetas;

import java.io.Serializable;


public class RegistroDeTarjetas implements Serializable{
    
    public  void main(String[] args) {
        ArchivoDeEntrada archivo = new ArchivoDeEntrada();
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        controlador.edicionDeReporteHTML("<html>\n");    
        //archivo.asignarArchivo();
        
 }
    }

