/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// árvore alv em C, com inserções de objetos jogador com base no atributo nome

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

// JOGADOR ------------------------------------------------------------------------------------------------------------
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

// ARVORE ------------------------------------------------------------------------------------------------------------
int comp = 0;
typedef struct No
{
    Jogador *elemento;
    struct No *esq;
    struct No *dir;
} No;

typedef struct Arvore
{
    No *raiz;
} Arvore;

No *balancEsq(No *raiz);
No *balancDir(No *raiz);

No *iniciarRaiz(Jogador *x)
{
    No *no = (No *)malloc(sizeof(No));
    no->elemento = x;
    no->esq = NULL;
    no->dir = NULL;
    return no;
}

void inicializar(Arvore *arvore)
{
    arvore->raiz = NULL;
}

int getAltura(No *raiz)
{
    int h = 0;
    if (raiz == NULL)
    {
        h = 0;
        comp++;
    }
    else
    {
        comp++;
        int alturaDir = (raiz->dir) ? getAltura(raiz->dir) : 0;
        int alturaEsq = (raiz->esq) ? getAltura(raiz->esq) : 0;
        h = (alturaEsq > alturaDir) ? alturaEsq + 1 : alturaDir + 1;
    }
    return h;
}

No *balancEsq(No *raiz)
{
    if (getAltura(raiz->dir->esq) > getAltura(raiz->dir->dir))
    {
        raiz->dir = balancDir(raiz->dir);
    }
    comp++;
    No *tmp = raiz->dir;
    raiz->dir = tmp->esq;
    tmp->esq = raiz;
    return tmp;
}

No *balancDir(No *raiz)
{
    if (getAltura(raiz->esq->dir) > getAltura(raiz->esq->esq))
    {
        raiz->esq = balancDir(raiz->esq);
    }
    comp++;
    No *tmp = raiz->esq;
    raiz->esq = tmp->dir;
    tmp->dir = raiz;
    return tmp;
}

No *balancear(No *raiz)
{
    int calc = getAltura(raiz->dir) - getAltura(raiz->esq);
    if (calc > 1)
    {
        raiz = balancEsq(raiz);
    }
    else if (calc < -2)
    {
        raiz = balancDir(raiz);
    }

    return raiz;
}

void balancear2(No *raiz)
{
    if (raiz != NULL)
    {
        comp++;
        raiz = balancear(raiz);
        balancear2(raiz->esq);
        balancear2(raiz->dir);
    }
}

No *inserir2(No *raiz, Jogador *jogador)
{
    if (raiz == NULL)
    {
        comp++;
        raiz = iniciarRaiz(raiz);
    }
    else if (strcmp(jogador->nome, raiz->elemento->nome) < 0)
    {
        comp += 2;
        raiz->esq = inserir2(raiz->esq, jogador);
        raiz = balancear(raiz);
    }
    else
    {
        comp += 2;
        raiz->dir = inserir2(raiz->dir, jogador);
        raiz = balancear(raiz);
    }

    return raiz;
}

void inserir(Arvore *arvore, Jogador jogador)
{
    Jogador *x = (Jogador *)malloc(sizeof(Jogador));
    *x = jogador;

    arvore->raiz = inserir2(arvore->raiz, x);
}

void pesquisar(No *raiz, char *nome)
{
    if (raiz == NULL)
    {
        comp++;
        printf(" NAO\n");
    }
    else if (strcmp(nome, raiz->elemento->nome) == 0)
    {
        comp += 2;
        printf(" SIM\n");
    }
    else if (strcmp(nome, raiz->elemento->nome) < 0)
    {
        comp += 3;
        printf(" esq");
        pesquisar(raiz->esq, nome);
    }
    else
    {
        comp += 3;
        printf(" dir");
        pesquisar(raiz->dir, nome);
    }
}

void pesquisar(Arvore *arvore, char *nome)
{
    printf("%s raiz", nome);
    pesquisar(arvore->raiz, nome);
}

// MAIN ------------------------------------------------------------------------------------------------------------
clock_t startTime, endTime, tempo;

// criacao do arquivo de log
void criarLog()
{
    const char *nomeArquivo = "803531_avl.txt";
    char content[100];
    snprintf(content, sizeof(content), "803531\t%d", comp);
    double duracao = (double)(tempo) / CLOCKS_PER_SEC;
    snprintf(content + strlen(content), sizeof(content) - strlen(content), "\t%.2f", duracao);
    FILE *arquivo = fopen(nomeArquivo, "w");

    if (arquivo == NULL)
    {
        printf("Não foi possível abrir o arquivo para escrita.\n");
    }

    fputs(content, arquivo);
    fclose(arquivo);
}

int main(void)
{
    long start = clock();
    char csvData[600];
    Jogador jogadores[3922];

    // leitura de arquivo csv
    // /tmp/
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

    Arvore *arvore = malloc(sizeof(Arvore));
    inicializar(arvore);

    // input de jogadores
    char input[100];
    for (int i = 0; 1; i++)
    {
        scanf("%s", input);
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }
        else
        {
            int id = atoi(input);
            inserir(arvore, jogadores[id]);
        }
    }

    input[0] = '\0'; // limpeza de buffer

    balancear2(arvore->raiz);

    // selection sort
    startTime = clock();

    while (true)
    {
        scanf(" %[^\n]", input);
        if (strcmp(input, "FIM") == 0) {
            break;
        }
        else {
            pesquisar(arvore, input);
        }
    }

    endTime = clock();
    tempo = endTime - startTime;

    criarLog();
    fclose(arq);

    return 0;
}
