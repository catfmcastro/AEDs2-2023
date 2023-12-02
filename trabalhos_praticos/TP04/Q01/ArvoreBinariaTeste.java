/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// teste de árvore binária

import java.util.Scanner;

class No {
    public int elemento;
    public No esq, dir;

    public No(int elemento) {
        this(elemento, null, null);
    }

    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {
    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public int getRaiz() throws Exception {
        return raiz.elemento;
    }

    // pesquisar --------------------
    public boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(int x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x == i.elemento) {
            resp = true;

        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);

        } else {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    // caminhamento central --------------------
    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq);
            System.out.print(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }

    // caminhamento pre --------------------
    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    private void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    // inserir elemento --------------------
    public void inserir(int x) throws Exception {
        System.out.print("raiz ");
        raiz = inserir(x, raiz);
    }

    private No inserir(int x, No i) throws Exception {
        if (i == null) {
            i = new No(x);

        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);
            System.out.print("esq ");

        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);
            System.out.print("dir ");

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    // remover elemento --------------------
    public void remover(int x) throws Exception {
        raiz = remover(x, raiz);
    }

    private No remover(int x, No i) throws Exception {

        if (i == null) {
            throw new Exception("Erro ao remover!");

        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = remover(x, i.dir);

            // Sem no a direita.
        } else if (i.dir == null) {
            i = i.esq;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            i = i.dir;

            // No a esquerda e no a direita.
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    // substitui a posição do elemento removido pelo maior a esquerda
    private No maiorEsq(No i, No j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

}

public class ArvoreBinariaTeste {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os 10 elementos que entrarão na árvore: ");
        for (int i = 0; i < 10; i++) {
            int elemento = sc.nextInt();
            arvore.inserir(elemento);
        }
        

        int pesquisa;
        System.out.println("Insira um elemento pra pesquisar: ");
        pesquisa  = sc.nextInt();

        boolean tem = arvore.pesquisar(pesquisa);

        if(tem) {
            System.out.println("O elemento está na árvore");
        } else {
            System.out.println("O elemento não está na árvore");
        }

        // imprime o resultado na tela
        System.out.println("Os elementos inseridos na árvore foram: ");
        arvore.caminharCentral();

        sc.close();
    }
}
