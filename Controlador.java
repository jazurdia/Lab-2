/**
 * @author Javier Alejandro Azurdia Arrecis
 * @version 0.1
 */

import java.util.*;
public class Controlador {
    public static void main(String [] args){

        ArrayList<Programa> listaprogramas = new ArrayList<Programa>();
        int opcion = 0;
        int tipo_de_memoria = 0;
        
        // Obtener la memoria 
        if (opcion == 0){ //iniciar la memoria. 
            /**
             * Llamar método de la vista para obtener el tipo de memoria. 
             */
            int opcionmemoria = 0;
            if (opcionmemoria == 1){
                Ddr ddr = new Ddr();
                tipo_de_memoria = 1;
            }else if(opcionmemoria == 2){
                Sdr sdr = new Sdr(4); //ESE 4 HAY QUE CAMBIARLO Y LLAMAR UN MÉTODO DE LA VISTA PARA PREGUNTAR ESA MADADA
            }else{
                //ELIGE UNA OPCIÓN CORRECTA.
            }
            
        }else if(opcion == 2){//Ejecutar programas (mandarlos a la ram)
            
            //NECESITO LLAMAR UN MÉTODO DE LA VISTA DONDE SE AÑADAN ESTAS MAMADAS. 
            listaprogramas.add(new Programa("nombre", 0, 0));


        }


    }//Fin del main

    public void memoria(){
        
    }


}// Fin de clase
