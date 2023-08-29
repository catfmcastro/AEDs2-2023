/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler a nota de 5 alunos e mostrar a média daqueles cuja nota é maior ou igual a 80

import java.util.*;
import java.io.*;

public class ExemploForIf {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        double[] notas = new double[5];
        double media = 0;
        int cont = 0;

        // Preenchimento do array
        for(int i=0; i<5; i++){
            System.out.println("Insira a nota do(a) aluno(a): ");
            notas[i] = in.nextDouble();
            if(notas[i]>=80){
                media += notas[i];
                cont++;
            }
        }

        // Cálculo de média
        media /= cont;

        // Resultado
        System.out.println("\nA média das notas dos alunos com nota acima de 80 é " + media);

        in.close(); // Fechamento do Scanner
    }
}
