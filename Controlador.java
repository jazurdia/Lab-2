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
                
                if(memoria.getCola().size() != 0){
                    ArrayList<String> lista_para_imprimir = new ArrayList<String>();
                    for(int i = 0; i < memoria.getRam().size()-1; i++){
                        lista_para_imprimir.add(memoria.getNomByProgramaCola(i));
                    }
                    vista.opcion4y5(lista_para_imprimir);
                }else{
                    vista.ans0();
                }

            }else if(opcion == 6){//Ver la posicion de los bloques de RAM
                
                ArrayList<String> posicion = new ArrayList<String>();
                for (int i = 0; i< memoria.getRam().size(); i++){
                    posicion.add(memoria.getNomByProgramaCola(i));
                }

                String nom_programa = vista.opcion6a();
                int pos_inicial = 0;
                int pos_final = 0;
                for (int i = 0;i<posicion.indexOf(nom_programa);i++){
                    pos_inicial = pos_inicial + memoria.getPrograma(i).getEspacio();
                }
                pos_final = pos_inicial + memoria.bloquesByPrograma(posicion.indexOf(nom_programa));
                vista.opcion6b(pos_inicial, pos_final, nom_programa);

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