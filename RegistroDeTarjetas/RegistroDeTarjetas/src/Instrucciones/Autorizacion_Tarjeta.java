package Instrucciones;

import NumerosDeTarjeta.NumeroDeTarjetaDeCredito;
import java.io.Serializable;
import registrodetarjetas.ControladorDeArchivos;
import registrodetarjetas.TarjetaDeCredito;


public class Autorizacion_Tarjeta extends AccionTarjeta implements Serializable {
        String numeroDeSiguienteTarjeta;
        int salario ;
        int tipo ;
        String nombre;
        String direccion;
        boolean estado;
        int limite;
        double credito;
        
    public void evaluarLinea(String line){
        try{
        int numeroDeSolicitud;
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        Solicitud solicitudActual= new Solicitud();
        NumeroDeTarjetaDeCredito numeroDeTarjeta = new NumeroDeTarjetaDeCredito();//se accede a un metodo que es el que evalua el numero siguiente de tarjeta 
        /*
        Las siguientes lineas sirven para capturar el numero de solicitud
        */
        numeroDeSolicitud=Integer.valueOf(line
                .replaceAll("AUTORIZACION_TARJETA", "")
                .replace("(", "")
                .replace(")", ""));
        //Se crea una variable con el nombre del archivo que contiene a nuestra solicitud
        String nombreDelArchivo="Solicitud"+numeroDeSolicitud+".sol";
        //Se instancia un objeto controlador para acceder a un metodo que no es estatico
        //De esta manera se captura el objeto del tipo Solicitud y se asigna a la variable Solicitud Actual
        solicitudActual=controlador.leerSolicitud(nombreDelArchivo);
        tipo =solicitudActual.getTipoDeSolicitud();
        salario =solicitudActual.getSalarioDeSolicitud();
        limite = (int) (salario*0.6);
        nombre=solicitudActual.getNombreDeSolicitud();
        direccion = solicitudActual.getDireccionDeSolicitud();
        credito=0;
        estado=true;
        //Se capturan los atributos de nuestra solicitud
        numeroDeSiguienteTarjeta=numeroDeTarjeta.asignarNumeroDeTarjeta(limite,tipo);
        //Ahora si ya tenemos luz verde vamos a instanciar un objeto TarjetaDeCredito para que ya pueda ser utilizada.
        if(numeroDeSiguienteTarjeta==null){
            System.out.println("No se pudo autorizar su tarjeta, porque no cumple con los requisitos.");
        }else{
            TarjetaDeCredito tarjeta = new TarjetaDeCredito(numeroDeSiguienteTarjeta,tipo, limite,nombre, direccion, credito, true);
            String nombreDelArchivoTarjeta="Tarjeta"+numeroDeSiguienteTarjeta+".tacre";
            ControladorDeArchivos.escribirEnArchivo(nombreDelArchivoTarjeta, tarjeta);
        }
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage()+"No puede autorizar una solicitud que no exista");
        }
    }
}
