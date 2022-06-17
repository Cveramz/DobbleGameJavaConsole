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
    
    //crear metodo que cree una carta.
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
        
    //Función para verificar si se contiene un elemento en un array.
    //Entrada: Una carta y un elemento a buscar.
    //Salida: Un booleano indicando si el elemento se encuentra en la carta.
    public static int contieneElemento(String[] carta, String elemento) {
        for (int i = 0; i < carta.length; i++) {
            if (carta[i].equals(elemento)) {
                return 1;
            }
        }
        return 0;
    }

    //crear un metodo que reciba un arreglo de elementosPosibles y que devuelva la cantidad de cartas que se pueden crear
    //considerando que no se pueden repetir elementos
    public static int cantidadDeCartas(int tamano, String[] elementosPosibles) {
        //vamos a usar la formula n^2+n+1
        //Donde n= tamano
        return ((tamano*tamano)+tamano+1);
    }
    
}