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

class CelulaDupla {
    public Jogador elemento;
    public CelulaDupla prox;
    public CelulaDupla ant;

    public CelulaDupla() {
    }

    public CelulaDupla(Jogador elemento) {
        this.elemento = elemento;
    }

    public Jogador getElemento() {
        return this.elemento;
    }

    public void setElemento(Jogador elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getProx() {
        return this.prox;
    }

    public void setProx(CelulaDupla prox) {
        this.prox = prox;
    }
}

class Lista {
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;

    public Lista() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public int tamanho() {
        int tamanho = 0;
        for (CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

    public void inserirInicio(Jogador x) {
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Jogador x) {
        if (ultimo == null) {
            ultimo = new CelulaDupla(x);
        } else {
            ultimo.prox = new CelulaDupla(x);
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox;
        }
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
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    public Jogador removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Jogador removido = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;

        return removido;
    }

    public Jogador removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        Jogador removido = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;

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
            CelulaDupla i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            removido = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }

        return removido;
    }

    // imprime a lista inteira
    public void imprimirLista() {
        CelulaDupla tmp = primeiro.prox;
        while (tmp != null) {
            tmp.elemento.imprimir();
            tmp = tmp.prox;
        }
    }

}

public class QuicksortListaDupla {

    public static int comp = 0;
    public static int mov = 0;

    public static void criarArq(long tmp) throws IOException {
        File log = new File("/tmp/803531_quicksort.txt");
        FileWriter write = new FileWriter(log);
        write.write("803531" + '\t' + tmp + '\t' + comp + '\t' + mov);
        write.close();
    }

    // método swap
    public static void swap(int x, int y, Jogador[] array) {
        Jogador tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        mov += 3;
    }

    // compara o elemento com o pivo
    public static int comparaPivo(Jogador x, Jogador pivo, Jogador[] array) {
        int resp = x.getEstadoNascimento().compareTo(pivo.getEstadoNascimento());
        comp++;

        if (resp == 0) {
            return x.getNome().compareTo(pivo.getNome());
        }

        return resp;
    }

    public static void sort(int esq, int dir, Jogador[] array) {
        int i = esq, j = dir;
        int meio = (esq + dir) / 2;
        Jogador pivo = array[meio];

        while (i <= j) {
            comp++;
            while (comparaPivo(array[i], pivo, array) < 0) {
                comp++;
                i++;
            }
            while (comparaPivo(array[j], pivo, array) > 0) {
                comp++;
                j--;
            }
            if (i <= j) {
                comp++;
                swap(i, j, array);
                i++;
                j--;
            }
        }

        if (esq < j) {
            sort(esq, j, array);
        }
        if (i < dir) {
            sort(i, dir, array);
        }
    }

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
            Jogador[] inputs = new Jogador[470];
            int tam = 0;
            Lista lista = new Lista();

            // insere jogadores na lista
            while (!sc.hasNext("FIM")) {
                int in = sc.nextInt();
                inputs[tam] = jogadores[in];
                tam++;
            }

            long startTime = System.currentTimeMillis();
            sort(0, tam - 1, inputs);
            long endTime = System.currentTimeMillis();

            long duracao = endTime - startTime;

            try {
                criarArq(duracao);
            } catch (IOException e) {
                System.out.println("Não foi possível criar o arquivo de log: " + e);
            }

            for (int i = 0; i < tam; i++) {
                lista.inserirFim(inputs[i]);
            }

            // imprime o resultado na tela
            lista.imprimirLista();

            // fechamento do scanner
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
