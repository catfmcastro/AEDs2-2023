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
    public static boolean acabou(String s){
    
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }
    
    // Converte url e html em string
    public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
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


    public static void main(String[] args){
        // Declaração de variáveis
        String endereco, html;
        String nome = "";

        // Declaração de variáveis contadoras
        int a = 0, e = 0, i = 0, o = 0, u = 0; // vogais sem acento
        int aAgu = 0, eAgu = 0, iAgu = 0, oAgu = 0, uAgu = 0; // vogais com acento agudo
        int aCras = 0, eCras = 0, iCras = 0, oCras = 0, uCras = 0; // vogais com crase
        int aTil = 0, oTil = 0; // vogais com til
        int aCirc = 0, eCirc = 0, iCirc = 0, oCirc = 0, uCirc = 0; // vogais com circunflexo
        int consoantes = 0;
        int br = 0, table = 0; // elementos do html

        while(!acabou(nome)){
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

            for(int j = 0; j+6<html.length(); j++){
                char c = html.charAt(j);

                if(c == 'a'){
                    a++;
                }
                if(c == 'e'){
                    e++;
                }
                if(c == 'i'){
                    i++;
                }
                if(c == 'o'){
                    o++;
                }
                if(c == 'u'){
                    u++;
                }
                if(c == '\u00e1'){
                    aAgu++; // á
                }
                if(c == '\u00e9'){
                    eAgu++; // é
                }
                if(c == '\u00ed'){
                    iAgu++; // í
                }
                if(c == '\u00f3'){
                    oAgu++; // ó
                }
                if(c == '\u00fa'){
                    uAgu++; // ú
                }
                if(c == '\u00e0'){
                    aCras++; // à
                }
                if(c == '\u00e8'){
                    eCras++; // è
                }
                if(c == '\u00ec'){
                    iCras++; // ì
                }
                if(c == '\u00f2'){
                    oCras++; // ò
                }
                if(c == '\u00f9'){
                    uCras++; // ù
                }
                if(c == '\u00e3'){
                    aTil++; // ã
                }
                if(c == '\u00f5'){
                    oTil++; // õ
                }
                if(c == '\u00e2'){
                    aCirc++; // â
                }
                if(c == '\u00ea'){
                    eCirc++; // ê
                }
                if(c == '\u00ee'){
                    iCirc++; // î
                }
                if(c == '\u00f4'){
                    oCirc++; // ô
                }
                if(c == '\u00fb'){
                    uCirc++; // û
                }
                if(c == '\u003c' && c+1 == 'b' && c+2 == 'r' && c+3 == '\u003e'){
                    br++; // <br>
                }
                if(c == '\u003c' && c+1 == 't' && c+2 == 'a' && c+3 == 'b' && c+4 == 'l' && c+5 == 'e' && c+6 == '\u003e'){
                    table++; // <table>
                }

            }

            // Imprime resultado na tela
            MyIO.println("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") á(" + aAgu + ") é(" + eAgu + ") í(" + iAgu + ") ó(" + oAgu + ") ú(" + uAgu + ") à(" + aCras + ") è(" + eCras + ") ì(" + iCras + ") ò(" + oCras + ") ù(" + uCras + ") ã(" + aTil + ") õ(" + oTil + ") â(" + aCirc + ") ê(" + eCirc + ") î(" + iCirc + ") ô(" + oCirc + ") û(" + uCirc + ") consoante(" + consoantes + ") \u003cbr\u003e(" + br + ") \u003ctable\u003e(" + table + ")");
        }

    }
}
