package Instrucciones;

import Files.ManejadorArchivosInstrucciones;
import Files.ManejadorArchivosTarjetas;
import java.io.Serializable;
import java.util.Calendar;
import java.util.StringTokenizer;
import NumerosDeTarjeta.TarjetaDeCredito;

public class Movimiento extends Instruccion implements Serializable {

    String numeroDeTarjeta;
    String fecha;
    String tipoDeMovimiento;
    String descripcion;
    String establecimiento;
    double monto;

    public Movimiento(String numero, String fecha, String tipo, String descripcion, String establecimiento, double monto) {
        this.numeroDeTarjeta = numero;
        this.fecha = fecha;
        this.tipoDeMovimiento = tipo;
        this.descripcion = descripcion;
        this.establecimiento = establecimiento;
        this.monto = monto;
    }

    public Movimiento() {
    }

    public void evaluarLinea(String line) {

        StringTokenizer token = new StringTokenizer(line, ","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp = token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token que en este caso es Movimiento(
        numeroDeTarjeta = temp.replaceAll("MOVIMIENTO", "");//Luego aca se le se quita la palabra movimiento a la variable numero de tarjeta y se convierte a entero
        fecha = token.nextToken().replaceAll("\"", ""); //mediante esta instruccion se quitan las comillas a la fecha 
        tipoDeMovimiento = (token.nextToken().replace("\"", ""));
        descripcion = (token.nextToken().replace("\"", ""));
        establecimiento = (token.nextToken().replace("\"", ""));
        monto = Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
        try {
            ManejadorArchivosTarjetas mat = new ManejadorArchivosTarjetas();
            TarjetaDeCredito tarjeta = mat.leerTarjetaDeCredito("Tarjeta" + numeroDeTarjeta + ".tacre");

            tarjeta.setCredito(tarjeta.getCredito() + monto);

            mat.escribirEnArchivoTarjeta("Tarjeta" + numeroDeTarjeta + ".tacre", tarjeta);     //Actualizacion del objeto en el archivo

            Movimiento movimiento = new Movimiento(numeroDeTarjeta, fecha, tipoDeMovimiento, descripcion, establecimiento, monto);
            Calendar tiempo = Calendar.getInstance();
            String nombreDelNuevoMovimiento = "Movimiento" + String.valueOf(tiempo.getTimeInMillis()) + ".mvito";
            ManejadorArchivosInstrucciones mai = new ManejadorArchivosInstrucciones();
            mai.escribirEnArchivoInstruccion(nombreDelNuevoMovimiento, movimiento);
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }
}
