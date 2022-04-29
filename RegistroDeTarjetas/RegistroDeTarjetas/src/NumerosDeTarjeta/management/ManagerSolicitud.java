/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NumerosDeTarjeta.management;

import Instrucciones.Solicitud;
import NumerosDeTarjeta.FactoryTarjeta;
import NumerosDeTarjeta.TarjetaDeCredito;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author marito
 */
public class ManagerSolicitud {

    private Solicitud solicitud;

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public String isAccepted(TarjetaDeCredito tarjeta) {
        if (solicitud.getSalarioDeSolicitud() * 0.6 >= tarjeta.obtenerMinimo()) {
            return this.leerYAsingarNumeroEnArchivo(tarjeta);
        }
        throw new AssertionError();
    }

    public TarjetaDeCredito procesarSolicitud() {
        FactoryTarjeta ft = new FactoryTarjeta();
        try {
            TarjetaDeCredito tarjeta = ft.obtenerTipoTarjeta(solicitud.getTipoDeSolicitud());
            tarjeta.setNumeroDeTarjeta(this.isAccepted(tarjeta));
            tarjeta.setTipo(solicitud.getTipoDeSolicitud());
            tarjeta.setLimite((int) (solicitud.getSalarioDeSolicitud() * 0.6));
            tarjeta.setNombreDelCliente(solicitud.getNombreDeSolicitud());
            tarjeta.setDireccionDelCliente(solicitud.getDireccionDeSolicitud());
            tarjeta.setCredito(0);
            tarjeta.setEstaActiva(true);
            return tarjeta;
        } catch (AssertionError e) {
            throw e;
        }
    }

    private String asignarNumeroTarjeta(String base, int valor) {
        String numeroDeTarjeta = null;
        if (valor >= 1 & valor < 10) {
            numeroDeTarjeta = base + "000" + valor;
        }
        if (valor >= 10 & valor < 100) {
            numeroDeTarjeta = base + "00" + valor;
        }
        if (valor >= 100 & valor < 10000) {
            numeroDeTarjeta = base + "0" + valor;
        }
        return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }

    public String leerYAsingarNumeroEnArchivo(TarjetaDeCredito tarjeta) {
        try {
            DataInputStream fileIn = new DataInputStream(
                    new FileInputStream(tarjeta.getPATH()));
            int numero = (Integer) fileIn.readInt();  //este comando lee el valor que tiene nuestro archivo numeroNacionalCorriente.txt
            String noTarjeta = (this.asignarNumeroTarjeta(tarjeta.getNUMERO_TIPO(), numero)); //aca Obtenemos el numero de nuestra siguiente tarjeta a instanciar
            numero++;
            actualizarArchivo(numero, tarjeta.getPATH());  //Mediante este comando se invoca al metodo actualizarArchivo el cual sobreescribe el siguiente numero.
            fileIn.close();
            return noTarjeta;
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        return null; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
    }

    public void actualizarArchivo(int numero, String path) {
        try {
            DataOutputStream fileOut;
            fileOut
                    = new DataOutputStream(
                            new FileOutputStream(path, false));
            fileOut.writeInt(numero);
            fileOut.close();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
    
    public static String toStringTipo(int tipo){
        switch (tipo) {
            case 1:
                return "Nacional";
            case 2:
                return "Regional";
            case 3:
                return "Internacional";
        }
        return null;
    }
}
