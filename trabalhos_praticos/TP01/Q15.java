/*
    Trabalho Prático 01

    @catfmcastro
    Catarina F. M. Castro

    AEDs II
*/

// Métodos RECURSIVOS booleanos que: checa se a string é composta somente por vogais, outro que faz a mesma coisa só que com consoantes, outro que checa se a string é um número inteiro e, por fim, outro que checa se a string é um número real.

package TP01;

public class Q15 {
    // Método flag
    public static boolean acabou(String s){
    
        if(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
            return true; // Se input for "FIM", retorna true
        }
        else{
            return false; // Se não, retorna false
        }
    }

    // TESTES DE CARACTERES ----------------------------------------
    // É número
    public static boolean isCharNumero(char c){
        if(c >= 48 && c <= 57){
            return true; // char é um núemero
        }
        else{
            return false; // char não é um  número
        }
    }
    
    // É vogal
    public static boolean isCharVogal(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ){
            return true; // char é vogal
        }
    
    return false; // char não é vogal
}

    // É consoante
    public static boolean isCharConsoante(char c){
    if(isCharVogal(c)){
        return false; // char é vogal
    }
    else if(isCharNumero(c)){
        return false; // char é um número
    }

    return true; // char é consoante
}

    // TESTES DE STRINGS ----------------------------------------
    // String é composta unicamente por vogais
    public static boolean isStrVogal(String s, int i){
        // Declaração de variáveis
        boolean resp = false;
        
        if(i == s.length()){
            resp = true;
            return resp; // Str só tem vogais
        }
        else{
            if(!(isCharVogal(s.charAt(i)))){
                resp = false;
                return resp; // Str tem algum char que não é uma vogal
            }
            // Chamada recursiva
            resp = isStrVogal(s, (i+1));
        }
        return resp;
    }

    // String é composta unicamente por consoantes
    public static boolean isStrConsoante(String s, int i){
        // Declaração de variáveis
        boolean resp = true;

        if(i == s.length()){
            resp = true;
            return resp; // Str só tem consoantes
        }
        else{
            if(!isCharConsoante(s.charAt(i))){
                resp = false;
                return resp; // Str tem chars que não são consoantes
            }
            // Chamada recursiva
            resp = isStrConsoante(s, (i+1));
        }

        return resp;
    }

    // String equivale a um número inteiro
    public static boolean isStrInt(String s, int i){
        // Declaração de variáveis
        boolean resp = true;

        if(i == s.length()){
            resp = true;
            return resp; // Str é um inteiro
        }
        else{
            if(!isCharNumero(s.charAt(i))){
                resp = false;
                return resp; // Str tem chars que não são inteiros
            }
            // Chamada recursiva
            resp = isStrInt(s, (i+1));
        }

        return resp;
    }

    // String equivale a um número real
    public static boolean isStrReal(String s, int i, int temPonto){
        // Declaração de variáveis
        boolean resp = false;

        if(i == s.length()){
            resp = true;
            return resp; // Str é um real
        }
        else{
            if (isCharNumero(s.charAt(i))) {
                resp = isStrReal(s, (i+1), temPonto); // Str possui números
            }
            else if ((s.charAt(i) == '.' || s.charAt(i) == ',') && temPonto < 1) {
                // Str possui apenas um ponto ou vírgula
                temPonto++;
                resp = isStrReal(s, (i+1), temPonto);
            }
            else{
                resp = false;
                return resp; // Str não é real
            }
        }

        return resp;
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
            boolean vogal = isStrVogal(str, 0);
            boolean consoante = isStrConsoante(str, 0);
            boolean inteiro = isStrInt(str, 0);
            boolean real = isStrReal(str, 0, 0);

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
