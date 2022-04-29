package Instrucciones;

import Files.ControladorArchivosInstruccion;
import Files.ControladorArchivosTarjeta;
import NumerosDeTarjeta.management.ManagerSolicitud;
import java.io.Serializable;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Autorizacion_Tarjeta extends Instruccion implements Serializable {

    @Override
    public void evaluarLinea(String line) {
        try {
            //Las siguientes lineas sirven para capturar el numero de solicitud
            int numeroDeSolicitud = Integer.valueOf(line
                    .replaceAll("AUTORIZACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", ""));
            //Se instancia un objeto controlador para acceder a un metodo que no es estatico
            //De esta manera se captura el objeto del tipo Solicitud y se asigna a la variable Solicitud Actual
            ControladorArchivosInstruccion controladorSolicitud = new ControladorArchivosInstruccion();
            Solicitud solicitudActual = (Solicitud) controladorSolicitud.leerArchivo("Solicitud" + numeroDeSolicitud + ".sol");
            //Se capturan los atributos de nuestra solicitud
            ManagerSolicitud solicitud = new ManagerSolicitud();
            solicitud.setSolicitud(solicitudActual);
            TarjetaDeCredito tarjeta = solicitud.procesarSolicitud();
            ControladorArchivosTarjeta controladorTarjeta = new ControladorArchivosTarjeta();
            controladorTarjeta.escribirEnArchivo("Tarjeta" + tarjeta.getNumeroDeTarjeta() + ".tacre", tarjeta);
        } catch (NullPointerException e) {
            throw new AssertionError("No puede autorizar una solicitud que no exista ", e);
        }
    }
}
