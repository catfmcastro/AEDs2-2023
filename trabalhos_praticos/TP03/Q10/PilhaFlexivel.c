/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// pilha flexivel de registros de jogadores

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

// JOGADOR ---------------------------------------------------------------------------------------------------------------------

typedef struct Jogador
{
    int id;
    char nome[100];
    char altura[100];
    char peso[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

Jogador clone(Jogador *jogador)
{
    Jogador novo = *jogador;

    return novo;
}
void ler(Jogador *j, char *frase) {}

void imprimir(Jogador jogador, int pos)
{
    int altura = atoi(jogador.altura);
    int peso = atoi(jogador.peso);
    int anoNascimento = atoi(jogador.anoNascimento);

    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos,
           jogador.nome, altura, peso, anoNascimento, jogador.universidade,
           jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *linhaCsv(char *frase)
{
    char noInfo[] = "nao informado";
    char *novaFrase = malloc(sizeof(char) * 200);
    if (novaFrase == NULL)
    {
        return NULL;
    }

    strcpy(novaFrase, "");

    for (int i = 0; frase[i] != '\0'; i++)
    {
        if (frase[i] == ',' && frase[i + 1] == ',')
        {
            strcat(novaFrase, ",");
            strcat(novaFrase, noInfo);
        }
        else if (frase[i] == ',' && frase[i + 2] == '\0')
        {
            strcat(novaFrase, ",");
            strcat(novaFrase, noInfo);
        }
        else
        {
            char tmp[2] = {frase[i], '\0'};
            strcat(novaFrase, tmp);
        }
    }

    return novaFrase;
}

void addJogador(Jogador *jogador, char tokens[8][100])
{
    jogador->id = atoi(tokens[0]);

    strcpy(jogador->nome, tokens[1]);
    strcpy(jogador->altura, tokens[2]);
    strcpy(jogador->peso, tokens[3]);
    strcpy(jogador->universidade, tokens[4]);
    strcpy(jogador->anoNascimento, tokens[5]);
    strcpy(jogador->cidadeNascimento, tokens[6]);
    strcpy(jogador->estadoNascimento, tokens[7]);
}

void split(const char *str, char delimiter, char tokens[8][100])
{
    int l = 0;
    int index = 0;
    while (l < 8)
    {
        int i = 0;
        while (1)
        {
            if (str[index] == delimiter || str[index] == '\0' || str[index] == '\n')
            {
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

// PILHA ---------------------------------------------------------------------------------------------------------------------

typedef struct Celula
{
    Jogador elemento;
    struct Celula *prox;

} Celula;

typedef struct Pilha
{
    Celula *topo;
} Pilha;

void criarPilha(Pilha *pilha)
{
    pilha->topo = NULL;
}

void remover(Pilha *pilha)
{
    if (pilha->topo == NULL)
    {
        return;
    }

    printf("(R) %s\n", pilha->topo->elemento.nome);
    Celula *tmp = pilha->topo;
    pilha->topo = pilha->topo->prox;
    free(tmp);
}

void inserir(Jogador x, Pilha *pilha)
{
    Celula *novo = malloc(sizeof(Celula));
    novo->elemento = x;
    novo->prox = pilha->topo;
    pilha->topo = novo;
}

// MAIN ---------------------------------------------------------------------------------------------------------------------

int main(void)
{
    char csvData[600];
    Jogador jogadores[3922];

    // abertura csv
    FILE *arq = fopen("/tmp/players.csv", "r");
    fgets(csvData, sizeof(csvData), arq);
    for (int i = 0; fgets(csvData, 600, arq) != NULL; i++)
    {
        char *frase = linhaCsv(csvData);
        char dados[8][100];
        split(frase, ',', dados);
        free(frase);
        addJogador(&jogadores[i], dados);
    }

    // criacao pilha
    Pilha *Pilha = malloc(sizeof(Pilha));
    criarPilha(Pilha);

    for (int i = 0; 1; i++)
    {
        char entrada[100];
        scanf("%s", entrada);
        if (strcmp(entrada, "FIM") == 0)
        {
            break;
        }
        int id = atoi(entrada);
        inserir(jogadores[id], Pilha);
    }

    Celula *tmp = Pilha->topo;
    Jogador array[2000];

    int quantidade;
    scanf("%d", &quantidade);

    for (int i = 0; i < quantidade; i++)
    {
        char input[10];
        scanf("%s", input);

        if (strcmp(input, "I") == 0)
        {
            int id;
            scanf("%d", &id);
            inserir(jogadores[id], Pilha);
        }

        else if (strcmp(input, "R") == 0)
        {
            remover(Pilha);
        }
    }

    int count = 0;
    while (tmp != NULL)
    {
        array[count] = tmp->elemento;
        tmp = tmp->prox;
        count++;
    }

    for (int i = 0; i < count; i++)
    {
        imprimir(array[count - i - 1], i);
    }

    fclose(arq);
    return 0;
}
