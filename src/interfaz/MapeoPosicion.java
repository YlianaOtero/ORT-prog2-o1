/**/
package interfaz;

import dominio.Posicion;

/** MapeoPosicion define la correspondencia entre una posicion del estilo 
 * "LETRANUMERO" y las correspondientes filas y columnas del tablero.
 * LETRA esta entre la A y la F, y NUMERO entre el 1 y el 5.
 * @author yliana*/

public class MapeoPosicion {
    
    private String posicion;
    private int fila;
    private int col;
    
    /*CONSTRUCTORES*/
    public MapeoPosicion(String unaPosicion) {
        unaPosicion = unaPosicion.toUpperCase();
        this.posicion = unaPosicion;
        this.fila = filaCorrespondiente(unaPosicion);
        this.col = colCorrespondiente(unaPosicion);
    } 
    
    public MapeoPosicion(int fila, int col) {
        this.posicion = posCorrespondiente(fila, col);
        this.fila = fila;
        this.col = col;
    } 
    
    /*METODOS DE ACCESO*/
    public String getPosicion() {
        return this.posicion;
    }
    
    public int getFila() {
        return this.fila;
    }
    
    public int getCol() {
        return this.col;
    }
    
    /*METODOS AUXILIARES*/
    private int filaCorrespondiente(String posicion) {
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
    
    private int colCorrespondiente(String posicion) {
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
    
    public Posicion posTableroCorrespondiente() {
        Posicion pos = new Posicion(this.fila, this.col);
        return pos;
    }
}
