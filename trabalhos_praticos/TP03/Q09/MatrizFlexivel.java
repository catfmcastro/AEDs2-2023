/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// matriz flexivel em java, com soma, multiplicacao, mostrar diagonal principal e mostrar diagonal secundaria

import java.util.Scanner;

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
        this.inicio = new Celula();
        criarMat();
    }

    public void criarMat() {
        Celula l, c;
        l = c = inicio;

        // alocação dos espaços das celulas
        // todo fazer conexões verticais
        for (int i = 1; i < linha; i++) {
            for (int j = 1; j < coluna; j++) {
                c.dir = new Celula();
                c.dir.esq = c;
                c = c.dir;
            }

            l.inf = new Celula();
            l.inf.sup = l;
            l = l.inf;
            c = l;
        }

    }

    public void preencheMatriz() {
        Scanner sc = new Scanner(System.in);
        Celula l, c;
        l = inicio;
        c = l.dir;

        // input de elementos da matriz
        // todo checar se iniciar do i = 1 funciona
        for (int i = 1; i < linha; i++) {
            l.elemento = sc.nextInt();
            for (int j = 1; j < coluna; j++) {
                c.elemento = sc.nextInt();
                c = c.dir;
            }
            sc.nextLine(); // pula para a próxima linha
            l = l.inf;
            c = l.dir;
        }

        sc.close();
    }

    public boolean isQuadrada() {
        return (this.linha == this.coluna);
    }

    public static Matriz somaMat(Matriz m1, Matriz m2) throws Exception {

        if (m1.linha == m2.linha && m1.coluna == m2.coluna) {
            Matriz resp = new Matriz();
            Celula l = resp.inicio;
            Celula c = l.dir;
            Celula l1 = m1.inicio;
            Celula c1 = l1.dir;
            Celula l2 = m2.inicio;
            Celula c2 = l2.dir;

            for (int i = 1; i < m1.linha; i++) {
                
                l.elemento = (l1.elemento + l2.elemento);

                for (int j = 1; j < m2.coluna; j++) {
                    c.elemento = (c1.elemento + c2.elemento);
                    c = c.dir;
                    c1 = c1.dir;
                    c2 = c2.dir;
                }

                l = l.inf;
                l1 = l1.inf;
                l2 = l2.inf;
            }

            return resp;
        } else {
            throw new Exception("Erro: não é possível somar matrizes de tamanhos diferentes.");
        }

    }

}

public class MatrizFlexivel {
    public static void main(String[] args) {
        int casos, l, c;
    }
}
