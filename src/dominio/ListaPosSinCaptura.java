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
    protected boolean puedeDesplazarse(Posicion fin) {
        return fin.getFichaEnPos(this.tablero) == ' ' && 
                    inicio.getDistanciaAlCentro() < fin.getDistanciaAlCentro();
    } 
    
    
    private ArrayList<Posicion> listarPosHorizontal() {
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (col > 0) {
            Posicion nueva = new Posicion(fila, col - 1);
            if (puedeDesplazarse (nueva)) {
                posiciones.add(nueva);
            } 
        }

        if (col < this.tablero.getTamanio() - 1) {
            Posicion nueva = new Posicion(fila, col + 1);
            if (puedeDesplazarse (nueva)) {
                posiciones.add(nueva);
            }
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosVertical() {
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0) {
            Posicion nueva = new Posicion(fila - 1, col);
            if (puedeDesplazarse (nueva)) {
                posiciones.add(nueva);
            }
        }
        
        if (fila < this.tablero.getTamanio() - 1) {
            Posicion nueva = new Posicion(fila + 1, col);
            if (puedeDesplazarse (nueva)) {
                posiciones.add(nueva);
            }
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosDiagonal() {
        int fila = this.inicio.getFila();
        int col = this.inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0) {
            if (col > 0) {
                Posicion nueva = new Posicion(fila - 1, col - 1);
                if (puedeDesplazarse (nueva)) {
                    posiciones.add(nueva);
                }
            }
            if (col < this.tablero.getTamanio() - 1) {
                Posicion nueva = new Posicion(fila - 1, col + 1);
                if (puedeDesplazarse (nueva)) {
                    posiciones.add(nueva);
                }
            }
        }

        if (fila < this.tablero.getTamanio() - 1) {
            if (col > 0) {
                Posicion nueva = new Posicion(fila + 1, col - 1);
                if (puedeDesplazarse (nueva)) {
                    posiciones.add(nueva);
                }
            }
            if (col < this.tablero.getTamanio() - 1) {
                Posicion nueva = new Posicion(fila + 1, col + 1);
                if (puedeDesplazarse (nueva)) {
                    posiciones.add(nueva);
                }
            }
        }

        return posiciones;
    }
}
