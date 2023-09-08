<<<<<<< HEAD
package lab_16_28;

import java.util.*;
import java.io.*;

/*
 * Aula de laboratorio - 16/08/23
 * 
 * Catarina F. M. Castro - 803531
 *
 * AEDs II
 * */

// testando e brincando com classes e herancas

class Person{
	// Declaracao de atributos privados
	protected String name;
	protected int age;

	// metodo construtivo
	public Person(String name, int age){
		this.name = name;
		this.age = age;

		setAge(age);

	}

	// metodos getter e setter
	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age;
	}

	public void setAge(int age){
		if(hasValidAge(age)){
			this.age = age;
		}

	}

	// checa se o cadastro de idade 
	public boolean hasValidAge(int age){
		if(age > 0){
			return true;
		}

		return false;
	}
}

class Student extends Person{
	private int id;

	// construtor
	public Student(String name, int age, int id){
		// metodo que chama o construtor da classe pai
		super(name, age);
		
		this.id = id;
	
	}

	// getter e setter
	public int getId(){
		return id;
	}


}

class Prog{
	public static void main(String[] args){
		//declaracao de variaveis
		Person p = new Person("Cat", 18);

		// imprime os resultados na tela
		System.out.println("Hello, my name is " + p.name + " and I am " + p.age + " years old.");
	}
}

=======
import java.util.*;
import java.io.*;

/*
 * Aula de laboratorio - 16/08/23
 * 
 * Catarina F. M. Castro - 803531
 *
 * AEDs II
 * */

// testando e brincando com classes e herancas

class Person{
	// Declaracao de atributos privados
	protected String name;
	protected int age;

	// metodo construtivo
	public Person(String name, int age){
		this.name = name;
		this.age = age;

		setAge(age);

	}

	// metodos getter e setter
	public String getName(){
		return this.name;
	}

	public int getAge(){
		return this.age;
	}

	public void setAge(int age){
		if(hasValidAge(age)){
			this.age = age;
		}

	}

	// checa se o cadastro de idade 
	public boolean hasValidAge(int age){
		if(age > 0){
			return true;
		}

		return false;
	}
}

class Student extends Person{
	private int id;

	// construtor
	public Student(String name, int age, int id){
		// metodo que chama o construtor da classe pai
		super(name, age);
		
		this.id = id;
	
	}

	// getter e setter
	public int getId(){
		return id;
	}


}

class Prog{
	public static void main(String[] args){
		//declaracao de variaveis
		Person p = new Person("Cat", 18);

		// imprime os resultados na tela
		System.out.println("Hello, my name is " + p.name + " and I am " + p.age + " years old.");
	}
}

>>>>>>> 5c1024fa06657e65b619b49ea31ad94f2fffc1fb
