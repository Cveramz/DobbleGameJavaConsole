package DobbleOperaciones;
import Cartas.*;
import java.util.List;


/*
Representa el conjunto de cartas y todas las operaciones que se
pueden realizar sobre estas.
Ej: obtener la n-esima carta, convertir un set en string, buscar
cartas faltantes, conocer la cantidad de elementos requeridos, total de cartas
a partir de una carta de muestra, etc.)
 */

public class Dobble {
    
    
    //Crear metodo que cree un set de cartas.
    //Entrada: Tamaño de la carta, Cantidad de elementos por carta y array de elementos posibles.
    //Salida: Array representando el set de cartas.
    public static String[][] setDeCartas(int cantCartas, int CantElementos, String[] elementosPosibles) {
        String[][] set = new String[cantCartas][CantElementos];
        for (int i = 0; i < cantCartas; i++) {
            set[i] = Card.crearCarta(CantElementos, elementosPosibles);
        }
        return set;
    }
    //Falta hacer un constructor y utilizando otra función que verifique si es valido el set.
}
