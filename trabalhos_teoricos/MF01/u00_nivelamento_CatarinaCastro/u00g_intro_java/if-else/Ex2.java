/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler três números reais e informar se o triângulo formado por esses valores é equilátero, isosceles ou escaleno

import java.util.*;
import java.io.*;

public class Ex2 {

    public static void main(String[] args){
        // Declaração do Scanner
        Scanner input = new Scanner(System.in);

        // Entrada de informações
        System.out.println("Insira um número inteiro: ");
        int x = input.nextInt();

        System.out.println("Insira outro número inteiro: ");
        int y = input.nextInt();

        System.out.println("Insira o último número inteiro: ");
        int z = input.nextInt();


        int[] array = {x, y, z};
        int aux;

        // Bubble sort para ordenação dos valores
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j]>array[j+1]){
                    aux = array[j+1];
                    array[j+1] = array [j];
                    array[j] = aux;
                }
            }
        }

        System.out.println("O menor valor inserido foi " + array[0] + " e o maior foi " + array[array.length-1]);

        input.close();
    }

}