/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê uma string e checa se é um palindromo ou não, em java

package TP01;

public class Q01 {
    // Método para condição de parada das entradas
    public static boolean acabou(String s){
    
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    public static void main(String[] args){
        // Declaracao de variaveis
        boolean resp = true;
        String s = " ";

        // Checa se a frase inserida é palindromo
        while (!(acabou(s))){
            
            // Entrada de String
            s = MyIO.readLine();

            // Interrompe o loop se "FIM" for digitado
            if (acabou(s)){
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