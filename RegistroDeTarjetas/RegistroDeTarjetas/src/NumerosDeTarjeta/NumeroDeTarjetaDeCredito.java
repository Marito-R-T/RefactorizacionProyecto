package NumerosDeTarjeta;

import Instrucciones.Autorizacion_Tarjeta;
import java.io.Serializable;

public class NumeroDeTarjetaDeCredito implements Serializable {
    String valorActual;
    Autorizacion_Tarjeta controladorDeTarjeta = new Autorizacion_Tarjeta();
    String exito="Completado correctamente";
    public String asignarNumeroDeTarjeta(int limiteDeCredito, int tipo){
        valorActual=null; //Cada vez que ingrese aca se va a reiniciar el valor que tenia el valorActual.
        if(tipo==1 & limiteDeCredito>=2000){ //se evalua si es del tipo 1 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual=Nacional.leerYAsingarNumeroEnArchivo();
            System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        if(tipo==2 & limiteDeCredito>=5000){ //se evalua si es del tipo 2 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual=Regional.leerYAsingarNumeroEnArchivo();
            System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        if(tipo==3 & limiteDeCredito>=12000){ //se evalua si es del tipo 3 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual=Internacional.leerYAsingarNumeroEnArchivo();
            System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        return valorActual;
    }
    String asingarNumeroTarjeta(String base,int valor){
        String numeroDeTarjeta = null;
        if(valor>=1 & valor<10){
            numeroDeTarjeta=base+"000"+valor;
        }
        if(valor>=10& valor<100){
            numeroDeTarjeta=base+"00"+valor;
        }
        if(valor>=100&valor<10000){
            numeroDeTarjeta=base+"0"+valor;
        }
    return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }
}
