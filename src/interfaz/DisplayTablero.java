package interfaz;

import dominio.ListaPosConCaptura;
import dominio.ListaPosPosibles;
import dominio.ListaPosSinCaptura;
import dominio.Posicion;

/** DisplayTablero permite imprimir por pantalla los tableros de una partida dada,
 * con el estado actual del tablero de dicha partida.
 * Es una clase abstracta porque no nos interesa crear objetos de tipo DisplayTablero, y
 * sus metodos son static porque nos permite llamarlos desde otras clases sin necesidad
 * de instanciar DisplayTablero en ellas.
 * @author yliana*/

public abstract class DisplayTablero {
    private static final String Filas = "    1 2 3 4 5 6    ";
    private static final String Separador = "   +-+-+-+-+-+-+   ";
    
    /** Imprime por pantalla el tablero actual de una partida, con el formato 
     * solicitado para el juego.
     * @param unaPartida recibe la partida que contiene el tablero a mostrar.*/
    public static void mostrarTableroActual(Partida unaPartida) {
        Color negro = new Color();

        String impresion = Filas + "\n" + Separador + "\n";

        for (int i = 0; i < unaPartida.getTablero().getTamanio(); i++) {
            String letraBorde = letraBordeTablero(i);
            impresion += " " + letraBorde + " |";

            for (int j = 0; j < unaPartida.getTablero().getTamanio(); j++) {
                char ficha = unaPartida.getTablero().getTablero()[i][j];
                Color color = new Color(ficha);
                String coloreada = color.letraPintada(ficha);

                impresion += coloreada + negro.getCodigo() +"|";
            }

            impresion += " " + negro.getCodigo() + letraBorde + "\n" + Separador + "\n";
        }

        impresion += Filas;
        System.out.println(impresion);
    }
    
    /** @param fila Recibe la fila del tablero.
     * @return Devuelve un String con la letra a colocar en el borde de esa fila 
     * del tablero cuando lo vamos a mostrar por pantalla. */
    private static String letraBordeTablero(int fila) {
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

    /** Imprime por pantalla el tablero correspondiente a una posicion elegida 
     * en una partida, con el formato solicitado para el juego.
     * @param movsConCaptura Es la lista de todos los movimientos posibles con captura.
     * @param movsSinCaptura Es la lista de todos los movimientos posibles sin captura.
     * @param elegida Es la posicion elegida, desde la cual estamos "mirando" el tablero.
     * @param unaPartida Recibe la partida que contiene el tablero a mostrar.*/
    public static void mostrarTableroPosibilidades(ListaPosConCaptura movsConCaptura, 
                                            ListaPosSinCaptura movsSinCaptura,
                                            Posicion elegida, Partida unaPartida) {
        Color defaultColor = new Color();
        String impresion = Filas + "\n" + Separador + "\n";
        
        for (int i = 0; i < unaPartida.getTablero().getTamanio(); i++) {
            String letraBorde = letraBordeTablero(i);
            impresion += " " + defaultColor.getCodigo() + letraBorde + " |";

            for (int j = 0; j < unaPartida.getTablero().getTamanio(); j++) {
                Posicion pos = new Posicion(i, j);
                char ficha = unaPartida.getTablero().getTablero()[i][j];
                if (ListaPosPosibles.estaEnLaLista(pos, movsConCaptura.getLista())) {
                    ficha = '#';
                } else if (ListaPosPosibles.estaEnLaLista(pos, movsSinCaptura.getLista())) {
                    ficha = '*';
                } else if (elegida.getFila() == i && elegida.getCol() == j) {
                    ficha = 'E';
                }
                Color color = new Color(ficha);
                String coloreada = color.letraPintada(ficha);

                impresion += coloreada + defaultColor.getCodigo() +"|";
            }

            impresion += " " + defaultColor.getCodigo() + letraBorde + "\n" + Separador + "\n";
        }

        impresion += Filas;
        System.out.println(impresion);
    }
}
