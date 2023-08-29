/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Recebe um número N e mostra os N primeiros números ímpares

import java.util.*;
import java.io.*;

public class Ex2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;

        System.out.println("Insira um número inteiro: ");
        n = in.nextInt();

        int i = 1;

        while(n > 0){
            if(i%2 != 0){
                System.out.println(i);
                n--;
            }
            i++;
        }

        in.close();
    }
}
