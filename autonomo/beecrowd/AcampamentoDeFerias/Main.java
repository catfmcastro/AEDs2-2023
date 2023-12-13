/*
 * Acampamento de Férias
 * 
 * @catfmcastro
 * Catarina F. M. Castro
 * 
 * Beecorwd
*/

// brincadeira em roda com crianças em um acampamento de férias

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n; // numero de crianças que vao participar da brincadeira
        String input = "";

        while (!sc.hasNext("0")) {
            n = sc.nextInt();
            sc.nextLine();

            String[] nome = new String[n];
            int[] valor = new int[n];

            for (int i = 0; i < n; i++) {
                input = sc.nextLine();
                String[] aux = input.split(" ");

                nome[i] = aux[0];
                valor[i] = Integer.parseInt(aux[1]);
            }

            int index = 1;
            int cont = valor[index - 1];
            int tmp = valor[index];
            int restantes = valor.length;

            for (int i = 0; i < valor.length; i++) {
                System.out.println("tmp % 2 = " + tmp%2);
                if (tmp % 2 == 0) { // contar no sentido horário
                    System.out.println("tmp começa em: " + tmp);
                    while (cont > 0) {
                        if (index < 0) {
                            tmp = valor[valor.length - 1];
                            index = valor.length - 1;
                            System.out.println("limite horario - tmp é: " + tmp);
                        } else {
                            tmp = valor[index];
                            index--;
                            System.out.println("tmp é: " + tmp);
                        }
                        cont--;
                    }
                    cont = tmp;

                } else { // contar no sentido anti-horario
                    System.out.println("tmp começa em: " + tmp);
                    while (cont > 0) {
                        if (index > valor.length - 1) {
                            index = 0;
                            tmp = valor[0];
                            System.out.println("limite anti-horario - tmp é: " + tmp);
                        } else {
                            tmp = valor[index];
                            index++;
                            System.out.println("tmp é: " + tmp);
                        }
                        cont--;
                    }
                    cont = tmp;
                }
            }

        }

        sc.close();
    }
}
