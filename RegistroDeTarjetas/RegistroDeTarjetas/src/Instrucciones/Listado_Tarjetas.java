package Instrucciones;

import Files.ManejadorArchivosTarjetas;
import Files.ManejadorHTML;
import Instrucciones.html.FotterHTML;
import Instrucciones.html.HeaderHTML;
import Instrucciones.html.RowHTML;
import java.io.File;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Listado_Tarjetas extends Instruccion implements FotterHTML, HeaderHTML, RowHTML<TarjetaDeCredito>  {

    String reporteHTML;

    @Override
    public void evaluarLinea(String line) {
        File carpeta = new File(new File(".").getAbsolutePath());
        File[] files = carpeta.listFiles((dir1, name)
                -> name.endsWith(".tacre"));
        reporteHTML = this.generarHTMLHeader();
        ManejadorArchivosTarjetas mat = new ManejadorArchivosTarjetas();
        for (File i : files) {
            try {
                TarjetaDeCredito tarjeta = mat.leerTarjetaDeCredito(i.getName());
                reporteHTML = generarHTMLRow(tarjeta);
            } catch (AssertionError err) {
                System.out.println(err.getMessage());
            }
        }
        ManejadorHTML mhtml = new ManejadorHTML();
        reporteHTML += this.generarHTMLFooter();
        mhtml.edicionDeReporteHTML(reporteHTML);

    }

    @Override
    public String generarHTMLFooter() {
        return "</table>";
    }

    @Override
    public String generarHTMLHeader() {
        return "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>"
                + "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n"
                + "           <th style=\"border: 1px solid #000000;\">FECHA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n"
                + "	  </tr>";
    }

    @Override
    public String generarHTMLRow(TarjetaDeCredito tarjeta) {
        return "         <tr>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNumeroDeTarjeta() + "</th>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getClass().getName() + "</th>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.obtenerMinimo() + "</th>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNombreDelCliente() + "</th>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getDireccionDelCliente() + "</th>\n"
                        + "           <td style=\"border: 1px solid #000000;\">" + "" + "</th>\n"
                        + "	    <td style=\"border: 1px solid #000000;\">" + (tarjeta.isEstaActiva() ? "ACTIVA" : "CANCELADA") + "</th>\n"
                        + "	  </tr>";
    }
}
