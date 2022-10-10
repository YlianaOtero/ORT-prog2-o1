/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ranking;

/**
 *
 * @author nalux
 */
public class Ranking{
        private ListaJugadores listaJugadores;
        /*CONSTRUCTORES*/
        public Ranking(ListaJugadores unaListaJugadores){
            this.setListaJugadores= unaListaJugadores;
            Collection.sort(listaJugadores);
        }
        
        /*METODOS DE ACCESO*/
         public String getListaJugadores(){
        return this.listaJugadores;
        }
        
        /*METODOS DE MODIFICACION*/
        public void setListaJugadores(ListaJugadores unaListaJugadores){
        this.listaJugadores = unaListaJugadores;
        }
        
        
        
         /*OVERRIDES*/
          @Override
          public String toString(){
            String jugadores = "ALIAS          PARTIDAS JUGADAS             VICTORIAS";
            for(int i = 0; i < listaJugadores.size(); i++){
                jugadores += (i + 1) + ". " + listaJugadores.get(i).getAlias() + "          " 
                        + listaJugadores.get(i).getPartidas() + "           "
                        +   listaJugadores.get(i).getVictorias() + "\n";
            }
            return jugadores;
          }
     
        
        

    }
    

