/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que receba um array de inteiros e os ordene

import java.util.*;
import java.io.*;

public class Ex6 {
    // Método que ordena o array
    public static void bubbleSort(int[] arr, int n){
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args){
        // Declaração de variáveis
        int[] arr = {5, 6, 8, 10, 2, 1, 3, 9, 4, 7};
        int n = arr.length;

        // Chamada da função
        bubbleSort(arr, n);

        // Imprime a resposta
        System.out.println("Array ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
