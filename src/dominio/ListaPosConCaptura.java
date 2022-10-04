/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ylian
 */
public class ListaPosConCaptura {
    private Posicion inicio;
    private ArrayList<Posicion> lista;
    
    public ListaPosConCaptura(Posicion unaPosicion, Tablero unTablero) {
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
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
                
        boolean frenar = false;
        
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        for (int i = fila+1; i < unTablero.getTablero().length && !frenar; i++) {
            if (unTablero.esLugarVacio(i, col)) {
                frenar = true;
                Posicion actual = new Posicion(i, col, unTablero);
                if (puedeComer(unaPosicion, actual, unTablero)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = true;
        
        for (int i = fila-1; i >= 0&& !frenar; i--) {
            if (unTablero.esLugarVacio(i, col)) {
                frenar = true;
                Posicion actual = new Posicion(i, col, unTablero);
                if (puedeComer(unaPosicion, actual, unTablero)) {
                    posiciones.add(actual);
                }
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosVertical(Posicion unaPosicion, Tablero unTablero) {
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
                
        boolean frenar = false;
        
        int fila = unaPosicion.getFila();
        int col = unaPosicion.getCol();
        
        for (int j = col+1; j < unTablero.getTablero()[0].length && !frenar; j++) {
            if (unTablero.esLugarVacio(fila, j)) {
                frenar = true;
                Posicion actual = new Posicion(fila, j, unTablero);
                if (puedeComer(unaPosicion, actual, unTablero)) {
                    posiciones.add(actual);
                }
            }
        }
        
        for (int j = col-1; j >= 0 && !frenar; j--) {
            if (unTablero.esLugarVacio(fila, j)) {
                frenar = true;
                Posicion actual = new Posicion(fila, j, unTablero);
                if (puedeComer(unaPosicion, actual, unTablero)) {
                    posiciones.add(actual);
                }
            }
        }
        
        return posiciones;
    }
    
    
    
    
    private boolean puedeComer(Posicion inicio, Posicion fin, Tablero unTablero) {
        boolean valida = false;
        
        if (inicio.getFichaEnPos(unTablero) == 'R') {
            valida = fin.getFichaEnPos(unTablero) == 'A' && 
                    inicio.getDistanciaAlCentro() <= fin.getDistanciaAlCentro();
        } else if (inicio.getFichaEnPos(unTablero) == 'A') {
            valida = fin.getFichaEnPos(unTablero) == 'R' && 
                    inicio.getDistanciaAlCentro() <= fin.getDistanciaAlCentro();
        }
        
        return valida;
    }


    //FALTA LISTAR DIAGONAL

    private ArrayList<Posicion> listarPosDiagonal(Posicion unaPosicion, Tablero unTablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
