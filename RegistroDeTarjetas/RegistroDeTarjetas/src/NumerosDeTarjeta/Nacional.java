package NumerosDeTarjeta;

import java.io.*;


public class Nacional extends TarjetaDeCredito {
    
    public Nacional() {
        super("4256-3102-6585-", "numeroNacionalCorriente.txt");
    }

    @Override
    public double obtenerMinimo() {
        return 2000;
    }
}
