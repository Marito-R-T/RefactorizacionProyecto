package Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marito
 */
public class ManejadorHTML {

    public void edicionDeReporteHTML(String textoEntrante) {
        File archivo = new File("Reportes.html");
        FileOutputStream salida = null;
        try {
            salida = new FileOutputStream(archivo, true);
            salida.write(textoEntrante.getBytes());
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " no se pudo grabar el texto");
        }
    }
    
}
