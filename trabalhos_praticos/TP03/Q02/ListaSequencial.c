/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// lista sequencial de registros de jogadores

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

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

int tam = 0;

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

// LISTA --------------------------------------------------------------------------------------------------------------------

void inserirInicio(Jogador J, Jogador array[]) {
    for (int i = tam; i > 0; i--) {
        array[i] = array[i - 1];
    }
    array[0] = J;
    tam++;
}

void inserirFinal(Jogador J, Jogador array[]) {
    array[tam] = J;
    tam++;
}

void inserir(int posicao, Jogador J, Jogador array[]) {
    for (int i = tam; i > posicao; i--) {
        array[i] = array[i - 1];
    }
    array[posicao] = J;
    tam++;
}

void removerInicio(Jogador array[]) {
    Jogador tmp = array[0];
    for (int i = 0; i < tam - 1; i++) {
        array[i] = array[i + 1];
    }
    tam--;
    printf("(R) %s\n", tmp.nome);
}

void removerFinal(Jogador array[]) {
    Jogador tmp = array[tam - 1];
    array[tam - 1] = (Jogador){0, '\0', 0, 0, '\0', 0, '\0', '\0'};
    tam--;
    printf("(R) %s\n", tmp.nome);
}

void remover(int pos, Jogador array[]) {
    Jogador tmp = array[pos];
    for (int i = pos; i < tam - 1; i++)
    {
        array[i] = array[i + 1];
    }
    array[tam - 1] = (Jogador){0, '\0', 0, 0, '\0', 0, '\0', '\0'};
    tam--;
    printf("(R) %s\n", tmp.nome);
}

// MAIN ---------------------------------------------------------------------------------------------------------------------
int main (void) {
    long start = clock();
    char csvData[600];
    Jogador jogadores[3922];

    // leitura de arquivo csv
    // /tmp/
    FILE *arq = fopen("/tmp/players.csv", "r");
    fgets(csvData, sizeof(csvData), arq);
    for (int i = 0; fgets(csvData, 600, arq) != NULL; i++) {
        char *frase = linhaCsv(csvData);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        addJogador(&jogadores[i], dados);
    }

    Jogador *lista;
    lista = malloc(sizeof(Jogador) * 1000);
    int size = 0;
    
    // input de jogadores
    for (int i = 0; 1; i++) {
        size = i;
        char input[100];
        scanf("%s", input);
        if (strcmp(input, "FIM") == 0) {
            break;
        } else {
            int id = atoi(input);
            tam++;
            lista[i] = clone(&jogadores[id]);
        }
    }

    // comandos
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        char comando[10];
        scanf("%s", comando);

        if (strcmp(comando, "II") == 0) {
            int id;
            scanf("%d", &id);
            inserirInicio(jogadores[id], lista);
        } else if (strcmp(comando, "IF") == 0) {
            int id;
            scanf("%d", &id);
            inserirFinal(jogadores[id], lista);
        } else if (strcmp(comando, "I*") == 0) {
            int pos, id;
            scanf("%d %d", &pos, &id);
            inserir(pos, jogadores[id], lista);
        } else if (strcmp(comando, "RI") == 0) {
            removerInicio(lista);
        } else if (strcmp(comando, "RF") == 0) {
            removerFinal(lista);
        }
        else if (strcmp(comando, "R*") == 0) {
            int pos;
            scanf("%d", &pos);
            remover(pos, lista);
        }
    }

    // saida
    for (int i = 0; i < tam; i++) {
        imprimir(lista[i], i);
    }

    // fechamento arquivo
    fclose(arq);

    return 0;
}