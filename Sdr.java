import java.util.*;
public class Sdr{
    int bloques;
    int bloques_usados;
    LinkedList <Programa> ram = new LinkedList<Programa>();

    public Sdr(int space){
        this.bloques = space * 64;
    }

    public Boolean addProgramas(Programa programa){
        Boolean mensaje;

        if (bloques_usados <= bloques){
            ram.add(programa);
            mensaje = true;
        }else{
            mensaje = false;
        }
        return mensaje;
    }

    public int getEmptySpace(){
        int empty_space = bloques - bloques_usados;
        return empty_space;
    }
    
    public int getFilledSpace(){
        return bloques_usados;
    }

    public void click(){
        ram.get(0).exciclos();
        System.out.println("Ciclos restantes" + ram.get(0).getCiclos());
    }

}