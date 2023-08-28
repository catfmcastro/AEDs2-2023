/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N números inteiros e mostrar na tela a soma daqueles que são múltiplos de três

import java.util.*;
import java.io.*;

public class Ex17 {
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

            // Soma os múltiplos de três
            if(arr[i] % 3 == 0){
                soma += arr[i];
            }
        }

        // Mostra resultado na tela
        System.out.println("A soma dos múltiplos de três é: " + soma);

        // Fechamento do Scanner
        in.close();

    }
}

