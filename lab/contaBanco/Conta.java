package Lab_20_09;

import java.util.Scanner;

public class Conta {
    // declaracao de variaveis
    int saldo = 0;
    int limite = 500;
    Scanner sc = new Scanner(System.in);

    // construtor
    public Conta(){

    }

    // getter e setter saldo
    public int getSaldo(){
        return this.saldo;
    }

    public void setSaldo(){
        
        System.out.println("Insira o valor a ser adicionado em sua conta: ");
        int valor = sc.nextInt();
        this.saldo += valor;
    }

    // getter e setter limite
    public int getLimite(){
        return this.limite;
    }

    public void setLimite(){
        System.out.println("Insira um novo limite para sua conta: ");
        int valor = sc.nextInt();
        this.limite = valor;
    }

    // metodo sacar
    public void sacar(int valor){

    }

}
