/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler dois vetores, um N elementos e o outro com M, e os mostrar de forma intercalada

import java.util.*;
import java.io.*;

public class Ex18 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n, m, maior;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos no 1º vetor?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr1 = new int[n];

        for(int i=0; i<arr1.length; i++){
            System.out.println("Elemento " + i);
            arr1[i] = in.nextInt();
        }

        // Entrada de dados
        System.out.println("\nQuantos números serão inseridos no 2º vetor?");
        m = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr2 = new int[m];

        for(int i=0; i<arr2.length; i++){
            System.out.println("Elemento " + i);
            arr2[i] = in.nextInt();
        }

        // Checa qual array é o maior
        if(n > m){
            maior = n;
        }
        else{
            maior = m;
        }

        // Mostra os vetores intercalados
        for(int i=0; i<maior; i++){
            System.out.print(arr1[i] + " " + arr2[i] + " ");
        }

        // Fechamento do Scanner
        in.close();

    }
}


