/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma matriz com L linhas e com C colunas e mostrar os elementos em forma de grid.

import java.util.*;
import java.io.*;

public class Ex1 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int l, c;

        // Entrada de linhas
        System.out.println("Quantas linhas a matriz terá?: ");
        l = in.nextInt();

        // Entrada de colunas
        System.out.println("E quantas colunas?");
        c = in.nextInt();

        // Declaração da matriz
        int[][] mat = new int[l][c];

        // Preenchimento da matriz
        System.out.println("\n");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        // Mostra a matriz em grid
        System.out.println("\n\nA matriz inserida foi:");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        // Fechamento do Scanner
        in.close();
    }
}
