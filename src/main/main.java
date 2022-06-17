package main;
//import Juego.*;
import Jugador.*;
import DobbleOperaciones.*;
import java.util.Scanner;
import java.util.Arrays;

class opcionesMenu{
    public static void crearJuego(){
        System.out.println("CrearJuego");
    }
    public static Player registrarJugador(){
        System.out.println("registrarJugador");
        Scanner input= new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre=input.nextLine();
        Player jugador=new Player(nombre);
        System.out.println("El jugador "+jugador.getNombre()+" se ha registrado correctamente.");
        //input.close();
        return jugador;
    }
    public static void iniciarJuego(){
        System.out.println("iniciarJuego");
    }
    public static void vizualizarEstado(){
        System.out.println("vizualizarEstado");
    }
    //Metodo para probar funcionalidades manualmente
    //Entrada: Nada
    //Salida: Nada
    public static void testMode(){
        System.out.println("testMode");
        String[][] set = Dobble.generarSet();
        for (int i = 0; i < set.length; i++) {
            System.out.println("Carta " + (i+1) + ": " + Arrays.toString(set[i]));
        }   
        
    }
}

class menu{
    String nombreJugador = "INVITADO";

    //Metodo para mostrar el menu de opciones y recibir opciones.
    //Entrada: Nada
    //Salida: Nada
    public void menuPrincipal(){
        Scanner input= new Scanner(System.in);
        int verifyMain=0;
        int rMenu=0;
        int cerrar=0;
        while(cerrar==0){
        //usar un while para verificar si lo que se ingresará es un numero de 1 a 4.
        verifyMain=0;
        rMenu=0;
        while(verifyMain==0){
            System.out.println("###### MENU ######");
            System.out.println("## REGISTRADO COMO: " + this.nombreJugador + " ##");
            System.out.println("ESCOJA UNA OPCION:");
            System.out.println("[1] Crear un juego");
            System.out.println("[2] Registrar jugador");
            System.out.println("[3] Jugar");
            System.out.println("[4] Visualizar estado completo del juego");
            System.out.println("[5] Probar metodos manualmente");
            System.out.println("[6] Salir");
            rMenu =input.nextInt();
            //hacer un if para verificar si el numero es valido.
            if(rMenu>=1 && rMenu<=6){
                verifyMain=1;
            }
            else{
                System.out.println("ERROR: El numero ingresado no es valido.");
            }
        }
        //crear un switch para verificar que opcion se eligio.
        System.out.println("Respuesta: "+rMenu);
        switch(rMenu){
            case 1:
                opcionesMenu.crearJuego();
                break;
            case 2:
                Player jugador=opcionesMenu.registrarJugador();
                this.nombreJugador=jugador.getNombre();
                break;
            case 3:
                opcionesMenu.iniciarJuego();
                break;
            case 4:
                opcionesMenu.iniciarJuego();
                break;
            case 5:
                opcionesMenu.testMode();
                break;
            case 6:
                //terminar programa.
                cerrar=1;
                input.close();
                break;
        }
        }
    //Cerrar el input.
    input.close();
    }
}

class Main {
    //Metodo para iniciar el programa.
    public static void main(String[] args) {
        menu m = new menu();
        m.menuPrincipal();
    }
}