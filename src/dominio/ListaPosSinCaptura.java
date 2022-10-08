/* ListaPosSinCaptura se encarga de la lógica de los movimientos sin captura del
 * juego. Un objeto de esta clase tiene una posición a partir de la cual se genera
 * la lista de posiciones a las cuales se podría desplazar sin captura, siempre
 * dentro de un mismo tablero dado.*/
package dominio;

import java.util.ArrayList;

/**
 *
 * @author ylian
 */
public class ListaPosSinCaptura {

    private Posicion inicio;
    private Tablero tablero;
    private ArrayList<Posicion> lista;

    /*CONSTRUCTORES*/
    public ListaPosSinCaptura(Posicion unaPosicion, Tablero unTablero) {
        this.inicio = unaPosicion;
        this.tablero = unTablero;
        this.lista = listarPosiciones();
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
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (col > 0 && this.tablero.esLugarVacio(fila, col - 1)) {
            enlistar(fila, col - 1, posiciones);
        }

        if (col < this.tablero.getTamanio() - 1 && this.tablero.esLugarVacio(fila, col + 1)) {
            enlistar(fila, col + 1, posiciones);
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosVertical() {
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0 && this.tablero.esLugarVacio(fila - 1, col)) {
            enlistar(fila - 1, col, posiciones);
        }
        if (fila < this.tablero.getTamanio() - 1 && this.tablero.esLugarVacio(fila + 1, col)) {
            enlistar(fila + 1, col, posiciones);
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosDiagonal() {
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0) {
            if (col > 0 && this.tablero.esLugarVacio(fila - 1, col - 1)) {
                enlistar(fila - 1, col - 1, posiciones);
            }
            if (col < this.tablero.getTamanio() - 1 && this.tablero.esLugarVacio(fila - 1, col + 1)) {
                enlistar(fila - 1, col + 1, posiciones);
            }
        }

        if (fila < this.tablero.getTamanio() - 1) {
            if (col > 0 && this.tablero.esLugarVacio(fila + 1, col - 1)) {
                enlistar(fila + 1, col - 1, posiciones);
            }
            if (col < this.tablero.getTamanio() - 1 && this.tablero.esLugarVacio(fila + 1, col + 1)) {
                enlistar(fila + 1, col + 1, posiciones);
            }
        }

        return posiciones;
    }
    
    private void enlistar(int fila, int col, ArrayList<Posicion> lista) {
        Posicion nueva = new Posicion(fila, col);
        lista.add(nueva);
    }
}
