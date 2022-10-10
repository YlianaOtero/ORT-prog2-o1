/* Representa una partida puntual del juego Distancia. */
package interfaz;

import dominio.Jugador;
import dominio.ListaPosConCaptura;
import dominio.ListaPosSinCaptura;
import dominio.Posicion;
import dominio.Tablero;

/**
 *
 * @author ylian
 */
public class Partida {
    private final Jugador jugador1; //Rojo
    private final Jugador jugador2; //Azul
    private Tablero tablero;
    private Jugador ganador;

    /*CONSTRUCTORES*/
    public Partida(String configTablero, Jugador[] jugadores) {
        this.jugador1 = jugadores[0];
        this.jugador2 = jugadores[1];
        this.tablero = new Tablero(configTablero);
    }
    
    /*METODOS DE ACCESO*/
    public Jugador getGanador() {
        return this.ganador;
    }

    public Tablero getTablero() {
        return this.tablero;
    }
    
    /*METODOS DE MODIFICACION*/
    private void setGanador() {
        if (tablero.getCantFichasAzules() <= 0) {
            this.ganador = jugador1;
        } else {
            this.ganador = jugador2;
        }
    }
    
    /*BASICOS DEL JUEGO*/
    public void iniciarPartida() {
        int valor = jugada(jugador1);
        Jugador ultimo = jugador1;
        
        while (this.tablero.getCantFichasAzules() > 0 && this.tablero.getCantFichasRojas() > 0 
                && valor != -1)  {
            if (ultimo == jugador1) {
                valor = jugada(jugador2);
                ultimo = jugador2;
            } else {
                valor = jugada(jugador1);
                ultimo = jugador1;
            }
        }
        
        if (valor != -1) {
            setGanador();
        } 
        
        finPartida();
    }
    
    private void finPartida() {
        System.out.println("Fin de la partida! \n"
                + "El ganador es " +this.ganador.getAlias());
    }
    
    private int jugada(Jugador unJugador) {
        int valor = 0;

        if (hayJugadasPosiblesGral()) {
            imprimirHeaderJugada(unJugador);
            if (!hayJugadasPosibles(unJugador)) {
            System.out.println("No hay jugadas posibles para este jugador. \n"
                    + "Se pasa el turno.");
            } else {
                Posicion posInicial = movimientoInicial(unJugador);
                valor = movimientoFinal(unJugador, posInicial);
            }
        }

        return valor;
    }
    
    private void imprimirHeaderJugada(Jugador unJugador) {
        String colorFicha = "rojas";
        
        if (!esJugador1(unJugador)) {
            colorFicha = "azules";
        }
        
        System.out.println("Juega " +unJugador.getAlias() +" con las fichas " 
                +colorFicha + "\n");
        DisplayTablero.mostrarTableroActual(this);
    }
    
    private void rendicion(Jugador unJugador) {
        System.out.println(unJugador.getAlias() +" se ha rendido!");
        if (esJugador1(unJugador)) {
            this.ganador = jugador2;
        } else {
            this.ganador = jugador1;
        }
    }
    
    /*MOVIMIENTOS*/
    private Posicion movimientoInicial(Jugador unJugador) {
        Posicion pos = Lectura.leerPosicionInicial();
        while (!esJugadaInicialCorrecta(pos, unJugador)) {
            System.out.println("Por favor, ingrese una posicion que tenga una de sus fichas: ");
            pos = Lectura.leerPosicionInicial();
        }
        
        return pos;
    }
    
    //Si retorna 0, se movio sin captura. Si retorna 1, se movio con captura. Si retorna -1, se rindio.
    private int movimientoFinal(Jugador unJugador, Posicion posInicial) {
        int retorno = 0;
        
        ListaPosConCaptura movsConCaptura = new ListaPosConCaptura(posInicial, this.tablero);
        ListaPosSinCaptura movsSinCaptura = new ListaPosSinCaptura(posInicial, this.tablero);
        
        DisplayTablero.mostrarTableroPosibilidades(movsConCaptura, movsSinCaptura, posInicial, this);

        String posFinalString = Lectura.leerPosicionFinal();
        if (posFinalString.equals("X")) {
            rendicion(unJugador);
            retorno = -1;
        } else {
            MapeoPosicion mapFinal = new MapeoPosicion(posFinalString);
            if (!esJugadaFinalCorrecta(movsConCaptura, movsSinCaptura, mapFinal.getPosicion())) {
                System.out.println("Ha elegido una posicion incorrecta. \n"
                        + "Se ha reseteado la jugada");
                jugada(unJugador);
            } else if (retorno != -1) {
                retorno = moverse(movsConCaptura, movsSinCaptura, posInicial, mapFinal.getPosicion());
            }
        }
        
        return retorno;
    }
    
    private int moverse(ListaPosConCaptura movsConCaptura, ListaPosSinCaptura movsSinCaptura,
                        Posicion inicio, Posicion fin) {
        int retorno = 0;
        
        if (movsConCaptura.estaEnLaLista(fin)) {
            tablero.comerFicha(inicio.getFila(), inicio.getCol(), fin.getFila(), fin.getCol());
            retorno = 1;
        } else if (movsSinCaptura.estaEnLaLista(fin)) {
            tablero.desplazarFicha(inicio.getFila(), inicio.getCol(), fin.getFila(), fin.getCol());
        }
        
        return retorno;
    }
    
    /*PREDICADOS*/
    private boolean hayJugadasPosibles(Jugador unJugador) {
        boolean hay = false;
        char ficha = 'R';
        if (!esJugador1(unJugador)) {
            ficha = 'A';
        }  
        
        for (int i = 0; i < tablero.getTamanio() && !hay; i++) {
            for (int j = 0; j < tablero.getTamanio() && !hay; j++) {
                if (tablero.getFicha(i, j) == ficha) {
                    Posicion pos = new Posicion(i, j);
                    ListaPosConCaptura movsConCaptura = new ListaPosConCaptura(pos, tablero);
                    ListaPosSinCaptura movsSinCaptura = new ListaPosSinCaptura(pos, tablero);
                    if (movsConCaptura.hayMovimientos() || movsSinCaptura.hayMovimientos()) {
                        hay = true;
                    }
                }
            }
        }
     
        return hay;
    }
    
    private boolean hayJugadasPosiblesGral() {
        return hayJugadasPosibles(jugador1) || hayJugadasPosibles(jugador2);
    }
  
    private boolean esJugadaFinalCorrecta(ListaPosConCaptura movsConCaptura, 
                                    ListaPosSinCaptura movsSinCaptura,
                                    Posicion elegida) {
        return movsConCaptura.estaEnLaLista(elegida) || movsSinCaptura.estaEnLaLista(elegida);
    }
    
    private boolean esJugadaInicialCorrecta(Posicion elegida, Jugador unJugador) {
        boolean respuesta = true;
        if (esJugador1(unJugador)) {
            respuesta = tablero.getTablero()[elegida.getFila()][elegida.getCol()] == 'R';
        } else {
            respuesta = tablero.getTablero()[elegida.getFila()][elegida.getCol()] == 'A';
        }
        return respuesta;
    }
    
    private boolean esJugador1(Jugador unJugador) {
        return unJugador.getAlias().equals(jugador1.getAlias());
    }
}
