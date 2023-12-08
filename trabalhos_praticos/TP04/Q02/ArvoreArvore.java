/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// árvore binária de árvores binárias, com inserções de objetos jogador com base no atributo nome

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Jogador {
    // atributos
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {
        this(-1, "", -1, -1, "", -1, "", "");
    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
            String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void clone(Jogador x) {
        this.id = x.id;
        this.nome = x.nome;
        this.altura = x.altura;
        this.peso = x.peso;
        this.universidade = x.universidade;
        this.anoNascimento = x.anoNascimento;
        this.cidadeNascimento = x.cidadeNascimento;
        this.estadoNascimento = x.estadoNascimento;
    }

    public void imprimir() {
        System.out.println("[" + id + " ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## "
                + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + "]");
    }

    // ler uma str e converte para um Jogador
    public void ler(String str) {
        // separa as strings nas virgulas
        String[] atributos = str.split(",", -1);

        // id (sempre presente)
        this.id = Integer.parseInt(atributos[0]);

        // nome (sempre presente)
        this.nome = atributos[1];

        // altura
        if (atributos[2] != "") {
            this.altura = Integer.parseInt(atributos[2]);
        } else {
            this.altura = -1;
        }

        // peso
        if (atributos[3] != "") {
            this.peso = Integer.parseInt(atributos[3]);
        } else {
            this.peso = -1;
        }

        // universidade
        if (atributos[4] != "") {
            this.universidade = atributos[4];
        } else {
            this.universidade = "nao informado";
        }

        // anoNascimento
        if (atributos[5] != "") {
            this.anoNascimento = Integer.parseInt(atributos[5]);
        } else {
            this.anoNascimento = -1;
        }

        // cidadeNascimento
        if (atributos[6] != "") {
            this.cidadeNascimento = atributos[6];
        } else {
            this.cidadeNascimento = "nao informado";
        }

        // estadoNascimento
        if (atributos[7] != "") {
            this.estadoNascimento = atributos[7];
        } else {
            this.estadoNascimento = "nao informado";
        }

    }

}

class No2 {
    public Jogador elemento;
    public No2 esq, dir;

    public No2(Jogador elemento) {
        this(elemento, null, null);
    }

    public No2(Jogador elemento, No2 esq, No2 dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class No {
    public int key;
    public No esq, dir;
    public No2 outro;

    public No(int key) {
        this.key = key;
        esq = dir = null;
        this.outro = null;
    }

    public No(int key, No esq, No dir) {
        this.key = key;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}

class Arvore {
    // numero de comparacoes
    public static int comp = 0;

    // cria arquivo de log
    public static void criarLog(long tempo) throws IOException {
        File logs = new File("803531_arvoreArvore.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + tempo);
        write.close();
    }

    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public int getRaiz() throws Exception {
        return raiz.key;
    }

    // pesquisar --------------------
    // public boolean pesquisarPrincipal(int x) {
    // System.out.print("raiz ");
    // return pesquisarPrincipal(x, raiz);
    // }

    // private boolean pesquisarPrincipal(int x, No i) {
    // boolean resp;
    // if (i == null) {
    // resp = false;
    // comp++;

    // } else if (x == i.key) {
    // resp = true;
    // comp++;

    // } else if (x < i.key) {
    // System.out.print("esq ");
    // comp++;
    // resp = pesquisarPrincipal(x, i.esq); // x é menor que i

    // } else {
    // System.out.print("dir ");
    // resp = pesquisarPrincipal(x, i.dir); // x é maior que i
    // }
    // return resp;
    // }

    public boolean pesquisar(Jogador jogador) {
        System.out.print("raiz ");
        return pesquisar(jogador, raiz);
    }

    private boolean pesquisar(Jogador jogador, No no) {
        boolean resp;
        if (no == null) {
            resp = false;

        } else if (jogador.charAt(0) < no.elemento) {
            resp = pesquisar(no.esq, jogador);

        } else if (jogador.charAt(0) > no.elemento) {
            resp = pesquisar(no.dir, jogador);

        } else {
            resp = pesquisarSegundaArvore(no.outro, jogador);
        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(No2 no, String x) {
        boolean resp;
        if (no == null) {
            resp = false;

        } else if (x.compareTo(no.elemento) < 0) {
            resp = pesquisarSegundaArvore(no.esq, x);

        } else if (x.compareTo(no.elemento) > 0) {
            resp = pesquisarSegundaArvore(no.dir, x);

        } else {
            resp = true;
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
            comp++;
            caminharCentral(i.esq);
            System.out.print(i.key + " ");
            caminharCentral(i.dir);
        }
    }

    // inicia a arvore principal com os valores especificados
    public void inciarArvore() throws Exception {
        inserirPrincipal(7);
        inserirPrincipal(3);
        inserirPrincipal(11);
        inserirPrincipal(1);
        inserirPrincipal(5);
        inserirPrincipal(9);
        inserirPrincipal(13);
        inserirPrincipal(0);
        inserirPrincipal(2);
        inserirPrincipal(4);
        inserirPrincipal(6);
        inserirPrincipal(8);
        inserirPrincipal(10);
        inserirPrincipal(12);
        inserirPrincipal(14);
    }

    // insere elementos na arvore --------------------
    public void inserirPrincipal(int x) throws Exception {
        raiz = inserirPrincipal(x, raiz);
    }

    private No inserirPrincipal(int x, No i) throws Exception {
        if (i == null) {
            comp++;
            i = new No(x); // insere na raiz, se estiver vazia

        } else if (x < i.key) {
            comp++;
            i.esq = inserirPrincipal(x, i.esq); // x é menor que i

        } else if (x > i.key) {
            comp++;
            i.dir = inserirPrincipal(x, i.dir); // x é maior que i

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    public void inserir(Jogador jogador) throws Exception {
        inserir(jogador, raiz);
    }

    public void inserir(Jogador jogador, No i) throws Exception { // checa qual key o elemento deve ser inserido
        if (i == null) {
            throw new Exception("Erro ao inserir: elemento invalido!");

        } else if ((jogador.getAltura()) % 15 < i.key) {
            inserir(jogador, i.esq); // atributo < key -> chama metodo p esquerda

        } else if ((jogador.getAltura()) % 15 > i.key) {
            inserir(jogador, i.dir); // atributo > key -> chama metodo p direita

        } else {
            i.outro = inserir(jogador, i.outro);
        }
    }

    public No2 inserir(Jogador jogador, No2 i) throws Exception { // insere elementos nas arvores menores
        if (i == null) {
            i = new No2(jogador);

        } else if (jogador.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(jogador, i.esq); // jogador < i

        } else if (jogador.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(jogador, i.dir); // jogador > i

        } else {
            throw new Exception("Erro ao inserir: elemento existente!");
        }

        return i;
    }

    // remover elemento da arvore de keys --------------------
    public void removerPrincipal(int x) throws Exception {
        raiz = removerPrincipal(x, raiz);
    }

    private No removerPrincipal(int x, No i) throws Exception {

        if (i == null) {
            throw new Exception("Erro ao removerPrincipal!");

        } else if (x < i.key) {
            i.esq = removerPrincipal(x, i.esq); // x é menor que i
            comp++;

        } else if (x > i.key) {
            i.dir = removerPrincipal(x, i.dir); // x é maior
            comp++;

            // Sem no a direita.
        } else if (i.dir == null) {
            i = i.esq;
            comp++;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            i = i.dir;
            comp++;

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
            i.key = j.key; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.
            comp++;

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }
}

public class ArvoreArvore {
    // ler arquivo em csv e converte para uma string enorme
    public static String[] lerCsv(String path) {
        // abre o arquivo
        // "/tmp/" +
        File file = new File(path);

        // array de strings, com tamanho especifico do arquivo
        String[] data = new String[3922];
        int i = 0;

        try {
            Scanner sc = new Scanner(file);
            sc.nextLine(); // le a primeira linha

            // faz leituras ate que acabe o arquivo
            while (sc.hasNext()) {
                data[i] = sc.nextLine();
                i++;
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível econtrar o arquivo: " + e.getMessage());
        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] csvData = lerCsv("players.csv");

        // array com todos os jogadores
        Jogador[] jogadores = new Jogador[csvData.length];
        for (int i = 0; i < csvData.length; i++) {
            String aux = csvData[i];
            Jogador player = new Jogador();
            player.ler(aux);
            jogadores[i] = player;
        }

        Arvore arvore = new Arvore();

        arvore.inciarArvore();

        // insere jogadores em suas respectivas arvores
        while (!sc.hasNext("FIM")) {
            int input = sc.nextInt();
            int id = input;
            arvore.inserir(jogadores[id]);
        }

        sc.nextLine();
        sc.nextLine();

        // inicio contagem de tempo --------------------
        long startTime = System.currentTimeMillis();

        while (!sc.hasNext("FIM")) {
            String input = sc.nextLine();
            System.out.print(input + " ");
            boolean resp = arvore.pesquisar(input);
            if (resp == true) {
                System.out.print("SIM");
            } else {
                System.out.print("NAO");
            }
            System.out.println();
        }

        long endTime = System.currentTimeMillis();
        // fim contagem de tempo --------------------

        // criação do arquivo de log
        long duracao = endTime - startTime;
        Arvore.criarLog(duracao);

        sc.close();
    }

}
