package dominio;

import java.util.ArrayList;

/** Partiendo de la posicion Inicio almancenada en la superclase ListaPosPosibels, 
 * dentro del tablero incluido en la misma clase, ListaPosSinCaptura se encarga 
 * de listar las posiciones a las cuales la ficha en Inicio podria desplazarse
 * sin captura.
 * @author yliana */

public class ListaPosSinCaptura extends ListaPosPosibles{

    private ArrayList<Posicion> lista;

    /*CONSTRUCTORES*/
    public ListaPosSinCaptura() {
        this.lista = listarPosiciones();
    }
    
    /*METODOS DE ACCESO*/
    public ArrayList<Posicion> getLista() {
        return this.lista;
    }

    /*METODOS DE MODIFICACION*/
    private ArrayList<Posicion> listarPosiciones() {
        ArrayList<Posicion> posiciones = listarPosHorizontal();
        posiciones.addAll(listarPosVertical());
        posiciones.addAll(listarPosDiagonal());

        return posiciones;
    }

    /*METODOS PARA LISTAR LAS POSICIONES SEGUN DIRECCION*/
    private ArrayList<Posicion> listarPosHorizontal() {
        int fila = super.Inicio.getFila();
        int col = super.Inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (col > 0) {
            Posicion nueva = new Posicion(fila, col - 1);
            if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                posiciones.add(nueva);
            } 
        }

        if (col < super.Tablero.getTamanio() - 1) {
            Posicion nueva = new Posicion(fila, col + 1);
            if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                posiciones.add(nueva);
            }
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosVertical() {
        int fila = super.Inicio.getFila();
        int col = super.Inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0) {
            Posicion nueva = new Posicion(fila - 1, col);
            if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                posiciones.add(nueva);
            }
        }
        
        if (fila < super.Tablero.getTamanio() - 1) {
            Posicion nueva = new Posicion(fila + 1, col);
            if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                posiciones.add(nueva);
            }
        }

        return posiciones;
    }

    private ArrayList<Posicion> listarPosDiagonal() {
        int fila = super.Inicio.getFila();
        int col = super.Inicio.getCol();

        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        if (fila > 0) {
            if (col > 0) {
                Posicion nueva = new Posicion(fila - 1, col - 1);
                if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                    posiciones.add(nueva);
                }
            }
            if (col < super.Tablero.getTamanio() - 1) {
                Posicion nueva = new Posicion(fila - 1, col + 1);
                if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                    posiciones.add(nueva);
                }
            }
        }

        if (fila < super.Tablero.getTamanio() - 1) {
            if (col > 0) {
                Posicion nueva = new Posicion(fila + 1, col - 1);
                if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                    posiciones.add(nueva);
                }
            }
            if (col < super.Tablero.getTamanio() - 1) {
                Posicion nueva = new Posicion(fila + 1, col + 1);
                if (Posicion.puedeDesplazarse(super.Inicio, nueva, super.Tablero)) {
                    posiciones.add(nueva);
                }
            }
        }

        return posiciones;
    }
}
