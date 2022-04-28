package Instrucciones;

import Files.ManejadorArchivosTarjetas;
import Files.ManejadorHTML;
import Instrucciones.html.RowHTML;
import registrodetarjetas.ControladorDeArchivos;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Consultar_Tarjeta extends Instruccion implements RowHTML<TarjetaDeCredito> {

    @Override
    public void evaluarLinea(String line) {
        String reporteHTML;
        String numeroDeTarjeta;
        numeroDeTarjeta = line
                .replaceAll("CONSULTAR_TARJETA", "")
                .replace("(", "")
                .replace(")", "");
        try {
            ManejadorArchivosTarjetas mat = new ManejadorArchivosTarjetas();
            TarjetaDeCredito tarjeta = mat.leerTarjetaDeCredito("Tarjeta" + numeroDeTarjeta + ".tacre");

            reporteHTML = this.generarHTMLRow(tarjeta);

            ManejadorHTML mhtml = new ManejadorHTML();
            mhtml.edicionDeReporteHTML(reporteHTML);
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public String generarHTMLRow(TarjetaDeCredito tarjeta) {
        return "<h3>Consulta de Tarjeta: " + tarjeta.getNumeroDeTarjeta() + "</h3>"
                + "	<table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n"
                + "	  </tr>\n"
                + "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNumeroDeTarjeta() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getClass().getName() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.obtenerMinimo() + ".00" + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNombreDelCliente() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getDireccionDelCliente() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + (tarjeta.isEstaActiva() ? "ACTIVA" : "NO ACTIVA") + "</td>\n"
                + "	  </tr>\n"
                + "	</table>";
    }

}
