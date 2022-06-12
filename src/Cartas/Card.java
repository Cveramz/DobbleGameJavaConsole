package Cartas;
//import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


/*
Representa una carta y por tanto todas las operaciones que se pueden
realizar con una carta.
 */

public class Card {
    
    
    //FUNCIÓN QUE GENERA UNA CARTA, RECIBIENDO TAMAÑO Y ARREGLO DE ELEMENTOS.
    //Entrada: Tamaño de la carta, y array de elementos posibles.
    //Salida: Array representando la carta, que contiene tamaño cantidad de elementos.
    public static String[] crearCarta(int tamano, String[] elementosPosibles) {
        String[] carta = new String[tamano];
        String elemento;
        for (int i = 0; i < tamano; i++) {
            elemento = elementosPosibles[(int) (Math.random() * elementosPosibles.length)];
            //verificar que el elemento no se repita.
            while (Arrays.asList(carta).contains(elemento)) {
                elemento = elementosPosibles[(int) (Math.random() * elementosPosibles.length)];
            }
            carta[i] = elemento;
        }
        return carta;
    }
    
    //FUNCIÓN OBTENER CANTIDAD DE CARTAS, ESTO ES UTILIZANDO LA FUNCIÓN DE COMBINACIÓN SIN REPETICIÓN
    //ENTRADA: NUMERO DE TAMAÑO DE CARTAS Y ARREGLO CON LOS ELEMENTOS POSIBLES.
    //SALIDA: NUMERO DE CARTAS POSIBLES.
    public static int cantidadDeCartas(int tamano, String[] elementosPosibles) {
        int cantidadDeCartas = 0;
        //Vamos a usar la formula de combinación sin repeticion
        //Cantidad de elementos posibles = (m!)/(n!*(m-n)!)
        //donde m= len de elementosPosibles y n=tamano
        int m=elementosPosibles.length;
        int factorialM=1;
        for (int i = 1; i <= m; i++) {
            factorialM=factorialM*i;
        }
        int n=tamano;
        int factorialN=1;
        for (int i = 1; i <= n; i++) {
            factorialN=factorialN*i;
        }
        int factorialMN=1;
        for (int i = 1; i <= (m-n); i++) {
            factorialMN=factorialMN*i;
        }
        cantidadDeCartas=factorialM/(factorialN*factorialMN);
        return cantidadDeCartas;
    }
}
