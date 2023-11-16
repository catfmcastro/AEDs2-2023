/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// matriz flexivel em java, com soma, multiplicacao, mostrar diagonal principal e mostrar diagonal secundaria

import java.util.*;

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        criarMat();
    }

    // aloca espaços para a matriz
    public void criarMat() {
        // cria o primeiro elemento
        if (inicio == null) {
            inicio = new Celula();
        }

        // cria linhas
        Celula tmp = inicio;
        for (int j = 1; j < linha; j++) {
            Celula novaCelula = new Celula();
            tmp.inf = novaCelula;
            novaCelula.sup = tmp;
            tmp = novaCelula;
        }

        // criar colunas
        tmp = inicio;
        Celula tmp2 = inicio.inf;
        for (int i = 0; i < linha; i++) {
            tmp.inf = tmp2;
            tmp2.sup = tmp;

            // criar colunas
            for (int j = 0; j < coluna; j++) {
                Celula acima;
                Celula abaixo = new Celula();
                if (tmp.dir == null) {
                    acima = tmp.dir;
                } else {
                    acima = new Celula();
                    tmp.dir = acima;
                    acima.esq = tmp;
                }

                acima.inf = abaixo;
                abaixo.sup = acima;
                abaixo.esq = tmp2;
                tmp2.dir = abaixo;

                tmp = acima;
                tmp2 = abaixo;
            }

            // desloca os ponteiros para baixo
            tmp = tmp2;
            tmp2 = tmp2.inf;
        }
    }

    // insere elemento com base na posicao
    public void setPos(int l, int c, int x) {
        Celula tmp = inicio;

        for (int i = 0; i < l; i++) {
            tmp = tmp.inf;
        }

        for (int i = 0; i < c; i++) {
            tmp = tmp.dir;
        }

        tmp.elemento = x;

    }

    // retorna elemento com base na posicao
    public int getPos(int l, int c) {
        Celula tmp = inicio;

        for (int i = 0; i < l; i++) {
            tmp = tmp.inf;
        }

        for (int i = 0; i < c; i++) {
            tmp = tmp.dir;
        }

        return tmp.elemento;
    }

    // preenche os elementos
    public static Matriz inputMatriz(Matriz mat, Scanner sc) {
        int l, c;

        l = sc.nextInt();
        sc.nextLine();
        c = sc.nextInt();
        sc.nextLine();

        mat = new Matriz(l, c);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                int valor = sc.nextInt();
                mat.setPos(i, j, valor);
            }
            sc.nextLine();
        }

        return mat;
    }

    // imprime a matriz completa
    public void imprimeMatriz() {
        Celula l = inicio;
        Celula c;

        for (; l != null; l = l.inf) {
            c = l;

            for (; c != null; c = c.dir) {
                System.out.print(c.elemento + " ");
            }
            System.out.println();
        }
    }

    public void mostrarDiagonal() {
        Celula tmp = inicio;

        while (tmp != null) {
            System.out.print(tmp.elemento + " ");
            tmp = tmp.inf;

            if (tmp == null) {
                break;
            }

            tmp = tmp.dir;
        }
        System.out.println();
    }

    public void mostrarDiagonalInv() {
        Celula tmp = inicio;

        // caminha o maximo para a direita
        while (tmp.dir != null) {
            tmp = tmp.dir;
        }

        while (tmp != null) {
            System.out.print(tmp.elemento + " ");
            tmp = tmp.inf.esq;
        }
        System.out.println();
    }

    public static void soma(Matriz m1, Matriz m2) {
        Matriz resp = new Matriz(m1.linha, m1.coluna);

        for (int i = 0; i < m1.linha; i++) {
            for (int j = 0; j < m1.coluna; j++) {
                int conta = (m1.getPos(i, j) + m2.getPos(i, j));
                resp.setPos(i, j, conta);
            }
        }

        resp.imprimeMatriz();
    }

    public static void multiplicacao(Matriz m1, Matriz m2) {
        Matriz resp = new Matriz(m1.linha, m1.coluna);

        for (int i = 0; i < m1.linha; i++) {
            for (int j = 0; j < m2.coluna; j++) {
                int conta = 0;
                for (int k = 0; k < m1.coluna; k++) {
                    conta += m1.getPos(i, k) * m2.getPos(i, k);
                }
                resp.setPos(i, j, conta);
            }
        }

        resp.imprimeMatriz();;
    }
}

public class MatrizFlexivel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        // leitura de todos os casos
        for (; casos > 0; casos--) {
            Matriz[] array = new Matriz[2];

            for (int i = 0; i < 2; i++) {
                array[i] = Matriz.inputMatriz(array[i], sc);
            }

            array[0].mostrarDiagonal();
            array[0].mostrarDiagonalInv();
            Matriz.soma(array[0], array[1]);
            Matriz.multiplicacao(array[0], array[1]);
        }

        sc.close();
    }
}
