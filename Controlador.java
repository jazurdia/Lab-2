/**
 * @author Javier Alejandro Azurdia Arrecis
 * @version 0.1
 */

import java.util.*;
public class Controlador {
    public static void main(String [] args){
        
        int opcion = 0;
        int opcion_ram = 0;

        ArrayList<Integer> estado_ram = new ArrayList<Integer>();;
        String mensaje;


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
            int acumulado = 0;
            int espacio_buscado = 0;
            
            while(stop == false){      
                for(int i = 0; i <= Memoria.ram.size()-1; i++){
                    if(Memoria.ram.get(i).getNombre() != nom_programa){
                        acumulado = acumulado + Memoria.ram.get(i).getEspacio();
                    
                    }else{
                        espacio_buscado = Memoria.ram.get(i).getEspacio();
                        stop = true;
                    }
                }
            }
            acumulado = acumulado + 1;
            espacio_buscado = espacio_buscado + acumulado - 1;
            mensaje = "El programa " + nom_programa + " Se ejecuta desde el bloque de memoria " + acumulado + " y termina en " + espacio_buscado;
            // LLAMAR MÉTODO DE VISTA PARA MOSTRAR ESTO. 

        }else if(opcion == 7){//VER ESTADO DE LA RAM
            mensaje = "Se ocupa del bloque 1 al bloque " + memoria.getFilledSpace() + " Y está libre desde el bloque " + (memoria.getFilledSpace() + 1) + " al bloque " + memoria.getTotalSpace();
            //ENVIAR UN MÉTODO PARA QUE ESA SHIT VAYA A LA VISTA. 

        }else if(opcion == 8){//Realizar un ciclo de reloj
            memoria.click();
        }
    }//Fin del main
}// Fin de clase
