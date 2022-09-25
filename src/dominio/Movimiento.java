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
    private ArrayList<String> listarPosConCapturaHorizontal(int fila, int col, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        boolean libre = true;
        
        for (int j = col+1; j < unTablero.getTamanio() && libre; j++) {
            if (!unTablero.esPosicionVacia(fila, j)) {
                libre = false;
            } else {
                posiciones.add(posCorrespondiente(fila, j));
            }
        }
        
        libre = true;
        for (int j = 0; j < col && libre; j++) {
            if (!unTablero.esPosicionVacia(fila, j)) {
                libre = false;
            } else {
                posiciones.add(posCorrespondiente(fila, j));
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
                posiciones.add(posCorrespondiente(i, col));
            }
        }
        
        libre = true;
        for (int i = 0; i < fila && libre; i++) {
            if (!unTablero.esPosicionVacia(i, col)) {
                libre = false;
            } else {
                posiciones.add(posCorrespondiente(i, col));
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosConCaptura(String unaPosicion, Tablero unTablero) {
        ArrayList<String> posiciones = new ArrayList<String>();
        
        int filaPosicion = filaCorrespondiente(unaPosicion);
        int colPosicion = colCorrespondiente(unaPosicion);
        
        //HORIZONTALES:
        posiciones = listarPosConCapturaHorizontal(filaPosicion, colPosicion, unTablero);
        //VERTICALES:
        posiciones.addAll(listarPosConCapturaVertical(filaPosicion, colPosicion, unTablero));
        //DIAGONALES: TO DO
        
        
        return posiciones;
    }
    
    private ArrayList<String> listarPosSinCaptura(String unaPosicion, Tablero unTablero) {        
        ArrayList<String> posiciones = new ArrayList<String>();
        
        char[][] tablero = unTablero.getTablero();
        int filaPosicion = filaCorrespondiente(unaPosicion);
        int colPosicion = colCorrespondiente(unaPosicion);
        
        //HORIZONTALES:
        if (colPosicion > 0 && unTablero.esPosicionVacia(filaPosicion, colPosicion-1)) {
            posiciones.add(posCorrespondiente(filaPosicion, colPosicion-1));
        }
        if (colPosicion < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(filaPosicion, colPosicion+1)) {
            posiciones.add(posCorrespondiente(filaPosicion, colPosicion+1));
        }
        
        //VERTICALES:
        if (filaPosicion > 0 && unTablero.esPosicionVacia(filaPosicion-1, colPosicion)) {
            posiciones.add(posCorrespondiente(filaPosicion-1, colPosicion));
        }
        if (filaPosicion < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(filaPosicion+1, colPosicion)) {
            posiciones.add(posCorrespondiente(filaPosicion+1, colPosicion));
        }
        
        //DIAGONALES:
        if (filaPosicion > 0) {
            if (colPosicion > 0 && unTablero.esPosicionVacia(filaPosicion-1, colPosicion-1)) {
                posiciones.add(posCorrespondiente(filaPosicion-1, colPosicion-1));
            }
            if (colPosicion < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(filaPosicion-1, colPosicion+1)) {
                posiciones.add(posCorrespondiente(filaPosicion-1, colPosicion+1));
            }
        }
        if (filaPosicion < unTablero.getTamanio()-1) {
            if (colPosicion > 0 && unTablero.esPosicionVacia(filaPosicion+1, colPosicion-1)) {
                posiciones.add(posCorrespondiente(filaPosicion+1, colPosicion-1));
            }
            if (colPosicion < unTablero.getTamanio()-1 && unTablero.esPosicionVacia(filaPosicion+1, colPosicion+1)) {
                posiciones.add(posCorrespondiente(filaPosicion+1, colPosicion+1));
            }
        }
        
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
    
}
