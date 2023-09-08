/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê uma string e checa se é um palindromo ou não (recursivamente, em C)

#include <stdio.h>
#include <string.h>

// Checa se a palavra é palindromo
int isPalindromo(char s[500], int i){
    // Declaracao de variaveis
    int resp = 0;
    int tam = strlen(s);

    if(i == tam){
        resp = 1; // é palindromo
        return resp;
    }
    else{
        if(s[i] == s[tam-1-i]){
            resp = 1;
            return isPalindromo(s, (i+1));
        }
        else{
            resp = 0;
            return resp; // não é palindromo
        }
    }
}

int main (){
    // Declaracao de variaveis
    char s[500];
    int resp;

    while(strcmp(s, "FIM") != 0){
        // Input
        scanf("%[^\n]%*c", s);

        // Chamada do método
        resp = isPalindromo(s, 0);

        // Interrupção do loop
        if(strcmp(s, "FIM") == 0){
            break;
        }

        // Imprime o resultado na saída
        if(resp == 0){
            printf("NAO\n");
        }
        else{
            printf("SIM\n");
        }
    }

    return 0;
}