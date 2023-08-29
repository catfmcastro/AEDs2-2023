/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler dois números reais cúbica do menor e o logaritmo do menos, considerando a base desse log o maior.

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Ex7 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);

        // Entrada de dados
        System.out.println("Insira um número: ");
        int x = in.nextInt();

        System.out.println("Insira outro número: ");
        int y = in.nextInt();

        // Checa qual número é maior e qual é menor
        int maior;
        int menor;

        if(x>y){
            maior = x;
            menor = y;
        }
        else{
            maior = y;
            menor = x;
        }

        System.out.println("A raiz cúbica do menor número é " + Math.cbrt(menor));
        System.out.println("O logaritmo do menor número (com o maior de base) é " +  Math.log(menor) / Math.log(maior));

        in.close();
    }
}
