/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Inserir 10 valores, e imprimir o maior e o menor

import java.util.*;
import java.io.*;

public class Ex8 {
    public static void main(String[] args){
        // Declaração do Scanner
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        
        // Preenchimento da array
        for(int i=0; i<array.length; i++){
            System.out.println("Insira um número inteiro: ");
            array[i] = input.nextInt();
        }
        
        // Bubble sort para ordenação dos valores
        int aux;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j]>array[j+1]){
                    aux = array[j+1];
                    array[j+1] = array [j];
                    array[j] = aux;
                }
            }
        }

        // Imprime
        System.out.println("O maior valor inserido foi " + array[array.length-1] + " e o menor foi " + array[0]);

        input.close();
    }
}
