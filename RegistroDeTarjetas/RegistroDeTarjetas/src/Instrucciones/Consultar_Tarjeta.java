package Instrucciones;

import registrodetarjetas.ControladorDeArchivos;
import registrodetarjetas.TarjetaDeCredito;

public class Consultar_Tarjeta extends AccionTarjeta {
    
    public void evaluarLinea(String line){
        String reporteHTML;
        String numeroDeTarjeta;
        int tipoDeTarjeta;
        String tipo = null;
        int limite = 0;
        String nombre;
        String direccion;
        boolean estado;
        String variableEstado;
        
        
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito();
        numeroDeTarjeta=line
                .replaceAll("CONSULTAR_TARJETA","")
                .replace("(","")
                .replace(")","");
        
        tarjeta=controlador.leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");
        
        tipoDeTarjeta=tarjeta.getTipo();
        if(tipoDeTarjeta==1){tipo="Nacional";limite=2000;}
        if(tipoDeTarjeta==2){tipo="Regional";limite=5000;}
        if(tipoDeTarjeta==3){tipo="Internacional";limite=12000;}
        
        nombre=tarjeta.getnombreDelCliente();
        direccion=tarjeta.getDireccionDelCliente();
        estado=tarjeta.getEstaActiva();
        if(estado){
            variableEstado="Activa";
        }else{
            variableEstado="No Activa";
        }
        
        reporteHTML="<h3>Consulta de Tarjeta: " +numeroDeTarjeta +"</h3>" +
            "	<table style=\"border-collapse: collapse;\">\n" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+numeroDeTarjeta+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+limite+".00"+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+nombre+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+direccion+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+variableEstado+"</td>\n" +
            "	  </tr>\n" +
            "	</table>";
        
        controlador.edicionDeReporteHTML(reporteHTML);
    }
    
}
