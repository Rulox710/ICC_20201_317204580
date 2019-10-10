import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Raúl Nuño Valdés
 * @date 9 Otubre 2019
 */
public class Control {

    /**
     * Método que decide si una palbra es palíndromo o no
     * @param String -La palabra a revisar
     */
    public static boolean problema1(String str) {
	char[]todo;  
        boolean a;
	boolean b = true;                                                    
        todo = new char[str.length()];
	
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            todo[i] = c;                                                
        }
	
        for (int i = 0; i < str.length(); i++) {
	    a = todo[i] == todo[str.length()-1-i]?true:false;           
	    b = b && a;
	    if(i==str.length()-1){
		//System.out.println("La palabra \"" + str + "\" es un palíndromo: " + b);
		}                                    
        }
	return b;
    }

    /**
     * Método que revisa si un número de una lista, sumado a otro de la lista, da como reultado un número de la lista
     * @param int[] -Una lista de enteros
     */
    public static boolean problema2(int[]argo) {
	for(int x = 0; x < argo.length; x++) {
            for(int y = 0; y < argo.length; y++) {
                for(int z = 0; z < argo.length; z++) {
		    if ((x != y) && (x != z) && (y != z)) {
			if (argo[x] + argo[y] == argo[z]) {
			    return true;
			}
		    }
                }
            }
        }
	//System.out.println("La suma de dos elementos es igual a otro elemento resulta ser: " + a);
	return false;
    }

    /**
     * Método que ordena una lista de enteros de menor a mayor
     * @param int[] -Una lista de enteros
     */
    public static void problema3(int[]albatros) {
	int p = 0;
	int[]listaB = new int[albatros.length];
	
        while (p < albatros.length) {                              
            for (int o = 1; o < albatros.length; o++) {
                for (int l = 0; l < albatros.length; l++) {
                    listaB[l] = albatros[l];
		}   
                if (albatros[o-1] <= albatros[o]) {
                    albatros[o-1] = listaB[o-1];
                    albatros[o] = listaB[o];
                } else {
                    albatros[o] = listaB[o-1];
                    albatros[o-1] = listaB[o];
                }
            }
            p++;
        }
    }

    /**
     * Método que busca si una lista tiene a un número en ella
     * @param int[] -Lista de enteros
     * @param int -Número a buscar
     */
    public static boolean problema4(int[]arreglo, int buscando) {
	problema3(arreglo);
	int medio = arreglo.length/2;
	int dm = arreglo.length/2;
	for (int i = 0; i < arreglo.length/2; i++) {
	    if (dm==0){
		dm =0;
	    }
	    if (dm == 1) {
		dm = 1;
	    } else {
		dm = dm/2;
	    }
	    if (buscando == arreglo[medio]) {
		return true;	
	    }
	    if (buscando < arreglo[medio]) {
		medio = medio - dm;
	    }
	    if (buscando > arreglo[medio]) {
		medio = medio + dm;
	    }
	}
	return false;
    }

    /**
     * Método que decide si un número es primo o no
     * @param int -Un numero cualquiera
     */
    public static boolean problema5(int duda) {
	double raiz = Math.sqrt(duda);
	int chequeo;
	if((int)raiz * (int)raiz == duda) {
	    return false;
	} else {
	    for (int i = 2; i < raiz; i++) {
		chequeo = duda / i;
		if (chequeo * i == duda){
		    return false;
		}
	    }
	}
	return true;
    }

    /**
     * Método que regresa una lista con todos los números primos anteriores a un número
     * @param int -Un número cualquiera
     */
    public static int[] problema6(int coco) {
	int cantidad = 0;
	for(int i = 0; i <= coco; i++) {
	    if(problema5(i)) {
		cantidad = cantidad + 1;
	    }
	}
	int f = 0;
	int[]coso = new int[cantidad];
	for (int i = 2; i <= coco; i++) {
	    if(problema5(i)) {
		coso[f] = i;
		f += 1;
	    }
	}
	return coso;
    }

    
    public static void main(String []args) {
	
	String resultado = "";
        int[] desordenado = {9,8,7,6,5,4,3,2,1};
        int[] ordenado    = {1,2,3,4,5,6,7,8,9};
        int[] primos10 = {2,3,5,7};
        if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
        if(problema2(desordenado)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
        problema3(desordenado);
        if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
        if(problema4(desordenado,2)== true && problema4(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
        if(problema5(7)==true && problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
        if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
        System.out.println(resultado);   
    }
}

