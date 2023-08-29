/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler um array com N elementos inseridos de forma ordenada e mostrar na tela de forma ordenada

import java.util.*;
import java.io.*;

public class Ex19 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos no 1º vetor?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            System.out.println("Elemento " + i);
            arr[i] = in.nextInt();
        }

        // Bubble sort
        int aux;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<(arr.length-1); j++){
                if(arr[j]>arr[j+1]){
                    aux = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = aux;
                }
            }
        }

        // Mostra o resultado na tela
        System.out.println("O array ordenado é: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        // Fechamento do Scanner
        in.close();

    }
}



