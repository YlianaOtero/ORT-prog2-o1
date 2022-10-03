/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

public class Menu {
   private int opcion; //Guardaremos la opcion del usuario

   public Menu() {
       this.opcion = 0;
   }
   
   public void setOpcion(int unaOpcion) {
       this.opcion = unaOpcion;
   }
   
   public void mostrarMenu() {
       System.out.println("********************************\n"
        + "1. Registrar jugador\n"
        + "2. Establecer tablero\n"
        + "3. Jugar partida\n"
        + "4. Ver ranking\n"
        + "5. Salir\n"
        + "Escribe una de las opciones.\n"
        + "********************************\n");
   }
   
   public void mostrarOpcion() {
       switch(this.opcion){
            case 1:
                System.out.println("Has seleccionado Registrar jugador ");
                break;
            case 2:
                System.out.println("Has seleccionado Establecer tablero");
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
             default:
                System.out.println("Solo puede ingresar numeros entre 1 y 5");
        }

    }
}
   
   
   
        


        
