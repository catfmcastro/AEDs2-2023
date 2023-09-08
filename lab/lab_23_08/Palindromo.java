<<<<<<< HEAD:lab/lab_23_08/Palindromo.java
// checa se uma palavra é palindromo com uma solucao iterativa

package lab_23_08;

import java.util.*;

public class Palindromo{
	public boolean isPalindromo(String s){
		boolean resp = true;

		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) != s.charAt(s.length() -1-i)){
				resp = false;
				i = s.length();
			}
		}
	
		return resp;
	}

	public static void main(String[] args){
		
		
	}
}
=======
// checa se uma palavra é palindromo com uma solucao iterativa

import java.util.*;

public class Palindromo{
	public boolean isPalindromo(String s){
		boolean resp = true;

		for(int i=0, i<(s.length(), i++){
			if(s.charAt(i) != s.charAt(s.length-1-i){
				resp = false;
				i = s.length;
			}
		}
	
	}

	public static void main(String[] args){
		
		
	}
}
>>>>>>> 5c1024fa06657e65b619b49ea31ad94f2fffc1fb:lab/lab-23-08/Palindromo.java
