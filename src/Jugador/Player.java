package Jugador;
import java.util.Scanner;

/*
Representa un jugador y todas las operaciones que puede realizar un
jugador.
 */
public class Player {
    String nombre;
    String[] registrados;

    //Constructor por defecto, cambia el nombre del jugador a "INVITADO".
    //Entrada: Nada
    //Salida: Nada
    public Player() {
        this.nombre = "INVITADO";
    }

    //Constructor que recibe un nombre para el jugador.
    //Entrada: Un string con el nombre del jugador.
    //Salida: Nada
    public Player(String nombre) {
        setNombre(nombre);
        String[] registrados = new String[1];
        registrados[0] = nombre;
        this.registrados = registrados;
    }

    //Metodo para definir el nombre del jugador.
    //Entrada: Un string con el nombre del jugador.
    //Salida: Nada
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo para agregar a un jugador a la lista de jugadores registrados.
    //Entrada: Un string con el nombre del jugador.
    //Salida: Nada
    public void agregarRegistro(String registro) {
        String[] registrados = new String[this.registrados.length + 1];
        for (int i = 0; i < this.registrados.length; i++) {
            registrados[i] = this.registrados[i];
        }
        registrados[registrados.length - 1] = registro;
        this.registrados = registrados;
    }

    //Metodo para obtener el nombre del jugador actual.
    //Entrada: Nada
    //Salida: Un string con el nombre del jugador.
    public String getNombre() {
        return nombre;
    }

    //Metodo para obtener la lista de jugadores registrados.
    //Entrada: Nada
    //Salida: Un string con la lista de jugadores registrados.
    public String[] getRegistrados() {
        return registrados;
    }


}
