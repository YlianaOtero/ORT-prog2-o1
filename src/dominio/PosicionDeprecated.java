/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ylian
 */
public class PosicionDeprecated extends Tablero {
    private int fila;
    private int col;
    private int distanciaAlCentro;
    
    private static String[] posConDistanciaUno = {"2-2", "2-3", "3-2", "3-3"};
    private static String[] posConDistanciaDos = {"1-2", "1-3", "2-1", "2-4",  
                                                  "3-1", "3-4", "4-2", "4-3"};
    private static String[] posConDistanciaTres = {"1-1", "1-4", "5-1", "5-4"};
    private static String[] posConDistanciaCuatro = {"0-2", "0-3", "2-0", "2-3",  
                                                     "2-5", "3-5", "5-2", "5-3"};
    private static String[] posConDistanciaCinco = {"0-1", "0-4", "1-0", "1-5",
                                                    "4-0", "4-5", "5-1", "5-4"};
    private static String[] posConDistanciaSeis = {"0-0", "0-5", "5-0", "5-5"};
    
    //CONSTRUCTORES
    public PosicionDeprecated(int fila, int col, Tablero unTablero) {
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
    
    private int calcularDistanciaAlCentro(int fila, int col) {
        int distancia = 0;
        String pos = fila + "-" + col;
        
        if (Arrays.asList(posConDistanciaUno).contains(pos)) {
          distancia = 1;  
          
        } else if (Arrays.asList(posConDistanciaDos).contains(pos)) {
          distancia = 2;  
          
        } else if (Arrays.asList(posConDistanciaTres).contains(pos)) {
          distancia = 3;  
          
        } else if (Arrays.asList(posConDistanciaCuatro).contains(pos)) {
          distancia = 4;  
          
        } else if (Arrays.asList(posConDistanciaCinco).contains(pos)){
            distancia = 5;
            
        } else {
            distancia = 6;
        }
        
        return distancia;
    }
    
}
