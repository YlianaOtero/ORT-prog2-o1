package interfaz;

/**Color permite utilizar los codigos de colores ANSI que require el juego. Si se hace un
 * System.out.print(CODIGO_ANSI + "Texto a imprimir"); obtendremos "Texto a imprimir"
 * pintado del color correspondiente a ese codigo.
 * @author yliana*/

public class Color {

    private String codigo;
    private String nombre;

    private static String Reset = "\u001B[0m";
    private static String Negro = "\u001B[30m";
    private static String Rojo = "\u001B[31m";
    private static String Azul = "\u001B[34m";
    private static String Verde = "\u001b[32;1m";

    /** Constructor por defecto.*/
    public Color() {
        this.codigo = Reset;
        this.nombre = "";
    }
    
    /** Constructor.
     * @param caracter Si caracter es 'A', settea el color a azul. 
     * Si es 'R', settea el color a rojo. En cualquier otro caso, lo settea a verde.*/
    public Color(char caracter) {
        switch (caracter) {
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

    /** @return Devuelve el codigo ANSI del color correspondiente.*/
    public String getCodigo() {
        return this.codigo;
    }

    /** @return Devuelve el nombre del color correspondiente.*/
    public String getNombre() {
        return this.nombre;
    }

    /** Modifica los atributos nombre y codigo de un objeto de tipo Color.
     * @param unColor Recibe el nombre de un color. Si recibe rojo, azul o verde,
     * settea el color correspondiente. En cualquier otro caso, settea el color negro.*/
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

    /**"Pinta" una letra (o simbolo), apoyandose en el codigo ANSI del color.
     * @param letra Es el caracter a "pintar".
     * @return Devuelve un String del formato CODIGOletra. Si imprimimos esto por
     * pantalla, deberia mostrarse la variable letra en el color correspondiente.*/
    public String letraPintada(char letra) {
        String codigo = this.getCodigo();
        return codigo + letra;
    }
}
