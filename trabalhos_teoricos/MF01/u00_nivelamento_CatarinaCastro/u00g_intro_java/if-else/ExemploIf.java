import java.util.*;
import java.io.*;

/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Exemplo de uso do comando If Else

public class ExemploIf {

    public static void main(String[] args){
        // Declaração de variáveis
        Scanner input = new Scanner(System.in);
        float nota;    

        // Entrada de nota
        System.out.println("\nInsira a nota do aluno: ");
        nota = input.nextFloat();

        if(nota >= 80){
            System.out.println("\n\nParabéns, muito bom");
        }
        else if(nota >= 70 && nota < 80){
            System.out.println("\n\nParabéns, aprovado");
        }
        else{
            System.out.println("\n\nInfelizmente, reprovado");
        }

        input.close();
    }
}
