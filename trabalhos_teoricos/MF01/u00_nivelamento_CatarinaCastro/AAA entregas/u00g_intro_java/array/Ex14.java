/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N, ler N elementos de uma array e encontrar a posição do menor elemento

import java.util.*;
import java.io.*;

public class Ex14 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;
        int posicaoMenor = 0, menor = Integer.MAX_VALUE;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            System.out.println("Elemento " + i);
            arr[i] = in.nextInt();
            if(arr[i] < menor){
                menor = arr[i];
                posicaoMenor = i;
            }
        }

        // Mostra na tela a soma dos valores pares
        System.out.println("A posição do menor elemento é: " + posicaoMenor);

        // Fechamento do Scanner
        in.close();

    }
}
