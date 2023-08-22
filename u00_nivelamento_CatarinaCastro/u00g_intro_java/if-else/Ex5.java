/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Jogo de futebol: ver o número de gols do mandante e do visitante a checar quem ganhou

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
        // Declaração de variáveis
        Scanner in = new Scanner(System.in);
        int mandante, visitante;

        // Entrada de dados
        System.out.println(" Insira o número de gols do mandante: ");
        mandante = in.nextInt();

        System.out.println(" Insira o número de gols do vistante: ");
        visitante = in.nextInt();

        // Checa qual time ganhou e imprime na tela
        if(visitante>mandante){
            System.out.println("Visitante ganhou!!");
        }
        else{
            System.out.println("Mandante ganhou!!");
        }

        in.close();
    }
}
