import java.util.Scanner;

/*
Unidade 00 - Nivelamento
Exercícios de Revisão

Catarina F. M. Castro - 803531

AEDs II
*/

// Identifica se um número inteiro inserido está presente em uma array

public class ex1
{
    public static void main(String[] args)
    {
        // Declaração de variáveis
        int x;
        Scanner input = new Scanner(System.in);
        boolean temX = false;

        // Entrada do valor inteiro
        System.out.println("\nInsira um valor inteiro: ");
        x = input.nextInt();

        int[] array = {1, 2, 423, 534, 333, 8, -15, 79, 16};

        // Checa se x está no array
        for(int i = 0; i<array.length; i++){
            if(x == array[i]){
                temX = true;
                break;
            }
        }

        // Imprime o resultado
        if(temX == true)
        {
            System.out.println("\nO valor inserido está na array.");
        }
        else
        {
            System.out.println("\nO valor inserido NÃO está na array.");
        }

        // Fechamento de Scanner
        input.close();

    }

}