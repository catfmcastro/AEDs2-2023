/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler os elementos de uma array de tamanho N e mostrar a POSIÇÃO do menor elemento

import java.util.*;
import java.io.*;

public class Ex7 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n, menor = Integer.MAX_VALUE, id = 0;

        // Entrada do tamanho
        System.out.println("Insira o tamanho do array:");
        n = in.nextInt();

        // Declaração do array
        int[] arr = new int[n];

        // Checa qual é o menor número do array
        for(int i=0; i<n; i++){
            System.out.println("Insira o elemento " + i);
            arr[i] = in.nextInt();
            if(arr[i]<menor){
                menor = arr[i];
                id = i;
            }
        }

        // Imprime resposta
        System.out.println("O menor elemento do array está na posição " + id);

        in.close();
    }
    
}
