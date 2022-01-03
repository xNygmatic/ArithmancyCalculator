package com.nygmatic.arithmancycalculator;

public class Util {

    //Converts a String into an ordered array of ints,
    //where each position represents the char's position in the alphabet (B={2}, HI={8,9})
    protected static int[] getAlphabetPositions(String word) {
        int[] toAlphabetPositions = new int[word.length()];
        int counter = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            int temp = c;
            int tempInt = 64;
            if (temp<=90 & temp>=65) {
                toAlphabetPositions[counter] = temp - tempInt;
                counter++;
            }
        }
        return toAlphabetPositions;
    }

    // Removes certain letters from a String and returns the modified version,
    // if the second parameter is true it will remove all vowels, if false it will remove all consonants
    protected static String removeLetters(String word, boolean vowels) {
        String regex = vowels ? "[AaEeIiOoUu]" : "[^AaEeIiOoUu]";
        return word.replaceAll(regex, "");
    }
}
