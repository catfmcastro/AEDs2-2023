/*
Laboratório - 11 de outubro de 2023
Structs, classes em C

@catfmcastro
Catarina F. M. Castro
*/

// criar e implementar uma fila sem uma "cabeca" (ponteiro inicio aponta para objeto vazio)

#ifndef FILA_H
#define FILA_H

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"

//=============================================================================
typedef struct Fila
{
    struct Celula *primeiro, *ultimo;
    int size;
} Fila;

//=============================================================================
Fila new_fila()
{
    Fila temp;
    temp.primeiro = temp.ultimo = NULL;
    temp.size = 0;
    return temp;
}

//=============================================================================
int size_fila(Fila *f)
{
    return f->size;
}

//=============================================================================
void enqueue_fila(Fila *f, int elem)
{
    if(f->primeiro == NULL)
    {
        f->primeiro  = new_celula(elem);
        f->ultimo = f->primeiro;
        f->size++;
    } else {
        f->ultimo->prox = new_celula(elem);
        f->ultimo = f->ultimo->prox;
        f->size++;
    }
}

//=============================================================================
int dequeue_fila(Fila *f)
{

    if (f->primeiro == NULL)
    {
        printf("\nA fila esta vazia!\n");
        return INT_MIN;
    }

    Celula *temp = f->primeiro;
    f->primeiro = f->primeiro->prox;
    f->size--;
    free(temp);
    return f->primeiro->elemento;
}

//=============================================================================
void print_fila(Fila *f)
{
    Celula *i;
    printf("[");
    for (i = f->primeiro->prox; i != NULL; i = i->prox)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}

//=============================================================================
void delete_fila(Fila *f)
{
    while (f->size > 0)
        dequeue_fila(f);
    free(f->primeiro);
}

#endif