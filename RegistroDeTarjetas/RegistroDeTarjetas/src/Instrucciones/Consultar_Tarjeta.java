package Instrucciones;

import Files.ControladorArchivosTarjeta;
import Files.ManejadorHTML;
import Instrucciones.html.ToHTML;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Consultar_Tarjeta extends Instruccion implements ToHTML<TarjetaDeCredito> {

    @Override
    public void evaluarLinea(String line) {
        String reporteHTML;
        String numeroDeTarjeta;
        numeroDeTarjeta = line
                .replaceAll("CONSULTAR_TARJETA", "")
                .replace("(", "")
                .replace(")", "");
        ControladorArchivosTarjeta mat = new ControladorArchivosTarjeta();
        TarjetaDeCredito tarjeta = mat.leerArchivo("Tarjeta" + numeroDeTarjeta + ".tacre");

        reporteHTML = "<h3>Consulta de Tarjeta: " + tarjeta.getNumeroDeTarjeta() + "</h3>\n"
                + this.generarAll(tarjeta);

        ManejadorHTML mhtml = new ManejadorHTML();
        mhtml.edicionDeReporteHTML(reporteHTML);
    }

    @Override
    public String generarHTMLRow(TarjetaDeCredito tarjeta) {
        return "	  <tr>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNumeroDeTarjeta() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getClass().getName() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.obtenerMinimo() + ".00" + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getNombreDelCliente() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + tarjeta.getDireccionDelCliente() + "</td>\n"
                + "	    <td style=\"border: 1px solid #000000;\">" + (tarjeta.isEstaActiva() ? "ACTIVA" : "NO ACTIVA") + "</td>\n"
                + "	  </tr>\n";
    }

    @Override
    public String generarHTMLFooter() {
        return "</table>";
    }

    @Override
    public String generarHTMLHeader() {
        return "    <table style=\"border-collapse: collapse;\">\n"
                + "	  <tr>"
                + "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n"
                + "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n"
                + "	  </tr>";
    }

}
