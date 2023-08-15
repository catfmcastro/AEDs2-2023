import java.util.Scanner;
import java.util.Formatter;
import java.io.*;

/*
Unidade 00 - Nivelamento
Exercícios de Arquivos

Catarina F. M. Castro - 803531

AEDs II
*/

public class ex1 {
    public static void main(String[] args){
        Arq.openWrite("arquivo.txt");

        Arq.println("Testando o meu primeiro arquivo em Java! :)");
        Arq.println("1, 2, 3, 4, 5!");
        Arq.println("Arquivo!!");

        Arq.close();
    }
}
