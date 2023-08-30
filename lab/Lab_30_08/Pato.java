package Lab_30_08;

import java.util.*;

public class Pato{
	// declaracao de atributos
	private String cor;
	private double peso;
	
	// getter e setter
	public double getPeso(){
		return peso; 
	}

	public double setPeso(double peso){
		if(peso > 0){
			this.peso = peso;
		}
	}

	// construtor com par√metros
	public Pato(double peso){
		setPeso(peso);
	}

	// construtor com par√metros
	public Pato(String cor, double peso){
		this.cor = cor;
		this.(peso);
	}

	// metodo para clonar pato
	public Pato clone(){
		Pato aux = new Pato;


	}
}
