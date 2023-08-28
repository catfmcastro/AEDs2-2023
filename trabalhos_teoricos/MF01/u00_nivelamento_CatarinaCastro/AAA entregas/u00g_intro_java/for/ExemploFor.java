/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Usando o comando for, ler a nota de 5 alunos e mostrar a média das mesmas

import java.util.*;
import java.io.*;

public class ExemploFor {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        double[] notas = new double[5];
        double media = 0;

        // Preenchimento do array
        for(int i=0; i<5; i++){
            System.out.println("Insira a nota do(a) aluno(a): ");
            notas[i] = in.nextDouble();
            media += notas[i];
        }

        // Cálculo de média
        media /= 5;

        // Resultado
        System.out.println("\nA média das notas inseridas é " + media);

        in.close(); // Fechamento do Scanner
    }    
}
