/* Perfil del jugador.*/
package dominio;


/**
 *
 * @author nalu-
 */
public class Jugador {

    private String nombre;
    private int edad;
    private String alias;
    
    /*CONSTRUCTORES*/
    public Jugador(String unNombre, int unaEdad, String unAlias){
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAlias(unAlias);
    }

    /*METODOS DE ACCESO*/
    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public String getAlias(){
        return this.alias;
    }
    
    /*METODOS DE MODIFICACION*/
    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }
    
    public void setEdad(int unaEdad){
        this.edad = unaEdad;
    }

    public void setAlias(String unAlias){
        this.alias = unAlias;
    }

    /*OVERRIDES*/
    @Override
    public String toString(){
        return this.getNombre() + "         " + this.getAlias() + "          " + this.getEdad();
    }
}
