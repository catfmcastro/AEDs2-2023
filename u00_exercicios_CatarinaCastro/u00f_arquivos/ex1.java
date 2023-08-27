/*
Unidade 00 - Nivelamento
Arquivos

Catarina F. M. Castro - 803531

AEDs II
*/

// Manipulação de arquivos utilizando a classe local Arq.java

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
