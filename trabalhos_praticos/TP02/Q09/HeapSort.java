
/*
Trabalho Prático 02

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// ler uma serie de ids dos jogadores e imprimi-los na saida em ordenados pelo altura, utilizando o heap sort

// package Q09;

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

    // get e set id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // get e set nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // get e set altura
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    // get e set peso
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    // get e set universidade
    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getUniversidade() {
        return universidade;
    }

    // get e set anoNascimento
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    // get e set cidadeNascimento
    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    // get e set estadoNascimento
    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    // metodo clone
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

    // imprimir jogador
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

public class HeapSort {
    // numero de comparacoes
    public static int comp = 0;
    public static int mov = 0;

    // ler arquivo em csv e converte para uma string enorme
    public static String[] lerCsv(String path) {
        // abre o arquivo
        // "/tmp/" +
        File file = new File( path);

        // array de strings, com tamanho especifico do arquivo
        String[] data = new String[3922];

        // contador
        int i = 0;

        // le o arquivo e salva cada linha no array de strings
        try {
            // declaracao de scanner
            Scanner sc = new Scanner(file);
            sc.nextLine(); // le a primeira linha

            // faz leituras ate que acabe o arquivo
            while (sc.hasNext()) {
                data[i] = sc.nextLine();
                i++;
            }

            // fechamento camera
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível econtrar o arquivo: " + e.getMessage());
        }

        return data;
    }

    // cria arquivo de log
    public static void criarLog(long tempo) throws IOException {
        File logs = new File("803531_heapsort.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + mov + '\t' + tempo);
        write.close();
    }

    // compara os nomes dos jogadores, caso o ano de nascimento seja igual
    public static boolean compNome(Jogador atual, Jogador tmp) {
        comp += 2;
        return (atual.getAnoNascimento() == tmp.getAnoNascimento() && tmp.getNome().compareTo(atual.getNome()) < 0);
    }

    // método swap
    public static void swap(int x, int y, Jogador[] array) {
        mov += 3;
        Jogador tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // método para construir o heap
    public static void construir(int tamHeap, Jogador[] array) {
        for (int i = tamHeap; i > 1; i /= 2) {
            if (array[i].getAltura() > array[i / 2].getAltura()) {
                // troca filho com pai, se esse for maior
                swap(i, i / 2, array);
                comp++;
            } else if (compNome(array[i], array[i/2])) {
                swap(i, i/2, array);
            }
        }
    }

    // método reconstruir
    public static void reconstruir(int tamHeap, Jogador[] array) {
        int i = 1;
        while (hasFilho(i, tamHeap, array)) {
            int filho = getMaiorFilho(i, tamHeap, array);
            comp++;

            if (array[i].getAltura() < array[filho].getAltura()) {
                swap(i, filho, array);
                i = filho;
                comp++;
            } else if (compNome(array[i], array[filho])) {
                // ordena pelo nome, se alturas forem iguais
                swap(i, filho, array);
            } else {
                i = tamHeap;
            }
        }
    }

    // checa se o elemento tem filho
    public static boolean hasFilho(int i, int tam, Jogador[] array) {
        return (i <= (tam / 2));
    }

    // método para encontrar o maior filho
    public static int getMaiorFilho(int i, int tamHeap, Jogador[] array) {
        int filho;
        if (2 * i == tamHeap || array[2 * i].getAltura() > array[2 * i + 1].getAltura()) {
            filho = 2 * i;
            comp++;
        } else if (array[2 * i].getAltura() == array[2 * i + 1].getAltura()
                && array[2 * i].getNome().compareTo(array[2 * i + 1].getNome()) > 0) {
            filho = 2 * i;
            comp += 2;
        } else {
            filho = 2 * i + 1;
        }

        // retorna o indice do maior filho
        return filho;
    }

    // HEAPSORT pela altura do jogador
    public static void sort(Jogador[] array, int tam) {
        // Alterar o vetor ignorando a posicao zero
        Jogador[] tmp = new Jogador[tam + 1];
        for (int i = 0; i < tam; i++) {
            tmp[i + 1] = array[i];
        }
        array = tmp;

        // contrucao do heap
        for (int tamHeap = 2; tamHeap <= tam; tamHeap++) {
            construir(tamHeap, array);
        }

        // ordenacao propriamente dita
        int tamHeap = tam;
        while (tamHeap > 1) {
            swap(1, tamHeap--, array);
            reconstruir(tamHeap, array);
        }

        // Alterar o vetor para voltar a posicao zero
        tmp = array;
        array = new Jogador[tam];
        for (int i = 0; i < tam; i++) {
            array[i] = tmp[i + 1];
        }
    }

    public static void main(String[] args) {
        // declaracao Scanner
        Scanner sc = new Scanner(System.in);

        // chamada do metodo
        String[] data = lerCsv("players.csv");

        // array de jogadores
        Jogador[] jogadores = new Jogador[data.length];

        // preenche array de jogadores
        for (int i = 0; i < data.length; i++) {
            String aux = data[i];
            Jogador player = new Jogador();
            player.ler(aux);
            jogadores[i] = player;
        }

        // declaracao novo array
        Jogador arrSort[] = new Jogador[1000];
        int tam = 0;

        // salva jogadores (pelo id) em um array para ordenacao
        String input = sc.nextLine();
        while (!input.equals("FIM") && tam < arrSort.length) {
            int id = Integer.parseInt(input);
            arrSort[tam] = jogadores[id];
            tam++;
            input = sc.nextLine();
        }

        // contagem de tempo ------------------------------------
        long startTime = System.currentTimeMillis();

        // ordena o array
        sort(arrSort, tam);

        long endTime = System.currentTimeMillis();
        long tempo = endTime - startTime;
        // fim contagem de tempo --------------------------------

        // imprime o resultado na tela
        for (int i = 0; i < tam; i++) {
            arrSort[i].imprimir();
        }

        // criacao do arquivo log
        try {
            criarLog(tempo);
        } catch (IOException e) {
            System.out.println("Não foi possível criar arquivo: " + e);
        }

        // fechamento do scanner
        sc.close();
    }
}
