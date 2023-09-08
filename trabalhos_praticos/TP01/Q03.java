/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ciframento de César, em java, com a chave do ciframento três

package TP01;

public class Q03{
    // Método para condição de parada das entradas
    public static boolean acabou(String s){
        
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    // Método para criptografia de strings com Cifra de César
    public static String cifra(String s){
        // Declaracao de variaveis
        String resp = "";

        // Loop para realizar o ciframento
        for(int i = 0; i<s.length(); i++){

            if(s.charAt(i) >= 0 && s.charAt(i) <= 127){
                resp += (char)(s.charAt(i) + 3);
            }
            else{
                // exceção para o caractere especial
                resp += (char)s.charAt(i);
            }
        }

        return resp;
    }

    public static void main(String[] args){
        // Declaração de varáveis
        String s = "";
        String resp;

        // Loop para recebimento de entradas
        while(!(acabou(s))){
            // Entrada
            s = MyIO.readLine();

            // Interrupção do loop
            if(acabou(s)){
                break;
            }

            // Chamada do método
            resp = cifra(s);
            
            // Imprime o resultado
            MyIO.println(resp);
        }

    }

}