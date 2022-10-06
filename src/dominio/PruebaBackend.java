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
public class PruebaBackend {

    public static void main(String[] args) {
        Tablero tablero = new Tablero("Standard");
        imprimirTablero(tablero);

        Posicion pos = new Posicion(0, 0, tablero);
        Posicion pos2 = new Posicion(0, 1, tablero);
        // System.out.println(pos);

//        ListaPosPosibles movsPosibles = new ListaPosPosibles(pos, tablero);
//        System.out.println("POSICIONES POSIBLES SIN CAPTURA:");
//        System.out.println(movsPosibles.getPosPosiblesSinCaptura());
//        System.out.println("POSICIONES POSIBLES CON CAPTURA:");
//        System.out.println(movsPosibles.getPosPosiblesConCaptura());
//        
        ListaPosConCaptura listaCon = new ListaPosConCaptura(pos, tablero);
        System.out.println(listaCon);
//        
//        ArrayList<Posicion> prueba = listaCon.listarPosHorizontal(pos, tablero);
//        char x = pos.getFichaEnPos(tablero);
//        System.out.println(x);
//        System.out.println(tablero.getElem(pos.getFila(), pos.getCol()));
////        
//        System.out.println(listaCon.puedeComer(pos, pos2, tablero));


    }

    public static void imprimirTablero(Tablero unTablero) {
        for (int i = 0; i < unTablero.getTamanio(); i++) {
            for (int j = 0; j < unTablero.getTamanio(); j++) {
                char elem = unTablero.getElem(i, j);
                String color = "\u001B[31m"; //rojo
                if (elem == 'A') {
                    color = "\u001B[34m";
                }
                System.out.print(color + elem + " ");
            }
            System.out.println();
        }
    }

}
