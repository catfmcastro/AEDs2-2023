/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Receber um número N e mostrar o N-ésimo número na sequência de Fibonacci

import java.util.*;
import java.io.*;

public class Ex5 {
    // Método para cálculo de Fibonacci
    public static int Fibonacci(int n){

        if(n <= 0){
            return 0;
        }
        else if (n == 1){
            return 1; // Retorna 1, para iniciar a sequência de Fibonacci
        }
        else {
            // Declaração de variáveis
            int x = 0;
            int y = 1;
            int fib = 0;

            for(int i=2; i<=n; i++){
                fib = x+y;
                x = y;
                y = fib;
            }
            return fib;
        }
    }
    
    public static void main(String[] args){
        // Declaração de variáveis
        int n;
        Scanner in = new Scanner(System.in);

        // Entrada
        System.out.println("Insira um número: ");
        n = in.nextInt();

        // Chamada do método
        int resp = Fibonacci(n);

        // Resposta
        System.out.println("Na sequência de Fibonacci, o " + n + "º número é " + resp);

        in.close();
    }
}
