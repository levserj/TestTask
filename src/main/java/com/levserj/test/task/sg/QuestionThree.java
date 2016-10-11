package com.levserj.test.task.sg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serhii Levchynskyi on 13.07.2016.
 *
 * This code will find the longest compound word in words array
 */
public class QuestionThree {
    private static boolean recursiveCall = false;

    public static void main(String[] args) {
        String words[] = {"five", "fivetwo", "fourfive", "fourfivetwoone", "one", "onefiveone", "two",
                "twofivefourone", "fourtwofiveonefivetwo", "fivetwotwofourfive"};
        System.out.println("Longest Compound word : " + longestCompoundWord(words));
    }

    private static String longestCompoundWord(String[] wordsArray) {

        /* Collection of words is created and sorted by length */
        List<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, wordsArray);
        Collections.sort(wordsList, (str1, str2) -> (str2.length() - str1.length()));

        /* For every word in the list we call isCompoundWord function,
         * and as far as our list is sorted in descending order,
         * the first word found will be the longest.
         */
        for (String s : wordsList) {

            /* Flag to use for removing the word we examine, from the list on the first call. */
            recursiveCall = false;
            System.out.println("First call of consistOfWords method with word: " + s);
            if (isCompoundWord(s, wordsList)) {
                return s;
            }
            System.out.println(s + " is not a compound word");
        }
        return "No compound word found";
    }

    /*
     * This method tries to match any word from the list with the beginning
     * of the examined word (prefix). If found, it uses recursive call to examine
     * the rest of the word (suffix) is it compound.
     */
    private static boolean isCompoundWord(String word, List<String> words) {
        ArrayList<String> allWords = new ArrayList<>(words);

        /* Delete the word we examine from list, or we'll find the same word. */
        if (!recursiveCall) {
            allWords.remove(word);
        }

        /* Find all possible words to be the prefix in the word we examine */
        List<String> foundPrefixes = prefixSearch(word, allWords);

        /* Examine the suffixes: are they compound? */
        for (String prefix : foundPrefixes) {
            String suffix = word.substring(prefix.length());
            System.out.println("Suffix length is: " + suffix.length());
            if (suffix.length() == 0) {
                return true;
            } else {
                System.out.println("Recursive call with suffix: " + suffix);
                recursiveCall = true;
                return isCompoundWord(suffix, allWords);
            }
        }
        return false;
    }

    private static List<String> prefixSearch(String word, List<String> words) {
        ArrayList<String> possiblePrefixes = new ArrayList<>();
        for (String possiblePart : words) {
            if ((possiblePart.length() <= word.length()) &&
                    (word.substring(0, possiblePart.length()).equals(possiblePart))) {
                possiblePrefixes.add(possiblePart);
            }
        }
        return possiblePrefixes;
    }
}


