/*
Warm-up 02

Fila do Recreio

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

import java.util.*;

public class FilaDoRecreio {
    public static void main(String[] args) {
        int n; // numero dos casos de teste
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        while (n != 0) {
            // numero de alunos
            int m;
            m = sc.nextInt();

            // alunos por ordem de chegada
            int[] alunos = new int[m];
            for (int i = 0; i < m; i++) {
                alunos[i] = sc.nextInt();
            }

            // ordena o array decrescente
            int[] alunosSort = Arrays.copyOf(alunos, m);

            Arrays.sort(alunosSort);
            for (int i = 0; i < m / 2; i++) {
                int tmp = alunosSort[i];
                alunosSort[i] = alunosSort[m - 1 - i];
                alunosSort[m - 1 - i] = tmp;
            }

            // alunos que não trocaram de lugar
            int cont = 0;

            // compara os dois arrays
            for (int i = 0; i < m; i++) {
                if (alunos[i] == alunosSort[i]) {
                    cont++;
                }
            }

            System.out.println(cont);

            n--;
        }

        sc.close();
    }
}
