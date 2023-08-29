import java.io.*;
import java.nio.charset.*;

/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

// Exemplo de uso da classe BufferedReader

public class ExemploBufferedReader {
    // Declaração do método BufferedReader
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    // Método para a leitura de string
    public static String readString(){
        String s = "";
        char tmp;
        try{
           do{
              tmp = (char)in.read();
              if(tmp != '\n' && tmp != ' ' && tmp != 13){
                 s += tmp;
              }
           }while(tmp != '\n' && tmp != ' ');
        }catch(IOException ioe){}
        return s;
     }

     public static void main(String [] args) throws Exception {

        System.out.printf("Insira uma string: ");
        String s = readString();
  
        System.out.printf("Insira um numero inteiro: ");
        int i = Integer.parseInt(readString().trim());
  
        System.out.printf("Insira um numero real: ");
        double d = Double.parseDouble(readString().trim().replace(",","."));
  
        System.out.printf("Insira um caractere: ");
        char c = (char)in.read();
  
        System.out.println("\n\nOs valores inseridos foram: " + s + " " + i + " " + d + " " + c);
      }
} 
