/* 
 Estudo sobre MergeSort
 
 Author: @catfmcastro
 Catarina F. M. Castro
*/

// divide o array sucessivas vezes pelo meio e ordena cada parte individualmente

package aulao_aedsII.aulao_20_09;

public class Mergesort {

    // imprime array
    public static void mostrar(int k, int[] array) {
		System.out.print("[");
		
		for (int i = 0; i < k+1; i++) {
         System.out.print(array[i] + " ");
		}
		
		System.out.println("]");
	}

    // chamada do sort
    static void sort(int esq, int dir, int[] array) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;

            sort(esq, meio, array); // ordena o lado esquerdo
            sort(meio + 1, dir, array); // ordena o lado direito
            intercalar(esq, meio, dir, array); // intercala os dois lados ordenados

        }
    }

    // intercala os dois lados do array
    static void intercalar(int esq, int meio, int dir, int[] array) {
        // definir tamanho dos dois subarrays
        int nEsq = (meio + 1) - esq;
        int nDir = dir - meio;

        // subarrays
        int[] arrayEsq = new int[nEsq + 1];
        int[] arrayDir = new int[nDir + 1];

        // sentinela no final dos dois arrays
        arrayEsq[nEsq] = arrayDir[nDir] = 0x7FFFFFFF;

        // contadores/indices
        int iEsq, iDir, i;

        // inicializar primeiro subarray
        for (iEsq = 0; iEsq < nEsq; iEsq++) {
            arrayEsq[iEsq] = array[esq + iEsq];
        }

        // Inicializar segundo subarray
        for (iDir = 0; iDir < nDir; iDir++) {
            arrayDir[iDir] = array[(meio + 1) + iDir];
        }

        // Intercalacao propriamente dita
        for (iEsq = iDir = 0, i = esq; i <= dir; i++) {
            array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
        }

    }

    // metodo principal
    public static void main (String[] args){
        // declaracao de variaveis
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int tam = array.length-1;

        // imprime o array nao ordenado
        mostrar(tam, array);

        // ordena o array com o mergesort
        sort(0, tam, array);

        // imprime o array ordenado
        mostrar(tam, array);

    }

}