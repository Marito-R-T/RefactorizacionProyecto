package NumerosDeTarjeta;
import java.io.*;

import registrodetarjetas.TarjetaDeCredito;

public class Regional extends TarjetaDeCredito{
    final static String NUMERO_REGIONAL="4256-3102-6590-";
    static String noTarjeta;
    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito(); 
    private static final String path = "numeroRegionalCorriente.txt";

    public Regional(String NumeroDeTarjeta, int tipo, int limite, String nombreDelCliente,
            String direccionDelCliente, double credito, boolean estaActiva) {
        super(NumeroDeTarjeta, tipo, limite, nombreDelCliente, direccionDelCliente, credito, estaActiva, path);
    }

    public Regional() {
        super(path);
    }
    
    public static void actualizarArchivo(int numero){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroRegionalCorriente.txt", false));
                    fileOut.writeInt(numero);
            fileOut.close();
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
    }
    static int numero=0;
    public static String leerYAsingarNumeroEnArchivo(){
        try{
        DataInputStream fileIn;
            fileIn =
            new DataInputStream(
                    new FileInputStream("numeroRegionalCorriente.txt"));
                    numero = fileIn.readInt();
                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_REGIONAL,numero);
                    numero=numero+1;
                    actualizarArchivo(numero);
            fileIn.close();
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta;
    }   
}

