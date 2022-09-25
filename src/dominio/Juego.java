/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author ylian
 */
public class Juego {
    private int cantFichasAzules;
    private int cantFichasRojas;
    private char[][] tablero;

    public Juego() {
        this.cantFichasAzules = 18;
        this.cantFichasRojas = 18;
        this.tablero = new char[6][6];
        llenarTablero(this.tablero);
    }
    
    private void llenarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    tablero[i][j] = 'A';
                } else {
                    tablero[i][j] = 'R';
                }
            }
        }
    }
    
    public int getCantFichasAzules() {
        return this.cantFichasAzules;
    }
    
    public int getCantFichasRojas() {
        return this.cantFichasRojas;
    }
    
    public char[][] getTablero() {
        return this.tablero;
    }
    
    public void restarFichaAzul() {
        cantFichasAzules--;
    }
    
    public void restarFichaRoja() {
        cantFichasRojas--;
    }
    
}
