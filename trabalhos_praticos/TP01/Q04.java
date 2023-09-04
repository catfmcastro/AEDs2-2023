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
        String str1 = "";

        gerador.setSeed(4);
        System.out.println((char)('a' + (Math.abs(gerador.nextInt()) % 26)));
    }
}
