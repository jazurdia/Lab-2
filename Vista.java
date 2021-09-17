import java.util.Scanner;
import java.util.*;


public class Vista {
    int opcion = 0;
    Scanner in = new Scanner(System.in);

    public int menu(){ //Menu principal. 
        System.out.println("Bienvenido al simulador de RAM. Elige una de las siguientes opciones: ");
        System.out.println("1. Inicializar la RAM");
        System.out.println("2. Ingresar los programas que serán procesados para usar la memoria RAM");
        System.out.println("3. Ver las estadísticas de la RAM");
        System.out.println("4. Ver los programas en ejecucción");
        System.out.println("5. Ver los programas en cola");
        System.out.println("6. Ver los bloques en los que un programa se ejecuta");
        System.out.println("7. Ver el estado de memoria.");
        System.out.println("8. Realizar un ciclo de reloj");
        System.out.println("9. terminar la ejecucción del simulador");
        opcion = in.nextInt();
        return opcion;
    }

    public int opcion1(){// Selecciona el tipo de ram.
        int tipo_ram = 0;
        System.out.println("¿Que tipo de ram quieres usar?");
        System.out.println("1. SDR");
        System.out.println("2. DDR");
        tipo_ram = in.nextInt();
        return tipo_ram;
    }

    public int opcion1a(){ // Ingresa la capacidad de la RAM
        System.out.println("Ingresa la capacidad de alacenamiento que quieres que tu RAM tenga");
        System.out.println("4GB / 8 GB / 12 GB / 16GB / 32GB / 64GB");
        System.out.println("Ingresa solamente el número. Ej: 4 ");
        int opcion1a = in.nextInt();
        return opcion1a;
    }

    public String opcion2a(){//Ingresa el nombre del programa. 
        System.out.println("Ingresa el nombre del programa");
        String opcion2a = in.next();
        return opcion2a;
    }

    public int opcion2b(){ // Ingresa el espacio que ocupa el programa. 
        System.out.println("Ingresa los bloques de memoria que ocupa el programa.");
        int opcion2b = in.nextInt();
        return opcion2b;
    }

    public int opcion2c(){ // Ingresa el espacio que ocupa el programa. 
        System.out.println("Ingresa los ciclos de reloj del programa");
        int opcion2c = in.nextInt();
        return opcion2c;
    }

    public void opcion3(int ts, int es, int fs){
        System.out.println("El total de bloques de memoria es: " + ts );
        System.out.println("El numero de bloques vacios es: " + es);
        System.out.println("El numero de bloques usados es: " +  fs);
    }

    public void opcion4y5(ArrayList<String> lista_para_imprimir){
        for (String nom_programa : lista_para_imprimir) {
            System.out.println(nom_programa);
        }   
    }

    public String opcion6a(){
        System.out.println("Ingresa el nombre del programa que quieres buscar: ");
        String opcion6a = in.nextLine();
        return opcion6a;
    }

    public void opcion6b(int pos_inicial,int pos_final , String nom_programa){
        System.out.println("El programa "+nom_programa+" ocupa del bloque de memoria "+pos_inicial+" al bloque de memoria "+pos_final);
    }

    public void opcion7(int filled_space, int inicio, int total){
        System.out.println("Se ocupa del bloque 1 al bloque " + filled_space + ". Está libre desde el bloque " + inicio + " al bloque " + total + "." );
    }




    
}
