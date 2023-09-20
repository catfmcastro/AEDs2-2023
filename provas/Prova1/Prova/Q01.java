// quando compilei o código pelo meu terminal, ele rodava infinitamente, mas com a saida correta.

package Prova;

import java.util.Scanner;

public class Q01 {
    
    public static void main(String[] args){
        // Declaracao de variaveis
        String strNum = "";
        String strCutoff = "";
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            // entrada de valores
            strNum = sc.nextLine();
            strCutoff = sc.nextLine();

            // converte string para número
            float num = (Float.valueOf(strNum));
            float cutoff = (Float.valueOf(strCutoff));

            // num inteiro auxiliar
            int numInt = (int)num;

            // casas decimais de num
            float numDec = num - numInt;

            if(numDec > cutoff){
                MyIO.println(numInt+1);
            }
            else{
                MyIO.println(numInt);
            }
        }    
        
        sc.close();
    }
}
