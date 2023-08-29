/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que recebe uma string e retorna um número inteiro indicando a quantidade de vogais do mesmo

import java.util.*;
import java.io.*;

public class Ex4 {
    // Método que conta as vogais do array
    public static int isVogal(String arr, int tam){
        int cont = 0;

        if (tam < arr.length()){
            if (arr.charAt(tam) == 'a' || arr.charAt(tam) == 'e' || arr.charAt(tam) == 'i' || arr.charAt(tam) == 'o' || arr.charAt(tam) == 'u' || arr.charAt(tam) == 'A' || arr.charAt(tam) == 'E' || arr.charAt(tam) == 'I' || arr.charAt(tam) == 'O' || arr.charAt(tam) == 'U'){
            cont++;
            }
            cont += isVogal(arr, tam + 1);
        }
        return cont;

    }

    public static void main(String[] args){
        // Declaração de variáveis
        String arr = "testando vogais";
        int resp;

        // Chamada do método
        resp = isVogal(arr, 0);

        // Imprime resposta
        System.out.println("A string possui " + resp + " vogais.");
    }
}