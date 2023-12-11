#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

// HASH ------------------------------------------------------------------------------------------------------------
typedef struct No
{
    Jogador *jogador;
    struct No *prox;
} No;

typedef struct Hash
{
    No **tabela;
    int tam;
} Hash;

No *inicializarLista(Jogador *x)
{
    No *no = malloc(sizeof(No));
    no->jogador = x;
    no->prox = NULL;
    return no;
}

Hash *inicializar(int tam)
{
    Hash *hash = malloc(sizeof(Hash));
    hash->tam = tam;
    hash->tabela = malloc(sizeof(No *) * tam);

    for (int i = 0; i < tam; i++)
    {
        hash->tabela[i] = NULL;
    }
    return hash;
}

int h(Jogador *x, Hash *hash) { return x->id % hash->tam; }

void inserir(Jogador *x, Hash *hash)
{
    int pos = h(x, hash);

    if (hash->tabela[pos] == NULL)
    {
        hash->tabela[pos] = inicializarLista(x);
    }
    else
    {
        No *no = inicializarLista(x);
        no->prox = hash->tabela[pos];
        hash->tabela[pos] = no;
    }
}

bool pesquisar(int id, Hash *hash)
{
    int pos = id % hash->tam;

    if (hash->tabela[pos] == NULL)
    {
        return false;
    }

    No *tmp = hash->tabela[pos];
    while (tmp != NULL)
    {
        if (tmp->jogador->id == id)
        {
            return true;
        }
        tmp = tmp->prox;
    }

    return false;
}
Jogador *getJogadorByNome(char *nome, Jogador *jogadores)
{
    for (int i = 0; i < 3922; i++)
    {
        if (strcmp(jogadores[i].nome, nome) == 0)
        {
            return &jogadores[i];
        }
    }
    return NULL;
}

// MAIN -------------------------------------------------------------------------------------------
int main()
{
    char leraq[600];
    Jogador jogadores[3922];
    FILE *arq = fopen("/tmp/players.csv", "r");
    fgets(leraq, sizeof(leraq), arq);

    for (int i = 0; fgets(leraq, 600, arq) != NULL; i++)
    {
        char *frase = linhasCsv(leraq);
        char dados[8][100];
        split(frase, ',', dados);
        free(frase);
        addJogador(&jogadores[i], dados);
    }

    // primeiro loop para inserir na Hash
    Hash *hash = inicializar(25);

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
            inserir(&jogadores[id], hash);
        }
    }
    while (true)
    {
        scanf(" %[^\n]", input);
        if (strcmp(input, "FIM") == 0)
        {
            break;
        }
        else
        {
            Jogador *player = getJogadorByNome(input, jogadores);
            int id = player->id;
            bool resp = pesquisar(id, hash);
            printf("%s", jogadores[id].nome);
            if (resp)
            {
                printf(" SIM\n");
            }
            else
            {
                printf(" NAO\n");
            }
        }
    }

    fclose(arq);
    return 0;
}
