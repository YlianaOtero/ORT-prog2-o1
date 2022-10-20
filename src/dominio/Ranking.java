package dominio;

/** Un Ranking es una lista de jugadores ordenada descendentemente segun las 
 * victorias. 
 * @author natalia*/
public class Ranking{
    private ListaJugadores listaJugadores;

    /*CONSTRUCTORES*/
    public Ranking(ListaJugadores unaListaJugadores){
        unaListaJugadores.ordenarLista();    
        this.listaJugadores = unaListaJugadores;
    }

    /*METODOS DE ACCESO*/
    public ListaJugadores getListaJugadores(){
        return this.listaJugadores;
    }

    /*METODOS DE MODIFICACION*/
    public void setListaJugadores(ListaJugadores unaListaJugadores){
        this.listaJugadores = unaListaJugadores;
    }

    /*OVERRIDES*/
    @Override
    public String toString(){
        String pad = listaJugadores.paddingAlias();
        String jugadores = "************************************************\n"
                + "                       RANKING                    \n"
                + "************************************************\n"
                + "ALIAS " +pad + pad + " PARTIDAS " +pad + pad +" VICTORIAS \n";
        for(int i = 0; i < listaJugadores.largo(); i++){
            jugadores += (i + 1) + ". " + listaJugadores.jugadorEnPos(i).getAlias() + pad 
                    + "          " + listaJugadores.jugadorEnPos(i).getPartidas() + pad
                    + "           " + listaJugadores.jugadorEnPos(i).getVictorias() + "\n";
        }

        jugadores += "************************************************\n";

        return jugadores;
    }
}
