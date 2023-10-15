/*
Trabalho Prático 02

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// pesquis binaria em C, em um arquivo csv de jogadores da nba

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

typedef struct Jogador {
    // declaracao dos atributos
    int id;
    char nome[60];
    int altura;
    int peso;
    char universidade[60];
    int anoNascimento;
    char cidadeNascimento[60];
    char estadoNascimento[60];
} Jogador;

// getters e setters

int getId(Jogador jogador) {
    return jogador.id;
}

void setId(Jogador *jogador, int novoId) {
    jogador->id = novoId;
}

char *getNome(Jogador jogador) {
    return strdup(jogador.nome);
}

void setNome(Jogador *jogador, char *novoNome) {
    strncpy(jogador->nome, novoNome, sizeof(jogador->nome));
    jogador->nome[sizeof(jogador->nome) - 1] = '\0';
}

int getAltura(Jogador jogador) {
    return jogador.altura;
}

void setAltura(Jogador *jogador, int novaAltura) {
    jogador->altura = novaAltura;
}

int getPeso(Jogador jogador) {
    return jogador.peso;
}

void setPeso(Jogador *jogador, int novoPeso) {
    jogador->peso = novoPeso;
}

char *getUniversidade(Jogador jogador) {
    return strdup(jogador.universidade);
}

void setUniversidade(Jogador *jogador, char *novaUniversidade) {
    strncpy(jogador->universidade, novaUniversidade, sizeof(jogador->universidade));
    jogador->universidade[sizeof(jogador->universidade) - 1] = '\0';
}

int getAnoNascimento(Jogador jogador) {
    return jogador.anoNascimento;
}

void setAnoNascimento(Jogador *jogador, int novoAnoNascimento) {
    jogador->anoNascimento = novoAnoNascimento;
}

char *getCidadeNascimento(Jogador jogador) {
    return strdup(jogador.cidadeNascimento);
}

void setCidadeNascimento(Jogador *jogador, char *novaCidadeNascimento) {
    strncpy(jogador->cidadeNascimento, novaCidadeNascimento, sizeof(jogador->cidadeNascimento));
    jogador->cidadeNascimento[sizeof(jogador->cidadeNascimento) - 1] = '\0';
}

char *getEstadoNascimento(Jogador jogador) {
    return strdup(jogador.estadoNascimento);
}

void setEstadoNascimento(Jogador *jogador, char *novoEstadoNascimento) {
    strncpy(jogador->estadoNascimento, novoEstadoNascimento, sizeof(jogador->estadoNascimento));
    jogador->estadoNascimento[sizeof(jogador->estadoNascimento) - 1] = '\0';
}

// imprime jogador na saída
void imprimir(Jogador jogador) {
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
           getId(jogador),
           getNome(jogador),
           getAltura(jogador),
           getPeso(jogador),
           getAnoNascimento(jogador),
           getUniversidade(jogador),
           getCidadeNascimento(jogador),
           getEstadoNascimento(jogador));
}

Jogador clone(Jogador jogador) {
    return jogador;
}

// declaracao de array de jogadores
Jogador jogadores[3922];
int ultimoJogador = 1;

// array para ser ordenado
Jogador arrSort[200];
int nArrJogadores = 0;

// complexidade do algoritmo
int comp = 0;
clock_t startTime, endTime, tempo;

// salva dados da string em objetos
void ler(char *data) {
    Jogador jogador;
    int j = 0;
    char info[60];
    int i = 0;

    // set id
    while (data[i] != ',') {
        info[j++] = data[i];
        i++;
    }
    info[j++] = '\0';
    setId(&jogador, atoi(info));

    // set nome
    j = 0;
    info[j] = '\0';
    i++;
    while (data[i] != ',')
    {
        info[j++] = data[i];
        i++;
    }
    info[j++] = '\0';
    setNome(&jogador, info);

    // set altura
    j = 0;
    info[j] = '\0';
    i++;
    while (data[i] != ',')
    {
        info[j++] = data[i];
        i++;
    }
    info[j++] = '\0';
    setAltura(&jogador, atoi(info));

    // set peso
    j = 0;
    info[j] = '\0';
    i++;
    while (data[i] != ',')
    {
        info[j++] = data[i];
        i++;
    }
    info[j++] = '\0';
    setPeso(&jogador, atoi(info));

    // set uni
    j = 0;
    info[j] = '\0';
    if (data[++i] == ',')
    {
        strcpy(info, "nao informado\0");
    }
    else
    {
        while (data[i] != ',')
        {
            info[j++] = data[i];
            i++;
        }
        info[j++] = '\0';
    }
    setUniversidade(&jogador, info);

    // set ano nascimento
    j = 0;
    info[j] = '\0';
    i++;
    while (data[i] != ',')
    {
        info[j++] = data[i];
        i++;
    }
    info[j++] = '\0';
    setAnoNascimento(&jogador, atoi(info));

    // set cidade nascimento
    j = 0;
    info[j] = '\0';
    if (data[++i] == ',')
    {
        strcpy(info, "nao informado\0");
    }
    else
    {
        while (data[i] != ',')
        {
            info[j++] = data[i];
            i++;
        }
        info[j++] = '\0';
    }
    setCidadeNascimento(&jogador, info);

    // set estado nascimento
    j = 0;
    info[j] = '\0';
    if (++i == strlen(data) - 1)
    {
        strcpy(info, "nao informado\0");
    }
    else
    {
        while (i != strlen(data) - 1)
        {
            info[j++] = data[i];
            i++;
        }
        info[j++] = '\0';
    }
    setEstadoNascimento(&jogador, info);

    // adiciona jogador no array de objetos
    jogadores[ultimoJogador++] = jogador;
}

// checa igualdade de strings
bool isIgual(char *str1, char *str2) {
    return strcmp(str1, str2) == 0;
}

// checa se uma string é maior que outra
bool isMaior(char *str1, char *str2) {
    return strcmp(str1, str2) > 0;
}

// pesquisa binaria
bool search(char *key) {
    int esq = 0;
    int dir = nArrJogadores - 1;
    int meio;
    while (esq <= dir)
    {
        comp++;
        meio = (esq + dir) / 2;
        if (isIgual(getNome(arrSort[meio]), key))
        {
            comp++;
            return true;
        }
        else if (isMaior(getNome(arrSort[meio]), key))
        {
            comp++;
            dir = meio - 1;
        }
        else
        {
            comp++;
            esq = meio + 1;
        }
    }
    return false;
}

// metodo swap
void swap(int x, int y) {
    Jogador tmp = arrSort[x];
    arrSort[x] = arrSort[y];
    arrSort[y] = tmp;
}

// ordenacao de objetos
void ordernarSelecao() {
    for (int i = 0; i < nArrJogadores; i++) {
        int menor = i;
        for (int j = i + 1; j < nArrJogadores; j++) {
            if (isMaior(getNome(arrSort[menor]), getNome(arrSort[j]))) {
                menor = j;
            }
        }

        swap(menor, i);
    }
}

// leitura de arquivo csv
void lerCsv(char *path) {
    // abertura do arquivo
    FILE *arq = fopen(path, "r");
    if (arq == NULL) {
        perror("Erro ao abrir o arquivo");
    }

    char linha[1024];
    int isPrimeiraLinha = true;

    // le cada linha e salva como objeto
    while (fgets(linha, sizeof(linha), arq)) {
        if (!isPrimeiraLinha) {
            ler(linha);
        } else {
            isPrimeiraLinha = false;
        }
    }

    // fechamento do arquivo
    fclose(arq);
}

// detecta flag de fim de entradas
bool isFim(char leitura[]) {
    if (leitura[0] == 'F' && leitura[1] == 'I' && leitura[2] == 'M') {
        return true;
    } else {
        return false;
    }
}

// criacao do arquivo de log
void criaLog() {
    const char *nomeArquivo = "803531_binaria.txt";
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

// FUNÇÃO MAIN
int main() {
    // /tmp/
    lerCsv("/tmp/playersAtualizado.csv");

    // entradas
    bool flag = true;
    while (flag) {
        char leitura[2000];
        scanf(" %[^\n]s", leitura);
        if (isFim(leitura)) {
            flag = false;
        } else {
            arrSort[nArrJogadores++] = jogadores[atoi(leitura) + 1];
        }
    }

    // ordenacao do array
    ordernarSelecao();

    // pesquisa binaria propriamente dita
    bool flagSearch = true;
    startTime = clock();
    while (flagSearch) {
        char leitura[2000];
        scanf(" %[^\n]s", leitura);
        if (isFim(leitura)) {
            flagSearch = false;
        } else {
            //imprime o resultado na tela
            printf("%s\n", search(leitura) ? "SIM" : "NAO");
        }
    }
    endTime = clock();

    // criacao do arquivo de log
    criaLog();

    return 0;
}