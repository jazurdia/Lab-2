import java.util.*;
public class Vista {
    Scanner in = new Scanner(System.in);

    public int menu()throws InputMismatchException{ //Menu principal. 
        int opcion = 0;
        boolean parar = false;
        
        while(parar == false){
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
            
            try {
                opcion = in.nextInt();
                parar = true;
            } catch (InputMismatchException e) {
                in = new Scanner(System.in);
                System.out.println("Intenta nuevamente. ");
            }
        }
        
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
        
        int opcion1a = 0;
        boolean parar = false;
        while(parar == false){
            try {
                System.out.println("Ingresa la capacidad de alacenamiento que quieres que tu RAM tenga");
                System.out.println("4GB / 8GB / 12GB / 16GB / 32GB / 64GB");
                System.out.println("Ingresa solamente el número. Ej: 4 ");
                opcion1a = in.nextInt();
                parar = true;
            } catch (Exception e) {
                System.out.println("Intenta de nuevo");
                in = new Scanner(System.in);            
            }
        }

        
        return opcion1a;
    }

    public String opcion2a(){//Ingresa el nombre del programa. 
        String opcion2a = "default";
        boolean parar = false;
        while (parar == false){
            try {
                System.out.println("Ingresa el nombre del programa");
                opcion2a = in.next();
                parar = true;
            } catch (Exception e) {
                System.out.println("Intenta de nuevo");
                in = new Scanner(System.in);
            }
        }        
        return opcion2a;
    }

    public int opcion2b(){ // Ingresa el espacio que ocupa el programa. 
        int opcion2b = 0;
        boolean parar = false;
        while (parar == false){
            try {
                System.out.println("Ingresa los bloques de memoria que ocupa el programa.");
                opcion2b = in.nextInt();
                parar = true;
            } catch (Exception e) {
                System.out.println("Intenta de nuevo");
                in = new Scanner(System.in);
            }
        }
        
        
        return opcion2b;
    }

    public int opcion2c(){ // Ingresa el espacio que ocupa el programa. 
        int opcion2c = 0;
        boolean parar = false;
        while(parar == false){
            try {
                System.out.println("Ingresa los ciclos de reloj del programa");
                opcion2c = in.nextInt();
                parar = true;
            } catch (Exception e) {
                System.out.println("Intenta de nuevo");
                in = new Scanner(System.in);
            }
        }
        
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
        
        String opcion6a = "default";
        boolean parar = false;
        while (parar == false){
            try {
                System.out.println("Ingresa el nombre del programa que quieres buscar: ");
                opcion6a = in.next();
                parar = true;
            } catch (Exception e) {
                System.out.println("Intenta de nuevo");
                in = new Scanner(System.in);
            }
        }
        return opcion6a;
    }

    public void opcion6b(int pos_inicial,int pos_final , String nom_programa){
        System.out.println("El programa "+nom_programa+" ocupa del bloque de memoria "+pos_inicial+" al bloque de memoria "+pos_final);
    }

    public void opcion7(int filled_space, int inicio, int total){
        System.out.println("Se ocupa del bloque 1 al bloque " + filled_space + ". Está libre desde el bloque " + inicio + " al bloque " + total + "." );
    }

    public void ans0(){
        System.out.println("No hay programas.");
    }




    
}
