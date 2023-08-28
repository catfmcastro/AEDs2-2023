/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e mostre se ela é um palindromo

import java.util.*;
import java.io.*;

public class Ex3 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        boolean resp = true;

        // Entrada de String
        System.out.println("Insira uma palavra:");
        str = in.nextLine();

        // Checa se a palavra é um palindromo
        for (int i = 0; i < str.length()/2; i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
            resp = false;
            i = str.length();
            }
        }

        // Imprime a resposta
        if(resp == true){
            System.out.println("É palindromo!");
        }
        else{
            System.out.println("Não é palindromo.");
        }

        // Fechamento do Scanner
        in.close();
    }
}
