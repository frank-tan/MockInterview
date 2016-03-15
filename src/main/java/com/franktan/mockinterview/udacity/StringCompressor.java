package com.franktan.mockinterview.udacity;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by tan on 15/03/2016.
 */
public class StringCompressor {
    public static String compress(String input) {
        //null or empty
        if(input == null || input.length() == 0) {
            return input;
        }
        //all chars are unique
        int oldSize = input.length();
        if(numOfUniqueChar(input) == oldSize) {
            return input;
        }

        int repeat = 0;
        Set<Character> charSet = new HashSet();
        String compressed = "";
        Character currentChar = null, oldChar = null;

        for(int i = 0; i<oldSize; i++) {
            oldChar = (currentChar != null) ? currentChar : null;
            currentChar = input.charAt(i);

            // if a new character comes in, append the old character into result
            if(charSet.add(currentChar)) {
                if(oldChar != null){
                    compressed += (oldChar + String.valueOf(repeat));
                }

                charSet.clear();
                repeat = 0;
                charSet.add(currentChar);
            }
            repeat ++;
        }
        //append the last character
        compressed += (currentChar + String.valueOf(repeat));

        if(compressed.length() >= oldSize) {
            return input;
        }
        return compressed;
    }

    public static int numOfUniqueChar(String input) {
        if(input == null || input.length() == 0) return 0;
        Set<Character> charSet = new HashSet();
        for (int i=0;i<input.length();i++) {
            charSet.add(input.charAt(i));
        }
        return charSet.size();
    }
}
