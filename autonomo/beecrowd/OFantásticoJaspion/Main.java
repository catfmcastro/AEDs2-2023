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
            String musica[] = new String[linhas];

            for (int j = 0; j < palavras; j++) {
                japones[j] = sc.nextLine();
                portugues[j] = sc.nextLine();
            }

            japones[palavras] = "o";
            japones[palavras + 1] = ".";

            for (int j = 0; j < linhas; j++) {
                musica[j] = sc.nextLine();
            }

            String musicaSplit[];

            for (int j = 0; j < linhas; j++) {
                musicaSplit[j] += musica[j].split(" ");
            }

            for (int j = 0; j < palavras + 2; j++) {
                for (String palavra : musicaSplit) {
                    if (palavra.equals(japones[j])) {
                        System.out.print(portugues[j] + " ");
                    } else {
                        System.out.print(palavra + " ");
                    }
                }
            }
            System.out.println();

        }

        sc.close();
    }
}
