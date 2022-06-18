package Juego;
import DobbleOperaciones.*;
import java.util.Scanner;
import java.util.Arrays;

/*
Representa el juego y el desarrollo del mismo, esto incluye
todas las operaciones que puede realizar un juego (ver enunciados labs
anteriores como referencia. Ej: ¿de quién es el turno?, ¿cuál es el estado del
juego?).

 */
public class DobbleGame {
    public String nombreJugador;
    String[] cartaJugador;
    public int cantJugadores;
    public boolean estadoJuego;
    public int cantidadRondas;
    public int cantElementos;
    int puntajeJugador;
    String dificultad;
    String[][] cardSet;
    int numRonda;
    String ModoJuego;


    public DobbleGame() {
        this.nombreJugador = "INVITADO";
        this.cartaJugador = new String[0];
        this.cantJugadores = 0;
        this.estadoJuego = false;
        this.cantidadRondas = 0;
        this.puntajeJugador = 0;
        this.cardSet =new String[2][];
        this.numRonda = 0;
        
    }

    public void verificarEstado(){
        System.out.println("=========================");
        System.out.println("INFORMACIÓN DE LA PARTIDA:");
        //mostar nombre de jugador
        System.out.println("Nombre del jugador: "+ this.nombreJugador);
        System.out.println("Cantidad de jugadores: "+ this.cantJugadores);
        System.out.println("Cantidad de rondas: " + this.cantidadRondas);
        System.out.println("Ronda actual: " + this.numRonda);
        System.out.println("Puntaje del jugador: " + this.puntajeJugador);
        System.out.println("Dificultad: " + this.dificultad);
        System.out.println("=========================");
    }

    public void iniciarJuego() {
        this.estadoJuego = true;
        //Inicia el juego
        System.out.println("Ingrese cantidad de rondas.");
        Scanner input= new Scanner(System.in);
        int rondas=input.nextInt();
        this.cantidadRondas = rondas;
        int dificultad = 0;
        while (dificultad<1 || dificultad>3){
            System.out.println("********INGRESE UNA DIFICULTAD********");
            System.out.println("[1] Facil");
            System.out.println("[2] Normal");
            System.out.println("[3] Dificil");
            dificultad =input.nextInt();
        }
        switch(dificultad){
            case 1:
                this.dificultad = "Facil";
                break;
            case 2:
                this.dificultad = "Normal";
                break;
            case 3:
                this.dificultad = "Dificil";
                break;
        }
        int modo = 0;
        while (modo<1 || modo>2){
            System.out.println("********INGRESE UN MODO DE JUEGO********");
            System.out.println("[1] Jugador vs Computador");
            //System.out.println("[2] Computador vs Computador");
            modo =input.nextInt();
        }
        switch(modo){
            case 1:
                this.ModoJuego = "Jugador vs CPU";
                break;
            /*case 2:
                this.ModoJuego = "CPU vs CPU";
                break;
                */
        }

        System.out.println("=========================");
        System.out.println("INFORMACIÓN DE LA PARTIDA:");
        //mostar nombre de jugador
        System.out.println("Nombre del jugador: "+ this.nombreJugador);
        System.out.println("Cantidad de jugadores: "+ this.cantJugadores);
        System.out.println("Cantidad de rondas: " + this.cantidadRondas);
        System.out.println("Dificultad de CPU: " + this.dificultad);
        System.out.println("Modo de juego: " + this.ModoJuego);
        System.out.println("=========================");
        if (this.ModoJuego.equals("Jugador vs CPU")){
            jugadorVsCPU();
        }
        else{
            System.out.println("CPU VS CPU");
        }

    }

