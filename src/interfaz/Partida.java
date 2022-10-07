/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;

/**
 *
 * @author ylian
 */
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    
    
    public Partida(String configTablero, Jugador[] jugadores) {
        this.jugador1 = jugadores[0];
        this.jugador2 = jugadores[1];
    }

    public void iniciarPartida() {
        //FALTA PROGRAMAR ESTE METODO
    }
}
