/*
Trabalho Prático 04

@catfmcastro
Catarina F. M. Castro

AEDs II
*/

// tabela hash direta com reserva, com inserções de objetos jogador com base no atributo ALTURA % tamTabela

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

class Hash {
    public static int comp = 0;

    Jogador tabela[];
    int m1, m2, m, reserva;

    public Hash() {
        this(21, 9);
    }

    public Hash(int m1, int m2) {
        this.m1 = m1;
        this.m2 = m2;
        this.m = m1 + m2;
        this.tabela = new Jogador[this.m];
        for (int i = 0; i < m1; i++) {
            tabela[i] = null;
        }
        this.reserva = 0;
    }

    public int h(Jogador x) {
        return Math.abs(x.getAltura()) % 21;
    }

    public boolean inserir(Jogador x) {
        boolean resp = false;
        if (x != null) {
            comp++;
            int pos = h(x);
            if (tabela[pos] == null) {
                comp++;
                tabela[pos] = x;
                resp = true;
            } else if (reserva < m2) {
                comp += 2;
                tabela[m1 + reserva] = x;
                reserva++;
                resp = true;
            }
        }
        return resp;
    }

    public void pesquisar(Jogador x) {
        boolean resp = false;
        resp = pesquisar(x, resp);

        if (resp == true) {
            System.out.print("SIM");
        } else {
            System.out.print("NAO");
        }
        System.out.println();
    }

    private boolean pesquisar(Jogador x, boolean resp) {
        int pos = h(x);
        if (tabela[pos] != null && tabela[pos].getNome().equals(x.getNome())) {
            comp++;
            resp = true;
        } else if (tabela[pos] != null) {
            for (int i = 0; i < reserva; i++) {
                if (tabela[m1 + i].getNome().equals(x.getNome())) {
                    resp = true;
                    i = reserva;
                }
            }
        }
        return resp;
    }

    public void mostrar() {
        System.out.println("os jogadores inseridos no hash são: ");
        for (int i = 0; i < m1; i++) {
            System.out.println(tabela[i].getNome());
        }

        System.out.println();
        System.out.println("e na reserva são: ");

        for (int i = 0; i < reserva; i++) {
            System.out.println(tabela[m1 + i].getNome());
        }
    }

    // cria arquivo de log
    public static void criarLog(long tempo) throws IOException {
        File logs = new File("803531_hashReserva.txt");
        FileWriter write = new FileWriter(logs);
        write.write("803531" + '\t' + comp + '\t' + tempo);
        write.close();
    }
}

public class HashReserva {
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

        Hash hash = new Hash();

        // insere jogadores em suas respectivas arvores
        while (!sc.hasNext("FIM")) {
            int input = sc.nextInt();
            int id = input;
            hash.inserir(jogadores[id]);
        }

        sc.nextLine();
        sc.nextLine();

        // inicio contagem de tempo --------------------
        long startTime = System.currentTimeMillis();

        // pesquisa de jogadores no hash
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
                hash.pesquisar(tmp);
            }
        }

        long endTime = System.currentTimeMillis();
        // fim contagem de tempo --------------------

        // criação do arquivo de log
        long duracao = endTime - startTime;
        Hash.criarLog(duracao);

        sc.close();
    }
}
