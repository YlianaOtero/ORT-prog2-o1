package interfaz;

import dominio.Jugador;
import dominio.ListaJugadores;
import dominio.Ranking;

/**Sistema guarda la configuracion de sistema del juego. Contiene el menu y las 
 * acciones que se realizan desde este. 
 * Es una clase abstracta porque no nos interesa crear objetos de tipo Sistema, y
 * sus metodos son static porque nos permite llamarlos desde otras clases sin necesidad
 * de instanciar Sistema en ellas.
 * @author yliana*/

public abstract class Sistema {

    private static ListaJugadores Jugadores = new ListaJugadores();
    private static String ConfigTablero = "Standard";
    
    /** Muestra por pantalla el menu principal del juego.*/
    public static void menuInicial() {
        System.out.println("************************************************\n"
                + "         BIENVENIDO AL JUEGO DISTANCIA          \n"
                + "************************************************\n"
                + "a. Registrar jugador\n"
                + "b. Establecer tablero\n"
                + "c. Jugar partida\n"
                + "d. Ver ranking\n"
                + "e. Salir del menu\n"
                + "Escribe una de las opciones:\n"
                + "************************************************\n");

        char opcion = Lectura.leerOpcionMenu('a', 'e');
        opciones(opcion);
    }

    /** Llama a los metodos que realizan las acciones correspondientes a cada 
     * opcion del menu inicial.
     * @param opcion Opcion elegida del menu inicial.*/
    public static void opciones(char opcion) {
        opcion = Character.toLowerCase(opcion);
        switch (opcion) {
            case 'a' -> {
                System.out.println("Has seleccionado Registrar jugador ");
                String datos[] = pedirJugador();
                registrarJugador(datos[0], datos[1], datos[2]);
                volverAlMenu();
            }
            case 'b' -> {
                System.out.println("Has seleccionado Establecer tablero");
                String tipo = pedirTipoTablero();
                establecerTablero(tipo);
                volverAlMenu();
            }
            case 'c' -> {
                System.out.println("Has seleccionado Jugar partida");
                jugarPartida();
                volverAlMenu();
            }
            case 'd' -> {
                System.out.println("Has seleccionado Ranking");
                verRanking();
                volverAlMenu();
            }
            case 'e' ->
                System.out.println("************************************************\n"
                        + "          Gracias por usar nuestro juego.       \n"
                        + "************************************************\n");
        }
    }

    public static void volverAlMenu() {
        System.out.println("************************************************\n"
                + "Desea volver al menu principal? \n"
                + "a. Si. \n"
                + "b. No. \n"
                + "************************************************\n");

        char opcion = Lectura.leerOpcionMenu('a', 'b');

        switch (opcion) {
            case 'a' ->
                menuInicial();
            case 'b' ->
                opciones('e');
        }
    }

    /*METODOS DE OPCION*/
    private static void establecerTablero(String tipo) {
        ConfigTablero = tipo;
        System.out.println("Se ha seleccionado " + tipo + " como tipo de tablero.");
    }

    private static void registrarJugador(String nombre, String edad, String alias) {
        int edadNumerica = Integer.valueOf(edad);
        Jugador jugador = new Jugador(nombre, edadNumerica, alias);
        Jugadores.agregarJugador(jugador);
        System.out.println("El jugador " + alias + " ha sido registrado correctamente.");
    }

    private static void jugarPartida() {
        if (Jugadores.largo() > 1) {
            Jugador[] jugadores = pedirJugadoresPartida();
            Partida nueva = new Partida(ConfigTablero, jugadores);
            nueva.iniciarPartida();
            ConfigTablero = "Standard";
        } else {
            System.out.println("Debe tener al menos dos jugadores registrados para poder jugar.");
            volverAlMenu();
        }
    }

    private static void verRanking() {
        Ranking ranking = new Ranking(Jugadores);
        System.out.println(ranking);
    }

    /*PETICIONES AL USUARIO*/
    private static String pedirTipoTablero() {
        System.out.println("************************************************\n"
                + "Ingrese el tablero a usar: \n"
                + "a. Standard\n"
                + "b. Precargado 1\n"
                + "c. Precargado 2\n"
                + "Elija una de las opciones.\n"
                + "********************************\n");

        char opcion = Lectura.leerOpcionMenu('a', 'c');

        String tipo = switch (opcion) {
            case 'b' ->
                "Precargado 1";
            case 'c' ->
                "Precargado 2";
            default ->
                "Standard";
        };

        return tipo;
    }

    private static String[] pedirJugador() {
        String[] datos = new String[3];

        System.out.println("Ingrese nombre del jugador:");
        datos[0] = Lectura.leerNombreJugador();

        System.out.println("Ingrese edad del jugador:");
        datos[1] = String.valueOf(Lectura.leerEdadJugador());

        System.out.println("Ingrese alias del jugador:");
        datos[2] = Lectura.leerAliasJugador(Jugadores);

        return datos;
    }

    private static Jugador[] pedirJugadoresPartida() {
        Jugador[] jugadores = new Jugador[2];

        mostrarListaJugadores();

        System.out.println("Elija al jugador 1:");
        jugadores[0] = Jugadores.jugadorEnPos(Lectura.leerOpcionJugadores(Jugadores.largo()) - 1);

        boolean repetido = true;
        System.out.println("Elija al jugador 2:");
        while (repetido) {
            jugadores[1] = Jugadores.jugadorEnPos(Lectura.leerOpcionJugadores(Jugadores.largo()) - 1);
            if (jugadores[1].getAlias().equals(jugadores[0].getAlias())) {
                System.out.println("Debe elegir dos jugadores diferentes. Ingrese otra opcion:");
            } else {
                repetido = false;
            }
        }
        return jugadores;
    }

    private static void mostrarListaJugadores() {
        System.out.println(Jugadores);
    }
}
