/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// pilha sequencial simples de registros de jogadores

import java.util.*;
import java.io.*;

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

    // construtor sem parametro
    public Jogador() {
        this.id = -1;
        this.nome = "";
        this.altura = -1;
        this.peso = -1;
        this.universidade = "";
        this.anoNascimento = -1;
        this.cidadeNascimento = "";
        this.estadoNascimento = "";
    }

    // construtor com parametros
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

class Celula {
    public Jogador elemento;
    public Celula prox;

    public Celula() {
    }

    public Celula(Jogador elemento) {
        this.elemento = elemento;
    }

    public Jogador getElemento() {
        return this.elemento;
    }

    public void setElemento(Jogador elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return this.prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }
}

class Pilha {
    private Celula primeiro;
    private Celula ultimo;

    public Pilha() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

    public void inserirInicio(Jogador x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Jogador x) {
        if (ultimo == null) {
            ultimo = new Celula(x);
        } else {
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }
    }

    public Jogador removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        // caminhar ate a penultima celula
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        Jogador removido = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

        return removido;
    }

    // imprime a lista inteira
    public void imprimir() {
        Celula tmp = primeiro.prox;
        int indice = 0;
        while (tmp != null) {
            System.out.print("[" + indice + "]");
            System.out.print(" ## " + tmp.getElemento().getNome());
            System.out.print(" ## " + tmp.getElemento().getAltura());
            System.out.print(" ## " + tmp.getElemento().getPeso());
            System.out.print(" ## " + tmp.getElemento().getAnoNascimento());
            System.out.print(" ## " + tmp.getElemento().getUniversidade());
            System.out.print(" ## " + tmp.getElemento().getCidadeNascimento());
            System.out.print(" ## " + tmp.getElemento().getEstadoNascimento());
            System.out.println(" ## ");
            tmp = tmp.prox;
            indice++;
        }
    }

}

public class PilhaSequencial {

    // ler csv e converte para string
    public static String[] lerCsv(String path) {
        // "/tmp/" +
        File file = new File("/tmp/" + path);
        String[] csvData = new String[3922]; // array de strings, com tamanho especifico do arquivo
        int i = 0;

        // le o arquivo e salva cada linha no array de strings
        try {
            Scanner sc = new Scanner(file);

            if (sc.hasNext()) { // pula a primeira linha do csv
                sc.nextLine();
            }

            while (sc.hasNext()) {
                csvData[i] = sc.nextLine();
                i++;
            }

            // fechamento camera
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível econtrar o arquivo: " + e.getMessage());
        }

        return csvData;
    }

    // método swap
    public static void swap(int x, int y, Jogador[] array) {
        Jogador tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        try {
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

            // lista de jogadores
            Pilha pilha = new Pilha();

            // insere jogadores na lista
            while (!sc.hasNext("FIM")) {
                int input = sc.nextInt();
                int id = input;
                pilha.inserirFim(jogadores[id]);
            }

            sc.nextLine();
            sc.nextLine();

            int n = sc.nextInt(); // numero de linhas a serem lidas
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                String comando = sc.next(); // comando

                if (comando.equals("I")) {
                    int idTmp = sc.nextInt(); // id do jogador
                    pilha.inserirFim(jogadores[idTmp]);
                } else if (comando.equals("R")) {
                    Jogador tmp = pilha.removerFim();
                    System.out.println("(R) " + tmp.getNome());
                }
            }

            // imprime o resultado na tela
            pilha.imprimir();

            // fechamento do scanner
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
