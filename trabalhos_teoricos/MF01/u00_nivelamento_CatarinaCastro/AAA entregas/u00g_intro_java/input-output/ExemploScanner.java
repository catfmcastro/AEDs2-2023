import java.util.Scanner;

/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Exemplo de uso da classe Scanner

public class ExemploScanner {

    public static void main(String[] args){
        // Declaração da variaveis
        Scanner input = new Scanner(System.in);
        String s;
        char c;
        int i;
        float f;

        // Entrada de valores
        System.out.println("\nInsira uma string: ");
        s = input.nextLine();

        System.out.println("\nInsira um caractere: ");
        c = input.nextLine().charAt(0);

        System.out.println("\nInsira um número inteiro: ");
        i = input.nextInt();

        System.out.println("\nInsira um número real: ");
        f = input.nextFloat();

        //Imprime os resultados
        System.out.println("\n\nOs valores inseridos foram: " + s + " " + i + " " + f + " " + c);

        input.close();
    }
}
