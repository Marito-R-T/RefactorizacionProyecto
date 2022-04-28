package Instrucciones;

import Files.ManejadorArchivosTarjetas;
import java.io.Serializable;
import registrodetarjetas.ControladorDeArchivos;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Cancelacion_Tarjeta extends Instruccion implements Serializable {

    public void evaluarLinea(String line) {
        try {
            String numeroDeTarjeta = line
                    .replaceAll("CANCELACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", "");
            String nombreDelArchivo = "Tarjeta" + numeroDeTarjeta + ".tacre";
            TarjetaDeCredito tarjeta;
            ManejadorArchivosTarjetas mat = new ManejadorArchivosTarjetas();
            tarjeta = mat.leerTarjetaDeCredito(nombreDelArchivo);
            if (tarjeta.getCredito()< 0) {
                tarjeta.setEstaActiva(false);
            } else {
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
            }
        } catch (NullPointerException e) {
            System.out.println("No puede autorizar solicitudes que no existan ");
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }

}
