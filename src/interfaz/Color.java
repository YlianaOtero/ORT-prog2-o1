/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author ylian
 * 
 * Los codigos de los colores son los codigos ANSI.
 * 
 * Si se hace System.out.print(CODIGO_ANSI + "Texto a imprimir"),
 * deberia mostrarse en pantalla el texto entre comillas, pintado del color
 * correspondiente a ese codigo.
 */
public class Color {
    private String codigo;
    private String nombre;
    
    private static String negro = "\\u001B[30m";
    private static String rojo = "\\u001B[31m";
    private static String azul = "\\u001B[34m";
    
    public Color() {
        //Color negro
        this.codigo = negro;
    }
    
    public void setColor(String unColor) {
        if (unColor.equalsIgnoreCase("rojo")) {
            this.codigo = rojo;
            this.nombre = "rojo";
        } else if (unColor.equalsIgnoreCase("azul")) {
            this.codigo = azul;
            this.nombre = "azul";
        } else {
            this.codigo = negro;
            this.nombre = "negro";
        }
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    
}
