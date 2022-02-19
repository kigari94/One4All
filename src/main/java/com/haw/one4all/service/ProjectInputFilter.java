package com.haw.one4all.service;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectInputFilter {

    // list of statistically common inappropriate/forbidden words
    static String[] filterList = {
        "dumm", "terror", "isis", "nazi", "arsch", "bastard", "fuck", "shit", "idiot",
        "scheiße", "arschloch", "bitch", "krüppel", "nutte"
    };

    // regex to filter URL's
    private static final String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static final Pattern pattern = Pattern.compile(regex);

    // check for inappropriate words in userinput
    public static boolean isValid(final String input) {
        String[] inputList = input.split(" ");
        for (String word : inputList) {
            // filter URL's
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                return false;
            }

            // match the words in the user input to the list of bad words
            for (String badWord : filterList) {
                if (word.toLowerCase().equals(badWord.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }
}
