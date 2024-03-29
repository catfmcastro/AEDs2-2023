/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê o nome de uma página web e seu conteúdo, e mostra o número de vogais (sem e com acento), consoantes, e dos padrões <br> e <table>

package TP01;

import java.io.*;
import java.net.*;

public class Q07 {
    // Método para condição de parada das entradas
    public static boolean acabou(String s) {

        if (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') {
            return true; // Se input for "FIM", retorna true
        } else {
            return false; // Se não, retorna false
        }
    }

    // Converte url e html em string
    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    // Checa se o char é uma vogal
    public static boolean isVogal(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            case '\u00E1': // á
            case '\u00E9': // é
            case '\u00ED': // í
            case '\u00F3': // ó
            case '\u00FA': // ú
            case '\u00E0': // à
            case '\u00E8': // è
            case '\u00EC': // ì
            case '\u00F2': // ò
            case '\u00F9': // ù
            case '\u00E3': // ã
            case '\u00F5': // õ
            case '\u00E2': // â
            case '\u00EA': // ê
            case '\u00EE': // î
            case '\u00F4': // ô
            case '\u00FB': // û
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args){
        // Declaração de variáveis
        String endereco, html;
        String nome = "";
        
        while(!acabou(nome)){
            // Declaração de variáveis contadoras
            int a = 0, e = 0, i = 0, o = 0, u = 0; // vogais sem acento
            int aAgu = 0, eAgu = 0, iAgu = 0, oAgu = 0, uAgu = 0; // vogais com acento agudo
            int aCras = 0, eCras = 0, iCras = 0, oCras = 0, uCras = 0; // vogais com crase
            int aTil = 0, oTil = 0; // vogais com til
            int aCirc = 0, eCirc = 0, iCirc = 0, oCirc = 0, uCirc = 0; // vogais com circunflexo
            int consoantes = 0;
            int br = 0, table = 0; // elementos do html

            // Entrada nome da página web
            nome = MyIO.readLine();

            // Interrupção do loop
            if(acabou(nome)){
                break;
            }

            // Entrada do endereço
            endereco = MyIO.readLine();

            // Converte url em string html
            html = getHtml(endereco);

            for(int j = 0; j<html.length(); j++){
                char c = html.charAt(j);

                // contagem de vogais, acentuadas ou nao
                if(isVogal(c)){
                    switch (Character.toLowerCase(c)) {
                        case 'a':
                            a++;
                            break;
                        case 'e':
                            e++;
                            break;
                        case 'i':
                            i++;
                            break;
                        case 'o':
                            o++;
                            break;
                        case 'u':
                            u++;
                            break;
                        case '\u00E1': // á
                            aAgu++;
                            break;
                        case '\u00E9': // é
                            eAgu++;
                            break;
                        case '\u00ED': // í
                            iAgu++;
                            break;
                        case '\u00F3': // ó
                            oAgu++;
                            break;
                        case '\u00FA': // ú
                            uAgu++;
                            break;
                        case '\u00E0': // à
                            aCras++;
                            break;
                        case '\u00E8': // è
                            eCras++;
                            break;
                        case '\u00EC': // ì
                            iCras++;
                            break;
                        case '\u00F2': // ò
                            oCras++;
                            break;
                        case '\u00F9': // ù
                            uCras++;
                            break;
                        case '\u00E3': // ã
                            aTil++;
                            break;
                        case '\u00F5': // õ
                            oTil++;
                            break;
                        case '\u00E2': // â
                            aCirc++;
                            break;
                        case '\u00EA': // ê
                            eCirc++;
                            break;
                        case '\u00EE': // î
                            iCirc++;
                            break;
                        case '\u00F4': // ô
                            oCirc++;
                            break;
                        case '\u00FB': // û
                            uCirc++;
                            break;
                    }
                }

                // contagem de consoantes
                if((c >= 'a' && c <= 'z')){
                    consoantes++;
                }

                // contagem de breaks e tables
                if(j + 4 < html.length() && html.charAt(j) == '<' && html.charAt(j + 1) == 'b' && html.charAt(j + 2) == 'r' && html.charAt(j + 3) == '>'){
                    br++; // <br>
                    consoantes -= 2;
                }
                if(j + 6 < html.length() && html.charAt(j) == '<' && html.charAt(j + 1) == 't' && html.charAt(j + 2) == 'a' && html.charAt(j + 3) == 'b' && html.charAt(j + 4) == 'l' && html.charAt(j + 5) == 'e' && html.charAt(j + 6) == '>'){
                    table++; // <table>
                    consoantes -= 3;
                    a--;
                    e--;
                }
            }

            // Imprime resultado na tela
            MyIO.println("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") á(" + aAgu + ") é(" + eAgu + ") í(" + iAgu + ") ó(" + oAgu + ") ú(" + uAgu + ") à(" + aCras + ") è(" + eCras + ") ì(" + iCras + ") ò(" + oCras + ") ù(" + uCras + ") ã(" + aTil + ") õ(" + oTil + ") â(" + aCirc + ") ê(" + eCirc + ") î(" + iCirc + ") ô(" + oCirc + ") û(" + uCirc + ") consoante(" + consoantes + ") <br>(" + br + ") <table>(" + table + ") " + nome);
        }
    }
}