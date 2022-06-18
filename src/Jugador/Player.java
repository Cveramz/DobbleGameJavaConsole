package Jugador;

/*
Representa un jugador y todas las operaciones que puede realizar un
jugador.
 */
public class Player {
    String nombre;
    String[] registrados;

    //Constructor de la clase Player
    public Player() {
        this.nombre = "INVITADO";
    }

    //Constructor de la clase Player cuando se ingresa un nombre
    //Entrada: nombre
    public Player(String nombre) {
        setNombre(nombre);
        String[] registrados = new String[1];
        registrados[0] = nombre;
        this.registrados = registrados;
    }

    //Metodo para asignar el nombre del jugador
    //Entrada: nombre
    //Salida: nada
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo para agregar usuario registrado (aunque no se usó)
    //entrada : Nombre
    //salida : Nada
    public void agregarRegistro(String registro) {
        String[] registrados = new String[this.registrados.length + 1];
        for (int i = 0; i < this.registrados.length; i++) {
            registrados[i] = this.registrados[i];
        }
        registrados[registrados.length - 1] = registro;
        this.registrados = registrados;
    }

    //Metodo para obtener el nombre del jugador
    //Entrada: Nada
    //Salida: nombre
    public String getNombre() {
        return nombre;
    }

    //Metodo para obtener los usuarios registrados
    //Entrada: Nada
    //Salida: registrados
    public String[] getRegistrados() {
        return registrados;
    }


}
