package Instrucciones;

import Files.ControladorArchivosInstruccion;
import Files.ManejadorHTML;
import Instrucciones.html.ToHTML;
import NumerosDeTarjeta.management.ManagerSolicitud;
import java.io.File;

public class Listado_Solicitudes extends Instruccion implements ToHTML<Solicitud> {

    @Override
    public void evaluarLinea(String line) {
        ControladorArchivosInstruccion controlador = new ControladorArchivosInstruccion();
        String reporteHTML = this.generarHTMLHeader();
        for (File i : controlador.getFiles()) {
            Solicitud solicitud = (Solicitud) controlador.leerArchivo(i.getName());
            reporteHTML += generarHTMLRow(solicitud);
        }
        ManejadorHTML mhtml = new ManejadorHTML();
        reporteHTML += generarHTMLFooter();
        mhtml.edicionDeReporteHTML(reporteHTML);

    }

    @Override
    public String generarHTMLHeader() {
        return "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>"
                + "	  <tr>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n"
                + "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n"
                + "	  </tr>";
    }

    @Override
    public String generarHTMLRow(Solicitud solicitud) {
        return "         <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getNumeroDeSolicitud() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getFechaDeSolicitud() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + ManagerSolicitud.toStringTipo(solicitud.getTipoDeSolicitud()) + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getNombreDeSolicitud() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getSalarioDeSolicitud() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + solicitud.getDireccionDeSolicitud() + "</td>\n"
                + "           <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + "" + "</td>\n"
                + "	  </tr>";
    }

    @Override
    public String generarHTMLFooter() {
        return "</table>";
    }

}
