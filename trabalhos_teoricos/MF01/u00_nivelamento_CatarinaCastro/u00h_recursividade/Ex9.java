/*
Unidade 00 - Nivelamento
Recursivdade

Catarina F. M. Castro - 803531

AEDs II
*/

// Solução recursiva para resolver o problema das Torres de Hanoi

import java.util.*;
import java.io.*;

public class Ex9 {
    // Método que executa as Torres de Hanoi
    public static void torresDeHanoi(int discos, int pinos, char origem, char destino, char aux) {
        if (discos == 1) {
            System.out.println("Mova o disco do pino " + origem + " para o pino " + destino);
            return;
        }

        torresDeHanoi(discos - 1, pinos, origem, aux, destino); // Chamada recursiva

        System.out.println("Mova o disco " + discos + " do pino " + origem + " para o pino " + destino);

        torresDeHanoi(discos - 1, pinos, aux, destino, origem); // Chamada recursiva
    }

    public static void main(String[] args) {
        // Declaração de variáveis
        int discos = 5;
        int pinos = 3;

        // Chamada do método
        torresDeHanoi(discos, pinos, 'A', 'C', 'B');
    }
}




