/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Cálculo da média das notas de 5 alunos

import java.util.*;
import java.io.*;

public class ExercicioWhile {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int[] notas = new int[5];
        int media = 0;

        // Entrada de notas
        for(int i=0; i<5; i++){
            System.out.println("Insira a nota do aluno(a): ");
            notas[i] = in.nextInt();
            media += notas[i];
        }

        // Cálculo de média
        media /= 5;

        System.out.println("\nA média das notas foi de " + media);

        in.close();

    }
}
