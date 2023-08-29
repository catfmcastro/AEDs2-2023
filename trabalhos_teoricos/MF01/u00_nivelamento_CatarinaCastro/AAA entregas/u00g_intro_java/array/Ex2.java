/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler N números e mostrar quais deles são acima da média

import java.util.*;
import java.io.*;

public class Ex2 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int media = 0;
        
        // Entrada
        System.out.println("Quantos números serão inseridos?: ");
        int n = in.nextInt();
        
        // Declaração do array
        int[] numeros = new int[n];
        
        // Preenchimento do array
        for(int i=0; i<n; i++){
            System.out.println("Insira um número: ");
            numeros[i] = in.nextInt();
            media += numeros[i];
        }
        
        // Cálculo de média
        media /= n;

        // Resultado
        System.out.println("\nOs valores que estão acima da média são:");

        for(int i=0; i<n; i++){
            if(numeros[i] > media){
                System.out.print(numeros[i] + " ");
            }
        }

        in.close(); // Fechamento do Scanner
    }    
}
