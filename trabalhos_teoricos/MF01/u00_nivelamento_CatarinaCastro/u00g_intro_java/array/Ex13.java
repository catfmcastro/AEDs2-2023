/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N, ler os N elementos de um array e mostrar a soma de seus elementos pares

import java.util.*;
import java.io.*;

public class Ex13 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;
        int soma = 0;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            System.out.println("Elemento " + i);
            arr[i] = in.nextInt();

            // Soma os elementos pares
            if(arr[i] % 2 == 0){
                soma += arr[i];
            }
        }

        // Mostra na tela a soma dos valores pares
        System.out.println("A soma dos valores pares é: " + soma);

        // Fechamento do Scanner
        in.close();

    }
}
