/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Ler dois números. Se um deles for maior que 45, somar os dois. Caso contrário, se outro for maior que 20. subtraia o maior pelo o menor.
// Senão, se um deles for menor que 10 e o outro diferente de 0, realize a divisão do primeiro pelo segundo
// Se nenhum dos casos for válido, imprima seu nome na tela

import java.util.*;
import java.io.*;

public class Ex4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // Entrada de valores
        System.out.println("Insira um número: ");
        int x = in.nextInt();

        System.out.println("Insira outro número: ");
        int y = in.nextInt();

        if(x>45 || y>45){
            int soma = x+y;
            System.out.println("A soma dos dois números é: " + soma);
        }
        else if(x>20 && y>20){
            if(x>y){
                int subt = x-y;
                System.out.println("A subtração do maior pelo menor é: " + subt);
            }
            else{
                int subt = y-x;
                System.out.println("A subtração do maior pelo menor é: " + subt);
            }
        }
        else if((x>10 && y!=0) || (y>10 && x!=0)){
            if(x>10){
                int div = x/y;
                System.out.println("A divisão dos números é: " + div);
            }
            else{
                int div = y/x;
                System.out.println("A divisão dos números é: " + div);
            }
        }
        else{
            System.out.println("Catarina");
        }

        in.close();
    }
}
