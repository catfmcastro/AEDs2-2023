<<<<<<< HEAD
package lab_30_08;

import java.util.*;

public class Pato{
	// declaracao de atributos
	private String cor;
	private double peso;
	
	// getter e setter
	public double getPeso(){
		return peso; 
	}

	public void setPeso(double peso){
		if(peso > 0){
			this.peso = peso;
		}
	}

	// construtor com parï¿½metros
	public Pato(double peso){
		setPeso(peso);
	}

	// construtor com parï¿½metros
	public Pato(String cor, double peso){
		this.cor = cor;
		this.peso = peso;
	}

	// metodo para clonar pato
	public Pato clone(){
		Pato aux = new Pato();
	}
}
=======
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

	// construtor com parÃmetros
	public Pato(double peso){
		setPeso(peso);
	}

	// construtor com parÃmetros
	public Pato(String cor, double peso){
		this.cor = cor;
		this.(peso);
	}

	// metodo para clonar pato
	public Pato clone(){
		Pato aux = new Pato;


	}
}
>>>>>>> 5c1024fa06657e65b619b49ea31ad94f2fffc1fb
