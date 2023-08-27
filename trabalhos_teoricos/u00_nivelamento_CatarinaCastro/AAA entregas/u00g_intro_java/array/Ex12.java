/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler n números inteiros, mostrar a média e aqueles que são maiores que a média

import java.util.*;
import java.io.*;

public class Ex12 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;
        int media = 0;

        // Entrada de dados
        System.out.println("Quantos números serão inseridos?");
        n = in.nextInt();

        // Declaração do array + entrada de valores
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++){
            System.out.println("Elemento " + i);
            arr[i] = in.nextInt();
            media += arr[i];
        }

        // Cálculo de média
        media /= arr.length;

        // Mostra os números maiores que a média
        System.out.println("Os valores que são maiores que a média são: ");
        for(int i=0; i<arr.length; i++){
            if(arr[i] > media){
                System.out.print( arr[i] + " ");
            }
        }

        // Fechamento do Scanner
        in.close();

    }
}
