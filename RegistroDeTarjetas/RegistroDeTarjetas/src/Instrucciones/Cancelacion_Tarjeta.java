package Instrucciones;

import Files.ControladorArchivosTarjeta;
import java.io.Serializable;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Cancelacion_Tarjeta extends Instruccion implements Serializable {

    public void evaluarLinea(String line) {
        try {
            String numeroDeTarjeta = line
                    .replaceAll("CANCELACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", "");
            TarjetaDeCredito tarjeta;
            ControladorArchivosTarjeta mat = new ControladorArchivosTarjeta();
            tarjeta = mat.leerArchivo("Tarjeta" + numeroDeTarjeta + ".tacre");
            if (tarjeta.getCredito()< 0) {
                tarjeta.setEstaActiva(false);
            } else {
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
            }
        } catch (NullPointerException e) {
            throw new AssertionError("No puede autorizar solicitudes que no existan ", e);
        }
    }

}
