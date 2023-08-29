import java.util.Scanner;

/*
Unidade 00 - Nivelamento
Exercícios de Revisão

Catarina F. M. Castro - 803531

AEDs II
*/

// Imprime o maior e o menor elemento de uma array

public class ex3 {

    public static void maiorMenor(int array[]) {
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        // Checa quais são os maiores e os menores números da array
        for(int i=0; i<array.length; i++){
            if(array[i] > maior){
                maior = array[i];
            }
            else if(array[i]<menor){
                menor = array[i];
            }
        }

        // Imprime os resultados
        System.out.println("\nO maior número da array inserida é: " + maior);
        System.out.println("O menor número da array inserida é: " + menor);

    }

    public static void main(String[] args) throws Exception {
        // Declaração de variáveis
        int array[] = {1, 2, 3, 522, -35, 9, 10, -10, -9, -8 , -3, -6, 999};

        // Chamada do método
        maiorMenor(array);
    }
}

