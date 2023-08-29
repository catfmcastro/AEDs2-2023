/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma matriz quadrada (com n linhas e n colunas) e mostrar as diagonais principais e secundárias

import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int n;

        // Entrada de linhas e colunas
        System.out.println("Quantas linhas e colunas a matrize terá?: ");
        n = in.nextInt();

        // Declaração da matriz
        int[][] mat = new int[n][n];

        // Preenchimento da matriz
        System.out.println("\nInsira os elementos da matriz");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat[i][j] = in.nextInt();
            }
        }

        // Mostra a diagonal das matrizes em grid
        System.out.println("\n\nDiagonal principal:");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j){
                    System.out.print(mat[i][j] + " ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("\nDiagonal secundária:");
        for(int i=0; i<n; i++){
            for(int j=(n-1); j>=0; j--){
                if(i == j){
                    System.out.print(mat[i][j] + " ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Fechamento do Scanner
        in.close();
    }
}

