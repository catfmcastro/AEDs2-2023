/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e mostrar o número de caracteres, de letras, de não letras, de vogais e de consoantes.

import java.util.*;
import java.io.*;

public class Ex6 {

    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        int caracteres = 0, letras = 0, naoletras = 0, vogais = 0, consoantes = 0;

        // Entrada de String
        System.out.println("Insira uma String:");
        str = in.nextLine();

        // Conta quantos caracteres foram inseridos
        caracteres = str.length();

        // Conta o número de caracteres maíusculos
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                letras++;

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vogais++;
                }
                else{
                    consoantes++;
                }
            }
            else{
                naoletras++;
            }
        }

        // Imprime a resposta
        System.out.println("Foram inseridos " + caracteres + " caracteres, sendo " + letras + " letras e " + naoletras + " não letras. Dentre as letras, foram inseridas " + vogais + " vogais e " + consoantes + " consoantes.");

        // Fechamento do Scanner
        in.close();
    }
}
