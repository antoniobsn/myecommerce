package br.com.absn.myecommerce.temp;

public class Palindrome {

    public static void main(String[] args) {
        String word = "antonio";

        String reverseWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverseWord += word.charAt(i);
        }

        if (word.equals(reverseWord)) {
            System.out.println("É palíndromo!");
        } else {
            System.out.println("Não é palíndromo.");
        }
    }

}
