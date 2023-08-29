/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que recebe dois números inteiros e retorne a multiplicação do primeiro pelo segundo utilizando somas.

import java.util.*;
import java.io.*;

public class Ex1 {
    // Método recursivo para realizar a multiplicação
    public static int Multiplicacao(int x, int y){
        if( y == 0 ){
            return 0;
        }
        else{
            return x + Multiplicacao(x, (y-1));
        }
    }

    public static void main(String[] args){
        // Declaração de variáveis
        int resp = Multiplicacao(5, 3);

        // Imprime resposta
        System.out.println("Resultado: " + resp);
    }
}
