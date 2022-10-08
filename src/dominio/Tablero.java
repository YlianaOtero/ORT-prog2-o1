/* Tablero incluye la configuración del tablero del juego. Es la base de este,
 * pues consta de la matriz de caracteres que repersentan las fichas con las que
 * se debe jugar.*/
package dominio;

/**
 *
 * @author ylian
 */
public class Tablero {

    private static int Tamanio = 6;
    private static String[] Tipos = {"Standard", "Precargado 1", "Precargado 2"};

    private char[][] tablero;
    private int cantFichasAzules;
    private int cantFichasRojas;

    /*CONSTRUCTORES*/
    public Tablero() {
        this.cantFichasAzules = 18;
        this.cantFichasRojas = 18;
        this.tablero = new char[Tamanio][Tamanio];
        llenarTableroStandard(this.tablero);
    }

    public Tablero(String unTipo) {
        this.tablero = new char[Tamanio][Tamanio];

        if (unTipo.equals(Tipos[1])) {
            this.cantFichasAzules = 3;
            this.cantFichasRojas = 2;
            llenarTableroPrecargado1(this.tablero);
        } else if (unTipo.equals(Tipos[2])) {
            this.cantFichasAzules = 2;
            this.cantFichasRojas = 1;
            llenarTableroPrecargado2(this.tablero);
        } else {
            this.cantFichasAzules = 18;
            this.cantFichasRojas = 18;
            llenarTableroStandard(this.tablero);
        }
    }

    /*METODOS AUXILIARES*/
    private void llenarTableroStandard(char[][] tablero) {
        for (int i = 0; i < Tamanio; i++) {
            for (int j = 0; j < Tamanio; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    tablero[i][j] = 'A';
                } else {
                    tablero[i][j] = 'R';
                }
            }
        }
    }

    private void llenarTableroPrecargado1(char[][] tablero) {
        for (int i = 0; i < Tamanio; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 0 && j == 0 || i == 5 && j == 3) {
                    tablero[i][j] = 'R';
                } else if (i == 2 && j == 2 || i == 3 && j == 5 || i == 4 && j == 1) {
                    tablero[i][j] = 'A';
                } else {
                    tablero[i][j] = ' ';
                }
            }
        }
    }

    private void llenarTableroPrecargado2(char[][] tablero) {
        for (int i = 0; i < Tamanio; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 0 && j == 0) {
                    tablero[i][j] = 'R';
                } else if (i == 5 && j == 4 || i == 5 && j == 5) {
                    tablero[i][j] = 'A';
                } else {
                    tablero[i][j] = ' ';
                }
            }
        }
    }

    /*METODOS DE ACCESO*/
    public char[][] getTablero() {
        return this.tablero;
    }

    public int getCantFichasAzules() {
        return this.cantFichasAzules;
    }

    public int getCantFichasRojas() {
        return this.cantFichasRojas;
    }

    public int getTamanio() {
        return this.Tamanio;
    }

    public char getFicha(int fila, int col) {
        return this.tablero[fila][col];
    }

    /*METODOS DE MODIFICACION*/
    public void desplazarFicha(int filaInicial, int colInicial, int filaFinal, int colFinal) {
        char ficha = this.tablero[filaInicial][filaFinal];
        this.tablero[filaFinal][colFinal] = ficha;
        this.tablero[filaInicial][colInicial] = ' ';
    }

    public void comerFichaAzul(int fila, int col) {
        this.tablero[fila][col] = 'R';
        cantFichasRojas--;
    }

    public void comerFichaRoja(int fila, int col) {
        this.tablero[fila][col] = 'A';
        cantFichasAzules--;
    }

    /*PREDICADOS*/
    public boolean esLugarVacio(int fila, int col) {
        boolean esVacia = false;

        if (this.tablero[fila][col] == ' ') {
            esVacia = true;
        }

        return esVacia;
    }
}
