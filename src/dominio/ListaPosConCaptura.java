/*  ListaPosConCaptura se encarga de la lógica de los movimientos con captura del
 * juego. Un objeto de esta clase tiene una posición a partir de la cual se genera
 * la lista de posiciones a las cuales se podría desplazar capturando a una ficha,
 * siempre dentro de un tablero dado.*/
package dominio;

import java.util.ArrayList;

/**
 *
 * @author ylian
 */
public class ListaPosConCaptura {
    
    private Posicion inicio;
    private Tablero tablero;
    private ArrayList<Posicion> lista;
    
    /*CONSTRUCTORES*/
    public ListaPosConCaptura(Posicion unaPosicion, Tablero unTablero) {
        this.inicio = unaPosicion;
        this.tablero = unTablero;
        this.lista = listarPosiciones();
    }
    
    /*METODOS DE ACCESO*/
    public ArrayList<Posicion> getLista() {
        return this.lista;
    }
    
    /*PREDICADOS*/
    public boolean hayMovimientos() {
        return !this.lista.isEmpty();
    }
    
    public boolean estaEnLaLista(Posicion pos) {
        boolean esta = false;
        
        for (int i = 0; i < this.lista.size() && !esta; i++) {
            Posicion actual = this.lista.get(i);
            if (actual.getFila() == pos.getFila() && actual.getCol() == pos.getCol()) {
                esta = true;
            }
        }
        
        return esta;
    }
    
    /*METODOS DE MODIFICACION*/
    private ArrayList<Posicion> listarPosiciones() {
        ArrayList<Posicion> posiciones = listarPosHorizontal();
        posiciones.addAll(listarPosVertical());
        posiciones.addAll(listarPosDiagonal());
        
        return posiciones;
    }

    /*METODOS AUXILIARES*/
    private ArrayList<Posicion> listarPosHorizontal() {
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
                
        boolean frenar = false;
        
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();
        
        for (int i = fila+1; i < this.tablero.getTamanio() && !frenar; i++) {
            if (!this.tablero.esLugarVacio(i, col)) {
                frenar = true;
                Posicion actual = new Posicion(i, col);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = true;
        
        for (int i = fila-1; i >= 0&& !frenar; i--) {
            if (!this.tablero.esLugarVacio(i, col)) {
                frenar = true;
                Posicion actual = new Posicion(i, col);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosVertical() {
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
                
        boolean frenar = false;
        
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();
        
        for (int j = col+1; j < this.tablero.getTamanio() && !frenar; j++) {
            if (!this.tablero.esLugarVacio(fila, j)) {
                frenar = true;
                Posicion actual = new Posicion(fila, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = false;
        
        for (int j = col-1; j >= 0 && !frenar; j--) {
            if (!this.tablero.esLugarVacio(fila, j)) {
                frenar = true;
                Posicion actual = new Posicion(fila, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        return posiciones;
    }
    
    private ArrayList<Posicion> listarPosDiagonal() {
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
                
        boolean frenar = false;
        
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();
        
        //DE IZQ A DERECHA CRECIENTE
        for (int i = fila-1, j = col+1; i >= 0 && j < this.tablero.getTamanio() && !frenar; i--, j++) {
            if (!this.tablero.esLugarVacio(i, j)) {
                frenar = true;
                Posicion actual = new Posicion(i, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = false;
        
        //DE IZQ A DER DECRECIENTE
        for (int i = fila+1, j = col+1; i < this.tablero.getTamanio() && j < this.tablero.getTamanio() && !frenar; i++, j++) {
            if (!this.tablero.esLugarVacio(i, j)) {
                frenar = true;
                Posicion actual = new Posicion(i, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = false;
        
        //DE DER A IZQ CRECIENTE
        for (int i = fila-1, j = col-1; i >= 0 && j >= 0 && !frenar; i--, j--) {
            if (!this.tablero.esLugarVacio(i, j)) {
                frenar = true;
                Posicion actual = new Posicion(i, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }
        
        frenar = false;
        
        //DE DER A IZQ DECRECIENTE
        for (int i = fila+1, j = col-1; i < this.tablero.getTamanio() && j >= 0 && !frenar; i++, j--) {
            if (!this.tablero.esLugarVacio(i, j)) {
                frenar = true;
                Posicion actual = new Posicion(i, j);
                if (puedeComer(actual)) {
                    posiciones.add(actual);
                }
            }
        }

        return posiciones;
    }
    
    protected boolean puedeComer(Posicion fin) {
        boolean valida = false;
        
        if (inicio.getFichaEnPos(this.tablero) == 'R') {
            valida = fin.getFichaEnPos(this.tablero) == 'A' && 
                    inicio.getDistanciaAlCentro() >= fin.getDistanciaAlCentro();
        } else if (inicio.getFichaEnPos(this.tablero) == 'A') {
            valida = fin.getFichaEnPos(this.tablero) == 'R' && 
                    inicio.getDistanciaAlCentro() >= fin.getDistanciaAlCentro();
        }
        
        return valida;
    } 
}
