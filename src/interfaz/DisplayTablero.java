/* DisplayTablero permite imprimir por pantalla los tableros de una partida dada,
con el estado actual del tablero de dicha partida. */
package interfaz;

import dominio.ListaPosConCaptura;
import dominio.ListaPosSinCaptura;
import dominio.Posicion;

/**
 *
 * @author ylian
 */
public abstract class DisplayTablero {
    private static final String Filas = "    1 2 3 4 5 6    ";
    private static final String Separador = "   +-+-+-+-+-+-+   ";
    
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
                if (movsConCaptura.estaEnLaLista(pos)) {
                    ficha = '#';
                } else if (movsSinCaptura.estaEnLaLista(pos)) {
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
