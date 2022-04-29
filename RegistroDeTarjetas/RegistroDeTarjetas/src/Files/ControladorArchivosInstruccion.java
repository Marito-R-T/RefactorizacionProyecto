/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import Instrucciones.Instruccion;
import java.io.File;

/**
 *
 * @author marito
 */
public class ControladorArchivosInstruccion extends ControladorDeArchivos<Instruccion> {

    
    @Override
    public File[] getFiles() {
        File carpeta = new File(new File(".").getAbsolutePath());
        return carpeta.listFiles((dir1, name) -> name.endsWith(".sol"));
    }
    
    
    
}
