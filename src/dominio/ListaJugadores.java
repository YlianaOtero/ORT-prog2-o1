/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author nalu-
 */
public class ListaJugadores {
    private ArrayList<Jugador> listaJugadores;
    
    public ListaJugadores(){
        this.listaJugadores = new ArrayList<Jugador>();
    }
    
    public ArrayList<Jugador> getListaJugadores(){
        return this.listaJugadores;
    }
    
    public void agregarJugador(Jugador unJugador){
        this.listaJugadores.add(unJugador);
    }

    public int size() {
        return this.listaJugadores.size();
    }
    
    public Jugador jugadorAt(int pos) {
        return this.listaJugadores.get(pos);
    }

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
}
