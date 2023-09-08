/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// questão sobre algebra booleana

package TP01;


public class Q05 {
    // Remove espaços em branco na string
    public static String removeEspacos(String str){
        // Declaração de nova string
        String newStr = new String();

        // Percorre a string
        for(int i = 0; i<str.length();i++){
            // Remove espaços em branco e salva em uma nova string
            if(str.charAt(i) != ' '){
                newStr += str.charAt(i);
            }
        }

        return newStr;
    }

    // Troca variáveis (A, B ou C) por valores binários
    public static String trocaValores(String str){
        // Declaração de String
        String newStr = new String();

        // 2 valores inseridos (A e B)
        if ((str.charAt(0) - 48) == '2') {
            // Declaração de variáveis
            int a = (str.charAt(1) - 48);
            int b = (str.charAt(2) - 48);

            // Percorre String
            for (int i = 3; i < str.length(); i++) {
                // Substitui variáveis na string pelos respectivos valores
                if (str.charAt(i) == 'A'){
                    newStr += a;
                }
                else if (str.charAt(i) == 'B'){
                    newStr += b;
                }
                else{
                    newStr += str.charAt(i);
                }
            }
        }
        // 3 valores inseridos (A, B e C)
        else {
            // Declaração de variáveis
            int a = (str.charAt(1) - 48); // -48 -> para pegar o valor 0 ou 1
            int b = (str.charAt(2) - 48);
            int c = (str.charAt(3) - 48);

            // Percorre String
            for (int i = 4; i < str.length(); i++) {
                // Substitui variáveis na string pelos respectivos valores
                if (str.charAt(i) == 'A') {
                    newStr += a;
                } else if (str.charAt(i) == 'B') {
                    newStr += b;
                } else if (str.charAt(i) == 'C') {
                    newStr += c;
                } else {
                    newStr += str.charAt(i);
                }
            }
        }
        return newStr;
    }

    // Calcula a expressão booleana dentro de um ()
    public static boolean calculo(String str, int posicao1, int posicao2){

        // Expressão AND, identificada pela letra d
        if (str.charAt(posicao1 - 1) == 'd') {

            for (int i = posicao1 + 1; i < posicao2; i++) {
                if (str.charAt(i) == '1') {
                    return true;
                }
            }
            return false;
        }

        // Expressão OR, identificada pela letra r
        if (str.charAt(posicao1 - 1) == 'r') {
            for (int i = posicao1 + 1; i < posicao2; i++) {
                if (str.charAt(i) == '1') {
                    return true;
                }
            }
            return false;
        }

        // Expressão NOT, identificada pela letra t
        if (str.charAt(posicao1 - 1) == 't') {
            if (str.charAt(posicao1 + 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // Substitui os caracteres na string pelos resultados
    public static String resposta(String str, int posicao1, int posicao2, boolean resp){
        // Declaração de String
        String newStr = new String();

        // Resultados de AND ou de NOT  
        if (str.charAt(posicao1 - 1) == 'd' || str.charAt(posicao1 - 1) == 't'){
            // Percorre string
            for (int i = 0; i < str.length(); i++){
                if (i < posicao1 - 3 || i > posicao2){
                    newStr += str.charAt(i); // Não altera os chars fora dos ()
                }
                else if (resp == true){
                    newStr += '1'; // Resultado da expressão == true
                    i = posicao2;
                }
                else{
                    newStr += '0'; // Resultado da expressão == false
                    i = posicao2;
                }
            }
        }
        // Resultados de OR
        else{
            // Percorre string
            for (int i = 0; i < str.length(); i++){
                if (i < posicao1 - 2 || i > posicao2){
                 newStr += str.charAt(i); // Não altera os chars fora dos ()
                }
                else if (resp == true){
                 newStr += '1'; // Resultado da expressão == true
                    i = posicao2;
                }
                else {
                 newStr += '0'; // Resultado da expressão == false
                    i = posicao2;
                }
            }
        }

        return newStr;
    }

    public static void main(String[] args){
        // Declaração de variáveis
        String input = ""; // String de entrada
        String str = ""; // String para manipulação
        int posicao1 = 0, posicao2 = 0;
        boolean resp; // Resultado

        // Input inicial
        input = MyIO.readLine();

        while(input.charAt(0) != '0'){
            // Manipulação da string para realização dos cálculos
            str = input;
            str = removeEspacos(str);
            str = trocaValores(str);
            
            while(str.length() != 1){

                // Marca início da expressão dentro do ()
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        posicao1 = i;
                    }
                }
                // Marca fim da expressão dentro do primeiro ()
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ')' && i > posicao1) {
                        posicao2 = i;
                        i = str.length(); // Flag
                    }
                }
                
                // Chamada das funções
                resp = calculo(str, posicao1, posicao2);
                str = resposta(str, posicao1, posicao2, resp);

            }

            // Imprime resposta
            MyIO.println(str);

            // Input
            input = MyIO.readLine();
        }
    }
}
