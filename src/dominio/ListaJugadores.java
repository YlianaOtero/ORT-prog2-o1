package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** ListaJugadores busca facilitar el manejo de un array list de tipo Jugador, a 
 * traves de metodos utiles para el juego como existeAlias.
 * @author natalia*/
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
    
    public int largo() {
        return this.listaJugadores.size();
    }

    public Jugador jugadorEnPos(int pos) {
        return this.listaJugadores.get(pos);
    }

    /*METODOS DE MODIFICACION*/
    public void agregarJugador(Jugador unJugador) {
        this.listaJugadores.add(unJugador);
    }
    
    /**Ordena la lista segun la cantidad de victorias de cada jugador, de manera
     * decreciente.*/
    public void ordenarLista() {
        ArrayList<Jugador> aux = this.getListaJugadores();
        
        Collections.sort(aux, new Comparator<Jugador>(){
            @Override
            public int compare(Jugador o1, Jugador o2) {
                    int victorias1 = o1.getVictorias();
                    int victorias2 = o2.getVictorias();
                    return (victorias2 - victorias1);
             }});
        
        this.listaJugadores = aux;
    }

    /*PREDICADOS*/
    public boolean existeAlias(String opcion) {
        boolean existe = false;

        for (int i = 0; i < this.largo() && !existe; i++) {
            String alias = this.jugadorEnPos(i).getAlias();
            if (alias.equalsIgnoreCase(opcion)) {
                existe = true;
            }
        }
        return existe;
    } 
    
    /** Generamos una cadena de espacios de un largo en particular para ayudarnos
     * un poco en el formato de impresion de la lista.
     * @return Devuelve un String de espacios del mismo largo que el alias mas
     * extenso de la lista*/
    public String paddingAlias() {
        String pad = "";
        int aliasMasLargo = 0;

        for (int i = 0; i < listaJugadores.size(); i++) {
            String aliasActual = listaJugadores.get(i).getAlias();
            int largo = aliasActual.length();
            if (largo > aliasMasLargo) {
                aliasMasLargo = largo;
            }
        }

        for (int i = 0; i < aliasMasLargo; i++) {
            pad += " ";
        }

        return pad;
    }
    
    /** Generamos una cadena de espacios de un largo en particular para ayudarnos
     * un poco en el formato de impresion de la lista.
     * @return Devuelve un String de espacios del mismo largo que el nombre mas
     * extenso de la lista*/
    public String paddingNombre() {
        String pad = "";
        int nombreMasLargo = 0;

        for (int i = 0; i < listaJugadores.size(); i++) {
            String nombreActual = listaJugadores.get(i).getNombre();
            int largo = nombreActual.length();
            if (largo > nombreMasLargo) {
                nombreMasLargo = largo;
            }
        }

        for (int i = 0; i < nombreMasLargo; i++) {
            pad += " ";
        }

        return pad;
    }

    /*OVERRIDES*/
    @Override
    public String toString() {
        String padNombre = paddingNombre();
        String padAlias = paddingAlias();
        String cadena = "************************************************\n"
                + "                     JUGADORES                  \n"
                + "************************************************\n"
                + "NOMBRE " +padNombre +padNombre + " ALIAS " +padAlias +padAlias +" EDAD \n";
        for (int i = 0; i < this.largo(); i++) {
            cadena += i + 1 + ". " + jugadorEnPos(i).getNombre() + padNombre + "       "
                    + jugadorEnPos(i).getAlias() + padNombre + "      " + jugadorEnPos(i).getEdad() + "\n";
        }

        cadena += "************************************************\n";
        return cadena;
    }
}
