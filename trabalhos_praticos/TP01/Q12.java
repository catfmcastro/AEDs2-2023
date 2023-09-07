/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Ciframento de César, em java, com a chave do ciframento três (recursivamente)

package TP01;

public class Q12 {
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
    public static String cifra(String s){
        return cifra(s, 0, "");
    }

    // Realiza o Ciframento de César
    public static String cifra(String s, int i, String resp){

        if(i == s.length()){
            return resp;
        }
        else{
            if(s.charAt(i) >= 0 && s.charAt(i) <= 127){
                resp += (char)(s.charAt(i) + 3);
                
                // Chamada recursiva
                return cifra(s, (i+1), resp);
            }
            else{
                // exceção para o caractere especial
                resp += (char)s.charAt(i);

                // Chamada recursiva
                return cifra(s, (i+1), resp);
            }
        }
    }

    public static void main(String[] args){
        // Declaração de variáveis
        String s = "";
        String resp;

        // Loop para recebimento de entradas
        while(!acabou(s)){
            // Input
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
