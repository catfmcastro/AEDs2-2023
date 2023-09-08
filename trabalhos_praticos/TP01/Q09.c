/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ler um inteiro n que indica o número de valores reais que serão lidos e salvos em um arquivo texto. Fechar o arquivo
// Reabrir o arquivo e utilizar e mostrar os valores lidos na tela, em ordem inversa

#include <stdio.h>
#include <stdlib.h>

int main (void){
    // Declaração de variáveis
    int n;
    FILE *arq = fopen("arq.txt", "w");

    // Input
    scanf("%d", &n);
    
    // Mensagem de erro
    if(arq == NULL){
        printf("Erro ao abrir o arquivo\n");
        return 1;
    }

    // Entrada de n valores no arquivo
    for(int i = 0; i<n; i++){
        double num;
        scanf("%lf", &num);
        fwrite(&num, sizeof(double), 1, arq);       
    }

    // Fechamento do arquivo
    fclose(arq);

    // Reabertura do arquivo
    arq = fopen("arq.txt", "r");

    // Mendagem de erro
    if(arq == NULL){
        printf("Erro ao abrir o arquivo\n");
        return 1;
    }

    // Percorre o arquivo e imprime resultado na saída
    for(int i = 0; i<n; i++){
        // Posiciona o ponteiro no final do arquivo
        fseek(arq, (n - i - 1) * sizeof(double), SEEK_SET);

        // Leitura dos números reais
        double num;
        fread(&num, sizeof(double), 1, arq);

        // Var auxiliar
        int aux = (int) num;

        // Imprime o resultado na saída
        if(num - aux == 0){
            printf("%d\n", aux);
        }
        else{
            printf("%g\n", num);
        }
    }

    // Fechamento do arquivo
    fclose(arq);

    return 0;
}