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
    private char[][] tablero;
    private static int tamanio = 6;
    private String tipo;
    private int cantFichasAzules;
    private int cantFichasRojas;
    
    private static String[] tipos = {"Standard", "Precargado 1", "Precargado 2"};
    
    public Tablero() {
        this.cantFichasAzules = 18;
        this.cantFichasRojas = 18;
        this.tablero = new char[tamanio][tamanio];
        llenarTableroStandard(this.tablero);
    }
    
    public Tablero(String unTipo) {
        this.tablero = new char[tamanio][tamanio];
        
        if (unTipo.equals(tipos[1])) {
            this.cantFichasAzules = 3;
            this.cantFichasRojas = 2;
            llenarTableroPrecargado1(this.tablero);
        } else if (unTipo.equals(tipos[2])) {
            this.cantFichasAzules = 2;
            this.cantFichasRojas = 1;
            llenarTableroPrecargado2(this.tablero);
        } else {
            this.cantFichasAzules = 18;
            this.cantFichasRojas = 18;
            llenarTableroStandard(this.tablero);
        }
    }
    
    private void llenarTableroStandard(char[][] tablero) {
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
    
    private void llenarTableroPrecargado1(char[][] tablero) {
        tablero[0][0] = 'R';
        tablero[5][3] = 'R';
        tablero[2][2] = 'A';
        tablero[3][5] = 'A';
        tablero[4][1] = 'A';
    }

    private void llenarTableroPrecargado2(char[][] tablero) {
        tablero[0][0] = 'R';
        tablero[5][4] = 'A';
        tablero[5][5] = 'A';
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
    
    public void comerFichaAzul(int fila, int col) {
        this.tablero[fila][col] = 'R';
        cantFichasRojas--;
    }
    
    public void comerFichaRoja(int fila, int col) {
        this.tablero[fila][col] = 'A';
        cantFichasAzules--;
    }
    
    public boolean esLugarVacio(int fila, int col) {
        boolean esVacia = false;
        
        if (this.tablero[fila][col] == ' ') {
            esVacia = true;
        }
        
        return esVacia;
    }  
}
