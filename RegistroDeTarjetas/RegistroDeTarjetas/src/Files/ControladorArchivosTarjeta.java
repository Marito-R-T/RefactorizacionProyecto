/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import NumerosDeTarjeta.TarjetaDeCredito;
import java.io.File;

/**
 *
 * @author marito
 */
public class ControladorArchivosTarjeta extends ControladorDeArchivos<TarjetaDeCredito> {

    public void agregarMonto(String path, double monto) throws NullPointerException {
        TarjetaDeCredito tarjeta = super.leerArchivo(path);
        tarjeta.setCredito(tarjeta.getCredito() + monto);
        super.escribirEnArchivo("Tarjeta" + tarjeta.getNumeroDeTarjeta() + ".tacre", tarjeta);
    }

    @Override
    public File[] getFiles() {
        File carpeta = new File(new File(".").getAbsolutePath());
        return carpeta.listFiles((dir1, name)
                -> name.endsWith(".tacre"));
    }

}
