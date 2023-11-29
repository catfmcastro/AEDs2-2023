class Celula {
    int elemento;
    Celula prox;

    Celula(int elemento) {
        this.elemento = elemento;
        prox = null;
    }

    Celula (int elemento, Celula prox) {
        this.elemento = elemento;
        this.prox = prox;
    }
}

class Lista {
    Celula primeiro;
    Celula ultimo;

    Lista() {
        primeiro = new Celula(-1);
        ultimo = null;
    }

    void mostrar() {
        for (Celula i = primeiro; i != ultimo; i = i.prox) {
            System.out.println("");
        }
    }
}

class Hash {
    Lista tabela[];
    int tamanho;
    final int NULO = -1;

    public Hash() {
        this(7);
    }

    public Hash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new Lista();
        }
    }

    public int h(int elemento) {
        return elemento % tamanho;
    }

    boolean pesquisar(int elemento) {
        int pos = h(elemento);
        return tabela[pos].pesquisar(elemento);
    }

    public void inserirInicio(int elemento) {
        int pos = h(elemento);
        tabela[pos].inserirInicio(elemento);
    }

    public int remover(int elemento) {
        int resp = NULO;
        if (pesquisar(elemento) == false) {
            throw new Exception("Erro ao remover!");
        } else {
            int pos = h(elemento);
            resp = tabela[pos].remover(elemento);
        }
        return resp;
    }
}

public class HashIndireto {
    public static void main(String[] args) {

    }
}
