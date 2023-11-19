/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// lista duplamente encadeada de registros de jogadores, com ordenação de objetos pelo estado de nascimento utilizando o quicksort

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

// imprime um jogador na tela
void imprimir(Jogador jogador)
{
    printf("[%d ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n",
           jogador.id,
           jogador.nome,
           jogador.altura,
           jogador.peso,
           jogador.anoNascimento,
           jogador.universidade,
           jogador.cidadeNascimento,
           jogador.estadoNascimento);
}

// LISTA DUPLA ---------------------------------------------------------------------------------------------------------------------
int tam = 0;
Jogador lista[1000];

// void inserirInicio(Jogador J, Jogador array[]) {
//     for (int i = tam; i > 0; i--) {
//         array[i] = array[i - 1];
//     }
//     array[0] = J;
//     tam++;
// }

// void inserirFinal(Jogador J, Jogador array[]) {
//     array[tam] = J;
//     tam++;
// }

// void inserir(int posicao, Jogador J, Jogador array[]) {
//     for (int i = tam; i > posicao; i--) {
//         array[i] = array[i - 1];
//     }
//     array[posicao] = J;
//     tam++;
// }

// void removerInicio(Jogador array[]) {
//     Jogador tmp = array[0];
//     for (int i = 0; i < tam - 1; i++) {
//         array[i] = array[i + 1];
//     }
//     tam--;
//     printf("(R) %s\n", tmp.nome);
// }

// void removerFinal(Jogador array[]) {
//     Jogador tmp = array[tam - 1];
//     array[tam - 1] = (Jogador){0, '\0', 0, 0, '\0', 0, '\0', '\0'};
//     tam--;
//     printf("(R) %s\n", tmp.nome);
// }

// void remover(int pos, Jogador array[]) {
//     Jogador tmp = array[pos];
//     for (int i = pos; i < tam - 1; i++)
//     {
//         array[i] = array[i + 1];
//     }
//     array[tam - 1] = (Jogador){0, '\0', 0, 0, '\0', 0, '\0', '\0'};
//     tam--;
//     printf("(R) %s\n", tmp.nome);
// }

// QUICKSORT ---------------------------------------------------------------------------------------------------------------------

// array de ordenação
Jogador lista[1000];
int comp = 0;

// checa igualdade de strings
bool isIgual(char *str1, char *str2) {
    return strcmp(str1, str2) == 0;
}

// checa se uma string é maior que outra
bool isMaior(char *str1, char *str2) {
    return strcmp(str1, str2) > 0;
}

// encontra o id do elemento de menor NOME
int minIndex(int i, int j) {
    if (i == j) {
        return i;
    }
    comp++;

    int k = minIndex(i + 1, j);

    return (isMaior(lista[i].nome, lista[k].nome) ? k : i);
}

// encontra o id do elemento de menor NOME
int minName(int i, int j) {
    if (i == j) {
        return i;
    }
    comp++;
    int k = minIndex(i + 1, j);

    return (isMaior(lista[i].nome, lista[k].nome) ? k : i);
}

void swap(int x, int y) {
    Jogador tmp = lista[x];
    lista[x] = lista[y];
    lista[y] = tmp;
}

// QUICK SORT pelo estado de nascimento
void sort(int esq, int dir) {
    int i = esq, j = dir;
    Jogador pivo = lista[(dir + esq) / 2]; // declaracao do pivo

    comp++;
    while (i <= j) {
    while ((strcmp(lista[i].estadoNascimento, "nao informado") == 0 ? __INT_MAX__ : strcmp(lista[i].estadoNascimento, pivo.estadoNascimento)) < 0 
        || (strcmp(lista[i].estadoNascimento, pivo.estadoNascimento) == 0 && strcmp(lista[i].nome, pivo.nome) < 0)) {
            i++;
        }

        while ((strcmp(lista[j].estadoNascimento, "nao informado") == 0 ? __INT_MAX__ : strcmp(lista[j].estadoNascimento, pivo.estadoNascimento)) > 0 
        || (strcmp(lista[j].estadoNascimento, pivo.estadoNascimento) == 0 && strcmp(lista[j].nome, pivo.nome) > 0)) {
            j--;
        }

        comp++;
        if (i <= j) {
            swap(i, j);
            i++;
            j--;
        }
    }
    comp++;
    if (esq < j) {
        sort(esq, j);
    }
    comp++;
    if (i < dir) {
        sort(i, dir);
    }
}


// MAIN ---------------------------------------------------------------------------------------------------------------------
clock_t startTime, endTime, tempo;

// criacao do arquivo de log
void criarLog() {
    const char *nomeArquivo = "803531_quicksort2.txt";
    char content[100];
    snprintf(content, sizeof(content), "803531\t%d", comp);
    double duracao = (double)(tempo) / CLOCKS_PER_SEC;
    snprintf(content + strlen(content), sizeof(content) - strlen(content), "\t%.2f", duracao);
    FILE *arquivo = fopen(nomeArquivo, "w");

    if (arquivo == NULL) {
        printf("Não foi possível abrir o arquivo para escrita.\n");
    }

    fputs(content, arquivo);
    fclose(arquivo);
}

int main (void) {
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

    
    // input de jogadores
    for (int i = 0; 1; i++) {
        char input[100];
        scanf("%s", input);
        if (strcmp(input, "FIM") == 0) {
            break;
        } else {
            int id = atoi(input);
            lista[i] = clone(&jogadores[id]);
            tam++;
        }
    }

    // selection sort
    startTime = clock();
    sort(0, tam-1);
    endTime = clock();
    tempo = endTime - startTime;

    criarLog();

    // saida
    for (int i = 0; i < tam; i++) {
        imprimir(lista[i]);
    }

    // fechamento arquivo
    fclose(arq);

    return 0;
}
