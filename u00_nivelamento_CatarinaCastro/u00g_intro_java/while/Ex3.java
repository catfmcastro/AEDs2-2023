/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Recebe um número N e mostra os N primeiros números de uma determinada sequência

import java.util.*;
import java.io.*;

public class Ex3 {
    public static void main(String[] args){
        // Inicialização das variáveis
        Scanner in = new Scanner(System.in);
        int[] seq = {1, 5, 12, 16, 23, 27, 34};
        int n;

        // Entrada de valor
        System.out.println("Insira um número inteiro: ");
        n = in.nextInt();

        // Inicialização do contador
        int i = 0;

        while(n > 0){
            System.out.println(seq[i]);
            n--;
            i++;
        }

        in.close();
    }
}