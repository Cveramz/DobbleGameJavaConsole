package main;

import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int verifyMain=0;
        //usar un while para verificar si lo que se ingresará es un numero de 1 a 4.
        while(verifyMain==0){
            System.out.println("###### MENU ######");
            System.out.println("## REGISTRADO COMO: ");
            System.out.println("ESCOJA UNA OPCION:");
            System.out.println("[1] Crear un juego");
            System.out.println("[2] Registrar jugador");
            System.out.println("[3] Jugar");
            System.out.println("[4] Visualizar estado completo del juego");
            int rMenu =input.nextInt();
            System.out.println("Respuesta: "+rMenu);
            //hacer un if para verificar si el numero es valido.
            if(rMenu>=1 && rMenu<=4){
                verifyMain=1;
            }
            else{
                System.out.println("ERROR: El numero ingresado no es valido.");
            }
        }


    }
}