/*
Unidade 00 - Nivelamento
Introdução a Orientação por Objetos

Catarina F. M. Castro - 803531

AEDs II
*/

// Classe Lixao/principal

package AEDS2_2023.u00_exercicios_CatarinaCastro.u00l_intro_OO.ex1;

public class Lixao {
    public static void main(String[] args){
        // Declaracao de objetos e de variaveis
        Retangulo r1 = new Retangulo(10, 4);
        Retangulo r2 = new Retangulo(5, 2);

        // Imprime os resultados na saída
        System.out.println("Retângulo 1\n Área: " + r1.getArea() + "\nPerímetro: " + r1.getPerimetro() + "\nDiagonal: " + r1.getDiagonal());
        System.out.println("Retângulo 1\n Área: " + r2.getArea() + "\nPerímetro: " + r2.getPerimetro() + "\nDiagonal: " + r2.getDiagonal());
    }
}
