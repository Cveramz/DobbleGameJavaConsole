package DobbleOperaciones;
import Cartas.*;

//import java.util.List;
//import java.util.ArrayList;


/*
Representa el conjunto de cartas y todas las operaciones que se
pueden realizar sobre estas.
Ej: obtener la n-esima carta, convertir un set en string, buscar
cartas faltantes, conocer la cantidad de elementos requeridos, total de cartas
a partir de una carta de muestra, etc.)
 */

public class Dobble {
    //public String[][] Cardset;

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


    //Metodo para contar la cantidad de elementos que se repiten entre dos cartas.
    //Entrada: Dos cartas.
    //Salida: Un entero indicando la cantidad de elementos que se repiten.
    public static int cantidadRepetidosPar(String[] Carta1, String[] Carta2) {
        String[] elementos = new String[Carta1.length*2];
        //vamos a agregar los elementos de la carta 1 a elementos.
        for (int i = 0; i < Carta1.length; i++) {
            elementos[i] = Carta1[i];
        }
        //agregar elementos de la carta 2 a elementos.
        for (int i = 0; i < Carta2.length; i++) {
            elementos[i+Carta1.length] = Carta2[i];
        }

        //ahora vamos a ir trabajando solo con el arreglo elementos.
        int[] elementosRepetidos = new int[elementos.length];
        //llenarlo de ceros.
        for (int i = 0; i < elementosRepetidos.length; i++) {
            elementosRepetidos[i] = 0;
        }
        //contar elementos repetidos desde su posición hasta el final, si se repite sumar 1.
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i+1; j < elementos.length; j++) {
                if (elementos[i].equals(elementos[j])) {
                    elementosRepetidos[i]++;
                }
            }
        }
        //crear suma de repetidos.
        int sumaRepetidos = 0;
        for (int i = 0; i < elementosRepetidos.length; i++) {
            sumaRepetidos += elementosRepetidos[i];
        }
        return sumaRepetidos;
    }

    //Metodo para encontrar el elemento repetido. Este se usará cuando CantidadRepetidosPar sea igual a 1.
    //Entrada: Dos cartas.
    //Salida: Un string indicando el elemento repetido.
    public static String getRepetido(String[] Carta1, String[] Carta2) {
        String[] elementos = new String[Carta1.length*2];
        //vamos a agregar los elementos de la carta 1 a elementos.
        for (int i = 0; i < Carta1.length; i++) {
            elementos[i] = Carta1[i];
        }
        //agregar elementos de la carta 2 a elementos.
        for (int i = 0; i < Carta2.length; i++) {
            elementos[i+Carta1.length] = Carta2[i];
        }

        //ahora vamos a ir trabajando solo con el arreglo elementos.
        int[] elementosRepetidos = new int[elementos.length];
        //llenarlo de ceros.
        for (int i = 0; i < elementosRepetidos.length; i++) {
            elementosRepetidos[i] = 0;
        }
        //contar elementos repetidos desde su posición hasta el final, si se repite sumar 1.
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i+1; j < elementos.length; j++) {
                if (elementos[i].equals(elementos[j])) {
                    elementosRepetidos[i]++;
                }
            }
        }
        //retornar el elemento en la posición n. Donde n es el índice donde se encuentre 1 en elementosRepetidos.
        for (int i = 0; i < elementosRepetidos.length; i++) {
            if (elementosRepetidos[i] == 1) {
                return elementos[i];
            }
        }
        return "";
    }

    //Metodo arreglar el set de cartas.
    //Entrada: Un set de cartas.
    //Salida: Un set de cartas arregladas.
    public static String[][] arreglarSet(String[][] set, String[] elementosPosibles) {
        //crear un array de strings que represente el set de cartas.
        String[][] setArreglado = new String[set.length][];
        for (int i = 0; i < set.length; i++) {
            setArreglado[i] = new String[set[i].length];
        }
        //copiar el set a setArreglado.
        for (int i = 0; i < set.length; i++) {
            for (int j = 0; j < set[i].length; j++) {
                setArreglado[i][j] = set[i][j];
            }
        }
        String elementoARepetir = "";

        //Primero vamos a arreglar la segunda carta en caso que no hayan repetidos en 1 y 2.
        if (cantidadRepetidosPar(set[0], set[1]) == 0 || cantidadRepetidosPar(set[0], set[1])>1) {
            //Si es cero o mayor a 1, debemos cambiar la carta i+1 hasta que cantidadRepetidosPar sea 1.
            int comprobador = 0;
            while (comprobador == 0){
                set[1] = Card.crearCarta(set[0].length, elementosPosibles);
                if (cantidadRepetidosPar(set[0], set[1]) == 1) {
                    comprobador = 1;
                }
            }
        }
        //si ya está arreglado guardaremos el elemento repetido en elementoARepetir.
        if (cantidadRepetidosPar(set[0], set[1]) == 1) {
            //obtener el elemento repetido.
            elementoARepetir = getRepetido(set[0], set[1]);
        }


        //ahora iremos verificando entre pares de carta.
        for (int i = 0; i < set.length-1; i++) {
            if (cantidadRepetidosPar(set[i], set[i+1]) == 0 || cantidadRepetidosPar(set[i], set[i+1])>1) {
                //Si es cero o mayor a 1, debemos cambiar la carta i+1 hasta que cantidadRepetidosPar sea 1.
                int comprobador = 0;
                while (comprobador == 0){
                    set[i+1] = Card.crearCarta(set[i].length, elementosPosibles);
                    if (cantidadRepetidosPar(set[i], set[i+1]) == 1) {
                        comprobador = 1;
                    }
                }
            }
            if (cantidadRepetidosPar(set[i], set[i+1]) == 1) {
                //Si igual a 1 verificar que se encuentre el elemento a repetir en el set[i+1].
                int comprobador = 0;
                while (comprobador == 0){
                    if (Card.contieneElemento(set[i+1], elementoARepetir) == 1) {
                        comprobador = 1;
                    }
                    else{
                        set[i+1] = Card.crearCarta(set[i].length, elementosPosibles);
                    }
                }
            }
        }


        return set;
    }


    //Generar un set de cartas.
    //Entrada: Cantidad de cartas, cantidad elementos.
    //Salida: Un set de cartas.
    public static String[][] generarSet(int tamanoSet, int cantidadElementos){
        String[] elementosPosibles = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        //int tamanoCartas = 5;
        //int cantidadElementos = 4;
        String[][] set = new String[tamanoSet][];

        set = setDeCartas(tamanoSet, cantidadElementos, elementosPosibles);
        set = arreglarSet(set, elementosPosibles);
        return set;
    }
    

    //Método que obtiene la n-ésima carta de un set.
    //Entrada: Un set de cartas y un entero n.
    //Salida: Una carta.
    public static String[] getCarta(String[][] set, int n){
        return set[n];
    }


   

}

    