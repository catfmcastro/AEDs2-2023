/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N números, armazená-los em um array e mostrar todos na tela

import java.util.*;
import java.io.*;

public class Ex1 {
   public static void main(String[] args){
        // Declaração de variáveis
        int n;
        Scanner in = new Scanner(System.in);

        // Entrada
        System.out.println("Quantos números serão inseridos?: ");
        n = in.nextInt();

        // Declaração de array
        int[] array = new int[n];

        // Preenchimento da array
        System.out.println("Insira os valores do array: ");
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
        }

        // Mostra os números inseridos
        System.out.println("\nOs números inseridos foram:");
        for(int i=0; i<n; i++){
            System.out.print(array[i] + " ");
        }

        in.close();
   } 
}
