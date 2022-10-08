/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.Tablero;

/**
 *
 * @author ylian
 */
public class Partida {

    private static String Filas = "    1 2 3 4 5 6    ";
    private static String Separador = "   +-+-+-+-+-+-+   ";
    
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    /*CONSTRUCTORES*/
    public Partida(String configTablero, Jugador[] jugadores) {
        this.jugador1 = jugadores[0];
        this.jugador2 = jugadores[1];
        this.tablero = new Tablero(configTablero);
    }

    public void iniciarPartida() {
        //FALTA PROGRAMAR ESTE METODO
    }
    
    private void mostrarTableroActual() {
        Color negro = new Color();

        String impresion = Filas + "\n" + Separador + "\n";

        for (int i = 0; i < tablero.getTamanio(); i++) {
            String letraBorde = letraBordeTablero(i);
            impresion += " " + letraBorde + " |";

            for (int j = 0; j < tablero.getTamanio(); j++) {
                char ficha = tablero.getTablero()[i][j];
                Color color = colorCorrespondiente(ficha);
                String coloreada = letraPintada(ficha, color);

                impresion += coloreada + negro.getCodigo() +"|";
            }

            impresion += " " + negro.getCodigo() + letraBorde + "\n" + Separador + "\n";
        }

        impresion += Filas;
        System.out.println(impresion);
    }

    private Color colorCorrespondiente(char ficha) {
        Color colorCorrespondiente = new Color();

        switch (ficha) {
            case 'A' ->
                colorCorrespondiente.setColor("azul");
            case 'R' ->
                colorCorrespondiente.setColor("rojo");
        }

        return colorCorrespondiente;
    }

    private String letraPintada(char letra, Color color) {
        String codigo = color.getCodigo();
        return codigo + letra;
    }

    private String letraBordeTablero(int fila) {
        String letra;

        letra = switch (fila) {
            case 0 ->
                "A";
            case 1 ->
                "B";
            case 2 ->
                "C";
            case 3 ->
                "D";
            case 4 ->
                "E";
            case 5 ->
                "F";
            default ->
                "";
        };

        return letra;
    }
}
