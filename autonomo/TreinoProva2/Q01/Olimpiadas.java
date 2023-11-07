/*
    Treino Prova 2 - Q01
    Olimpiadas de Natal

    @catfmcastro
    Catarina F. M. Castro
*/

// ordenacao de paises com base nas medalhas ganhas nas olimpiadas

import java.util.Scanner;

import javax.xml.crypto.dsig.keyinfo.X509Data;

class Pais {
    String nome;
    int ouro;
    int prata;
    int bronze;

    public Pais() {
        nome = "";
        ouro = 0;
        prata = 0;
        bronze = 0;
    }

    public Pais(String nome) {
        this.nome = nome;
        ouro = 0;
        prata = 0;
        bronze = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getOuro() {
        return ouro;
    }

    public void wonOuro() {
        ouro++;
    }

    public int getPrata() {
        return prata;
    }

    public void wonPrata() {
        prata++;
    }

    public int getBronze() {
        return bronze;
    }

    public void wonBronze() {
        bronze++;
    }
}

public class Olimpiadas {
    public static void main(String[] args) {
        // declaracao variaveis
        Scanner sc = new Scanner(System.in);
        Pais[] array = new Pais[400];
        int tam = 1;

        // entrada
        while (sc.hasNext()) {
            sc.nextLine(); // ler modalidade

            // ler pais ganhador ouro
            String pais = sc.nextLine();
            for (int i = 0; i < tam && tam < 400; i++) {
                if (array[i].getNome().equals(pais)) {
                    array[i].wonOuro(); // incrementa ouro se pais exisir
                    i = tam;
                }

                if (i == tam && tam < 400) {
                    array[tam - 1] = new Pais(pais); // cria novo pais se não existir
                    array[tam - 1].wonOuro();
                    tam++;
                }
            }

            // ler pais ganhador prata
            pais = sc.nextLine();
            for (int i = 0; i < tam && tam < 400; i++) {
                if (array[i].getNome().equals(pais)) {
                    array[i].wonPrata(); // incrementa prata se pais exisir
                    i = tam;
                }
                if (i == tam && tam < 400) {
                    array[tam - 1] = new Pais(pais); // cria novo pais se não existir
                    array[tam - 1].wonPrata();
                    tam++;
                }
            }

            // ler pais ganhador bronze
            pais = sc.nextLine();
            for (int i = 0; i < tam && tam < 400; i++) {
                if (array[i].getNome().equals(pais)) {
                    array[i].wonBronze(); // incrementa bronze se pais exisir
                    i = tam;
                }
                if (i == tam && tam < 400) {
                    array[tam - 1] = new Pais(pais); // cria novo pais se não existir
                    array[tam - 1].wonBronze();
                    tam++;
                }
            }
        }

        // insertion sort
        for (int i = 1; i < tam; i++) {
            Pais tmp = array[i];
            int j = i - 1;

            while ((j >= 0)) {
                if (array[j].getOuro() > tmp.getOuro()) {
                    array[j + 1] = array[j];
                    j--;
                } else if (array[j].getOuro() == tmp.getOuro()) {

                    if (array[j].getPrata() > tmp.getPrata()) {
                        array[j + 1] = array[j];
                        j--;
                    } else if (array[j].getPrata() == tmp.getPrata()) {

                        if (array[j].getBronze() > tmp.getBronze()) {
                            array[j + 1] = array[j];
                            j--;
                        } else if (array[j].getBronze() == tmp.getBronze()) {

                            if (array[j].getNome().compareTo(tmp.getNome()) < 0) {
                                array[j + 1] = array[j];
                                j--;
                            }

                        }
                    }
                }
            }
            array[j + 1] = tmp;
        }

        // saida
        System.out.println("Quadro de Medalhas");
        for (int i = 0; i < tam; i++) {
            System.out.println(array[i].getNome() + " " + array[i].getOuro() + " " + array[i].getPrata() + " "
                    + array[i].getBronze());
        }

        sc.close(); // fechamento scanner
    }
}
