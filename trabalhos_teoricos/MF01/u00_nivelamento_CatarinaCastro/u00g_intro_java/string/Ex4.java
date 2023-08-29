/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e mostra o número de caracteres e o número de caracteres maíusculos.

import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        int caracteres = 0, maisculos = 0;
        char c;

        // Entrada de String
        System.out.println("Insira uma String:");
        str = in.nextLine();

        // Conta quantos caracteres foram inseridos
        caracteres = str.length();

        // Conta o número de caracteres maíusculos
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                maisculos++;
            }
        }

        // Imprime a resposta
        System.out.println("Foram inseridos " + caracteres + " caracteres, sendo " + maisculos + " maiúsculos.");

        // Fechamento do Scanner
        in.close();
    }
}
