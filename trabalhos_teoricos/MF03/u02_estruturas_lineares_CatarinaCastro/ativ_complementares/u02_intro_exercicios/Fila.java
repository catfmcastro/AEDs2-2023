/*
MF03
Unidade 02 - Introdução
Atividades Complementares

Catarina F. M. Castro

AEDs II
*/

import java.util.*;

// Criar uma classe Fila 

public class Fila{
    // Declaração de atributos
    private ArrayList<String> fila = new ArrayList<String>();

    // Construtor
    public Fila(){}

    // Método para adição de um elemento
    public void Inserir(int n){
        fila.Add(n);
    }

    // Método para a remoção de um elemento 
    public void Remover(){
        fila.remove(0);
    }

    // Método para imprimir a Fila
    public void Mostrar(){
        System.out.println(fila);
    }

}