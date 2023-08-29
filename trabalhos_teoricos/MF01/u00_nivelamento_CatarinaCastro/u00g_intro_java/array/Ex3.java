/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler n números e mostrar a soma do i-ésimo com o (2*i+i)-ésimo termo até que (2*i+i) < n

import java.util.*;
import java.io.*;

public class Ex3 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int resp = 0;

        // Entrada
        System.out.println("Quantos números serão inseridos?: ");
        int n = in.nextInt();

        // Declaração do array
        int[] numeros = new int[n];
        
        // Preenchimento do array
        for(int i=0; i<n; i++){
            System.out.println("Insira um número: ");
            numeros[i] = in.nextInt();
        }

        // Realização do cálculo
        for(int i=0; ((2*i)+1)<n; i++){
            resp += numeros[(2*i)+1];
        }

        // Resultado
        System.out.println("\nO resutlado é:" + resp);

        in.close(); // Fechamento do Scanner
    }
}
