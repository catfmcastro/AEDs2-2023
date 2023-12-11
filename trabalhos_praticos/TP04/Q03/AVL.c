#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

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
    Jogador tmp = *jogador;
    return tmp;
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

char *linhasCsv(char *frase)
{
    char data[] = "nao informado";
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
            strcat(novaFrase, data);
        }
        else if (frase[i] == ',' && frase[i + 2] == '\0')
        {
            strcat(novaFrase, ",");
            strcat(novaFrase, data);
        }
        else
        {
            char temp[2] = {frase[i], '\0'};
            strcat(novaFrase, temp);
        }
    }

    return novaFrase;
}

void addJogador(Jogador *player, char tokens[8][100])
{
    player->id = atoi(tokens[0]);
    strcpy(player->nome, tokens[1]);
    strcpy(player->altura, tokens[2]);
    strcpy(player->peso, tokens[3]);
    strcpy(player->universidade, tokens[4]);
    strcpy(player->anoNascimento, tokens[5]);
    strcpy(player->cidadeNascimento, tokens[6]);
    strcpy(player->estadoNascimento, tokens[7]);
}

void split(const char *str, char delimitador, char tokens[8][100])
{
    int l = 0;
    int index = 0;

    while (l < 8)
    {
        int i = 0;
        while (1)
        {
            if (str[index] == delimitador || str[index] == '\0' || str[index] == '\n')
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

// ARVORE AVL ------------------------------------------------------------------------------------------------
int comp = 0;
typedef struct No
{
    Jogador *jogador;
    struct No *esq;
    struct No *dir;
} No;

No *iniciarRaiz(Jogador *x)
{
    No *no = malloc(sizeof(No));
    no->jogador = x;
    no->esq = NULL;
    no->dir = NULL;
    return no;
}

typedef struct AVL
{
    No *raiz;
} AVL;

No *balancEsq(No *raiz);
No *balanceDir(No *raiz);
No *balancear(No *raiz);
No *inserirNo(No *raiz, Jogador *jogador);
void pesquisarPriv(No *raiz, char *nome);
void pesquisar(AVL *arvore, char *nome);
void incializar(AVL *arvore) { arvore->raiz = NULL; }

int getAltura(No *raiz)
{
    if (raiz == NULL)
    {
        comp++;
        return 0;
    }
    int alturaDir = (raiz->dir) ? getAltura(raiz->dir) : 0;
    int alturaEsq = (raiz->esq) ? getAltura(raiz->esq) : 0;
    comp += 4;
    return (alturaEsq > alturaDir) ? alturaEsq + 1 : alturaDir + 1;
}

No *balancEsq(No *raiz)
{
    if (getAltura(raiz->dir->esq) > getAltura(raiz->dir->dir))
    {
        raiz->dir = balanceDir(raiz->dir);
    }
    comp++;
    No *aux = raiz->dir;
    raiz->dir = aux->esq;
    aux->esq = raiz;
    return aux;
}

No *balanceDir(No *raiz)
{
    if (getAltura(raiz->esq->dir) > getAltura(raiz->esq->esq))
    {
        raiz->esq = balancEsq(raiz->esq);
    }
    comp++;
    No *aux = raiz->esq;
    raiz->esq = aux->dir;
    aux->dir = raiz;
    return aux;
}

No *balancear(No *raiz)
{
    int soma = getAltura(raiz->dir) - getAltura(raiz->esq);
    if (soma > 1)
    {
        comp++;
        raiz = balancEsq(raiz);
    }
    else if (soma < -1)
    {
        comp += 2;
        raiz = balanceDir(raiz);
    }
    return raiz;
}

void BalancearCimaBaixo(No *raiz)
{
    if (raiz == NULL)
    {
        return;
    }
    comp++;
    raiz = balancear(raiz);
    BalancearCimaBaixo(raiz->esq);
    BalancearCimaBaixo(raiz->dir);
}

No *inserirNo(No *raiz, Jogador *jogador)
{
    if (raiz == NULL)
    {
        comp++;
        raiz = iniciarRaiz(jogador);
    }
    else if (strcmp(jogador->nome, raiz->jogador->nome) < 0)
    {
        comp += 2;
        raiz->esq = inserirNo(raiz->esq, jogador);
        raiz = balancear(raiz);
    }
    else
    {
        comp += 2;
        raiz->dir = inserirNo(raiz->dir, jogador);
        raiz = balancear(raiz);
    }
    return raiz;
}

void inserir(AVL *arvore, Jogador jogador)
{
    Jogador *x = (Jogador *)malloc(sizeof(Jogador));
    *x = jogador;

    arvore->raiz = inserirNo(arvore->raiz, x);
}

void pesquisarPriv(No *raiz, char *nome)
{
    if (raiz == NULL)
    {
        comp++;
        printf(" NAO\n");
        return;
    }
    else if (strcmp(nome, raiz->jogador->nome) == 0)
    {
        comp += 2;
        printf(" SIM\n");
    }
    else if (strcmp(nome, raiz->jogador->nome) < 0)
    {
        comp += 3;
        printf(" esq");
        pesquisarPriv(raiz->esq, nome);
    }
    else
    {
        comp += 3;
        printf(" dir");
        pesquisarPriv(raiz->dir, nome);
    }
}

void pesquisar(AVL *arvore, char *nome)
{
    printf("%s raiz", nome);
    pesquisarPriv(arvore->raiz, nome);
}

// MAIN ------------------------------------------------------------------------------------------------------
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

int main()
{
    char leraq[600];
    Jogador time[3922];
    FILE *arq = fopen("/tmp/players.csv", "r");

    fgets(leraq, sizeof(leraq), arq);

    for (int i = 0; fgets(leraq, 600, arq) != NULL; i++)
    {
        char *frase = linhasCsv(leraq);

        char dados[8][100];
        split(frase, ',', dados);
        free(frase);

        addJogador(&time[i], dados);
    }

    AVL *arvore = malloc(sizeof(AVL));
    incializar(arvore);

    char input[400];
    while (true)
    {
        scanf(" %[^\n]", input);
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }
        else
        {
            int id = atoi(input);
            inserir(arvore, time[id]);
        }
    }
    input[0] = '\0';

    BalancearCimaBaixo(arvore->raiz);

    while (true)
    {
        scanf(" %[^\n]", input);
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }
        else
        {
            pesquisar(arvore, input);
        }
    }

    criarLog();
    fclose(arq);
    return 0;
}
