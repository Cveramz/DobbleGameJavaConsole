package Cartas;

/*
Representa una carta y por tanto todas las operaciones que se pueden
realizar con una carta.
 */

public class Card {
    public void testCard () {
        System.out.println("CLASE CARD");
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
