/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma matriz com L linhas e com C colunas e mostrar os elementos da matriz transposta

import java.util.*;
import java.io.*;

public class Ex2 {
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
        int[][] matTrans = new int[c][l];

        // Preenchimento da matriz
        System.out.println("\n");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        // Preenchimento da matriz transposta
        for(int i=0; i<c; i++){
            for(int j=0; j<l; j++){
                matTrans[i][j] = mat[j][i];
            }
        }

        // Mostra a matriz em grid
        System.out.println("\n\nA matriz transposta é:");
        for(int i=0; i<c; i++){
            for(int j=0; j<l; j++){
                System.out.print(matTrans[i][j] + " ");
            }
            System.out.println();
        }

        // Fechamento do Scanner
        in.close();
    }
}
