/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler os elementos de uma array e mostrar o maior elemento da array

import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int maior = Integer.MIN_VALUE;

        // Entrada
        System.out.println("Quantos números serão inseridos?: ");
        int n = in.nextInt();

        // Declaração do array
        int[] numeros = new int[n];
        
        // Preenchimento do array
        for(int i=0; i<n; i++){
            System.out.println("Insira um número: ");
            numeros[i] = in.nextInt();
            if(numeros[i] > maior){
                maior = numeros[i];
            }
        }

        // Resultado
        System.out.println("\nO maior número da array é " + maior);

        in.close(); // Fechamento do Scanner
    }
}
