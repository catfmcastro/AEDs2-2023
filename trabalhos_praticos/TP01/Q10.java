/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Lê uma string e checa se é um palindromo ou não (recursivamente, em java)

package TP01;

public class Q10 {
    // Método flag
    public static boolean acabou(String s){

        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    // Inicializa o contador
    public static boolean isPalindromo(String s){
        return isPalindromo(s, 0);
    }

    // Checa se a palavra é palindromo
    public static boolean isPalindromo(String s, int i){
        // Declaração de variáveis
        boolean resp;

        if(i == s.length()){
            return true;
        }
        else{
            // Compara os caracteres da string
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                // Não é palindromo
                resp = false;
                return resp;
            }
            else{
                resp = true;

                // Chamada recursiva
                resp = isPalindromo(s, i + 1);
            }

        } 

        return resp;
    }
    
    public static void main(String[] args){
        // Declaração de variáveis
        String s = "";

        while(!acabou(s)){
            // Input
            s = MyIO.readLine();

            // Interrupção do loop
            if(acabou(s)){
                break;
            }

            // Chamara da função
            boolean resp = isPalindromo(s);

            if(resp){
                MyIO.println("SIM");
            }
            else{
                MyIO.println("NAO");
            }

        }
    }
}
