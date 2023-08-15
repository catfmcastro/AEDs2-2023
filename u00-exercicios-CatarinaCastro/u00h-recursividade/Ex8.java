/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que executa T(0) = 1 e T(n) = T(n-1)^2

import java.util.*;
import java.io.*;

public class Ex8 {
    // Método que realiza os calculos
    public static int T(int n){
        if( n == 0){
            return 1;
        }
        else{
            return Math.pow(T(n), 2);
        }
    }

    public static void main(String[] args){
        // Chamada recursiva + declaração de variáveis
        int resp = T(10);

        // Imprime resposta
        System.out.println(resp);
    }
}


