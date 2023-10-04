/*
    Estudos Autônomos

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Teste com Binary Search

package estudos_java;

public class BinarySearch {

    public static int binarySearch(int[] vec, int num){
        int dir = vec.length - 1;
        int esq = 0;
        int meio;
        
        while(esq <= dir) {
            meio = (esq + dir)/2;
            
            if(num == vec[meio]){
                return meio;
            }
            else (num > vec[meio]){
                esq = meio + 1;
            }
            else if(num < vec[meio]){
                dir = meio - 1;
            }

            meio = (esq + dir)/2;
        }

        return -1; // número não encontrado

    }
    
    public static void main(String[] args) {
        // variáveis
        int[] vec = {1, 45, 6246, -2323, 999, 1000, 12342, 2};
    }
}
