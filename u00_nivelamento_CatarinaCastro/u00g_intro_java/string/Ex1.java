/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler uma string e checar se ela é composta apenas por dígitos

import java.util.*;
import java.io.*;

public class Ex1 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        String str;
        boolean resp = true;
    
        // Entrada da string
        System.out.println("Insira a String:");
        str = in.nextLine();

        // Checa se a string é composta somente por dígitos
        for(int i=0; i<str.length(); i++){
            if((str.charAt(i) >= '0' && str.charAt(i) <= '9') == false){
                resp = false;
                i = str.length();
            }
        }

        // Mostra o resultado
        if(resp == true){
            System.out.println("A string é composta apenas por dígitos!");
        }
        else{
            System.out.println("A string NÃO é composta apenas por dígitos.");
        }

        // Fechamento do scanner
        in.close();
    }
}
