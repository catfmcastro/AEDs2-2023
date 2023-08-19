/*
Unidade 00 - Nivelamento
Introdução a Orientação por Objetos

Catarina F. M. Castro - 803531

AEDs II
*/

// Classe retangulo com atributos getArea, getPerimetro e getDiagonal

package AEDS2_2023.u00_exercicios_CatarinaCastro.u00l_intro_OO.ex1;

public class Retangulo {
   // Declaração de atributos
   private double base;
   private double altura;

   // Construtor vazio
   public Retangulo(){
     base = altura = 0;
   }

   // Construtor com parametros
   public Retangulo(double b, double a){
     base = b;
     altura = a;
   }

   // Retorna área
   public double getArea(){
     return base*altura;
   }

   // Retorna perimetro
   public double getPerimetro(){
     return ((2*base) + (2*altura));
   }
   
   public double getDiagonal(){
     return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
   } 
}
