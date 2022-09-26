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
public class Movimiento extends Tablero {
    private int filaInicial;
    private int colInicial;
    private int distanciaAlCentro;
    private ArrayList<String> posPosiblesConCaptura;
    private ArrayList<String> posPosiblesSinCaptura;
    
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
    public Movimiento(int fila, int col, Tablero unTablero) {
        this.filaInicial = fila;
        this.colInicial = col;
        this.distanciaAlCentro = calcularDistanciaAlCentro(fila, col);
        this.posPosiblesConCaptura = listarPosConCaptura(fila, col, unTablero);
        this.posPosiblesSinCaptura = listarPosSinCaptura(fila, col, unTablero);
    }
    
    //METODOS DE ACCESO
    public int getDistanciaAlCentro() {
        return this.distanciaAlCentro;
    }
    
    public int getFilaInicial() {
        return this.filaInicial;
    }
    
    public int getColInicial() {
        return this.colInicial;
    }
    
    public ArrayList<String> getPosPosiblesSinCaptura() {
        return this.posPosiblesSinCaptura;
    }
    
    public ArrayList<String> getPosPosiblesConCaptura() {
        return this.posPosiblesConCaptura;
    }
    
    //METODOS PRIVADOS: hallar diferentes atributos
    private ArrayList<String> listarPosConCaptura(int fila, int col, Tablero unTablero) {     
        //HORIZONTALES:
        ArrayList<String> posiciones = listarPosConCapturaHorizontal(fila, col, unTablero);
        
        //VERTICALES:
        posiciones.addAll(listarPosConCapturaVertical(fila, col, unTablero));
        
        //DIAGONALES: POR HACER
        posiciones.addAll(listarPosConCapturaDiagonal(fila, col, unTablero));
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosSinCaptura(int fila, int col, Tablero unTablero) {        
        //HORIZONTALES:
        ArrayList<String> posiciones = listarPosSinCapturaHorizontal(fila, col, unTablero);
        
        //VERTICALES:
        posiciones.addAll(listarPosSinCapturaVertical(fila, col, unTablero));
        
        //DIAGONALES:
        posiciones.addAll(listarPosSinCapturaDiagonal(fila, col, unTablero));
        
        return posiciones;
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
    
    
    //METODOS AUXILIARES
    private ArrayList<String> listarPosConCapturaHorizontal(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        boolean libre = true;
        
        for (int j = col+1; j < unTablero.getTamanio() && libre; j++) {
            if (!unTablero.esPosicionVacia(fila, j)) {
                libre = false;
            } else {
                posiciones.add(fila + "-" + j);
            }
        }
        
        libre = true;
        for (int j = 0; j < col && libre; j++) {
            if (!unTablero.esPosicionVacia(fila, j)) {
                libre = false;
            } else {
                posiciones.add(fila + "-" + j);
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosConCapturaVertical(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        boolean libre = true;
        
        for (int i = fila+1; i < unTablero.getTamanio() && libre; i++) {
            if (!unTablero.esPosicionVacia(i, col)) {
                libre = false;
            } else {
                posiciones.add(i + "-" + col);
            }
        }
        
        libre = true;
        for (int i = 0; i < fila && libre; i++) {
            if (!unTablero.esPosicionVacia(i, col)) {
                libre = false;
            } else {
                posiciones.add(i + "-" + col);
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosConCapturaDiagonal(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        //POR HACER
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosSinCapturaHorizontal(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        if (col > 0 && unTablero.esPosicionVacia(fila, col-1)) {
            posiciones.add(fila + "-" + (col-1));
        }
        
        if (col < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(fila, col+1)) {
            posiciones.add(fila + "-" + (col+1));
        }
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosSinCapturaVertical(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        if (fila > 0 && unTablero.esPosicionVacia(fila-1, col)) {
            posiciones.add((fila-1) + "-" + col);
        }
        if (fila < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(fila+1, col)) {
            posiciones.add((fila+1) + "-" + col);
        }
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosSinCapturaDiagonal(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        if (fila > 0) {
            if (col > 0 && unTablero.esPosicionVacia(fila-1, col-1)) {
                posiciones.add((fila-1) + "-" + (col-1));
            }
            if (col < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(fila-1, col+1)) {
                posiciones.add((fila-1) + "-" + (col+1));
            }
        }
        
        if (fila < unTablero.getTamanio()-1) {
            if (col > 0 && unTablero.esPosicionVacia(fila+1, col-1)) {
                posiciones.add((fila+1) + "-" + (col-1));
            }
            if (col < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(fila+1, col+1)) {
                posiciones.add((fila+1) + "-" + (col+1));
            }
        }
        
        return posiciones;
    }
    
}
