/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author nalu-
 */
public class Jugador {

    private String nombre;
    private int edad;
    private String alias;
    
    
 public Jugador(String unNombre, int unaEdad, String unAlias){
        this.setNombre(unNombre);
        this.setEdad(unaEdad);
        this.setAlias(unAlias);
}


    //Metodos de acceso
    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public String getAlias(){
        return this.alias;
    }
    
    //Metodos de modificacion
    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }
    
    public void setEdad(int unaEdad){
        this.edad = unaEdad;
    }

    public void setAlias(String unAlias){
        this.alias = unAlias;
    }
    
    
    public boolean tienenMismoAlias(Jugador unJ, ArrayList<Jugador>lista){
       
        for (int i=0; i < listaJugadores.size(); i++) {
            return (this.getAlias().equals(listaJugadores.get(i).getAlias()));
           
        }
    } 
    
    

 @Override
    public String toString(){
        return this.getNombre() + "-" + this.getEdad() + this.getAlias();
    }
    
}
