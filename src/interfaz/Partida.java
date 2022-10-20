package interfaz;

import dominio.*;

/**
 /** Representa una partida puntual del juego Distancia.
 * @author yliana*/

public class Partida {
    private final Jugador jugador1; //Rojo
    private final Jugador jugador2; //Azul
    private Tablero tablero;
    private Jugador ganador;

    /*CONSTRUCTORES*/
    public Partida(String configTablero, Jugador[] jugadores) {
        this.jugador1 = jugadores[0];
        this.jugador2 = jugadores[1];
        this.jugador1.aumentarPartidas();
        this.jugador2.aumentarPartidas();
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
    
    /** Comienza una partida y se encarga de llamar al metodo jugada segun el turno
     * que corresponda. Una vez alguien se queda sin fichas o se rinde, finaliza
     * la partida y se settea el ganador.*/
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
        this.ganador.aumentarVictorias();
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
    
    /** Es responsable del movimiento final de un turno. Este puede ser desplazarse
     * con o sin captura, rendirse, o resetear la posicion (volver a elegir una 
     * posicion inicial).
     * @param unJugador Puede ser jugador1 o jugador2.
     * @param posInicial La posicion elegida inicialmente (marcada con 'E' en el tablero).
     * @return Devuelve un entero. Si es -1, es porque el jugador se ha rendido. 
     * Si retorna 0, se movio sin captura. Si retorna 1, se movio con captura. */
    private int movimientoFinal(Jugador unJugador, Posicion posInicial) {
        int retorno = 0;
        
        ListaPosPosibles.setInicio(posInicial);
        ListaPosPosibles.setTablero(this.tablero);
        
        ListaPosConCaptura movsConCaptura = new ListaPosConCaptura();
        ListaPosSinCaptura movsSinCaptura = new ListaPosSinCaptura();
        
        DisplayTablero.mostrarTableroPosibilidades(movsConCaptura, movsSinCaptura, posInicial, this);

        String posFinalString = Lectura.leerPosicionFinal();
        if (posFinalString.equals("X")) {
            rendicion(unJugador);
            retorno = -1;
        } else {
            MapeoPosicion mapFinal = new MapeoPosicion(posFinalString);
            if (!esJugadaFinalCorrecta(movsConCaptura, movsSinCaptura, mapFinal.posTableroCorrespondiente())) {
                System.out.println("Ha elegido una posicion incorrecta. \n"
                        + "Se ha reseteado la jugada");
                jugada(unJugador);
            } else if (retorno != -1) {
                retorno = moverse(movsConCaptura, movsSinCaptura, posInicial, mapFinal.posTableroCorrespondiente());
            }
        }
        
        return retorno;
    }
    
    /** Ejecuta el movimiento.
     * @param movsConCaptura Lista de movimientos posibles con captura, para inicio.
     * @param movsSinCaptura Lista de movimientos posibles sin captura, para inicio.
     * @param inicio La posicion elegida inicialmente (marcada con 'E' en el tablero).
     * @param fin La posicion a la cual se debe mover la ficha en inicio.
     * @return Devuelve un entero. Si retorna 0, se movio sin captura. Si retorna 1, 
     * se movio con captura. */
    private int moverse(ListaPosConCaptura movsConCaptura, ListaPosSinCaptura movsSinCaptura,
                        Posicion inicio, Posicion fin) {
        int retorno = 0;
        
        if (ListaPosPosibles.estaEnLaLista(fin, movsConCaptura.getLista())) {
            tablero.comerFicha(inicio.getFila(), inicio.getCol(), fin.getFila(), fin.getCol());
            retorno = 1;
        } else if (ListaPosPosibles.estaEnLaLista(fin, movsSinCaptura.getLista())) {
            tablero.desplazarFicha(inicio.getFila(), inicio.getCol(), fin.getFila(), fin.getCol());
        } 
        
        return retorno;
    }
    
    /*PREDICADOS: ayudan a controlar que las jugadas puedan darse de manera correcta.*/
    private boolean hayJugadasPosibles(Jugador unJugador) {
        boolean hay = false;
        char ficha = 'R';
        if (!esJugador1(unJugador)) {
            ficha = 'A';
        }  
        
        ListaPosPosibles.setTablero(tablero);
        
        for (int i = 0; i < tablero.getTamanio() && !hay; i++) {
            for (int j = 0; j < tablero.getTamanio() && !hay; j++) {
                if (tablero.getFicha(i, j) == ficha) {
                    Posicion pos = new Posicion(i, j);
                    ListaPosPosibles.setInicio(pos);
                    
                    ListaPosConCaptura movsConCaptura = new ListaPosConCaptura();
                    ListaPosSinCaptura movsSinCaptura = new ListaPosSinCaptura();
                    if (ListaPosPosibles.hayPosiciones(movsConCaptura.getLista()) ||  
                            ListaPosPosibles.hayPosiciones(movsSinCaptura.getLista())) {
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
        return ListaPosPosibles.estaEnLaLista(elegida, movsConCaptura.getLista()) 
                || ListaPosPosibles.estaEnLaLista(elegida, movsSinCaptura.getLista());
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
