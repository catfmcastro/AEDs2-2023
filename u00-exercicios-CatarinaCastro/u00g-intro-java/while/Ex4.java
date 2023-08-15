/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler um inteiro N que indica a nota máxima de uma prova + Ler a nota de 20 alunos (de valores entre 0 e N)
// Mostrar a média da turma + o número de alunos cuja nota foi menor que 60% + o numero de alunos acima de 90%

import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n, abaixo = 0, acima = 0;
        int media = 0;
        int[] notas = new int[20];

        // Entrada de dados
        System.out.println("Insira a nota máxima da prova: ");
        n = in.nextInt();

        // Entrada de notas dos alunos
        for(int i=0; i<20; i++){
            System.out.println("Insira a nota do aluno: ");
            notas[i] = in.nextInt();
            media += notas[i];

            if(notas[i]<(n*0.6)){
                abaixo++;
            }

            if(notas[i]>(n*0.9)){
                acima++;
            }
        }

        // Cálculo de média
        media /= 20;

        System.out.println("A média da turma foi de " + media + " pontos, com " + abaixo + " alunos abaixo de 60% e " + acima + " alunos acima de 90%.");

        in.close();
    }
}
