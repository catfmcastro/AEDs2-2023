/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler a nota e o nome de 5 alunos e mostre na tela o nome daqueles que ficaram acima da média do grupo

import java.util.*;
import java.io.*;

public class ExemploArray {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        double[] notas = new double[5];
        String[] nomes = {"Alberto", "Bárbara", "Carolina", "Dias", "Eduardo"};
        double media = 0;

        // Preenchimento do array
        for(int i=0; i<5; i++){
            System.out.println("Insira a nota de " + nomes[i]);
            notas[i] = in.nextDouble();
            media += notas[i];
        }

        // Cálculo de média
        media /= 5;

        // Resultado
        System.out.println("\n Os alunos cuja nota está acima da média são:");

        for(int i=0; i<5; i++){
            if(notas[i] > media){
                System.out.print(nomes[i] + " ");
            }
        }

        in.close(); // Fechamento do Scanner
    }
}
