package NumerosDeTarjeta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import registrodetarjetas.TarjetaDeCredito;

public class ManagerArchivosTarjetas {

    private NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();
    
    public void actualizarArchivo(TarjetaDeCredito tarjeta) {
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroInternacionalCorriente.txt", false));
                    fileOut.writeInt(Integer.parseInt(tarjeta.getNumeroDeTarjeta()));
            fileOut.close();
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
    }
    
    public String leerYAsingarNumeroEnArchivo(TarjetaDeCredito tarjeta, String numeroTipo){
        try{
            DataInputStream fileIn;
            fileIn =
            new DataInputStream(
                    new FileInputStream("numeroInternacionalCorriente.txt"));
                    int numero=fileIn.readInt();
                    String noTarjeta=controlador.asingarNumeroTarjeta(numeroTipo,numero);
                    numero=numero+1;
                    actualizarArchivo(tarjeta);
            fileIn.close();
            return noTarjeta;
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return null; 
    }  

}
