/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler a nota de 5 alunos e mostrar a menor, a soma e a média. 

import java.util.*;
import java.io.*;

public class Ex11 {
   public static void main(String[] args){
    // Declaração de variáveis
    Scanner in = new Scanner(System.in);
    double[] notas = new double[5];
    double soma=0, media=0, menor=Integer.MAX_VALUE;

    for(int i=0; i<notas.length; i++){
        // Entrada das notas dos alunos
        System.out.println("Insira a nota do " + (i+1) + "º aluno: ");
        notas[i] = in.nextDouble();

        // Soma das notas
        soma += notas[i];

        // Checa qual a menor nota
        if(notas[i] < menor){
            menor = notas[i];
        }
    }

    // Cálculo de média
    media = soma/5;

    System.out.println("A soma das notas foi " + soma + ", a média foi " + media + " e a menor nota foi " + menor + ".");

    // Fechamento do Scanner
    in.close();

   } 
}
