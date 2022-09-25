/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author ylian
 */
public class Tablero {
    private int cantFichasAzules;
    private int cantFichasRojas;
    private char[][] tablero;
    private static int tamanio = 6;

    public Tablero() {
        this.cantFichasAzules = 18;
        this.cantFichasRojas = 18;
        this.tablero = new char[tamanio][tamanio];
        llenarTablero(this.tablero);
    }
    
    private void llenarTablero(char[][] tablero) {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    tablero[i][j] = 'A';
                } else {
                    tablero[i][j] = 'R';
                }
            }
        }
    }
    
    public int getTamanio() {
        return this.tamanio;
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
    
    public boolean esPosicionVacia(int fila, int col) {
        boolean esVacia = false;
        
        if (this.tablero[fila][col] == ' ') {
            esVacia = true;
        }
        
        return esVacia;
    }
    
    
    
}
