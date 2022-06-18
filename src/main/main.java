package main;
//import Juego.*;
import Jugador.*;
import Juego.*;
import java.util.Scanner;

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
}

class menu{
    String nombreJugador = "INVITADO";
    DobbleGame juego;

    public void menuPrincipal(){
        DobbleGame juego=new DobbleGame();
        this.juego = juego;
        Scanner input= new Scanner(System.in);
        int verifyMain=0;
        int rMenu=0;
        int cerrar=0;
        while(cerrar==0){
        //usar un while para verificar si lo que se ingresará es un numero de 1 a 4.
        verifyMain=0;
        rMenu=0;
        while(verifyMain==0){
            System.out.println("");
            System.out.println("====================");
            System.out.println("¡BIENVENIDO A DOBBLE!");
            System.out.println("====================");
            System.out.println("###### MENU ######");
            System.out.println("## REGISTRADO COMO: " + this.nombreJugador + " ##");
            System.out.println("");
            System.out.println("ESCOJA UNA OPCION:");
            System.out.println("[1] Registrar jugador");
            System.out.println("[2] Crear un juego");
            System.out.println("[3] Jugar una ronda de juego iniciado");
            System.out.println("[4] Visualizar estado completo del juego");
            System.out.println("[5] Salir");
            System.out.println("");
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
                Player jugador=opcionesMenu.registrarJugador();
                this.nombreJugador=jugador.getNombre();
                break;

            case 2:
                Scanner entrada= new Scanner(System.in);
                System.out.println("Cantidad de jugadores CPU: ");
                //La cantidad de jugadores debe ser mayor a 1.
                int cantJugadores=entrada.nextInt();
                if (cantJugadores>0){
                    System.out.println("Cantidad de elementos por carta: ");
                    int cantElementos=entrada.nextInt();
                    this.juego.nombreJugador= this.nombreJugador;
                    this.juego.cantJugadores= cantJugadores;
                    this.juego.cantElementos = cantElementos;
                    juego.iniciarJuego();
                }
                else{
                    System.out.println("ERROR: La cantidad de jugadores CPU debe ser mayor a 0");
                }
                    break;
            case 3:
                if (this.juego.estadoJuego == false){
                    System.out.println("¡No se ha iniciado un juego!");
                }
                else{
                    System.out.println("Reanudando...");
                    juego.jugarJugadorVsCpu(2);
                }
                break;
            case 4:
                if (this.juego.estadoJuego == false){
                    System.out.println("¡No se ha iniciado un juego!");
                }else{
                    this.juego.verificarEstado();
                }
                break;
            case 5:
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
    public static void main(String[] args) {
        menu m = new menu();
        m.menuPrincipal();
    }
}