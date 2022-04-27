package Instrucciones;

import java.io.Serializable;
import registrodetarjetas.ControladorDeArchivos;
import registrodetarjetas.TarjetaDeCredito;

public class Cancelacion_Tarjeta  extends AccionTarjeta  implements Serializable {
    public void evaluarLinea(String line){
        try{
            String numeroDeTarjeta=line
                .replaceAll("CANCELACION_TARJETA","")
                .replace("(", "")
                .replace(")", "");
            String nombreDelArchivo="Tarjeta"+numeroDeTarjeta+".tacre";
            ControladorDeArchivos controlador = new ControladorDeArchivos();
            TarjetaDeCredito tarjeta = new TarjetaDeCredito();
            tarjeta=controlador.leerTarjetaDeCredito(nombreDelArchivo);
        if(tarjeta.getCreditoDeTarjeta()<0){
            tarjeta.setEstaActiva(false);
        }else{
            System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
        }
        }
        catch(NullPointerException e){
            System.out.println("No puede autorizar solicitudes que no existan ");
        }
    }
    
}
