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
    
    private static String Negro = "\u001B[30m";
    private static String Rojo = "\u001B[31m";
    private static String Azul = "\u001B[34m";
    private static String Verde = "\u001b[32;1m";
    
    public Color() {
        this.codigo = Negro;
        this.nombre = "negro";
    }
    
    public void setColor(String unColor) {
        if (unColor.equalsIgnoreCase("rojo")) {
            this.codigo = Rojo;
            this.nombre = "rojo";
        } else if (unColor.equalsIgnoreCase("azul")) {
            this.codigo = Azul;
            this.nombre = "azul";
        } else if (unColor.equalsIgnoreCase("verde")){
            this.codigo = Verde;
            this.nombre = "verde";
        } else {
            this.codigo = Negro;
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
