/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dominio.Jugador;
import dominio.ListaJugadores;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ylian
 */
public class Sistema {
    private static ListaJugadores Jugadores = new ListaJugadores();
    private static String configTablero = "Standard";
    
    public void menuInicial() {
       System.out.println("********************************\n"
        + "a. Registrar jugador\n"
        + "b. Establecer tablero\n"
        + "c. Jugar partida\n"
        + "d. Ver ranking\n"
        + "e. Salir\n"
        + "Escribe una de las opciones.\n"
        + "********************************\n");
   }
    
    
    public String[] pedirJugador() {
        String[] datos = new String[3];
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("ingrese nombre del jugador");
        datos[0] = in.nextLine();
        
        System.out.println("ingrese edad del jugador");
        datos[1] = in.nextLine();
        
        System.out.println("ingrese alias del jugador");
        datos[2] = in.nextLine();
        
        return datos;
    }
    
    private void registrarJugador(String nombre, String edad, String alias) {
        int edadNumerica = Character.getNumericValue(edad.charAt(0));
        Jugador jugador = new Jugador(nombre, edadNumerica, alias);
        Jugadores.agregarJugador(jugador);
    }
    
    public String pedirTipoTablero() {
        Scanner in = new Scanner(System.in);
        
        String tipo = "";
        
        System.out.println("Ingrese el tablero a usar: \n"
                            + "1. Standard\n" 
                            + "2. Precargado 1\n"
                            + "3. Precargado 2\n"
                            + "Elija una de las opciones.\n"
                            + "********************************\n");
        
        int opcion = leerOpcionMenu(1, 3);
        
        tipo = switch (opcion) {
            case 2 -> "Precargado 1";
            case 3 -> "Precargado 2";
            default -> "Standard";
        };
        
        return tipo;
    }
    
    public int leerOpcionMenu(int min, int max) {
        Scanner in = new Scanner(System.in);
        
        String txtErrorRango = "Debe ingresar un numero entre el " +min +" y el " +max +". Por favor ingrese un valor correcto: ";
        
        int opcion = 0;
        boolean x = true;
        while (x) {
            try {
                opcion = in.nextInt();
                if (opcion <= max && opcion >= min) {
                    x = false;
                } else {
                    System.out.println(txtErrorRango);
                }
            } catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero natural. Por favor ingrese un valor correcto: ");
                in.nextLine();
            }
        }
        
        return opcion;
    }
       
    
    private void setConfigTablero(String tipo) {
        configTablero = tipo;
    }
        
   public void mostrarOpcion(char opcion) {
       switch(opcion){
            case 1:
                System.out.println("Has seleccionado Registrar jugador ");
                String datos[] = pedirJugador();
                registrarJugador(datos[0], datos[1], datos[2]);
                break;
            case 2:
                System.out.println("Has seleccionado Establecer tablero");
                String tipo = pedirTipoTablero();
                setConfigTablero(tipo);
                break;
             case 3:
                System.out.println("Has seleccionado Jugar partida");
                break;
             case 4:
                System.out.println("Has seleccionado Ranking");
                break;
             case 5:
                System.out.println("Gracias por usar el programa.");
                break;
        }

    }
    
    
}
