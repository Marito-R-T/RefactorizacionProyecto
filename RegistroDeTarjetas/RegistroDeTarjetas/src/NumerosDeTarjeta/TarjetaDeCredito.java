package NumerosDeTarjeta;

import java.io.Serializable;

public abstract class TarjetaDeCredito implements Serializable {

    private String NumeroDeTarjeta;
    private int tipo;
    private int limite;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    private final String NUMERO_TIPO;
    private final String PATH;
    
    public TarjetaDeCredito(String NUMERO_TIPO, String PATH) {
        this.NUMERO_TIPO = NUMERO_TIPO;
        this.PATH = PATH;
    }

    public void setEstaActiva(boolean valor) {
        this.estaActiva = valor;
    }

    public void setCredito(double valor) {
        this.credito = valor;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public void setNumeroDeTarjeta(String NumeroDeTarjeta) {
        this.NumeroDeTarjeta = NumeroDeTarjeta;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDireccionDelCliente(String direccionDelCliente) {
        this.direccionDelCliente = direccionDelCliente;
    }

    public double getCredito() {
        return credito;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public String getNumeroDeTarjeta() {
        return NumeroDeTarjeta;
    }

    public int getTipo() {
        return tipo;
    }

    public String getDireccionDelCliente() {
        return direccionDelCliente;
    }
    
    public abstract double obtenerMinimo();

    public String getNUMERO_TIPO() {
        return NUMERO_TIPO;
    }

    public String getPATH() {
        return PATH;
    }
    
}
