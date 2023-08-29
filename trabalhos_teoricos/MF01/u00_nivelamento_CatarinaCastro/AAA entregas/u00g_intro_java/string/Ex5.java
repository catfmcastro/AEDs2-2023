/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma palavra e mostrar a primeira ocorrência da letra A

import java.util.*;
import java.io.*;

public class Ex5 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        int id = 0;

        // Entrada de String
        System.out.println("Insira uma palavra:");
        str = in.nextLine();

        // Conta o número de caracteres maíusculos
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'a') {
               id = i;
               i = str.length(); 
            }
        }

        // Imprime a resposta
        System.out.println("A letra A aparece pela primeira vez na posição " + id);

        // Fechamento do Scanner
        in.close();
    }
}

