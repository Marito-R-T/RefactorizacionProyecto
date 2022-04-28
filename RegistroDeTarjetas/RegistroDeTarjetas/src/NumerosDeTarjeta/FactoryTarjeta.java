/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NumerosDeTarjeta;

/**
 *
 * @author marito
 */
public class FactoryTarjeta {

    public TarjetaDeCredito obtenerTipoTarjeta(int tipo) {
        switch (tipo) {
            case 1:
                return new Nacional();
            case 2:
                return new Regional();
            case 3:
                return new Internacional();
            default:
                throw new AssertionError();
        }
    }

}
