package com.levserj.test.task.sg;

/**
 * Created by Serhii Levchynskyi on 13.07.2016.
 *
 * To find next palindrome this code will use
 * string representation of the given number
 * and reverse() method of the StringBuilder class.
 */
public class QuestionTwo {

    /**
     * This method takes int, increments it in a cycle
     * and compares each new string representation of the value
     * with the same reversed string, and returns the value if they are equal.
     */
    public int nextPalindromeFinder(int inputNumber) {
        int result = 0;
        boolean foundPalindrome = false;
        StringBuilder sb = new StringBuilder();
        while (!foundPalindrome){
            inputNumber++;
            sb.delete(0, sb.length());
            sb.append(String.valueOf(inputNumber));
            if (sb.toString().equals(sb.reverse().toString())){
                result = inputNumber;
                foundPalindrome = true;
            }
        }
        return result;
    }
}
