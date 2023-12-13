/*
 * O Fantástico Jaspion
 * 
 * @catfmcastro
 * Catarina F. M. Castro
 * 
 * Beecorwd
*/

// tradução de uma música em japonês

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int instancias;
        int palavras, linhas;

        instancias = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < instancias; i++) {
            String leituraInt = sc.nextLine();
            String valores[] = leituraInt.split(" ");

            palavras = Integer.parseInt(valores[0]);
            linhas = Integer.parseInt(valores[1]);

            String japones[] = new String[palavras + 2];
            String portugues[] = new String[palavras + 2];
            String musica = "";

            for (int j = 0; j < palavras; j++) {
                japones[j] = sc.nextLine();
                portugues[j] = sc.nextLine();
            }

            // quando for "o", imprime "o"
            japones[palavras] = "o";
            portugues[palavras] = "o";

            // quando for ".", imprime \n
            japones[palavras + 1] = ".";
            portugues[palavras + 1] = "\n";

            for (int j = 0; j < linhas; j++) {
                musica += sc.nextLine();
                musica += " ";
                musica += ".";
                musica += " ";
            }

            String musicaSplit[] = musica.split("\\s+");
            String solucao = "";

            for (int j = 0; j < musicaSplit.length; j++) {
                for (int k = 0; k < japones.length; k++) {
                    if (musicaSplit[j].equals(japones[k])) {
                        solucao += portugues[k];
                        solucao +=  " ";
                    }
                }
            }

            System.out.println(solucao);
        }

        sc.close();
    }
}
