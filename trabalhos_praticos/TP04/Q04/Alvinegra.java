/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// árvore alvinegra/rubronegra, com inserções de objetos jogador com base no atributo nome

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
    public boolean cor;

    public No(Jogador elemento) {
        this(elemento, null, null, false);
    }

    public No(Jogador elemento, boolean cor) {
        this(elemento, null, null, cor);
    }

    public No(Jogador elemento, No esq, No dir, boolean cor) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }
}

class Arvore {
    // numero de comparacoes
    public static int comp = 0;

    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    // pesquisa -------------------------------------------------------
    public void pesquisar(Jogador x) {
        boolean resp = false;
        System.out.print("raiz ");
        resp = pesquisar(x, raiz, resp);

        if (resp == true) {
            System.out.print("SIM");
        } else {
            System.out.print("NAO");
        }
        System.out.println();
    }

    public boolean pesquisar(Jogador x, No no, boolean resp) {
        if (no != null) {
            if (x == null) {
                comp++;
                resp = false;
            } else if (x.getNome().equals(no.elemento.getNome())) {
                comp += 2;
                resp = true;
            } else if (x.getNome().compareTo(no.elemento.getNome()) < 0) {
                comp += 3;
                System.out.print("esq ");
                resp = pesquisar(x, no.esq, resp);
            } else if (x.getNome().compareTo(no.elemento.getNome()) > 0) {
                comp += 4;
                System.out.print("dir ");
                resp = pesquisar(x, no.dir, resp);
            }
        }

        return resp;
    }

    // inserção -------------------------------------------------------
    public void inserir(Jogador x) throws Exception {
        // se não tiver nenhum elemento
        if (raiz == null) {
            raiz = new No(x);
            comp++;
            // apenas um elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            comp += 2;
            if (x.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                comp++;
                raiz.esq = new No(x);
            } else {
                comp++;
                raiz.dir = new No(x);
            }
            // dois elementos - raiz e dir
        } else if (raiz.esq == null) {
            comp += 2;
            if (x.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                comp++;
                raiz.esq = new No(x);
            } else if (x.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                comp += 2;
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = x;
            } else {
                comp += 2;
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = x;
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // dois elementos - raiz e esq
        } else if (raiz.dir == null) {
            comp += 3;
            if (x.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                comp++;
                raiz.dir = new No(x);
            } else {
                comp += 2;
                raiz.dir = new No(raiz.elemento);
                if (x.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                    raiz.elemento = x;
                } else {
                    raiz.elemento = raiz.esq.elemento;
                    raiz.esq.elemento = x;
                }
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else {
            comp += 3;
            inserir(x, null, null, null, raiz);
            raiz.cor = false;
        }
    }

    private void balancear(No bisavo, No avo, No pai, No no) {
        // se o pai tiver cor == true, balancear
        if (pai.cor == true) {
            comp++;
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) {
                comp++;
                if (no.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    comp++;
                    avo = rotacaoEsq(avo);
                } else {
                    comp++;
                    avo = rotacaoDirEsq(avo);
                }
            } else {
                comp++;
                if (no.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                    comp++;
                    avo = rotacaoDir(avo);
                } else {
                    comp++;
                    avo = rotacaoEsqDir(avo);
                }
            }

            if (bisavo == null) {
                comp++;
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                comp += 2;
                bisavo.esq = avo;
            } else {
                comp += 2;
                bisavo.dir = avo;
            }

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private void inserir(Jogador x, No bisavo, No avo, No pai, No no) throws Exception {
        if (no == null) {
            comp++;
            if (x.getNome().compareTo(pai.elemento.getNome()) < 0) {
                comp++;
                no = pai.esq = new No(x, true);
            } else {
                comp++;
                no = pai.dir = new No(x, true);
            }

            if (pai.cor == true) {
                comp++;
                balancear(bisavo, avo, pai, no);
            }
        } else {
            comp++;
            if (no.esq != null && no.dir != null && no.esq.cor == true && no.dir.cor == true) {
                comp += 4;
                no.cor = true;
                no.esq.cor = no.dir.cor = false;

                if (no == raiz) {
                    comp++;
                    no.cor = false;
                } else if (pai.cor == true) {
                    comp += 2;
                    balancear(bisavo, avo, pai, no);
                }
            }

            if (x.getNome().compareTo(no.elemento.getNome()) < 0) {
                comp++;
                inserir(x, avo, pai, no, no.esq);
            } else if (x.getNome().compareTo(no.elemento.getNome()) > 0) {
                comp += 2;
                inserir(x, avo, pai, no, no.dir);
            } else {
                comp += 2;
                throw new Exception("Erro ao inserir: elemento repetido!");
            }
        }
    }

    private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    // caminhamento central --------------------------------------------
    public void caminharCentral() {
        caminharCentral(raiz);
    }

    private void caminharCentral(No i) {
        if (i != null) {
            comp++;
            caminharCentral(i.esq);
            System.out.println(i.elemento.getNome());
            caminharCentral(i.dir);
        }
    }

    // cria arquivo de log ---------------------------------------------
    public static void criarLog(long tempo) throws IOException {
        File logs = new File("803531_alvinegra.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + tempo);
        write.close();
    }

}

public class Alvinegra {
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
        String[] csvData = lerCsv("/tmp/players.csv");

        // array com todos os jogadores
        Jogador[] jogadores = new Jogador[csvData.length];
        for (int i = 0; i < csvData.length; i++) {
            String aux = csvData[i];
            Jogador player = new Jogador();
            player.ler(aux);
            jogadores[i] = player;
        }

        Arvore arvore = new Arvore();

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
            Jogador tmp = new Jogador();
            for (int i = 0; i < jogadores.length; i++) {
                if (jogadores[i].getNome().equals(input)) {
                    tmp.clone(jogadores[i]);
                    i = jogadores.length;
                }
            }
            if (tmp != null) {
                arvore.pesquisar(tmp);
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
