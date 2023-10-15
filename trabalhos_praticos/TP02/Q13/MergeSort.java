/*
Trabalho Prático 02

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// ler uma serie de ids dos jogadores e imprimi-los na saida em ordenados pela universidade, utilizando o merge sort

// package Q07;

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

class MergeSort {
    // numero de comparacoes
    public static int comp = 0;
    public static int mov = 0;

    // ler arquivo em csv e converte para uma string enorme
    public static String[] lerCsv(String path) {
        // abre o arquivo
        // "/tmp/" +
        File file = new File("/tmp/" + path);

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
        File logs = new File("803531_mergesort.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + mov + '\t' + tempo);
        write.close();
    }

    // método swap
    public static void swap(int x, int y, Jogador[] array) {
        mov += 3;
        Jogador tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    // compara os nomes dos jogadores, caso o ano de nascimento seja igual
    public static boolean compNome(Jogador atual, Jogador tmp) {
        return (tmp.getUniversidade().compareTo(atual.getUniversidade()) == 0 && tmp.getNome().compareTo(atual.getNome()) < 0);
    }

    // MERGE SORT pela universidade do jogador
    public static void sort(Jogador[] array, int esq, int dir) {
        comp++;
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            sort(array, esq, meio);
            sort(array, meio + 1, dir);
            merge(array, esq, meio, dir);
        }
    }

    public static void merge(Jogador[] array, int esq, int meio, int dir) {
        // tamanho dos subarrays
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        // declaracao de subarrays
        Jogador[] arrEsq = new Jogador[n1];
        Jogador[] arrDir = new Jogador[n2];

        // preenchimento dos arrays
        for (int i = 0; i < n1; i++) {
            mov++;
            arrEsq[i] = array[esq + i];
        }
        for (int j = 0; j < n2; j++) {
            mov++;
            arrDir[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0, k = esq;

        // sort por universidades
        while (i < n1 && j < n2) {
            comp += 3;
            if (arrEsq[i].getUniversidade().compareTo(arrDir[j].getUniversidade()) < 0) {
                array[k] = arrEsq[i];
                i++;
            } else if (compNome(arrEsq[i], arrDir[j])) {
                array[k] = arrEsq[i];
                i++;
                comp += 2;
            } else {
                array[k] = arrDir[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            mov++;
            array[k] = arrEsq[i];
            i++;
            k++;
        }

        while (j < n2) {
            mov++;
            array[k] = arrDir[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // declaracao Scanner
        Scanner sc = new Scanner(System.in);

        // chamada do metodo
        String[] data = lerCsv("playersAtualizado.csv");

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
        sort(arrSort, 0, tam);

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
