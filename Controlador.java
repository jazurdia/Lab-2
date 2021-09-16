/**
 * @author Javier Alejandro Azurdia Arrecis
 * @version 0.1
 */

import java.util.*;
public class Controlador {
    public static void main(String [] args){
        
        int opcion = 0;
        int opcion_ram = 0;


        Memoria memoria = new Memoria(0, 0, 0);
        ArrayList<Programa> listaprogramas = new ArrayList<Programa>();

        if (opcion == 1){//Elegir tipo de RAM
            //LLAMAR MÉTODO DE LA VISTA PARA PREGUNTAR QUE TIPO DE RAM QUIERE.
            if(opcion_ram == 1){
                //LLAMAR MÉTODO DE LA VISTA PARA PREGUNTAR QUE ALMACENAMIENTO QUIERE.
                memoria = new Memoria(4*16, 0, 1); //SDR
            }else if(opcion_ram == 2){
                //EN ESTA OPCION DE RAM, LA CANTIDAD EMPIEZA CON 4 POR DAFAULT, NO CAMBIAR. 
                memoria = new Memoria(4*16, 0, 2); //DDR
            }
        
        }else if (opcion == 2){// Añadir programas. 
            //LLAMAR UN MÉTODO EN LA VISTA QUE DEVUELVA LO NECESARIO PARA EL CONSTRUCTOR. 
            listaprogramas.add(new Programa("nombre", 56, 123));
        
        }else if (opcion == 3){// Ver la cantidad de memoria ram total. 
            //Llamar un método que muestre las estadísticas de la ram.             
            memoria.getTotalSpace();
            memoria.getEmptySpace();
            memoria.getFilledSpace();

        }else if(opcion == 4){// Ver los programas en ejecución. 

            for(int i = 0; i <= Memoria.ram.size() - 1; i++){
                ArrayList<String> lista_para_imprimir = new ArrayList<String>();
                lista_para_imprimir.add(Memoria.ram.get(i).getNombre());
                //LA VISTA DEBERÁ ACCEDER AL ARRAYLIST Y MOSTRAR 
            }
        
        }else if(opcion == 5){//Mostar programas en cola. 
            for(int i = 0; i <= Memoria.cola.size() - 1; i++){
                ArrayList<String> lista_para_imprimir = new ArrayList<String>();
                lista_para_imprimir.add(Memoria.cola.get(i).getNombre());
                //LA VISTA DEBERÁ ACCEDER AL ARRAYLIST Y MOSTRAR
            } 
        }else if(opcion == 6){//Ver la posición de los bloques de RAM que ocupa un programa.
            //LLAMAR UN MÉTODO DE LA VISTA PARA PREGUNTAR EL NOMBRE DEL PROGRAMA. 
            String nom_programa = "Word";
            boolean stop = false;
            int non_filled_space_bf = 0;
            
            while(stop == false){      
                for(int i = 0; i <= Memoria.ram.size()-1; i++){
                    if(Memoria.ram.get(i).getNombre() != nom_programa){
                        non_filled_space_bf = non_filled_space_bf + Memoria.ram.get(i).getEspacio();
                    
                    }else{
                        
                    }
                }
            }
        }
    }//Fin del main
}// Fin de clase
