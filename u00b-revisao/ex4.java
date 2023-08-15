import java.util.Scanner;

/*
Unidade 00 - Nivelamento
Exercícios de Revisão

Catarina F. M. Castro - 803531

AEDs II
*/

// Imprime o maior e o menor elemento de uma array, fazendo menos comparações com os elementos da array

public class ex4 {

    public static void maiorMenor(int array[]) {
        int aux; // Variável auxiliar

        // Checa quais são os maiores e os menores números da array, por meio de um bubble sort
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++){
                if(array[j] > array[j+1]){
                    aux = array[j+1];
                    array[j+1] = array[j];
                    array[j] = aux;
                }
            }
        }

        // Imprime os resultados
        System.out.println("\nO maior número da array inserida é: " + array[0]);
        System.out.println("O menor número da array inserida é: " + array[array.length-1]);

    }

    public static void main(String[] args) throws Exception {
        // Declaração de variáveis
        int array[] = {1, 2, 3, 522, -35, 9, 10, -10, -9, -8 , -3, -6, 999};

        // Chamada do método
        maiorMenor(array);
    }
}

