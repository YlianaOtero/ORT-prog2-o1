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
public class ListaPosSinCaptura {
    private Posicion inicio;
    private ArrayList<Posicion> lista;
    
    public ListaPosSinCaptura(Posicion unaPosicion, Tablero unTablero) {
        this.inicio = unaPosicion;
        this.lista = listarPosiciones(unaPosicion, unTablero);
    }
    
    private ArrayList<Posicion> listarPosiciones(Posicion unaPosicion, Tablero unTablero) {
        ArrayList<Posicion> posiciones = listarPosHorizontal(unaPosicion, unTablero);
        posiciones.addAll(listarPosVertical(unaPosicion, unTablero));
        posiciones.addAll(listarPosDiagonal(unaPosicion, unTablero));
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosHorizontal(Posicion unaPosicion, Tablero unTablero) {
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        if (col > 0 && unTablero.esLugarVacio(fila, col-1)) {
            Posicion nueva = new Posicion(fila, col-1, unTablero);
            posiciones.add(nueva);
        }
        
        if (col < unTablero.getTamanio()-1 && unTablero.esLugarVacio(fila, col+1)) {
            Posicion nueva = new Posicion(fila, col+1, unTablero);
            posiciones.add(nueva);
        }
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosVertical(Posicion unaPosicion, Tablero unTablero) {
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        if (fila > 0 && unTablero.esLugarVacio(fila-1, col)) {
            Posicion nueva = new Posicion(fila-1, col, unTablero);
            posiciones.add(nueva);
        }
        if (fila < unTablero.getTamanio()-1 && unTablero.esLugarVacio(fila+1, col)) {
            Posicion nueva = new Posicion(fila+1, col, unTablero);
            posiciones.add(nueva);
        }
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosDiagonal(Posicion unaPosicion, Tablero unTablero) {
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        if (fila > 0) {
            if (col > 0 && unTablero.esLugarVacio(fila-1, col-1)) {
                Posicion nueva = new Posicion(fila-1, col-1, unTablero);
                posiciones.add(nueva);
            }
            if (col < unTablero.getTamanio()-1 && unTablero.esLugarVacio(fila-1, col+1)) {
                Posicion nueva = new Posicion(fila-1, col+1, unTablero);
                posiciones.add(nueva);
            }
        }
        
        if (fila < unTablero.getTamanio()-1) {
            if (col > 0 && unTablero.esLugarVacio(fila+1, col-1)) {
                Posicion nueva = new Posicion(fila+1, col-1, unTablero);
                posiciones.add(nueva);
            }
            if (col < unTablero.getTamanio()-1 && unTablero.esLugarVacio(fila+1, col+1)) {
                Posicion nueva = new Posicion(fila+1, col+1, unTablero);
                posiciones.add(nueva);
            }
        }
        
        return posiciones;
    }
}
