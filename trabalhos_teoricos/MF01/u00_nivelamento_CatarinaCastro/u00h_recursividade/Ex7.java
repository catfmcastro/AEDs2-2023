/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Método recursivo que executa T(0) = 1, T(1) = 2 e T(n) = T(n-1)*T(n-2)-T(n-1)

import java.util.*;
import java.io.*;

public class Ex7 {
    // Método que realiza os calculos
    public static int T(int n){
        if(n == 0){
            return 1;
        }
        else if(n == 1){
            return 2;
        }
        else{
            return T(n-1) * T(n-2) - T(n-1);
        }        
    }

    public static void main(String[] args){
        // Chamada recursiva + declaração de variáveis
        int resp = T(10);

        // Imprime resposta
        System.out.println(resp);
    }
}

