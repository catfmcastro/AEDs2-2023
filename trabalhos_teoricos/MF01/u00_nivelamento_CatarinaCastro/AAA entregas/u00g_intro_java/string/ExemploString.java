/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e um char e mostrar quantas vezes esse char aparece dentro da string

import java.util.*;
import java.io.*;

public class ExemploString {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        char c;
        int cont = 0;
    
        // Entrada da string
        System.out.println("Insira a String:");
        str = in.nextLine();

        // Entrada de char
        System.out.println("Insira o caractere que deseja procurar:");
        c = in.next().charAt(0);

        // Checa quantas vezes o char apareceu na string
        for(int i=0; i<str.length(); i++){
            if(c == str.charAt(i)){
                cont++;
            }
        }

        // Mostra o resultado
        System.out.println("O caractere apareceu " + cont + " vezes na string inserida.");

        // Fechamento do scanner
        in.close();
    }
}
