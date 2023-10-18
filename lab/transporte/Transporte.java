// estudo sobre classes

// classe abstract: não pode ser instanciada
public abstract class Transporte {
    // atributos
    private int capacidade;
    private double velocidade;
    protected final String placa; // atributo final: não pode ser alterado

    // construtor
    public Transporte() {
        placa = "XXXXXX";
    }

    public Transporte(int c, String p) {
        capacidade = c;
        placa = p;
    }

    // getters e setter
    // método final: não pode ser sobreescrito
    public final void setCapacidade(int x) {
        capacidade = x; // uma vez decidida a capacidade do carro, essa nao pode ser alterada
    }

    // método abstrato (todas as subclasses devem ter)
    abstract String buzinar();

    // metodo frear
    public void freiar() {
        velocidade--;
    }

    // metodo acelerar
    public void acelerar() {
        velocidade++;
    }
}
