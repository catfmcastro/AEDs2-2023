/*
Warm-up 02

Bingo

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

#include <stdio.h>

int main(int argc, char const *argv[])
{
    int n; // numero de cartelas
    int k; // numero de valores por cartela
    int u; // valor maximo

    // leitura de valores
    scanf("%d", &n);
    scanf("%d", &k);
    scanf("%d", &u);

    int cartelas[n][k]; // matriz com todas as cartelas
    int sorteio[u]; // numeros sorteados
    int cont [n]; // conta os numeros sorteados de cada cartela

    // preenchimento
    for (int i = 0; i < n; i++) {
        cont[i] = 0;
        for (int j = 0; j < k; j++) {
            scanf("%d", &cartelas[i][j]);
        }
    }

    for (int i = 0; i < u; i++) {
        scanf("%d", &sorteio[i]);
    }

    // cartelas vencedoras
    for (int z = 0; z < u; z++) {

        for (int i = 0; i < n; i++) {
            int tmp = sorteio[z];
            for (int j = 0; j < k; j++) {
                if (cartelas[i][j] == tmp) {
                    cont[i]++;
                    if (cont[i] == k) {
                        printf("%d", i+1);

                        // interrupcao do loop
                        j = k;
                        z = u;
                        i = n;
                    }
                }
            }
        }

    }


    return 0;
}

