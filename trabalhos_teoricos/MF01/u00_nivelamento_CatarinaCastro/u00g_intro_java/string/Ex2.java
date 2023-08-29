/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e a converter para número inteiro

import java.util.*;
import java.io.*;

public class Ex2 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        int num = 0, aux;
        
        // Entrada da string
        System.out.println("Insira a String:");
        str = in.nextLine();

        // Converte a string para número
        for(int i=0; i<str.length(); i++){
            aux = (int)(str.charAt(i) - 48);
            aux *= (int)Math.pow(10, (str.length()- i - 1));
            num += aux;
        }

        // Imprime resposta
        System.out.println("Resposta: " + num);

        // Fechamento do scanner
        in.close();
    }
}

