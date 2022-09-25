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
public class Movimiento extends Juego {
    private int distanciaAlCentro;
    private String posicionInicial;
  //  private String posicionFinal;
    ArrayList<String> posicionesPosibles;
    
    private static ArrayList<String> posConDistanciaUno = {"C3", "C4", "D3", "D4"};
    private static ArrayList<String> posConDistanciaDos = {"B3", "B4", "C2", "C5",  
                                                           "D2", "D5", "E3", "E4"};
    private static ArrayList<String> posConDistanciaTres = {"B2", "B5", "E2", "E5"};
    private static ArrayList<String> posConDistanciaCuatro = {"A3", "A4", "C1", "C6",  
                                                              "D1", "D6", "F3", "F4"};
    private static ArrayList<String> posConDistanciaCinco = {"A2", "A5", "B1", "B6",
                                                             "E1", "E6", "F2", "F5"};
    private static ArrayList<String> posConDistanciaSeis = {"A1", "A6", "F1", "F6"};
    
    public Movimiento(String unaPosicion) {
        this.posicionInicial = unaPosicion;
        calcularDistanciaAlCentro(unaPosicion);
        this.posicionesPosibles = new ArrayList();
       //falta hacer la lista de posiciones posibles
    }

    public int getDistanciaAlCentro() {
        return this.distanciaAlCentro;
    }
    
    public void calcularDistanciaAlCentro(String unaPosicion) {
        String pos = unaPosicion.toUpperCase();
        if (posConDistanciaUno.contains(pos)) {
          this.distanciaAlCentro = 1;  
        } else if (posConDistanciaDos.contains(pos)) {
          this.distanciaAlCentro = 2;  
        } else if (posConDistanciaTres.contains(pos)) {
          this.distanciaAlCentro = 3;  
        } else if (posConDistanciaCuatro.contains(pos)) {
          this.distanciaAlCentro = 4;  
        } else if (posConDistanciaCinco.contains(pos)){
            this.distanciaAlCentro = 5;
        } else {
            this.distanciaAlCentro = 6;
        }
    }
    
}
