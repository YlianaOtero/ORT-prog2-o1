/* Lectura contiene todos los metodos necesarios para leer valores por pantalla.
 * Permite manejar todos los System.in y las excepciones desde un mismo lugar. */
package interfaz;

import dominio.ListaJugadores;
import dominio.Posicion;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ylian
 */
public abstract class Lectura {
    private static final String TxtErrorPosicion = "La posicion debe tener formato LETRANUMERO, "
                + "siendo LETRA una letra entre la A y la F, y NUMERO un entero "
                + "entre el 1 y el 6.\n"
                + "Por favor ingrese una poisicion correcta: ";
    private static final String TxtErrorNoNatural = "Debe ingresar un numero natural. \n"
                        + "Por favor ingrese un valor correcto: ";
    
    public static char leerOpcionMenu(char min, char max) {
        Scanner in = new Scanner(System.in);

        String txtErrorRango = "Debe ingresar una letra entre " + min + " y " + max + ". \n"
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
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(txtErrorRango);
                in.nextLine();
            }
        }
        return opcion;
    }

    public static String leerNombreJugador() {
        Scanner in = new Scanner(System.in);

        String txtErrorCaracteres = "El nombre puede incluir unicamente letras de la A a la Z. \n"
                + "Por favor ingrese un nombre correcto: ";

        String opcion = "";
        boolean opcionInvalida = true;

        while (opcionInvalida) {
            try {
                opcion = in.nextLine();
                if (!Pattern.matches("[a-zA-Z]+", opcion)) {
                    System.out.println(txtErrorCaracteres);
                } else {
                    opcionInvalida = false;
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println("Por favor, ingrese un nombre valido: \n");
                in.nextLine();
            }
        }
        return opcion;
    }

    public static String leerAliasJugador(ListaJugadores jugadores) {
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
                if (!Pattern.matches("[a-z]+", opcion)) {
                    System.out.println(txtErrorCaracteres);
                } else if (jugadores.existeAlias(opcion)) {
                    System.out.println(txtErrorAliasExistente);
                } else {
                    opcionInvalida = false;
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(txtErrorCaracteres);
                in.nextLine();
            }
        }
        return opcion;
    }

    public static int leerEdadJugador() {
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
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(TxtErrorNoNatural);
                in.nextLine();
            }
        }
        return opcion;
    }

    public static int leerOpcionJugadores(int max) {
        Scanner in = new Scanner(System.in);

        String txtErrorRango = "Debe ingresar un natural entre 1 y " + max + ". \n"
                + "Por favor ingrese un valor correcto: ";

        int opcion = 0;
        boolean opcionInvalida = true;

        while (opcionInvalida) {
            try {
                opcion = in.nextInt();

                if (opcion <= max && opcion >= 1) {
                    opcionInvalida = false;
                } else {
                    System.out.println(txtErrorRango);
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(TxtErrorNoNatural);
                in.nextLine();
            }
        }
        return opcion;
    }
    public static String leerPosicionFinal() {
        Scanner in = new Scanner(System.in);

        String txtError = TxtErrorPosicion + "En caso de querer rendirse, "
                + "puede ingresar la letra X. \n";
        
        String opcion = "";
        boolean opcionInvalida = true;
        while (opcionInvalida) {
            try {
                opcion = in.nextLine().toUpperCase();
                String letra = String.valueOf(opcion.charAt(0));
                String num = "";
                if (letra.length() > 1) {
                    num = String.valueOf(opcion.charAt(1));
                }
                if ("ABCDEFX".contains(letra) && "123456".contains(num)) {
                    opcionInvalida = false;
                } else {
                    System.out.println(txtError);
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(txtError);
                in.nextLine();
            }
        }
   
        return opcion;
    }
    
    public static Posicion leerPosicionInicial() {
        Scanner in = new Scanner(System.in);
        
        String opcion = "";
        boolean opcionInvalida = true;
        while (opcionInvalida) {
            try {
                opcion = in.nextLine().toUpperCase();
                String letra = String.valueOf(opcion.charAt(0));
                String num = String.valueOf(opcion.charAt(1));
                if (!(Pattern.matches("[a-fA-F]+", letra) && Pattern.matches("[1-6]+", num))) {
                    System.out.println(TxtErrorPosicion);
                } else {
                    opcionInvalida = false;
                }
            } catch (InputMismatchException | StringIndexOutOfBoundsException e) {
                System.out.println(TxtErrorPosicion);
                in.nextLine();
            }
        }
        
        MapeoPosicion map = new MapeoPosicion(opcion);
        Posicion pos = new Posicion(map.getFila(), map.getCol());
        
        return pos;
    }
}
