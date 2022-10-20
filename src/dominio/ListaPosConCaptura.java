package dominio;

import java.util.ArrayList;

/** Partiendo de la posicion Inicio almancenada en la superclase ListaPosPosibels, 
 * dentro del tablero incluido en la misma clase, ListaPosConCaptura se encarga 
 * de listar las posiciones a las cuales la ficha en Inicio podria desplazarse
 * con captura. 
 * @author yliana */
public class ListaPosConCaptura extends ListaPosPosibles {
    private ArrayList<Posicion> lista;
    
    /*CONSTRUCTORES*/
    public ListaPosConCaptura() {
        this.lista = listarPosiciones();
    }
    
    /*METODOS DE ACCESO*/
    public ArrayList<Posicion> getLista() {
        return this.lista;
    }
    
    private ArrayList<Posicion> listarPosiciones() {
        ArrayList<Posicion> posiciones = listarPosSegunDireccion("horizontal creciente", 
                                        incrementoEnRecorrida("horizontal creciente"));
        
        posiciones.addAll(listarPosSegunDireccion("horizontal decreciente", 
                          incrementoEnRecorrida("horizontal decreciente")));
        
        posiciones.addAll(listarPosSegunDireccion("vertical creciente", 
                          incrementoEnRecorrida("vertical creciente")));
        
        posiciones.addAll(listarPosSegunDireccion("vertical decreciente", 
                          incrementoEnRecorrida("vertical decreciente")));
        
        posiciones.addAll(listarPosSegunDireccion("izquierda derecha creciente", 
                          incrementoEnRecorrida("izquierda derecha creciente")));

        posiciones.addAll(listarPosSegunDireccion("izquierda derecha decreciente", 
                          incrementoEnRecorrida("izquierda derecha decreciente")));
        
        posiciones.addAll(listarPosSegunDireccion("derecha izquierda creciente", 
                          incrementoEnRecorrida("derecha izquierda creciente")));
        
        posiciones.addAll(listarPosSegunDireccion("derecha izquierda decreciente", 
                          incrementoEnRecorrida("derecha izquierda decreciente")));
        
        return posiciones;
    }

    /** Lista todas las posiciones con captura posibles, segun una direccion especifica.
     * @param direccion Representa la direccion en la cual se buscaran las posiciones.
     * @param  incrementoRecorrida Es un arreglo de enteros. El primer elemento
     * representa el factor de cambio o incremento de la fila al recorrer, mientras
     * que el segundo, el de la columna.
     * @return Devuelve la lista con dichas posiciones.*/
    private ArrayList<Posicion> listarPosSegunDireccion(String direccion, 
                                             int[] incrementoRecorrida) {
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
  
        int fila = super.Inicio.getFila() + incrementoRecorrida[0];
        int col = super.Inicio.getCol() + incrementoRecorrida[1];
        
        boolean frenar = false;
        
        while (continuaRecorrida(direccion, fila, col) && !frenar) {
            if (!super.Tablero.esLugarVacio(fila, col)) {
                frenar = true;
                Posicion actual = new Posicion(fila, col);
                if (Posicion.puedeComer(super.Inicio, actual, super.Tablero)) {
                    posiciones.add(actual);
                }
            }
            fila = fila + incrementoRecorrida[0];
            col = col + incrementoRecorrida[1];
        }
        
        return posiciones;
    }
    
    /**Es un metodo auxiliar de listarPosSegunDireccion.
     * Controla que las variables de recorrida del while no se vayan del rango
     * del tablero, y esto depende de en qué dirección se está recorriendo este.
     * @param direccion Representa la direccion en la cual se buscaran las posiciones.
     * @param fila Fila sobre la cual se comenzara a recorrer.
     * @param col Columna sobre la cual se comenzara a recorrer.
     * @return Devuelve true en caso de que sea posible seguir recorriendo el tablero
     * en dicha direccion, y false en caso contrario.*/
    private boolean continuaRecorrida(String direccion, int fila, int col) {
        boolean resultado = false;
        
        switch (direccion) {
            case "vertical creciente" -> resultado = col < super.Tablero.getTamanio();
            case "vertical decreciente" -> resultado = col > 0;
            case "horizontal creciente" -> resultado = fila < super.Tablero.getTamanio();
            case "horizontal decreciente" -> resultado = fila > 0;
            case "izquierda derecha creciente" -> resultado = fila >= 0 && col < super.Tablero.getTamanio();
            case "izquierda derecha decreciente" -> resultado = fila < super.Tablero.getTamanio() && col < super.Tablero.getTamanio();
            case "derecha izquierda creciente" -> resultado = fila >= 0 && col >= 0;
            case "derecha izquierda decreciente" -> resultado = fila < super.Tablero.getTamanio() && col >= 0;
        }
        
        return resultado;
    }
 
    /**Es un metodo auxiliar de listarPosSegunDireccion.
    * @param direccion Representa la direccion en la cual se buscaran las posiciones.
    * @return Devuelve un arreglo de dos enteros, de los cuales el primero representa el
    * factor que influira en la fila de la recorrida, y el segundo en la columna.*/
    private int[] incrementoEnRecorrida(String direccion) {
        int[] resultado = new int[2];
        
        if (direccion.equals("vertical creciente") || direccion.equals("vertical decreciente")) {
            resultado[0] = 0;
        }
        if (direccion.equals("horizontal creciente") || direccion.equals("horizontal decreciente")) {
            resultado[1] = 0;
        }
        if (direccion.equals("izquierda derecha creciente") || direccion.equals("derecha izquierda creciente") 
                || direccion.equals("horizontal decreciente")) {
            resultado[0] = -1;
        }
        if (direccion.equals("izquierda derecha decreciente") || direccion.equals("derecha izquierda decreciente") 
                || direccion.equals("horizontal creciente")) {
            resultado[0] = 1;
        }
        if (direccion.equals("derecha izquierda decreciente") || direccion.equals("derecha izquierda creciente") 
                || direccion.equals("vertical decreciente")) {
            resultado[1] = -1;
        }
        if (direccion.equals("izquierda derecha creciente") || direccion.equals("izquierda derecha decreciente") 
                || direccion.equals("vertical creciente")) {
            resultado[1] = 1;
        }
        
        return resultado;
    }
}
