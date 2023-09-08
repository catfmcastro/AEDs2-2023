/*
    Warm-up: Laboratório

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Recebe dois números inteiros e imprime a sua sequência espelho

package lab_06_09;

import java.util.*;

public class SequenciaEspelho {
    public static void main(String[] args){
        // Declaração de variaveis
        Scanner in = new Scanner(System.in);
        int n1;
        int n2;

        // Interrompe o Loop quando acabarem as entradas
        while(in.hasNext()){
            // Entrada de valores
            n1 = in.nextInt();
            n2 = in.nextInt();

            // Imprime o resultado
            for(int i = n1; i <= n2; i++){
                MyIO.print(i);
            }
            for(int i = n2; i >= n1; i--){
                int aux = i;
                while(aux>0){
                    MyIO.print(aux%10);
                    aux /= 10;
                }
            }

            MyIO.print("\n");

        }

        // Fechamento do Scanner
        in.close();
    }
}
