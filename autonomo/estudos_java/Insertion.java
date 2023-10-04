/*
    Estudos Autônomos

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Teste com insertion Sort

package estudos_java;

public class Insertion {

    public static void insertion(int[] vec){
        for(int i = 1; i < vec.length; i++){  
            int temp = vec[i];
            int j = i - 1;

            while( j >= 0 && vec[j] > temp){
                vec [j+1] = vec[j];
                j = j - 1;
            }

            vec[j+1] = temp;
        }
    }

    public static void main(String[] args){
        // Declaração de variáveis
        int[] vec = {5, 7, 8, 9, 233, 1434, 3};

        for(int i = 0; i<vec.length; i++){
            System.out.print(vec[i] + " ");
        }

        insertion(vec);

        System.out.println();

        for(int i = 0; i<vec.length; i++){
            System.out.print(vec[i] + " ");
        }
    }
}
