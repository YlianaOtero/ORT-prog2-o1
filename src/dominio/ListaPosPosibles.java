/* ListaPosPosibles es la clase padre de ListaPosConCaptura y ListaPosSinCaptura.
 * Almacena la informacion de posicion de inicio y tablero, a partir de la cual
 * sus subclases pueden listar los movimientos posibles de la ficha en Inicio.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author ylian
 */
public abstract class ListaPosPosibles {
    protected static Posicion Inicio;
    protected static Tablero Tablero;
    
    public static void setTablero(Tablero unTablero) {
        Tablero = unTablero;
    }
    
    public static void setInicio(Posicion unaPos) {
        Inicio = unaPos;
    }
    
    public static boolean hayPosiciones(ArrayList<Posicion> lista) {
        return lista.isEmpty();
    }
    
    public static boolean estaEnLaLista(Posicion pos, ArrayList<Posicion> lista) {
        boolean esta = false;
        
        for (int i = 0; i < lista.size() && !esta; i++) {
            Posicion actual = lista.get(i);
            if (actual.getFila() == pos.getFila() && actual.getCol() == pos.getCol()) {
                esta = true;
            }
        }
        
        return esta;
    }
}
