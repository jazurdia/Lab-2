import java.util.LinkedList;

public class Memoria {
    
    private int bloques = 0;
    private int bloques_usados = 0;
    private int tipo_de_memoria = 0;
    static public LinkedList<Programa> ram = new LinkedList<Programa>(); //SE USARÁ EN EL CONTROLADOR. NO SE MODIFICARÁ
    static public LinkedList<Programa> cola = new LinkedList<Programa>(); //SE USARÁ EN EL CONTROLADOR. NO SE MODIFICARÁ

    /**
     * 
     * @param bloques: bloques de memoria de la ram
     * @param bloques_usados: bloques de memoria 
     * @param tipo_de_memoria: tipo de memoria ram que se usará
     * @param ram: lista en la que los programas estarán ejecutandose.
     * @param cola: lista en la que está la cola de espera de los programas que no "caben" en la ram.  
     */

    public Memoria(int bloques, int bloques_usados, int tipo_de_memoria){
        this.bloques = bloques;
        this.bloques_usados = bloques_usados;
        this.tipo_de_memoria = tipo_de_memoria;
    }

    private void conf_memory(){
        if (tipo_de_memoria == 2){//DDR
            if(bloques_usados >= 4*16){
                bloques = 8 * 16;
            }else if(bloques_usados >= 8*16){
                bloques = 12*16;
            }else if(bloques_usados >= 12*16){;
                bloques = 16 * 16;
            }else if(bloques_usados >= 16*16){
                bloques = 32 * 16;
            }else if(bloques_usados >= 32*16){
                bloques = 64 * 16;
            }
        }
    }

    public int getEmptySpace(){
        if(tipo_de_memoria == 2){
            conf_memory();
        }
        int empty_space = bloques - bloques_usados;
        return empty_space;
    }

    public int getFilledSpace(){
        if(tipo_de_memoria == 2){
            conf_memory();
        }
        return bloques_usados;
    }

    public int getTotalSpace(){
        if(tipo_de_memoria == 2){
            conf_memory();
        }
        return bloques;
    }

    public void addProgramas(Programa programa){
        if(tipo_de_memoria == 1){
            if(programa.getEspacio()+ bloques_usados <= bloques){
                ram.add(programa);
                bloques_usados = bloques_usados + programa.getEspacio();
            }else if(programa.getEspacio() + bloques_usados > bloques_usados){
                cola.add(programa);
            }
        }else if(tipo_de_memoria == 2){
            if (programa.getEspacio() + bloques_usados <= 64*16){
                ram.add(programa);
                bloques_usados = bloques_usados + programa.getEspacio();
                conf_memory();
            }else if(programa.getEspacio() + bloques_usados > 64*16){
                cola.add(programa);
            }
        }
    }

    public void click(){
        if (tipo_de_memoria == 1){
            ram.get(0).exciclos(1);
        }else if (tipo_de_memoria == 2){
            ram.get(0).exciclos(2);
        }

        if(ram.get(0).getCiclos() == 0){
            ram.remove(0);
            if(cola.get(0).getEspacio() + bloques_usados <= bloques){
                ram.add(cola.get(0));
                cola.remove(0);
            }     
        }
    }

    public Programa getPrograma(int i){
        return ram.get(i);
    }

    public String getNomByProgramaRam(int i){
        return ram.get(i).getNombre();
    }

    public String getNomByProgramaCola(int i){
        return cola.get(i).getNombre();
    }

    public LinkedList<Programa> getRam(){
        return ram;
    }

    public LinkedList<Programa> getCola(){
        return cola;
    }

    public int bloquesByPrograma(int i){
        int bloquesByPrograma = ram.get(i).getEspacio();
        return bloquesByPrograma;
    }

}
