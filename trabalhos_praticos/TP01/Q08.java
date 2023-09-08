/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ler um inteiro n que indica o número de valores reais que serão lidos e salvos em um arquivo texto. Fechar o arquivo
// Reabrir o arquivo e utilizar os métodos getFilePointer e seek (da classe RAF) e mostrar os valores lidos na tela

package TP01;

import java.io.RandomAccessFile;

public class Q08 {
    public static void main(String[] args) throws Exception {
        int n = MyIO.readInt(); // quant de numeros que serão inseridos
        try {
            // Declaraçao de variaveis
            RandomAccessFile raf = new RandomAccessFile("arq.txt", "rw");

            // entradas
            for (int i = 0; i < n; i++) {
                // double numero = MyIO.readDouble();
                raf.writeDouble(MyIO.readDouble());
                raf.writeBytes("\n");
            }

            // Fechamento de arquivo
            raf.close();

            // Reabre o arquivo
            raf = new RandomAccessFile("arq.txt", "r");

            // Posiciona o ponteiro no final do arq
            raf.seek(raf.length());

            // percorre o arquivo
            for (int i = 0; i < n; i++) {
                raf.seek((n - i - 1) * (Double.BYTES + 1)); // Calcula a posição correta
                double num = raf.readDouble(); // lê o número do arquivo
                int aux = (int) num;

                // imprime o resultado na tela
                if (num - aux == 0) {
                    MyIO.println(aux);
                } else {
                    MyIO.println(num);
                }

            }

            // fechamento do arquivo
            raf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
