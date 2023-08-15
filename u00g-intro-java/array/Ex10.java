/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Declarar um vetor contento os inteiros 10, 5, 8, 2 e 8 e imprimir na tela

import java.util.*;
import java.io.*;

public class Ex10 {
   public static void main(String[] args){
    // Declaração do vetor
    int[] vetor = {10, 5, 8, 2, 8};

    // Imprime o vetor
    System.out.println("O vetor contém os seguintes números: ");
    for(int i=0; i<vetor.length; i++){
        System.out.print(vetor[i] + " ");
    }

   } 
}
