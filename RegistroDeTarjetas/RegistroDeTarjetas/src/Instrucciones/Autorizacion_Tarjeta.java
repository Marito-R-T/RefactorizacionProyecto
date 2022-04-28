package Instrucciones;

import Files.ManejadorArchivosInstrucciones;
import Files.ManejadorArchivosTarjetas;
import NumerosDeTarjeta.ManagerSolicitud;
import java.io.Serializable;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Autorizacion_Tarjeta extends Instruccion implements Serializable {

    @Override
    public void evaluarLinea(String line) {
        try {
            int numeroDeSolicitud;
            /*
        Las siguientes lineas sirven para capturar el numero de solicitud
             */
            numeroDeSolicitud = Integer.valueOf(line
                    .replaceAll("AUTORIZACION_TARJETA", "")
                    .replace("(", "")
                    .replace(")", ""));
            //Se crea una variable con el nombre del archivo que contiene a nuestra solicitud
            String nombreDelArchivo = "Solicitud" + numeroDeSolicitud + ".sol";
            //Se instancia un objeto controlador para acceder a un metodo que no es estatico
            //De esta manera se captura el objeto del tipo Solicitud y se asigna a la variable Solicitud Actual
            ManejadorArchivosInstrucciones mai = new ManejadorArchivosInstrucciones();
            Solicitud solicitudActual = mai.leerSolicitud(nombreDelArchivo);
            //Se capturan los atributos de nuestra solicitud
            ManagerSolicitud solicitud = new ManagerSolicitud();
            solicitud.setSolicitud(solicitudActual);
            TarjetaDeCredito tarjeta = solicitud.procesarSolicitud();
            String nombreDelArchivoTarjeta = "Tarjeta" + tarjeta.getNumeroDeTarjeta() + ".tacre";
            ManejadorArchivosTarjetas mat = new ManejadorArchivosTarjetas();
            mat.escribirEnArchivoTarjeta(nombreDelArchivoTarjeta, tarjeta);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + "No puede autorizar una solicitud que no exista");
        }
    }
}
