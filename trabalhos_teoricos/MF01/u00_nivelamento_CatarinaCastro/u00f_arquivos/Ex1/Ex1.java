/*
Unidade 00 - Nivelamento
Arquivos

Catarina F. M. Castro - 803531

AEDs II
*/

<<<<<<< HEAD:u00_exercicios_CatarinaCastro/u00f_arquivos/ex1.java
// Manipulação de arquivos utilizando a classe local Arq.java
=======
package AEDS2_2023;

public class Ex1 {
    public static void main(String[] args){
        Arq.openWrite("arquivo.txt");
>>>>>>> af3569b26e5ca024a83cfefe00a557c92d5209c3:u00_nivelamento_CatarinaCastro/u00f_arquivos/Ex1/Ex1.java

import u00f_arquivos.Arq;

class Ex1 {
    public static void main (String[] args){
        Arq.openWrite("exemplo.txt");
        Arq.println(1);
        Arq.println(5.3);
        Arq.println('X');
        Arq.println(true);
        Arq.println("Algoritmos");
        Arq.close();
    }
}
