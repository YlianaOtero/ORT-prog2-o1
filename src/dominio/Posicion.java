package dominio;

/** Una Posicion representa un lugar puntual de un Tablero cualquiera.
 * El valor de esta clase reside en la información de distancias al centro.
 * Si los valores de las distancias cambiasen, solo seria necesario actualizar
 * esta clase, permitiendo asi mantener el tablero.
 * @author yliana */
public class Posicion {
    
    private static final int[][] PosConDistanciaUno = {{2, 2}, {2, 3}, {3, 2}, {3, 3}};
    private static final int[][] PosConDistanciaDos = {{1, 2}, {1, 3}, {2, 1}, {2, 4},
                                                      {3, 1}, {3, 4}, {4, 2}, {4, 3}};                                           
    private static final int[][] PosConDistanciaTres = {{1, 1}, {1, 4}, {5, 1}, {5, 4}};
    private static final int[][] PosConDistanciaCuatro = {{0, 2}, {0, 3}, {2, 0}, {2, 3},
                                                         {2, 5}, {3, 5}, {5, 2}, {5, 3}, {3, 0}};
    private static final int[][] PosConDistanciaCinco = {{0, 1}, {0, 4}, {1, 0}, {1, 5},
                                                        {4, 0}, {4, 5}, {5, 1}, {5, 4}};
    private static final int[][] PosConDistanciaSeis = {{0, 0}, {0, 5}, {5, 0}, {5,5}};
    
    private int fila;
    private int col;
    private int distanciaAlCentro;

    /*CONSTRUCTORES*/
    public Posicion(int fila, int col) {
        this.fila = fila;
        this.col = col;
        this.distanciaAlCentro = calcularDistanciaAlCentro(fila, col);
    }
    
    /*METODOS DE ACCESO*/
    public int getFila() {
        return this.fila;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public int getDistanciaAlCentro() {
        return this.distanciaAlCentro;
    }
    
    public char getFichaEnPos(Tablero unTablero) {
        return unTablero.getFicha(this.fila, this.col);
    }
    
    /*PREDICADOS*/
    public static boolean puedeComer(Posicion inicio, Posicion fin, Tablero tablero) {
        boolean valida = false;
        
        if (inicio.getFichaEnPos(tablero) == 'R') {
            valida = fin.getFichaEnPos(tablero) == 'A' && 
                    inicio.getDistanciaAlCentro() >= fin.getDistanciaAlCentro();
        } else if (inicio.getFichaEnPos(tablero) == 'A') {
            valida = fin.getFichaEnPos(tablero) == 'R' && 
                    inicio.getDistanciaAlCentro() >= fin.getDistanciaAlCentro();
        }
        
        return valida;
    } 
    
    public static boolean puedeDesplazarse(Posicion inicio, Posicion fin, Tablero tablero) {
        return fin.getFichaEnPos(tablero) == ' ' && 
                    inicio.getDistanciaAlCentro() < fin.getDistanciaAlCentro();
    } 
    
    /*METODOS AUXILIARES*/
    private int calcularDistanciaAlCentro(int fila, int col) {
        int distancia;
        
        if (estaEnLaMatriz(fila, col, PosConDistanciaUno)) {
          distancia = 1;  
          
        } else if (estaEnLaMatriz(fila, col, PosConDistanciaDos)) {
          distancia = 2;  
          
        } else if (estaEnLaMatriz(fila, col, PosConDistanciaTres)) {
          distancia = 3;  
          
        } else if (estaEnLaMatriz(fila, col, PosConDistanciaCuatro)) {
          distancia = 4;  
          
        } else if (estaEnLaMatriz(fila, col, PosConDistanciaCinco)){
            distancia = 5;
            
        } else {
            distancia = 6;
        }
        
        return distancia;
    }
    
    private boolean estaEnLaMatriz(int fila, int col, int[][] mat) {
        boolean esta = false;
        
        for (int i = 0; i < mat.length && !esta; i++) {
            if (mat[i][0] == fila && mat[i][1] == col) {
                esta = true;
            }
        }
        
        return esta;
    }
}
