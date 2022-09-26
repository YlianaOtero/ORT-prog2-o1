/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author ylian
 */
public class ListaPosPosibles extends Posicion {
    private Posicion inicio;
    private ArrayList<String> posPosiblesConCaptura;
    private ArrayList<String> posPosiblesSinCaptura;
    
    public ListaPosPosibles(Posicion unaPosicion, Tablero unTablero) {
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        this.inicio = unaPosicion;
        this.posPosiblesConCaptura = listarPosConCaptura(fila, col, unTablero);
        this.posPosiblesSinCaptura = listarPosConCaptura(fila, col, unTablero);
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
