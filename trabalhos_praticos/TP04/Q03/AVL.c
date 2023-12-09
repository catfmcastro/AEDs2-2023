/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// árvore binária de árvores binárias, com inserções de objetos jogador com base no atributo nome

#include <stdio.h>
#include <string.h>

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

// JOGADOR ------------------------------------------------------------------------------------------------------------
typedef struct Jogador {
    int id;
    char nome[100];
    char altura[100];
    char peso[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

Jogador clone(Jogador *jogador) {
    Jogador novo = *jogador;
    return novo;
}

void ler(Jogador *j, char *frase) {}

void imprimir(Jogador jogador, int pos) {
    int altura = atoi(jogador.altura);
    int peso = atoi(jogador.peso);
    int anoNascimento = atoi(jogador.anoNascimento);

    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos,
           jogador.nome, altura, peso, anoNascimento, jogador.universidade,
           jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *linhaCsv(char *frase) {
    char noInfo[] = "nao informado";
    char *novaFrase = malloc(sizeof(char) * 200);
    if (novaFrase == NULL) {
        return NULL;
    }

    strcpy(novaFrase, "");

    for (int i = 0; frase[i] != '\0'; i++) {
        if (frase[i] == ',' && frase[i + 1] == ',') {
            strcat(novaFrase, ",");
            strcat(novaFrase, noInfo);
        } else if (frase[i] == ',' && frase[i + 2] == '\0') {
            strcat(novaFrase, ",");
            strcat(novaFrase, noInfo);
        } else {
            char tmp[2] = {frase[i], '\0'};
            strcat(novaFrase, tmp);
        }
    }

    return novaFrase;
}

void addJogador(Jogador *jogador, char tokens[8][100]) {
    jogador->id = atoi(tokens[0]);
    strcpy(jogador->nome, tokens[1]);
    strcpy(jogador->altura, tokens[2]);
    strcpy(jogador->peso, tokens[3]);
    strcpy(jogador->universidade, tokens[4]);
    strcpy(jogador->anoNascimento, tokens[5]);
    strcpy(jogador->cidadeNascimento, tokens[6]);
    strcpy(jogador->estadoNascimento, tokens[7]);
}

void split(const char *str, char delimiter, char tokens[8][100]) {
    int l = 0;
    int index = 0;
    while (l < 8) {
        int i = 0;
        while (1) {
            if (str[index] == delimiter || str[index] == '\0' || str[index] == '\n') {
                tokens[l][i] = '\0';
                break;
            }
            tokens[l][i] = str[index];
            i++;
            index++;
        }
        index++;
        l++;
    }
}

// ARVORE ------------------------------------------------------------------------------------------------------------
typedef struct No {
    Jogador elemento;
    No *esq, *dir;g
}No;

// MAIN ------------------------------------------------------------------------------------------------------------
int main(int argc, char const *argv[])
{

    return 0;
}
