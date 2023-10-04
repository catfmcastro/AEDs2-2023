/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Sorteia duas letras minúsculas aleatórias e substitui todas as ocorrencias da primeira pela segunda, em C

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// Função flag
int acabou(char *s) {
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char* alteracaoAleatoria(char *str1, char *str2, char c1, char c2, int i){

        if(i == strlen(str1)){
            // Finaliza a string
            str2[i] = '\0';
            return str2;
        }
        else{
            if (str1[i] == c1) {
                // Substituição de char
                str2[i] = c2;
            } else {
                // Não substitui o char
                str2[i] = str1[i];
            }
            return alteracaoAleatoria(str1, str2, c1, c2, (i+1));
        }

    return str2;
}

int main() {
    // Declaração de variáveis
    srand(4); // Define a seed 4 para a geração de números aleatórios
    char str1[500];
    char str2[500];

    while (1){
        // Input str1
        scanf("%[^\n]%*c", str1);
        str1[strcspn(str1, "\n")] = '\0'; // Remover a quebra de linha

        // Interrupção do loop
        if (acabou(str1)) {
            break;
        }

        // Gera caracteres aleatórios
        char c1 = 'a' + (rand() % 26);
        char c2 = 'a' + (rand() % 26);

        // Chamada da função
        alteracaoAleatoria(str1, str2, c1, c2, 0);

        // Imprime o resultado na saída
        printf("%s\n", str2);
    }

    return 0;
}
