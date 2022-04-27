package registrodetarjetas;

import java.io.Serializable;

public abstract class TarjetaDeCredito implements Serializable{
    
    private String NumeroDeTarjeta;
    private int tipo;
    private int limite;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    private final String path;
    //Constructor de la tarjeta de credito
    public TarjetaDeCredito( String NumeroDeTarjeta,int tipo,int limite,String nombreDelCliente,String direccionDelCliente,double credito,boolean estaActiva, String path){
        this.NumeroDeTarjeta=NumeroDeTarjeta;
        this.tipo=tipo;
        this.limite=limite;
        this.nombreDelCliente=nombreDelCliente;
        this.direccionDelCliente=direccionDelCliente;
        this.credito=credito;
        this.estaActiva=estaActiva;
        this.path = path;
    }

    public TarjetaDeCredito(String path)
    {
        this.path = path;
    }
    
    public String getNumeroDeTarjeta(){
        return this.NumeroDeTarjeta;
    }
    public int getTipo(){
    return this.tipo;
    }
    public int getlimite(){
        return this.limite;
    }
    public String getnombreDelCliente(){
        return this.nombreDelCliente;
    }
    public String getDireccionDelCliente(){
        return this.direccionDelCliente;
    }
    public double getCreditoDeTarjeta(){
        return this.credito;
    }
    public boolean getEstaActiva(){
        return this.estaActiva;
    }
    public void setEstaActiva(boolean valor)
    {
        this.estaActiva = valor;
    }
    public void setCredito(double valor)
    {
        this.credito = valor;
    }
}
