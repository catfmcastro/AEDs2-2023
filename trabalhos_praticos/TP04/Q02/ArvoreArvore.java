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

    public boolean pesquisar(Jogador jogador) throws Exception {
        boolean resp = false;
        System.out.print("raiz ");

        resp = pesquisar(jogador, raiz, resp);

        return resp;
    }

    private boolean pesquisar(Jogador jogador, No no, boolean resp) throws Exception {

        // if (jogador != null && resp != true) {
        // resp = pesquisarSegundaArvore(jogador, no.outro, resp); // pesquisa na arvore
        // da key

        // if (resp != true) {
        // System.out.print("esq ");
        // resp = pesquisar(jogador, no.esq, resp);

        // System.out.print("dir ");
        // resp = pesquisar(jogador, no.dir, resp);
        // }
        // } else {
        // throw new Exception("Não foi possível realizar a pesquisa na árvore
        // principal.");
        // }

        if (no == null) {
            comp++;
            resp = false;

        } else if ((jogador.getAltura() % 15) < (no.key % 15)) {
            comp += 2;
            System.out.print("esq ");
            resp = pesquisar(jogador, no.esq, resp);

        } else if ((jogador.getAltura() % 15) > (no.key % 15)) {
            comp += 3;
            System.out.print("dir ");
            resp = pesquisar(jogador, no.dir, resp);

        } else {
            comp += 3;
            resp = pesquisarSegundaArvore(jogador, no.outro, resp); // pesquisa na arvore da key
        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(Jogador jogador, No2 no, boolean resp) throws Exception {
        System.out.println("Chamada da pesquisa secundária realizada com sucesso!");
        System.out.println("o jogador sendo passado para a pesquisa secundária é: " + jogador.getNome());
        System.out.println("o no sendo passado para a pesquisa secundaria é: " + no.elemento.getNome());
        // if(no != null) {
        // if(jogador.getNome().equals(no.elemento.getNome())) {
        // resp = true;
        // return resp;
        // }

        // System.out.print("ESQ ");
        // resp = pesquisarSegundaArvore(jogador, no.esq, resp);

        // System.out.print("DIR ");
        // resp = pesquisarSegundaArvore(jogador, no.dir, resp);
        // } else {
        // throw new Exception("Não foi possível realizar a pesquisa na árvore
        // secundária.");
        // }
        if (no.elemento != null) {

            if (no == null) {
                System.out.println("nao encontrou jogador/entrou só no primeiro if");
                comp++;
                resp = false;

            } else if (jogador.getNome().compareTo(no.elemento.getNome()) < 0) {
                comp += 2;
                System.out.print("ESQ ");
                resp = pesquisarSegundaArvore(jogador, no.esq, resp);

            } else if (jogador.getNome().compareTo(no.elemento.getNome()) > 0) {
                comp += 3;
                System.out.print("DIR ");
                resp = pesquisarSegundaArvore(jogador, no.dir, resp);

            } else {
                comp += 3;
                resp = true;
            }
        } else {
            throw new Exception("o nó2 passado possui o elemento nulo!");
        }

        return resp;
    }

    // caminhamento central --------------------
    public void caminharCentralPrincipal() {
        System.out.print("[ ");
        caminharCentralPrincipal(raiz);
        System.out.println("]");
    }

    private void caminharCentralPrincipal(No i) {
        if (i != null) {
            comp++;
            caminharCentralSecundario(i.outro);
            caminharCentralPrincipal(i.esq);
            System.out.println(i.key + " ");
            caminharCentralPrincipal(i.dir);
        }
    }

    private void caminharCentralSecundario(No2 i) {
        if (i != null) {
            comp++;
            caminharCentralSecundario(i.esq);
            System.out.println(i.elemento.getNome() + " ");
            caminharCentralSecundario(i.dir);
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

    // insere keys na arvore de busca --------------------
    public void inserirPrincipal(int x) throws Exception {
        raiz = inserirPrincipal(x, raiz);
    }

    private No inserirPrincipal(int x, No i) throws Exception {
        if (i == null) {
            comp++;
            i = new No(x); // insere na raiz, se estiver vazia

        } else if (x < i.key) {
            comp += 2;
            i.esq = inserirPrincipal(x, i.esq); // x é menor que i

        } else if (x > i.key) {
            comp += 3;
            i.dir = inserirPrincipal(x, i.dir); // x é maior que i

        } else {
            comp += 3;
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    // insere jogadores nas subarvores ---------------------
    public void inserir(Jogador jogador) throws Exception {
        inserir(jogador, raiz);
    }

    public void inserir(Jogador jogador, No i) throws Exception { // checa em qual key o elemento deve ser inserido
        int h = jogador.getAltura() % 15;

        if (i == null) {
            comp++;
            throw new Exception("Erro ao inserir: elemento invalido!");

        } else if (h < (i.key % 15)) {
            comp += 2;
            inserir(jogador, i.esq); // atributo < key -> chama metodo p esquerda

        } else if (h > (i.key % 15)) {
            comp += 3;
            inserir(jogador, i.dir); // atributo > key -> chama metodo p direita

        } else {
            comp += 3;
            i.outro = inserir(jogador, i.outro); // atributo == key, insere elemento
        }
    }

    public No2 inserir(Jogador jogador, No2 i) throws Exception { // inserção de jogadores propriamente dita
        if (i == null) {
            comp++;
            i = new No2(jogador);

        } else if (jogador.getNome().compareTo(i.elemento.getNome()) < 0) {
            comp += 2;
            i.esq = inserir(jogador, i.esq); // jogador < i

        } else if (jogador.getNome().compareTo(i.elemento.getNome()) > 0) {
            comp += 3;
            i.dir = inserir(jogador, i.dir); // jogador > i

        } else {
            comp += 3;
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
            comp++;
            throw new Exception("Erro ao removerPrincipal!");

        } else if (x < i.key) {
            comp += 2;
            i.esq = removerPrincipal(x, i.esq); // x é menor que i

        } else if (x > i.key) {
            comp += 3;
            i.dir = removerPrincipal(x, i.dir); // x é maior

            // Sem no a direita.
        } else if (i.dir == null) {
            comp += 4;
            i = i.esq;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            comp += 5;
            i = i.dir;

            // No a esquerda e no a direita.
        } else {
            comp += 5;
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    // substitui a posição do elemento removido pelo maior a esquerda
    private No maiorEsq(No i, No j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            comp++;
            i.key = j.key; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            comp++;
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

        // /tmp/
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

        // // !! testando
        // arvore.caminharCentralPrincipal();
        // // !! testando

        // inicio contagem de tempo --------------------
        long startTime = System.currentTimeMillis();

        while (!sc.hasNext("FIM")) {
            String input = sc.nextLine();
            System.out.print(input + " ");
            Jogador tmp = new Jogador();
            for (int i = 0; i < jogadores.length; i++) {
                if (jogadores[i].getNome().equals(input)) {
                    tmp.clone(jogadores[i]);
                    i = jogadores.length;
                }
            }
            if (tmp != null) {
                boolean resp = arvore.pesquisar(tmp);
                if (resp == true) {
                    System.out.print("SIM");
                } else {
                    System.out.print("NAO");
                }
                System.out.println();
            }
        }

        long endTime = System.currentTimeMillis();
        // fim contagem de tempo --------------------

        // criação do arquivo de log
        long duracao = endTime - startTime;
        Arvore.criarLog(duracao);

        sc.close();
    }

}
