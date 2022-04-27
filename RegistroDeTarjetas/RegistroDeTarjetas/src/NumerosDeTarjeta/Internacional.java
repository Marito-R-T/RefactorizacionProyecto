package NumerosDeTarjeta;

import java.io.*;

import registrodetarjetas.TarjetaDeCredito;

public class Internacional extends TarjetaDeCredito{

    final static String NUMERO_INTERNACIONAL=   "4256-3102-6595-";
    static String noTarjeta;
    private static final String path = "numeroInternacionalCorriente.txt";
    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();    
    
    public Internacional(String NumeroDeTarjeta, int tipo, int limite, String nombreDelCliente,
            String direccionDelCliente, double credito, boolean estaActiva) {
        super(NumeroDeTarjeta, tipo, limite, nombreDelCliente, direccionDelCliente, credito, estaActiva, path);
    }

    public Internacional() {
        super(path);
    }

    public static void evaluarNumero(){
    
    }
    
    public static void actualizarArchivo(int numero){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroInternacionalCorriente.txt", false));
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
                    new FileInputStream("numeroInternacionalCorriente.txt"));
                    numero=fileIn.readInt();
                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_INTERNACIONAL,numero);
                    numero=numero+1;
                    actualizarArchivo(numero);
            fileIn.close();
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta; 
    }  
}
