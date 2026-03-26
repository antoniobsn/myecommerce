package br.com.absn.myecommerce.temp;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {

        String palavra1 = "amor";
        String palavra2 = "roma";

        char[] array1 = palavra1.toLowerCase().toCharArray();
        char[] array2 = palavra2.toLowerCase().toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        if (Arrays.equals(array1, array2)) {
            System.out.println("São anagramas!");
        } else {
            System.out.println("Não são anagramas.");
        }
    }
}
