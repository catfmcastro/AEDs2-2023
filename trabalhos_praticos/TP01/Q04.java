/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Sorteia duas letras minúsculas aleatórias e substitui todas as ocorrencias da primeira pela segunda

package TP01;

import java.util.*;

public class Q04 {
    // Método para condição de parada das entradas
    public static boolean acabou(String s){
    
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    public static void main (String[] args){
        // Declaracao de variaveis
        Random gerador = new Random();
        gerador.setSeed(4);
        String str1 = "";
        
        while(!acabou(str1)){
            // Declaracao str2
            String str2 = "";

            // Entrada da String 1
            str1 = MyIO.readLine();

            // Interrupção do Loop
            if(acabou(str1)){
                break;
            }
            
            // Gerador de caractere aleatorio
            char c1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            // Gerador de caractere aleatorio
            char c2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            // Preenche str2 com os caracteres trocados
            for(int i = 0; i<str1.length(); i++){
                if(str1.charAt(i) == c1){
                    str2 += c2;
                }
                else{
                    str2 += str1.charAt(i);
                }
            }

            MyIO.println(str2);
        }

    }
}
