/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.ListaJugadores;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ylian
 */
public class Sistema {
    private static ListaJugadores Jugadores = new ListaJugadores();
    private static String ConfigTablero = "Standard";
    
    public static void main(String[] args) {
        menuInicial();
    }
    
    //METODOS DE MENU
    public static void menuInicial() {
       System.out.println("********************************\n"
            + " BIENVENIDO AL JUEGO DISTANCIA\n"
            + "********************************\n"
            + "a. Registrar jugador\n"
            + "b. Establecer tablero\n"
            + "c. Jugar partida\n"
            + "d. Ver ranking\n"
            + "e. Salir del menu\n"
            + "Escribe una de las opciones:\n"
            + "********************************\n");
       
        char opcion = leerOpcionMenu('a', 'e');
        opciones(opcion);      
   }
    
   public static void opciones(char opcion) {
       opcion = Character.toLowerCase(opcion);
       switch(opcion){
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
            }
             case 'd' -> {
                System.out.println("Has seleccionado Ranking");
                verRanking();
                volverAlMenu();
            }
             case 'e' -> System.out.println("Gracias por usar el programa.");
        }
    }
   
   public static void volverAlMenu() {
       System.out.println("********************************\n"
               + "Desea volver al menu principal? \n"
               + "a. Si. \n"
               + "b. No. \n"
               + "********************************\n");
       
       Scanner in = new Scanner(System.in);
       
       char opcion = leerOpcionMenu('a', 'b');
       
       switch (opcion) {
           case 'a' -> menuInicial();
           case 'b' -> System.out.println("********************************\n"
                       + " Gracias por usar el programa. \n "
                       + "********************************\n");
       }  
   }
   
   //METODOS DE OPCION
    private static void establecerTablero(String tipo) {
        ConfigTablero = tipo;
        System.out.println("Se ha seleccionado " +tipo +" como tipo de tablero.");
    }
   
    private static void registrarJugador(String nombre, String edad, String alias) {
        int edadNumerica = Integer.valueOf(edad);
        Jugador jugador = new Jugador(nombre, edadNumerica, alias);
        Jugadores.agregarJugador(jugador);
        System.out.println("El jugador " +alias + " ha sido registrado correctamente.");
    }
    
    private static void jugarPartida() {
       Jugador[] jugadores = pedirJugadoresPartida();
       Partida nueva = new Partida(ConfigTablero, jugadores);
       nueva.iniciarPartida();
    }
   
    private static void verRanking() {
       //MOSTRAR RANKING
    }
    
    //PETICIONES AL USUARIO
    private static String pedirTipoTablero() {
        Scanner in = new Scanner(System.in);
        
        String tipo = "";
        
        System.out.println("Ingrese el tablero a usar: \n"
                            + "a. Standard\n" 
                            + "b. Precargado 1\n"
                            + "c. Precargado 2\n"
                            + "Elija una de las opciones.\n"
                            + "********************************\n");
        
        char opcion = leerOpcionMenu('a', 'c');
        
        tipo = switch (opcion) {
            case 'b' -> "Precargado 1";
            case 'c' -> "Precargado 2";
            default -> "Standard";
        };
        
        return tipo;
    }
    
    private static String[] pedirJugador() {
        String[] datos = new String[3];
        
        System.out.println("Ingrese nombre del jugador:");
        datos[0] = leerNombreJugador();
        
        System.out.println("Ingrese edad del jugador:");
        datos[1] = String.valueOf(leerEdadJugador());
        
        System.out.println("Ingrese alias del jugador:");
        datos[2] = leerAliasJugador();
        
        return datos;
    }
    
    private static Jugador[] pedirJugadoresPartida() {
        Jugador[] jugadores = new Jugador[2];
        
        mostrarListaJugadores();
        
        System.out.println("Elija al jugador 1:");
        jugadores[0] = Jugadores.jugadorAt(leerOpcionJugadores(Jugadores.size())-1);
        
        boolean repetido = true;
        System.out.println("Elija al jugador 2:");
        while (repetido) {
            jugadores[1] = Jugadores.jugadorAt(leerOpcionJugadores(Jugadores.size())-1);
            if (jugadores[1].getAlias().equals(jugadores[0].getAlias())) {
                System.out.println("Debe elegir dos jugadores diferentes. Ingrese otra opcion:");
            } else {
                repetido = false;
            }
        }
        return jugadores;
    }
    
    private static void mostrarListaJugadores() {
        System.out.println("********************************\n"
        + "       JUGADORES: \n"
        + "********************************\n"
        + "   Nombre            Alias           Edad");
        System.out.println(Jugadores);
        System.out.println("********************************");
    }
    
    //LECTURA POR PANTALLA Y MANEJO DE EXCEPCIONES
    private static char leerOpcionMenu(char min, char max) {
        Scanner in = new Scanner(System.in);
        
        String txtErrorRango = "Debe ingresar una letra entre " +min +" y " +max +". \n"
                + "Por favor ingrese un valor correcto: ";
        
        char opcion = 0;
        boolean opcionInvalida = true;
        
        while (opcionInvalida) {
            try {
                String strOpcion = in.nextLine();
                opcion = Character.toLowerCase(strOpcion.charAt(0));
                
                if (opcion <= max && opcion >= min && strOpcion.length() == 1) {
                    opcionInvalida = false;
                } else {
                    System.out.println(txtErrorRango);
                }
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar una letra. \n"
                        + "Por favor ingrese un valor correcto: ");
                in.nextLine();
            }
        }
        return opcion;
    }
    
    private static String leerNombreJugador() {
        Scanner in = new Scanner(System.in);
        
        String txtErrorCaracteres = "El nombre puede incluir unicamente letras de la A a la Z. \n"
                + "Por favor ingrese un nombre correcto: ";
        
        String opcion = "";
        boolean opcionInvalida = true;
        
        while (opcionInvalida) {
            try {
                opcion = in.nextLine();
                if (!Pattern.matches("[a-zA-Z]+", opcion))  {
                    System.out.println(txtErrorCaracteres);
                } else {
                    opcionInvalida = false;
                }
            } catch (InputMismatchException e){
                System.out.println("Por favor, ingrese un nombre valido: \n");
                in.nextLine();
            }
        }
        return opcion;
    }
    
    private static String leerAliasJugador() {
        Scanner in = new Scanner(System.in);
        
        String txtErrorCaracteres = "El alias puede incluir unicamente letras minusculas de la A a la Z. \n"
                + "Por favor ingrese un alias correcto: ";
        String txtErrorAliasExistente = "El alias ya esta en uso. \n"
                + "Por favor ingrese un alias que este disponible:";
        
        String opcion = "";
        boolean opcionInvalida = true;
        
        while (opcionInvalida) {
            try {
                opcion = in.nextLine();
                if (!Pattern.matches("[a-z]+", opcion))  {
                    System.out.println(txtErrorCaracteres);
                } else if (Jugadores.existeAlias(opcion))  {
                    System.out.println(txtErrorAliasExistente);
                } else {
                    opcionInvalida = false;
                }
            } catch (InputMismatchException e){
                System.out.println(txtErrorCaracteres);
                in.nextLine();
            }
        }
        return opcion;
    }
    
    private static int leerEdadJugador() {
        Scanner in = new Scanner(System.in);
        
        String txtErrorRango = "Debe ingresar un entero entre 1 y 100. \n"
                + "Por favor ingrese un valor correcto: ";
        
        int opcion = 0;
        boolean opcionInvalida = true;
        
        while (opcionInvalida) {
            try {
                opcion = in.nextInt();
                
                if (opcion <= 100 && opcion >= 1) {
                    opcionInvalida = false;
                } else {
                    System.out.println(txtErrorRango);
                }
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero natural. \n"
                        + "Por favor ingrese un valor correcto: ");
                in.nextLine();
            }
        }
        return opcion;
    }  
    
    private static int leerOpcionJugadores(int max) {
        Scanner in = new Scanner(System.in);
        
        String txtErrorRango = "Debe ingresar un entero entre 1 y " +max +". \n"
                + "Por favor ingrese un valor correcto: ";
        
        int opcion = 0;
        boolean opcionInvalida = true;
        
        while (opcionInvalida) {
            try {
                opcion = in.nextInt();
            
                if (opcion <= max && opcion >= 1 ) {
                    opcionInvalida = false;
                } else {
                    System.out.println(txtErrorRango);
                }
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero entero. \n"
                        + "Por favor ingrese un valor correcto: ");
                in.nextLine();
            }
        }
        return opcion;
    }
}
