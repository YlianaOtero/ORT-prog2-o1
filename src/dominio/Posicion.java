/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Arrays;

/**
 *
 * @author ylian
 */
public class Posicion {
    private int fila;
    private int col;
    private int distanciaAlCentro;
    
    private static int[][] posConDistanciaUno = {{2, 2}, {2, 3}, {3, 2}, {3, 3}};

    private static int[][] posConDistanciaDos = {{1, 2}, {1, 3}, {2, 1}, {2, 4},
                                                 {3, 1}, {3, 4}, {4, 2}, {4, 3}};
                                                  
    private static int[][] posConDistanciaTres = {{1, 1}, {1, 4}, {5, 1}, {5, 4}};

    private static int[][] posConDistanciaCuatro = {{0, 2}, {0, 3}, {2, 0}, {2, 3},
                                                    {2, 5}, {3, 5}, {5, 2}, {5, 3}};
   
    private static int[][] posConDistanciaCinco = {{0, 1}, {0, 4}, {1, 0}, {1, 5},
                                                   {4, 0}, {4, 5}, {5, 1}, {5, 4}};
    
    private static int[][] posConDistanciaSeis = {{0, 0}, {0, 5}, {5, 0}, {5,5}};
    
    //CONSTRUCTORES
    public Posicion(int fila, int col, Tablero unTablero) {
        this.fila = fila;
        this.col = col;
        this.distanciaAlCentro = calcularDistanciaAlCentro(fila, col);
    }
    
    //METODOS DE ACCESO
    public int getDistanciaAlCentro() {
        return this.distanciaAlCentro;
    }
    
    public int getFila() {
        return this.fila;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public char getFichaEnPos(Tablero unTablero) {
        return unTablero.getElem(this.fila, this.col);
    }
    
    private int calcularDistanciaAlCentro(int fila, int col) {
        int distancia = 0;
        String pos = fila + "-" + col;
        
        if (estaEnLaMatriz(fila, col, posConDistanciaUno)) {
          distancia = 1;  
          
        } else if (estaEnLaMatriz(fila, col, posConDistanciaDos)) {
          distancia = 2;  
          
        } else if (estaEnLaMatriz(fila, col, posConDistanciaTres)) {
          distancia = 3;  
          
        } else if (estaEnLaMatriz(fila, col, posConDistanciaCuatro)) {
          distancia = 4;  
          
        } else if (estaEnLaMatriz(fila, col, posConDistanciaCinco)){
            distancia = 5;
            
        } else {
            distancia = 6;
        }
        
        return distancia;
    }
    
    private boolean estaEnLaMatriz(int fila, int col, int[][] mat) {
        boolean esta = false;
        
        for (int i = 0; i < mat.length && !esta; i++) {
            if (mat[i][0] == fila && mat[i][1] == col) {
                esta = true;
            }
        }
        
        return esta;
    }
    
    @Override 
    public String toString() {
        return this.getFila() + "-" + this.getCol();
    }
    
}
