/* ListaJugadores busca facilitar el manejo de un array list de tipo Jugador, a 
 * traves de metodos utiles para el juego como existeAlias.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author nalu-
 */
public class ListaJugadores {

    private ArrayList<Jugador> listaJugadores;

    /*CONSTRUCTORES*/
    public ListaJugadores() {
        this.listaJugadores = new ArrayList<Jugador>();
    }

    /*METODOS DE ACCESO*/
    public ArrayList<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }
    
    public int size() {
        return this.listaJugadores.size();
    }

    public Jugador jugadorAt(int pos) {
        return this.listaJugadores.get(pos);
    }

    /*METODOS DE MODIFICACION*/
    public void agregarJugador(Jugador unJugador) {
        this.listaJugadores.add(unJugador);
    }
    
//    public void ordenarLista() {
//        ArrayList<Jugador> aux = this.getListaJugadores();
//        Collections.sort(aux, new Comparator<Jugador>() { //innerClass culero
//		@Override
//		public int compare(Jugador o1, Jugador o2) {
//                    int victorias1 = o1.getVictorias();
//                    int victorias2 = o2.getVictorias();
//                    return (victorias2 - victorias1);
//                });
//        }
//        this.listaJugadores = aux;
//    }

    /*PREDICADOS*/
    public boolean existeAlias(String opcion) {
        boolean existe = false;

        for (int i = 0; i < this.size() && !existe; i++) {
            String alias = this.jugadorAt(i).getAlias();
            if (alias.equalsIgnoreCase(opcion)) {
                existe = true;
            }
        }
        return existe;
    }

    /*OVERRIDES*/
    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < this.size(); i++) {
            cadena += i + 1 + ". " + jugadorAt(i).getNombre() + "         "
                    + jugadorAt(i).getAlias() + "         " + jugadorAt(i).getEdad() + "\n";
        }

        return cadena;
    }
}
