/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler duas arrays e mostrar os elementos intercalados

import java.util.*;
import java.io.*;

public class Ex6 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int tam1, tam2;
        int tamMaior;

        // Insira o tamanho dos vetores
        System.out.println("Insira o tamanho do 1º array:");
        tam1 = in.nextInt();

        System.out.println("Insira o tamanho do 2º array:");
        tam2 = in.nextInt();

        // Checa qual o maior tamanho
        if(tam1 > tam2){
            tamMaior = tam1;
        }
        else{
            tamMaior = tam2;
        }

        // Declaração dos arrays
        int[] arr1 = new int[tam1];
        int[] arr2 = new int[tam2];

        // Preenchimento dos arrays
        System.out.println("\nArray 1");
        for(int i=0; i<tam1; i++){
            System.out.println("Elemento " + (i+1) + " : ");
            arr1[i] = in.nextInt();
        }

        System.out.println("\nArray 2");
        for(int i=0; i<tam2; i++){
            System.out.println("Elemento " + (i+1) + " : ");
            arr2[i] = in.nextInt();
        }

        // Imprime os elementos inseridos
        System.out.println("\n\nOs elementos inseridos foram: ");
        for(int i=0; i<tamMaior; i++){
            if(i<tam1){
                System.out.println(arr1[i]);
            }
            if(i<tam2){
                System.out.println(arr2[i]);
            }
        }

        in.close(); // Fechamento do Scanner
    }
}
