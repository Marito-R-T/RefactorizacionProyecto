package main;

import java.io.Serializable;
import registrodetarjetas.Disenio;

public class RegistroDeTarjetas implements Serializable {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Disenio().setVisible(true);
        });
        
    }
}
