package main;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        String tempWord = "";
        for(int i = 0; i < word.length(); i++) {
            tempWord += word.charAt(word.length()-(i+1));
        }

        if (tempWord.equalsIgnoreCase(word))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}
