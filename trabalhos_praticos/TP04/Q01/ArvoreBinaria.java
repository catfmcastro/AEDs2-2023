/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// árvore binária, com inserções de objetos jogador com base no atributo nome

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

class No {
    public Jogador elemento;
    public No esq, dir;

    public No(Jogador elemento) {
        this(elemento, null, null);
    }

    public No(Jogador elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {
    // numero de comparacoes
    public static int comp = 0;

    // cria arquivo de log
    public static void criarLog(long tempo) throws IOException {
        File logs = new File("803531_arvoreBinaria.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + tempo);
        write.close();
    }

    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public Jogador getRaiz() throws Exception {
        return raiz.elemento;
    }

    // pesquisar --------------------
    public boolean pesquisar(String x) {
        System.out.print("raiz ");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
            comp++;

        } else if (x.equals(i.elemento.getNome())) {
            resp = true;
            comp++;

        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            System.out.print("esq ");
            comp++;
            resp = pesquisar(x, i.esq); // x é menor que i

        } else {
            System.out.print("dir ");
            resp = pesquisar(x, i.dir); // x é maior que i
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
            comp++;
            System.out.print(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    // inserir elemento --------------------
    public void inserir(Jogador x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private No inserir(Jogador x, No i) throws Exception {
        if (i == null) {
            comp++;
            i = new No(x);

        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            comp++;
            i.esq = inserir(x, i.esq); // x é menor que i

        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            comp++;
            i.dir = inserir(x, i.dir); // x é maior que i

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    // remover elemento --------------------
    public void remover(Jogador x) throws Exception {
        raiz = remover(x, raiz);
    }

    private No remover(Jogador x, No i) throws Exception {

        if (i == null) {
            throw new Exception("Erro ao remover!");

        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = remover(x, i.esq); // x é menor que i
            comp++;

        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = remover(x, i.dir); // x é maior
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
            i.elemento = j.elemento; // Substitui i por j.
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

public class ArvoreBinaria {
    // ler arquivo em csv e converte para uma string enorme
    public static String[] lerCsv(String path) {
        // abre o arquivo
        // "/tmp/" +
        File file = new File("/tmp/" + path);

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

        // insere jogadores na lista
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
