package Instrucciones;

import java.io.Serializable;

public abstract class Instruccion implements Serializable {
    
    public abstract void evaluarLinea(String line);
    
}
