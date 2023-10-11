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
