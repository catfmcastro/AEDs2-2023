public class Carro extends Transporte {
    // atributos
    Motor motor = new Motor();
    boolean airbagAberto;
    public static int contador = 0;

    // construtor
    public Carro(){
        super.placa = "YYYYYYY";
    }

    // método abstrato da classe pai
    @Override
    String buzinar(){
        return "BIBIBIBIBIBIBI!!!!";
    }

    // abrir airbag
    public void abrirAirBag(){
        airbagAberto = true;
    }

}