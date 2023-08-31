/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê uma string e checa se é um palindromo ou não, em java

package TP01;

public class Q01 {
    public static void main(String[] args){
        // Declaracao de variaveis
        boolean resp = true;
        String s = " ";

        // Checa se a frase inserida é palindromo
        while (!(s.equals("FIM"))){
            
            // Entrada de String
            s = MyIO.readLine();

            // Interrompe o loop se "FIM" for digitado
            if (s.equals("FIM")){
                break;
            }

            // Compara os caracteres da string
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) != s.charAt(s.length()-1-i)){
                    resp = false;
                    i = s.length();
                }
                else{
                    resp = true;
                }
            }

            // Imprime o resultado na tela
            if (resp == false){
                MyIO.println("NAO");
            }
            else{
                MyIO.println("SIM");
            }
        }
    }

}