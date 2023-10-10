/*
    Trabalho Prático 02

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// criacao da classe Jogador, em java, com pelo menos dois construtores, e os metodos gets,T sets, clone, imprimir e ler. 
// ler arquivo com todos os jogadores, depois, ler entrada de ids e imprimis suas respectivas informações na saida

//package Q01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jogador {
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

    // ler arquivo em csv e converte para uma string enorme
    public static String[] lerCsv(String path) {
        // abre o arquivo
        File file = new File("/tmp/" + path);

        // array de strings, com tamanho especifico do arquivo
        String[] data = new String[3922];

        // contador
        int i = 0;

        // le o arquivo e salva cada linha no array de strings
        try {
            // declaracao de scanner
            Scanner sc = new Scanner(file);
            sc.nextLine(); // le a primeira linha (irrelevante)

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

    // metodo main
    public static void main(String[] args) {
        // declaracao Scanner
        Scanner sc = new Scanner(System.in);

        // chamada do metodo
        String[] data = lerCsv("players.csv");

        // array de jogadores
        Jogador[] jogadores = new Jogador[data.length];

        // salva dados do file csv no array de objetos
        for (int i = 0; i < data.length; i++) {
            String aux = data[i];
            Jogador player = new Jogador();
            player.ler(aux);
            jogadores[i] = player;
        }

        // imprme players com base no id
        String input = sc.nextLine();
        while (!input.equals("FIM")) {
            int id = Integer.parseInt(input);
            jogadores[id].imprimir();
            input = sc.nextLine(); // nova entrada
        }

        // fechamento do scanner
        sc.close();
    }
}
