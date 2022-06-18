package Jugador;

/*
Representa un jugador y todas las operaciones que puede realizar un
jugador.
 */
public class Player {
    String nombre;
    String[] registrados;

    public Player() {
        this.nombre = "INVITADO";
    }

    public Player(String nombre) {
        setNombre(nombre);
        String[] registrados = new String[1];
        registrados[0] = nombre;
        this.registrados = registrados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarRegistro(String registro) {
        String[] registrados = new String[this.registrados.length + 1];
        for (int i = 0; i < this.registrados.length; i++) {
            registrados[i] = this.registrados[i];
        }
        registrados[registrados.length - 1] = registro;
        this.registrados = registrados;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getRegistrados() {
        return registrados;
    }


}
