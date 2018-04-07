package com.example.vasilis.finalprojectcs151082;

import java.util.Random;


public class Anagram  {

    public static final Random RANDOM = new Random();
    public static final String[] WORDS = {"ACCOUNT", "ADDITION","APPLE",
            "AGREEMENT", "ANGRY", "ANIMAL","BANANA", "BEHAVIOUR", "BETWEEN", "BLACK", "CENTER","COUNTER","CHERRY", "FAVOURITE",
            "FREQUENT", "GOVERNMENT", "GAIN", "GRASS", "HOSPITAL", "PAYMENT", "POLITICAL",
            "PROCESS", "SAME", "SMASH", "SMOOTH", "STATEMENT", "SUB", "TEACHING", "TOAST",
            "TOMORROW", "TOUCH", "UMBRELLA", "WEATHER","WHITE", "YESTERDAY"};



    public static String randomWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public static String shuffleWord(String word) {
        if (word != null  &&  !"".equals(word)) {
            char a[] = word.toCharArray();

            for (int i = 0; i < a.length; i++) {
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }

        return word;
    }
}
