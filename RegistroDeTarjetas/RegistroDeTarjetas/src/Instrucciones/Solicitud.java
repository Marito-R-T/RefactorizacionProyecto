package Instrucciones;

import Files.ControladorArchivosInstruccion;
import java.io.*;
import java.util.*;

public class Solicitud extends Instruccion implements Serializable {

    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;

    public Solicitud(int numSolicitud, String fecha, int tipo, String nombre, int salario, String direccion) {
        this.numeroDeSolicitud = numSolicitud;
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.salario = salario;
        this.direccion = direccion;
    }
    //de esta manera se sobrecarga el constructor de la clase solicitud

    public Solicitud() {
    }

    public int getNumeroDeSolicitud() {
        return this.numeroDeSolicitud;
    }

    public String getFechaDeSolicitud() {
        return this.fecha;
    }

    public int getTipoDeSolicitud() {
        return this.tipo;
    }

    public String getNombreDeSolicitud() {
        return this.nombre;
    }

    public int getSalarioDeSolicitud() {
        return this.salario;
    }

    public String getDireccionDeSolicitud() {
        return this.direccion;
    }

    @Override
    public void evaluarLinea(String line) {
        StringTokenizer token = new StringTokenizer(line, ","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp = token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token
        numeroDeSolicitud = Integer.parseInt(temp.replaceAll("SOLICITUD", ""));//Luego aca se le se quita la palabra solicitud a la variable numero de solicitud y se convierte a entero
        temp = token.nextToken(); //este token es de la fecha de la solicitud
        fecha = temp.replaceAll("\"", ""); //mediante esta instruccion se quitan las comillas a la fecha 
        tipo = Integer.valueOf(token.nextToken().replace("\"", ""));
        nombre = String.valueOf(token.nextToken().replaceAll("\"", ""));
        salario = Integer.valueOf(token.nextToken());
        direccion = token.nextToken().replaceAll("\"", "").replace(")", "");
        ControladorArchivosInstruccion controlador = new ControladorArchivosInstruccion();
        controlador.escribirEnArchivo("Solicitud" + this.getNumeroDeSolicitud() + ".sol", this);
    }
}
