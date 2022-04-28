package NumerosDeTarjeta;

import java.io.*;


public class Internacional extends TarjetaDeCredito {
    
    public Internacional() {
        super("4256-3102-6595-", "numeroInternacionalCorriente.txt");
    }

    @Override
    public double obtenerMinimo() {
        return 12000;
    }

}
