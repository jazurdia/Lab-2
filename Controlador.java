/**
 * @author Javier Alejandro Azurdia Arrecis
 * @version 0.7
 */

import java.util.*;
public class Controlador {
    public static void main(String [] args){
        
        int opcion = 0;
        int opcion_ram = 0;
        Vista vista = new Vista();
        Memoria memoria = new Memoria(0, 0, 0);
        boolean terminar = false;

        while (terminar == false){
            opcion = vista.menu();
            if (opcion == 1){//Elegir tipo de RAM
                opcion_ram = vista.opcion1();
                if(opcion_ram == 1){
                    memoria = new Memoria(vista.opcion1a()*16, 0, 1); //SDR
                }else if(opcion_ram == 2){
                    memoria = new Memoria(4*16, 0, 2); //DDR
                }
            
            }else if (opcion == 2){// Añadir programas. 
                memoria.addProgramas(new Programa(vista.opcion2a(), vista.opcion2b(), vista.opcion2c()));
                
            }else if (opcion == 3){// Ver la cantidad de memoria ram total. 
                vista.opcion3(memoria.getTotalSpace(), memoria.getEmptySpace(), memoria.getFilledSpace());

            }else if(opcion == 4){// Ver los programas en ejecución. 
                ArrayList<String> lista_para_imprimir = new ArrayList<String>();
                for(int i = 0; i < memoria.getRam().size(); i++){
                    lista_para_imprimir.add(memoria.getNomByProgramaRam(i));
                }

                vista.opcion4y5(lista_para_imprimir);
                    

            }else if(opcion == 5){//Mostar programas en cola. 
                
                if(memoria.getCola().size() > 0){
                    ArrayList<String> lista_para_imprimir = new ArrayList<String>();
                    for(int i = 0; i < memoria.getCola().size(); i++){
                        lista_para_imprimir.add(memoria.getNomByProgramaCola(i));
                    }
                    vista.opcion4y5(lista_para_imprimir);
                }else{
                    vista.ans0();
                }

            }else if(opcion == 6){//Ver la posicion de los bloques de RAM

                if(memoria.getRam().size() > 0){
                    String nom_programa = vista.opcion6a();
                    ArrayList<String> lista_de_programas = new ArrayList<String>();
                    
                    for (int i = 0; i< memoria.getRam().size(); i++){
                        lista_de_programas.add(memoria.getRam().get(i).getNombre()); // guardo los nombres de todos los programas de la RAM
                    }

                    int pos_i = 0;
                    int pos_f = 0;

                    for(int i = 0; i < lista_de_programas.indexOf(nom_programa);i++){
                        pos_i = pos_i + memoria.getRam().get(i).getEspacio();
                    }

                    pos_f = pos_i + memoria.getRam().get(lista_de_programas.indexOf(nom_programa)).getEspacio();
                    
                    vista.opcion6b(pos_i, pos_f, nom_programa);

                }else{
                    vista.ans0();
                }

            }else if(opcion == 7){//VER ESTADO DE LA RAM
                vista.opcion7(memoria.getFilledSpace(), memoria.getFilledSpace() + 1, memoria.getTotalSpace());

            }else if(opcion == 8){//Realizar un ciclo de reloj
                memoria.click();
            
            }else if(opcion == 9){
                terminar = true;
            }
        }// Fin del while
    }//Fin del main
}// Fin de clase