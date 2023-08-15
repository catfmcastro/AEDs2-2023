/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler os elementos de uma matriz e mostrar sua média

import java.util.*;
import java.io.*;

public class Ex5 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int l, c, quant;
        int media = 0;

        // Entrada de linhas
        System.out.println("Quantas linhas a matriz terá?: ");
        l = in.nextInt();

        // Entrada de colunas
        System.out.println("E quantas colunas?");
        c = in.nextInt();

        // Declaração da matriz
        int[][] mat = new int[l][c];
        quant = l*c; // Calculo da quantidade de elementos da matriz

        // Preenchimento da matriz
        System.out.println("\n");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat[i][j] = in.nextInt();
                media += mat[i][j];
            }
        }

        // Cálculo de média
        media /= quant;

        // Mostra a matriz em grid
        System.out.println("\n\nA média dos elementos da matriz é: " + media);

        // Fechamento do Scanner
        in.close();
    }
}

