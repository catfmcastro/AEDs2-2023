/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// fila flexivel de registros de jogadores

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

// JOGADOR ---------------------------------------------------------------------------------------------------------------------
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
    Jogador aux = *jogador;
    return aux;
}

// imprime um jogador na tela
void imprimir(Jogador jogador, int pos) {
    // converte string em int
    int altura = atoi(jogador.altura);
    int peso = atoi(jogador.peso);
    int anoNascimento = atoi(jogador.anoNascimento);

    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", pos,
        jogador.nome, altura, peso, anoNascimento, jogador.universidade,
        jogador.cidadeNascimento, jogador.estadoNascimento);
}

char *linhaCsv(char *frase) {
    char noInfo[] = "nao informado";
    char *newfrase = malloc(sizeof(char) * 200);

    if (newfrase == NULL) {
        return NULL;
    }

    strcpy(newfrase, ""); // inicialização

    for (int i = 0; frase[i] != '\0'; i++) {
        if (frase[i] == ',' && frase[i + 1] == ',') {
            strcat(newfrase, ",");
            strcat(newfrase, noInfo);
        } else if (frase[i] == ',' && frase[i + 2] == '\0') {
            strcat(newfrase, ",");
            strcat(newfrase, noInfo);
        } else {
            char temp[2] = {frase[i], '\0'};
            strcat(newfrase, temp);
        }
    }

    return newfrase;
}

// add novo jogador
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

// metodo split
void split(const char *str, char flag, char tokens[8][100]) {
    int line = 0;
    int index = 0;

    while (line < 8) {
        int i = 0;
        while (1) {
            if (str[index] == flag || str[index] == '\0' || str[index] == '\n') {
                tokens[line][i] = '\0';
                break;
            }

            tokens[line][i] = str[index];
            i++;
            index++;
        }

        index++;
        line++;
    }
}

void swap(int *x, int *y) {
    int tmp = *x;
    *x = *y;
    *y = tmp;
}

// FILA FLEXIVEL ---------------------------------------------------------------------------------------------------------------------

typedef struct Celula {
  Jogador elemento;
  struct Celula *prox;
} Celula;

typedef struct Pilha {
  Celula *topo;
} Pilha;

void criarPilha(Pilha *pilha) {
  pilha->topo = NULL;
}

void remover(Pilha *pilha) {
  if (pilha->topo == NULL) {
    return;
  }

  printf("(R) %s\n", pilha->topo->elemento.nome);
  Celula *temp = pilha->topo;
  pilha->topo = pilha->topo->prox;
  free(temp);
}

void inserir(Jogador x, Pilha *Pilha) {
    Celula *tmp = malloc(sizeof(Celula));
    tmp->elemento = x;
    tmp->prox = Pilha->topo;
    Pilha->topo = tmp;
}

void calcularMedia(Jogador *pilha) {
    int media;
    int soma = 0;
    int quantidade = 0;
    for (; ; i = (i + 1) % 1000)
    {
        int altura = atoi(pilha[i].altura);
        soma += altura;
        quantidade++;
    }
    media = soma / quantidade;
    printf("%d\n", media);
}

// MAIN ---------------------------------------------------------------------------------------------------------------------

int main() {
    long start = clock();
    char csvData[600];
    Jogador jogadores[3922];

    // leitura de arquivo csv
    // /tmp/
    FILE *arq = fopen("players.csv", "r");
    fgets(csvData, sizeof(csvData), arq);
    for (int i = 0; fgets(csvData, 600, arq) != NULL; i++) {
        char *frase = linhaCsv(csvData);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        addJogador(&jogadores[i], dados);
    }

    // criação da pilha
    Pilha *Pilha = malloc(sizeof(Pilha)); 
    criarPilha(Pilha);
  
    // input
    for (int i = 0; 1; i++) {
        char input[100];
        scanf("%s", input);
        if (strcmp(input, "FIM") == 0) {
            break;
        }
        int id = atoi(input);
        inserir(jogadores[id],Pilha);             
        calcularMedia(Pilha);
    }

    int quantidade;
    scanf("%d", &quantidade);
  
    for (int i = 0; i < quantidade; i++) {
        char input[10];
        scanf("%s", input);

        if (strcmp(input, "I") == 0) {
        int id;
        scanf("%d", &id);
        inserir(jogadores[id],Pilha);

        calcularMedia(Pilha);
        }

        else if (strcmp(input, "R") == 0) {
        remover(Pilha);
        }
    }

    int count = 0;
    Celula *temp = Pilha->topo;
    while(temp != NULL){
        imprimir(temp->elemento, count);
        count++;
        temp = temp->prox;
    }

    fclose(arq);
    return 0;
}
