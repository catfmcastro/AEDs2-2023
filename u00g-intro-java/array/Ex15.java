/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N, ler um array de N inteiros e, em seguida, calcular e mostrar a quantia de elementos pares e de elementos divisíveis por três.

import java.util.*;
import java.io.*;

public class Ex15 {
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

            // Conta os elementos pares e os divisiveis por três
            if(arr[i] % 2 == 0){
                pares++;
            }
            else if(arr[i] % 3 == 0){
                portres++;
            }
        }

        // Mostra os resultados na tela
        System.out.println("O array contém: " + pares + " números pares e " + portres + " números divisíveis por três.");

        // Fechamento do Scanner
        in.close();

    }
}
