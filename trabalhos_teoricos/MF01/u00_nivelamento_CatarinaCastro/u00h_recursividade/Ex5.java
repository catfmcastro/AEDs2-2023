/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que recebe uma string e retorna a sua quantidade de consoantes minúsculas.

import java.util.*;
import java.io.*;

public class Ex5 {
    // Mé
    public static int consoantesMinusculas(String arr, int tam){
        int cont = 0;

        if (tam < arr.length()){
            if ((arr.charAt(tam) == 'a' || arr.charAt(tam) == 'e' || arr.charAt(tam) == 'i' || arr.charAt(tam) == 'o' || arr.charAt(tam) == 'u' || arr.charAt(tam) == 'A' || arr.charAt(tam) == 'E' || arr.charAt(tam) == 'I' || arr.charAt(tam) == 'O' || arr.charAt(tam) == 'U') == false){
                if(Character.isUpperCase(arr.charAt(tam)) == false){
                    cont++;
                }
            }
            cont += consoantesMinusculas(arr, tam + 1);
        }
        return cont;
    }

    public static void main(String[] args){
        // Declaração de variáveis
        String arr = "Tccccc";
        int resp;

        // Chamada do método
        resp = consoantesMinusculas(arr, 0);

        // Imprime resposta
        System.out.println("A string possui " + resp + " consoantes minúsculas");
    }
}
