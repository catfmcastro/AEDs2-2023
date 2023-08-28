/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N números inteiros, e mostrar na tela a soma do 1º e do último, do 2º e do penultimo...

import java.util.*;
import java.io.*;

public class Ex16 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;
        int pares = 0, portres = 0;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            System.out.println("Elemento " + i);
            arr[i] = in.nextInt();
        }

        // Realiza os cálculos e mostra na tela
        int i=0, j=(arr.length) - 1;
        while( i <= j){
            System.out.println("Soma do elemento " + i + " com o elemento " + j + ": " + (arr[i] + arr[j]));
            i++;
            j--;
        }

        // Fechamento do Scanner
        in.close();

    }
}

