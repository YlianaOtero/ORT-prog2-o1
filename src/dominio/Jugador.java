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
    private int partidas;
    private int victorias;
    
    /*CONSTRUCTORES*/
    public Jugador(String unNombre, int unaEdad, String unAlias){
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAlias(unAlias);
        this.partidas = 0;
        this.victorias = 0;
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
    
    public int getPartidas(){
        return this.partidas;
    }
    
    public int getVictorias(){
        return this.victorias;
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
    
    public void setPartidas(int unaPartida){
        this.partidas= unaPartida;
    }
    
    public void setVictorias(int unaVictoria){
        this.victorias=unaVictoria;
    }
    
    @Override
    public String toString(){
        return this.getNombre() + "         " + this.getAlias() + "          " + this.getEdad();
    }

    /* TO DO: ARREGLAR ESTO
     @Override
     public int compareTo(Jugador j){
        return j.getVictorias().compareTo(this.getVictorias)
     }*/
}
