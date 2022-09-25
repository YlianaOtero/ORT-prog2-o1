/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author ylian
 */

/*Define la correspondencia entre una posicion del estilo "LETRANUMERO" y 
las correspondientes filas y columnas del tablero.
LETRA esta entre la A y la F, y NUMERO entre el 1 y el 5.*/
public class MapeoPosicion {
    private String posicion;
    private int fila;
    private int col;
    
    public MapeoPosicion(String unaPosicion) {
        unaPosicion = unaPosicion.toUpperCase();
        this.posicion = unaPosicion;
        this.fila = filaCorrespondiente(unaPosicion);
        this.col = colCorrespondiente(unaPosicion);
    } 
    
    public String getPosicion() {
        return this.posicion;
    }
    
    public int getFila() {
        return this.fila;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public int filaCorrespondiente(String posicion) {
        char fila = posicion.charAt(0);
        int correspondiente;
        
        switch(fila) {
            case 'B':
                correspondiente = 1;
                break;
            case 'C':
                correspondiente = 2;
                break;
            case 'D':
                correspondiente = 3;
                break;
            case 'E':
                correspondiente = 4;
                break;
            case 'F':
                correspondiente = 5;
                break;
            default:
                correspondiente = 0;
        }
        
        return correspondiente;
    }
    
    public int colCorrespondiente(String posicion) {
        posicion = posicion.toUpperCase();
        char col = posicion.charAt(1);
        int correspondiente = Character.getNumericValue(col) - 1;
        
        return correspondiente;
    }
    
    private String posCorrespondiente(int fila, int col) {
        String posicion = " ";
        
        switch(fila) {
            case 1:
                posicion = "B";
                break;
            case 2:
                posicion = "C";
                break;
            case 3:
                posicion = "D";
                break;
            case 4:
                posicion = "E";
                break;
            case 5:
                posicion = "F";
                break;
            default:
                posicion = "A";
        }
        
        posicion += (col+1);
        
        return posicion;
        
    }
}
