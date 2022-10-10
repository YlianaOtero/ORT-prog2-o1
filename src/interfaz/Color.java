/* Color permite utilizar los codigos de colores ANSI que require el juego. Si se hace un
 * System.out.print(CODIGO_ANSI + "Texto a imprimir"); obtendremos "Texto a imprimir"
 * pintado del color correspondiente a ese codigo. */
package interfaz;

/**
 *
 * @author ylian
 */
public class Color {

    private String codigo;
    private String nombre;

    private static String Reset = "\u001B[0m";
    private static String Negro = "\u001B[30m";
    private static String Rojo = "\u001B[31m";
    private static String Azul = "\u001B[34m";
    private static String Verde = "\u001b[32;1m";

    /*CONSTRUCTORES*/
    public Color() {
        this.codigo = Reset;
        this.nombre = "";
    }
    
    public Color (char letra) {
        switch (letra) {
            case 'A' -> {
               this.codigo = Azul;
                this.nombre = "azul"; 
            }
            case 'R' -> {
                this.codigo = Rojo;
                this.nombre = "rojo";
            }
            default -> {
                this.codigo = Verde;
                this.nombre = "verde";
            }
        }
    }

    /*METODOS DE ACCESO*/
    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    /*METODOS DE MODIFICACION*/
    public void setColor(String unColor) {
        if (unColor.equalsIgnoreCase("rojo")) {
            this.codigo = Rojo;
            this.nombre = "rojo";
        } else if (unColor.equalsIgnoreCase("azul")) {
            this.codigo = Azul;
            this.nombre = "azul";
        } else if (unColor.equalsIgnoreCase("verde")) {
            this.codigo = Verde;
            this.nombre = "verde";
        } else {
            this.codigo = Negro;
            this.nombre = "negro";
        }
    }

    public String letraPintada(char letra) {
        String codigo = this.getCodigo();
        return codigo + letra;
    }
}
