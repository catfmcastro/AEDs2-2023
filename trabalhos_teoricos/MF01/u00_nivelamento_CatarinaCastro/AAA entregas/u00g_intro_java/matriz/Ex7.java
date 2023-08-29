/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler os elementos de uma matriz e mostrar a média dos elementos de cada coluna

import java.util.*;
import java.io.*;

public class Ex7 {
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
        quant = l;

        // Preenchimento da matriz
        System.out.println("\n");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        // Calcula a média e mostra na tela
        System.out.println("\nA média dos elementos de cada coluna é:");
        for(int j=0; j<c; j++){
            for(int i=0; i<l; i++){
                media += mat[i][j];
            }
            media /= quant;
            System.out.println(media);
            media = 0;
        }

        // Fechamento do Scanner
        in.close();
    }
}



