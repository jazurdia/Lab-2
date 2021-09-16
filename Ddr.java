import java.util.HashSet;

import java.util.*;
public class Ddr {
    // DEBE HACER DOS OPERACIONES
    int bloques = 4 * 16;
    int bloques_usados = 0;
    
    LinkedList<Programa> ram = new LinkedList<Programa>();
    
    
    public void checkMemory(){
        if(bloques_usados >= 4*16){
            bloques = 8 * 16;
        }else if(bloques_usados >= 8*16){
            bloques = 12*16;
        }else if(bloques_usados >= 12*16){
            bloques = 16 * 16;
        }else if(bloques_usados >= 16*16){
            bloques = 32 * 16;
        }else if(bloques_usados >= 32*16){
            bloques = 64 * 16;
        }
    }

    public Boolean addProgramas(Programa programa){
        Boolean mensaje;
        if (bloques_usados <= 64*16){
            ram.add(programa);
            this.bloques_usados = bloques_usados - programa.getEspacio();
            mensaje = true; // Se logró añadir
            System.out.println(ram.toString());
        }else{
            mensaje = false; //No se logró añadir
            System.out.println(ram.toString());
        }
        return mensaje;
    }

    public int getFilledSpace(){
        return bloques_usados;
    }

    public int getEmptySpace(){
        int filled_space = bloques - bloques_usados;
        return filled_space;
    }

    public void click(){
        ram.get(0).exciclos();
        System.out.println("Ciclos restantes" + ram.get(0).getCiclos());
    }
    


}

    
    
