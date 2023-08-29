/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Banco do Zé: valor max. da prestação = 40% do salário
// Entrar com o salário bruto e o valor da prestação, e informar se o empréstimo será concedido

import java.util.*;
import java.io.*;

public class Ex6 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        float sal;
        float valor;

        // Entrada de dados
        System.out.println("Insira seu salário: ");
        sal = in.nextFloat();

        float prestMax = sal * (0.4f);

        System.out.println("Insira o valor do empréstimo: ");
        valor = in.nextFloat();

        // Checa se o emprestimo será concedido
        if(valor > prestMax){
            System.out.println("O empréstimo não será concedido!");
        }
        else{
            System.out.println("O empréstimo será concedido!");
        }

        in.close();
    }
}
