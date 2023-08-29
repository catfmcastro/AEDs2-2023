/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler três números reais e informar se o triângulo formado por esses valores é equilátero, isosceles ou escaleno

import java.util.*;
import java.io.*;

public class Ex1 {

    public static void main(String[] args){
        // Declaração do Scanner
        Scanner input = new Scanner(System.in);

        // Entrada de informações
        System.out.println("Insira um lado do triângulo: ");
        int x = input.nextInt();

        System.out.println("Insira outro lado do triângulo: ");
        int y = input.nextInt();

        System.out.println("Insira o último lado do triângulo: ");
        int z = input.nextInt();

        if( x == y && y == z){
            System.out.println("\nO triângulo é equilátero!");
        }
        else if ((x == y && x != z) || (x == z && x != y) || (y == z && y != x)){
            System.out.println("\nO triângulo é isosceles!");
        }
        else{
            System.out.println("\nO triângulo é escaleno!");
        }

        input.close();
    }

}