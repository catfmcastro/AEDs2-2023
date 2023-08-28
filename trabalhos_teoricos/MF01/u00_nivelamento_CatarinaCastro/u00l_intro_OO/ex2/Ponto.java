/*
Unidade 00 - Nivelamento
Introdução a Orientação por Objetos

Catarina F. M. Castro - 803531

AEDs II
*/

// Classe ponto

package ex2;

public class Ponto {
    // Declaracao dos atributos
    private double x;
    private double y;
    private int id;
    private static int nextID = 0;

    // Construtor sem parametros
    public Ponto(){
        id = nextID;
        nextID++;
        x = 0;
        y = 0;
    }

    // Construtor com parâmetros
    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    // Setters
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

}
