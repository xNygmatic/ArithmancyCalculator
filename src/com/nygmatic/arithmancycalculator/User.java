package com.nygmatic.arithmancycalculator;

public class User {

    private final String firstName, lastName;
    private final int characterNumber, heartNumber, socialNumber;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.characterNumber = calculateScore(firstName + lastName);
        this.heartNumber = calculateScore(Util.removeLetters(firstName + lastName, false));
        this.socialNumber = calculateScore(Util.removeLetters(firstName + lastName, true));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //all letters
    public int getCharacterNumber() {
        return characterNumber;
    }

    //only vowels
    public int getHeartNumber() {
        return heartNumber;
    }

    //only consonants
    public int getSocialNumber() {
        return socialNumber;
    }

    /*
      This method calculates an arithmancy score from a String, using the Aggripan method for assigning values. (1-9)
      To calculate the score per character, we can put it through the formula of x= x-9(x/9), where x represents the
      characters' position in the alphabet. After we have the total score for all characters, we reduce by this rule:
      If the score is greater than 9; continually set it to the sum of the first and last digit, until it's <=9
    */
    private int calculateScore(String name) {
        int[] alphabetPositions = Util.getAlphabetPositions(name);
        int score = 0;
        for (int num : alphabetPositions) {
            score += num - 9 * (num / 9);
        }
        while (score > 9) {
            score = Integer.parseInt(Integer.toString(score).substring(0, 1)) + score % 10;
        }
        return score;
    }
}
