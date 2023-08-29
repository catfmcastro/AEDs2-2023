/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler duas matrizes com o mesmo número de linhas e colunas e mostrar a soma delas

import java.util.*;
import java.io.*;

public class Ex3 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int l, c;

        // Entrada de linhas
        System.out.println("Quantas linhas as matrizes terão?: ");
        l = in.nextInt();

        // Entrada de colunas
        System.out.println("E quantas colunas?");
        c = in.nextInt();

        // Declaração da matriz
        int[][] mat1 = new int[l][c];
        int[][] mat2 = new int[l][c];

        // Preenchimento da matriz 1
        System.out.println("\nInsira os elementos da Matriz 1");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat1[i][j] = in.nextInt();
            }
        }

        // Preenchimento da matriz 2
        System.out.println("\nInsira os elementos da Matriz 2");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.println("Elemento [" + i + "] [" + j + "]: ");
                mat2[i][j] = in.nextInt();
            }
        }

        // Mostra a soma das matrizes em grid
        System.out.println("\n\nA soma das matrizes é:");
        for(int i=0; i<l; i++){
            for(int j=0; j<c; j++){
                System.out.print((mat1[i][j] + mat2[i][j]) + " ");
            }
            System.out.println();
        }

        // Fechamento do Scanner
        in.close();
    }
}
