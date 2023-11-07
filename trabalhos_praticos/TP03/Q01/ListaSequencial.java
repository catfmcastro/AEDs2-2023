/*
Trabalho Prático 03

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// lista de registros simples com jogadores

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
}

class Lista {
    private Celula primeiro;
    private Celula ultimo;

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
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public void inserir(Jogador x, int pos) throws Exception {
        int tam = tamanho();

        if (pos < 0 || pos > tam) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tam + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tam) {
            inserirFim(x);
        } else {
            // caminha ate a posicao anterior a insercao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = new Celula();
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public Jogador removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Jogador removido = primeiro.elemento;
        tmp.prox = null;
        tmp = null;

        return removido;
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

    public Jogador remover(int pos) throws Exception {
        Jogador removido;
        int tam = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        } else if (pos < 0 || pos > tam) {
            throw new Exception("Erro ao remover posicao (" + pos + " / tamanho = " + tam + ") invalida!");
        } else if (pos == 0) {
            removido = removerInicio();
        } else if (pos == tam) {
            removido = removerFim();
        } else {
            // caminhar ate a posicao anterior a remocao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = i.prox;
            removido = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return removido;
    }

    // public String mostrar(int id) {
        
    // }

}

public class ListaSequencial {

    // ler csv e converte para string
    public static String[] lerCsv(String path) {
        // "/tmp/" +
        File file = new File(path);

        // array de strings, com tamanho especifico do arquivo
        String[] csvData = new String[3922];

        // contador
        int i = 0;

        // le o arquivo e salva cada linha no array de strings
        try {
            Scanner sc = new Scanner(file);

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
        Scanner sc = new Scanner(System.in);

        String[] csvData = lerCsv("playersAtualizado.csv");

        // array com todos os jogadores
        Jogador[] jogadores = new Jogador[csvData.length];
        for (int i = 0; i < csvData.length; i++) {
            String aux = csvData[i];
            Jogador player = new Jogador();
            player.ler(aux);
            jogadores[i] = player;
        }

        // lista de jogadores
        Lista lista = new Lista();
        
        // insere jogadores na lista
        while (!sc.hasNext("FIM")) {
            int input = sc.nextInt();
            int id = input;
            lista.inserirFim(jogadores[id]);
        }
        
             

        // imprime o resultado na tela
        // for (int i = 0; i < tam; i++) {
        //     data[i].imprimir();
        // }

        // fechamento do scanner
        sc.close();
    }
}
