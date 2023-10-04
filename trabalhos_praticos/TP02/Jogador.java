/*
    Trabalho Prático 02

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// criacao da classe Jogador, em java, com pelo menos dois construtores, e os metodos gets, sets, clone, imprimir e ler. 

package TP02;

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
    public Jogador(){
        Jogador x = new Jogador();
    }
    // construtor com parametros
    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
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
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
 
    // get e set nome
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    // get e set altura
    public void setAltura(int altura){
        this.altura = altura;
    }
    public int getAltura(){
        return altura;
    }

    // get e set peso
    public void setPeso(int peso){
        this.peso = peso;
    }
    public int getPeso(){
        return peso;
    }

    // get e set universidade
    public void setUniversidade(String universidade){
        this.universidade = universidade;
    }
    public String getUniversidade(){
        return universidade;
    }

    // get e set anoNascimento
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }
    public int getAnoNascimento(){
        return anoNascimento;
    }

   // get e set cidadeNascimento
   public void setCidadeNascimento(String cidadeNascimento){
        this.cidadeNascimento = cidadeNascimento;
   }
   public String getCidadeNascimento(){
        return cidadeNascimento;
   }
 
   // get e set estadoNascimento
   public void setEstadoNascimento(String estadoNascimento){
        this.estadoNascimento = estadoNascimento;
   }
   public String getEstadoNascimento(){
        return estadoNascimento;
   }


   // metodo clone 
   public void clone(Jogador x){
        this.id = x.id;
        this.nome = x.nome;
        this.altura = x.altura;
        this.peso = x.peso;
        this.universidade = x.universidade;
        this.anoNascimento = x.anoNascimento;
        this.cidadeNascimento = x.cidadeNascimento;
        this.estadoNascimento = x.estadoNascimento;
   }
   
   
}
