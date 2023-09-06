/*
    Warm-up: Laboratório

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ler duas strings e combina-las, alterando as suas letras

#include <stdio.h>
#include <string.h>

int main (void){
    // Declaração de variáveis
    char str1[60];
    char str2[60];
    int maior;

    while (scanf("%s", str1) != EOF) {
        // Entrada das strings
        scanf("%s", str1);
        scanf("%s", str2);

        // Combinação das duas strings
        char conc[120];

        // Declaração de variaveis
        int i, j, k;
        i = j = k = 0;

        // Salva o resultado na string conc
        while(str1[i] != '\0' || str2[j] != '\0'){
            // Se str1 ainda nao tiver acabado, salva o char em conc[k] a incrementa os contadores
            if(str1[i] != '\0'){
                conc[k] = str1[i];
                i++;
                k++;
            }

            // Se str2 ainda nao tiver acabado, salva o char em conc[k] a incrementa os contadores
            if(str2[j] != '\0'){
                conc[k] = str2[j];
                j++;
                k++;
            }
        }

        // Finaliza string conc
        conc[k] = '\0';
    
        // Imprime o resultado na tela
        printf("%s\n", conc);
    }

    return 0;
}