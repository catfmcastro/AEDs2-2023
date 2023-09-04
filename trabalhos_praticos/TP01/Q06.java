/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Métodos iterativos booleanos que: checa se a string é composta somente por vogais, outro que faz a mesma coisa só que com consoantes, outro que checa se a string é um número inteiro e, por fim, outro que checa se a string é um número real.

package TP01;

public class Q06 {
    // Método para condição de parada das entradas
    public static boolean acabou(String s){
    
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    // Checa se o char é um número
    public static boolean isCharNumero(char c){
        if(c >= 48 && c <= 57){
            return true; // char é um núemero
        }
        else{
            return false; // char não é um  número
        }
    }

    // Checa se o char é uma vogal
    public static boolean isCharVogal(char c){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
                return true; // char é vogal
            }
        
        return false; // char não é vogal
    }

    // Checa se o char é uma consoante
    public static boolean isCharConsoante(char c){
        if(isCharVogal(c)){
            return false; // char é uma consoante
        }
        else if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){
            return false; // char não é uma letra
        }
        else if(isCharNumero(c)){
            return false; // char é um número
        }

        return true; // char é consoante
    }


    // Checa se a string é composta inteiramente por vogais
    public static boolean isStrVogal(String s){
        // Loop para percorrer a string
        for(int i = 0; i<s.length(); i++){
            if(!(isCharVogal(s.charAt(i)))){
                return false; // String possui algum char que não é uma vogal
            }
        }
        
        return true; // String é composta inteiramente por vogais
    }

    // Checa se a string é composta inteiramente por consoantes
    public static boolean isStrConsoante(String s){
        
        // Loop para percorrer string
        for(int i = 0; i<s.length(); i++){
            if(isCharVogal(s.charAt(i))){
                return false;
            }
        }

        return true; // String é composta inteiramente por consoantes
    }

    // Checa se a string é um número intero
    public static boolean isStrInt(String s){

        for(int i=0;i<s.length(); i++){
            if(!isCharNumero(s.charAt(i))){
                return false; // String possui pelo menos uma letra
            }
        }
        
        return true; // String é um número inteiro
    }

    // Checa se a string é um número real
    public static boolean isStrReal(String s){

        for(int i = 0; i<s.length(); i++){
            if(!isCharNumero(s.charAt(i))){
                return false; // string possui um char que não é número
            }
            else if(s.charAt(i) != '.'){
                return false; // string não é um número real
            }
        }

        return true; // string é um número real
    }

    public static void main(String[] args){
        // Declaração de variáveis
        String str = "";

        while(!acabou(str)){
            // Entrada da string
            str = MyIO.readLine();

            // Interrupção do loop
            if(acabou(str)){
                break;
            }

            // Chamada dos métodos
            boolean vogal = isStrVogal(str);
            boolean consoante = isStrConsoante(str);
            boolean inteiro = isStrInt(str);
            boolean real = isStrReal(str);

            // Imprime os resultados na tela
            if(vogal){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }

            if(consoante){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }

            if(inteiro){
                MyIO.print("SIM ");
            }
            else{
                MyIO.print("NAO ");
            }

            if(real){
                MyIO.print("SIM\n");
            }
            else{
                MyIO.print("NAO\n");
            }
        }

    }
}
