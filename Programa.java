public class Programa {
    
    String nombre;
    int espacio;
    int ciclos;

    /**
     * 
     * @param nombre : nombre del programa
     * @param espacio : espacio en la memoria RAM que ocupa el programa
     * @param ciclos : número de ciclos que toma ejecutar el programa. 
     */
    
    public Programa(String nombre, int espacio, int ciclos){
        this.nombre = nombre;
        this.espacio = espacio;
        this.ciclos = ciclos;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEspacio(){
        return espacio;
    }

    public int getCiclos(){
        return ciclos;
    }

    public void exciclos(int num){
        ciclos = ciclos - num;
    }

}