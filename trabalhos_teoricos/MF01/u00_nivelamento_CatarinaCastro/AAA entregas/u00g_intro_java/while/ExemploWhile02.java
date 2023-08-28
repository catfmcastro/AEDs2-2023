/*
Unidade 00 - Nivelamento
Introdução ao Java

Catarina F. M. Castro - 803531

AEDs II
*/

import java.util.*;
import java.io.*;
import java.lang.Math;

public class ExemploWhile02 {
    public static void main(String[] args){
        int num = 1;

        while(num < 11){
            System.out.println(Math.log10(num));
            num++;
        }
    }
}
