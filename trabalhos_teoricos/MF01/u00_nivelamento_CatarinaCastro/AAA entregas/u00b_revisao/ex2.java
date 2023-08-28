import java.util.Scanner;

/*
Unidade 00 - Nivelamento
Exercícios de Revisão

Catarina F. M. Castro - 803531

AEDs II
*/

// Identifica se um número inteiro inserido está presente em uma array, sabendo que a array está em ordem crescente

public class ex2
{
    // Método para checar se X está no array
    public static boolean buscaX(int[] array, int x) {
        int direita = array.length -1;
        int esquerda = 0;

        while(esquerda <= direita){
            int meio = esquerda + (direita - esquerda) / 2;

            if(array[meio] == x){
                return true; // Retorna true quando x está no array
            }
            else if(array[meio] < x){
                esquerda = meio + 1;
            }
            else if(array[meio] > x){
                direita = meio - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Declaração de variáveis
        int x;
        Scanner input = new Scanner(System.in);
        boolean temX;

        // Entrada do valor inteiro
        System.out.println("\nInsira um valor inteiro: ");
        x = input.nextInt();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        temX = buscaX(array, x);

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