    public void jugadorVsCPU() {
        //Juego jugador vs CPU
        Scanner respuesta= new Scanner(System.in);
        int confirmar = 0;
        String confirmar2 = "";
        while (confirmar != 1) {
            System.out.println("");
            System.out.println("Jugador vs CPU");
            System.out.println("Modo de juego: ¡Encuentra el elemento que se repite en todas las cartas!");
            System.out.println("¡Mientras más rapido respondas correctamente mayor será tu puntaje!.");
            System.out.println("¿Continuar? ( SI=1 / NO=0)");
            confirmar = respuesta.nextInt();
        //esta respuesta no se usará para nada. Solo es para que el jugador pueda leer el mensaje.
        }
        System.out.println("Iniciando partida...");
        String[][] cardSet = new String[this.cantJugadores][cantElementos];
        cardSet = Dobble.generarSet(this.cantJugadores, this.cantElementos);
        this.cardSet = cardSet;
        int dificultad=0;
        switch(this.dificultad){
            case "Facil":
                dificultad = 1;
                break;
            case "Normal":
                dificultad = 2;
                break;
            case "Dificil":
                dificultad = 3;
                break;
        }
        for (int i=0; i<this.cantidadRondas; i++){
            jugarJugadorVsCpu(dificultad);
            System.out.println("");
            System.out.println("¿Continuar? ( SI=1 / NO=0)");
            confirmar2 = respuesta.next();
            if (confirmar2.equals("0")){
                break;
            }
        }


    }
    public void jugarJugadorVsCpu(int dificultad) {
        String[][] cardSet = new String[this.cantJugadores][cantElementos];
        cardSet = this.cardSet;
        if (this.numRonda < this.cantidadRondas) {
            Scanner respuesta= new Scanner(System.in);
            this.numRonda = this.numRonda + 1;
            System.out.println("RONDA NÚMERO: " + this.numRonda);
            System.out.println("Presta atención a tu carta");
            //la carta del jugador es cardSet[0]
            this.cartaJugador = cardSet[0];
            //mostrar en pantalla la carta del jugador
            for (int i = 0; i < this.cantElementos; i++) {
                System.out.println(this.cartaJugador[i]);
            }
            System.out.println("¿Preparado para jugar...?");
            System.out.println("(Ingresa un numero para iniciar)");
            //pedir que se ingrese un numero para provocar una pausa
            int numero = respuesta.nextInt();
            //esta respuesta no se usará para nada. Solo es para que el jugador pueda leer el mensaje.
            System.out.println("");
            //buscar repetido en la carta del jugador  
            String repetido = Dobble.getRepetido(cardSet[0], cardSet[1]);
            
            //mostrar en pantalla las cartas del set
            //De la siguiente forma: Jugador 1: [carta1, carta2, carta3, carta4, carta5]
            for (int i = 0; i < this.cantJugadores; i++) {
                System.out.println("Jugador " + (i + 1) + ": " + Arrays.toString(cardSet[i]));
            }
            if (dificultad == 1){
                System.out.println("¿Que elemento se repite?");
                String respuestaDeElemento = "";
                respuestaDeElemento = respuesta.next();
                int numeroAleatorio = (int) (Math.random() * 100) + 1;
                if (numeroAleatorio < 70 && respuestaDeElemento.equals(repetido)){
                    System.out.println("¡Felicitaciones, has encontrado el elemento que se repite!");
                    System.out.println("+ 100 pts");
                    //sumar 100 puntos al jugador.
                    this.puntajeJugador += 100;
                }
                else{
                    if (respuestaDeElemento.equals(repetido)){
                        //generar numero aleatorio entre 1 y la cantidad de jugadores
                        int numeroAleatorio2 = (int) (Math.random() * this.cantJugadores) + 1;
                        System.out.printf("Lo sentimos, el jugador número "+numeroAleatorio2+" ha encontrado el elemento que se repite");
                    }
                }
            }
            if (dificultad == 2){
                System.out.println("¿Que elemento se repite?");
                String respuestaDeElemento = "";
                respuestaDeElemento = respuesta.next();
                int numeroAleatorio = (int) (Math.random() * 100) + 1;
                if (numeroAleatorio < 50 && respuestaDeElemento.equals(repetido)){
                    System.out.println("¡Felicitaciones, has encontrado el elemento que se repite!");
                    System.out.println("+ 200 pts");
                    //sumar 200 puntos al jugador.
                    this.puntajeJugador += 200;
                }
                else{
                    if (respuestaDeElemento.equals(repetido)){
                        //generar numero aleatorio entre 1 y la cantidad de jugadores
                        int numeroAleatorio2 = (int) (Math.random() * this.cantJugadores) + 1;
                        System.out.printf("Lo sentimos, el jugador número "+numeroAleatorio2+" ha encontrado el elemento que se repite");
                    }
                }
            }
            if (dificultad == 3){
                System.out.println("¿Que elemento se repite?");
                String respuestaDeElemento = "";
                respuestaDeElemento = respuesta.next();
                int numeroAleatorio = (int) (Math.random() * 100) + 1;
                if (numeroAleatorio < 30 && respuestaDeElemento.equals(repetido)){
                    System.out.println("¡Felicitaciones, has encontrado el elemento que se repite!");
                    System.out.println("+ 300 pts");
                    //sumar 300 puntos al jugador.
                    this.puntajeJugador += 300;
                }
                else{
                    if (respuestaDeElemento.equals(repetido)){
                        //generar numero aleatorio entre 1 y la cantidad de jugadores
                        int numeroAleatorio2 = (int) (Math.random() * this.cantJugadores) + 1;
                        System.out.printf("Lo sentimos, el jugador número "+numeroAleatorio2+" ha encontrado el elemento que se repite");
                    }
                }
            }
            //generar nuevo set de cartas
            String[][] cardSet2 = new String[this.cantJugadores][cantElementos];
            cardSet2 = Dobble.generarSet(this.cantJugadores, this.cantElementos);
            this.cardSet = cardSet2;
        } else {
            System.out.println("¡Las rondas han acabado!");
            System.out.println("Puntaje: " + this.puntajeJugador);
        }
    }



}
