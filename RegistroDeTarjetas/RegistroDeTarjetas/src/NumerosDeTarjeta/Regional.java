package NumerosDeTarjeta;


public class Regional extends TarjetaDeCredito {

    public Regional() {
        super("4256-3102-6590-", "numeroRegionalCorriente.txt");
    }
    
    @Override
    public double obtenerMinimo() {
        return 5000;
    }
}
