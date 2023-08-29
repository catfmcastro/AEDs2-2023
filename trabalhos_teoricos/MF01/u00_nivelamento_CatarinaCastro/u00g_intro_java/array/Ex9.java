/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler duas arrays e mostrar sua união e sua interseção

import java.util.*;
import java.io.*;

public class Ex9 {
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
            System.out.println("Elemento " + (i+1) + " do 1º array : ");
            arr1[i] = in.nextInt();
        }

        System.out.println("\nArray 2");
        for(int i=0; i<tam2; i++){
            System.out.println("Elemento " + (i+1) + " do 2º array : ");
            arr2[i] = in.nextInt();
        }

        // Criação dos Hashsets        
        Set <Integer> conj1 = new HashSet<>();
        for(int n : arr1){
            conj1.add(n);
        }
        
        Set <Integer> conj2 = new HashSet<>();
        for(int n : arr2){
            conj2.add(n);
        }

        // Declaração da União e Intersecção dos arrays
        Set <Integer> uniao = new HashSet<>(conj1);
        Set <Integer> inter = new HashSet<>(conj1);

        // Preenchimento da União e Intersecção
        uniao.addAll(conj2);
        inter.retainAll(conj2);

        // Imprime os elementos inseridos
        System.out.println("A união dos arrays é: " + uniao);
        System.out.println("A intersecção dos arrays é: " + inter);

        in.close(); // Fechamento do Scanner
    }
}
