package Instrucciones;

import Files.ControladorArchivosInstruccion;
import Files.ControladorArchivosTarjeta;
import java.io.Serializable;
import java.util.Calendar;
import java.util.StringTokenizer;

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

    @Override
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
        //Escribir nuevo valor de Tarjetas
        ControladorArchivosTarjeta mat = new ControladorArchivosTarjeta();
        mat.agregarMonto("Tarjeta" + numeroDeTarjeta + ".tacre", monto);    //Actualizacion del objeto en el archivo

        //Escribir Este movimiento
        Calendar tiempo = Calendar.getInstance();
        ControladorArchivosInstruccion controlador = new ControladorArchivosInstruccion();
        controlador.escribirEnArchivo("Movimiento" + String.valueOf(tiempo.getTimeInMillis()) + ".mvito", this);
    }
}
