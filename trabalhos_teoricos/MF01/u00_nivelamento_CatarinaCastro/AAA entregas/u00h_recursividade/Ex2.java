/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Recebe um array de números inteiros e um número N indicando o tamanho do array e retorne o maior elemento.

import java.util.*;
import java.io.*;

public class Ex2 {
    // Método que retorna o maior elemento
    public static int maior(int n, int[] arr, int i){
        int resp;
        if (i == n - 1){
            resp = arr[n - 1];
        } 
        else {
            resp = maior( n, arr, i + 1);

            if (resp < arr[i]){
                resp = arr[i];
            }
        }
        return resp;
    }

    public static void main(String[] args){
        // Declaração de variáveis
        int resp, n;
        int[] arr = {56, 87, 33, -2, 999, 8, 5, -53};

        // Tamanho do array
        n = arr.length;

        // Chamada do método
        resp = maior(n, arr, 0);

        // Imprime os resultados
        System.out.println("O maior número da array é: " + resp);
    }
}
