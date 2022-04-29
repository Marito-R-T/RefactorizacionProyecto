package Instrucciones.html;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author marito
 */
public interface ToHTML <T>{
    public String generarHTMLFooter();
    public String generarHTMLRow(T instruccion);
    public String generarHTMLHeader();
    
    public default String generarAll(T instruccion) {
        return generarHTMLHeader()+ generarHTMLRow(instruccion) + generarHTMLFooter();
    }
    
}
