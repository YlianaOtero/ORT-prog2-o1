/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author ylian
 */
public class ListaPosPosibles {
    private Posicion inicio;
    private ListaPosConCaptura posPosiblesConCaptura;
    private ListaPosSinCaptura posPosiblesSinCaptura;
    private ArrayList<Posicion> posPosibles;
    
    public ListaPosPosibles(Posicion unaPosicion, Tablero unTablero) {
        this.inicio = unaPosicion;
        this.posPosiblesConCaptura = new ListaPosConCaptura(unaPosicion, unTablero);
        this.posPosiblesSinCaptura = new ListaPosSinCaptura(unaPosicion, unTablero);
    }
    
    public ListaPosSinCaptura getPosPosiblesSinCaptura() {
        return this.posPosiblesSinCaptura;
    }
    
    public ListaPosConCaptura getPosPosiblesConCaptura() {
        return this.posPosiblesConCaptura;
    }
}
