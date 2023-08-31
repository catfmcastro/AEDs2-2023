/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê uma string e checa se é um palindromo ou não, em C

#include <stdio.h>
#include <string.h>

// checa se a palavra é palindromo
int isPalindromo(char str[50]){
    // declaracao de variaveis
    int tam = strlen(str); // tamanho da string

    // compara os caracteres e checa se a palavra é palindromo
    for(int i=0; i<tam/2; i++){
        if(str[i] != str[tam-1-i]){
            return 0; // não é palindromo
        }
    }

    return 1; // é palindromo
}

int main (void){
    // declaracao de variaveis
    char str[50];
    int resp;

    // recebe várias entradas e checa se são palindromos
    while(strcmp(str, "FIM") != 0){
        // input
        scanf("%[^\n]%*c", str);

        // break
        if(strcmp(str, "FIM") == 0){
            break;
        }
        
        // chamada da função
        resp = isPalindromo(str);

        // imprime o resultado na tela
        if(resp == 0){
            printf("NAO\n");
        }
        else{
            printf("SIM\n");
        }
    }

    return 0;
}