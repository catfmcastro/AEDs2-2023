/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Recebe um array e ordena os elementos

import java.util.*;
import java.io.*;

public class Ex8 {
    public static void main(String[] args){
        // Declaração de variáveis
        int[] arr = {5, 6, 3, 4, 8, 9, 10, 2, 3, 1, 7};

        // Imprime o array não ordenado
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n\n");

        // Bubble sort
        for(int i=0; i<arr.length; i++){
            for(int j=0; (j+1)<arr.length; j++){
                if(arr[j] > arr[j+1]){
                    int aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }

        // Imprime o array ordenado
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
