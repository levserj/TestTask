package com.levserj.test.task.sg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Serhii Levchynskyi on 13.07.2016.
 *
 * To find next palindrome this code will use
 * string representation of the given number
 * and reverse() method of the StringBuilder class.
 */
public class QuestionTwo {

    public static void main(String[] args) throws IOException {

        /* InputStreamReader is used to collect initial number from user */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input start number: ");
        int inputNumber = Integer.parseInt(br.readLine());

        /* Invocation of the method to find palindrome. */
        QuestionTwo instance = new QuestionTwo();
        int palindrome = instance.nextPalindromeFinder(inputNumber);
        System.out.println("Next smallest palindrome is : " + palindrome);
    }

    /*
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
