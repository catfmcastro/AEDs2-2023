/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que recebe um array de caracteres e retorne um valor booleano, que indica se esse é um palíndromo

import java.util.*;
import java.io.*;

public class Ex3 {
    // Método que checa se o array é um
    public static boolean palindromo(String arr, int tam){
        boolean resp;
        if (tam >= arr.length() / 2){
            resp = true;
        } 
        else if (arr.charAt(tam) != arr.charAt(arr.length() - 1 - tam)){
            resp = false;
        } 
        else {
            resp = palindromo(arr, (tam + 1));
        }
            return resp;
    }

    public static void main(String[] args){
        // Declaração de variáveis
        boolean resp;
        String arr = "hannah";

        // Checa o tamanho do array
        int tam = arr.length();

        // Chamada do método
        resp = palindromo(arr, tam);

        // Imprime os resultados
        if(resp == true){
            System.out.println("É palíndromo!");
        }
        else{
            System.out.println("Não é palídromo.");
        }

    }
}

