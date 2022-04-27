package Instrucciones;

import java.io.Serializable;
import registrodetarjetas.ControladorDeArchivos;
import registrodetarjetas.Disenio;

public class Instruccion implements Serializable {
    Disenio cont = new Disenio();
    /*
    A continuacion se van a hacer las inicializaciones de los objetos 
    para poder utilizar sus metodos, ya que todas las instruciones 
    tienen atributos y por lo cual tambien tienen estado, entonces 
    es necesario instanciar.
    */
    Autorizacion_Tarjeta autorizacion = new Autorizacion_Tarjeta();
    Cancelacion_Tarjeta cancelacion = new Cancelacion_Tarjeta();
    Consultar_Tarjeta consultar = new Consultar_Tarjeta();
    Estado_Cuenta estado = new Estado_Cuenta();
    Listado_Solicitudes listadoSolicitudes = new Listado_Solicitudes();
    Listado_Tarjetas listadoTarjetas = new Listado_Tarjetas();
    Movimiento movimiento = new Movimiento();
    Solicitud solicitud= new Solicitud();
    ControladorDeArchivos controlador = new ControladorDeArchivos();
    
    public void evaluarLinea(String line){
        if(line.startsWith("SOLICITUD")){
            solicitud.evaluarLinea(line);
        }
        if(line.startsWith("MOVIMIENTO")){
            movimiento.evaluarLinea(line);
        }
        if(line.startsWith("AUTORIZACION_TARJETA")){
            autorizacion.evaluarLinea(line);
        }
        if(line.startsWith("CANCELACION_TARJETA")){
            cancelacion.evaluarLinea(line);
        }
        if(line.startsWith("CONSULTAR_TARJETA")){
            consultar.evaluarLinea(line);
        }
        if(line.startsWith("ESTADO_CUENTA")){
            estado.evaluarLinea(line);
        }
        if(line.startsWith("LISTADO_TARJETAS")){
            listadoTarjetas.evaluarLinea(line);
        }
        if(line.startsWith("LISTADO_SOLICITUDES")){
            listadoSolicitudes.evaluarLinea(line);
        }
    }
}
