/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ler um inteiro n que indica o número de valores reais que serão lidos e salvos em um arquivo texto. Fechar o arquivo
// Reabrir o arquivo e utilizar os métodos getFilePointer e seek (da classe RAF) e mostrar os valores lidos na tela

package TP01;

import java.io.*;

public class Q08 {
    public static void main(String[] args) throws Exception{
        
        // Declaraçao de variaveis
        RandomAccessFile raf = new RandomAccessFile ("arq.txt","rw");
        int n = MyIO.readInt(); // quant de numeros que serão inseridos

        // entradas
        for(int i = 0; i<n; i++){
            double numero = MyIO.readDouble();

            raf.writeDouble(numero);
            raf.writeChar('\n');
        }

        // Fechamento de arquivo
        raf.close();

        // Reabre o arquivo
        raf = new RandomAccessFile("arq.txt", "r");

        // percorre o arquivo de modo invertido
        for(int i = 0; i < n; i++){
            raf.seek((n-i-1) * 8); // última posição do arquivo * 8 (tamanho de um double)

            double num = raf.readDouble(); // salva o número da linha em um double
            int aux = (int) num; // converte para inteiro

            if(num - aux == 0){
                MyIO.println(aux);
            }
            else{
                MyIO.println(num);
            }
        }

        // fechamento do arquivo
        raf.close();
    }
}
