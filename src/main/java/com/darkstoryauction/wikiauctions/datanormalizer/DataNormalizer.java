package com.darkstoryauction.wikiauctions.datanormalizer;

import org.apache.logging.log4j.message.StringFormatterMessageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * This Class is a static one inorder to keep data normalized for insertion of the Database.
 */
public class DataNormalizer {

    /**
     * Will return uppercase words regardless of amount of words submitted.
     * @param word
     * @return
     */
    public static String upperCaseTitle(String word) {
        word.trim();
        if (multiStringChecker(word)) {
            return multiWordCapitalize(word);
        } else {
            return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        }
    }

    /**
     * Check if any spring is larger than one word.
     * @param words
     * @return boolean; true if more than one word, false if only one word.
     */
    public static boolean multiStringChecker(String words) {
        Pattern spaceChars = Pattern.compile("[ -]", Pattern.CASE_INSENSITIVE);
        Matcher matcherFinder = spaceChars.matcher(words);
        return matcherFinder.find();
    }

    /**
     * Take a string and ensures all words get Capitalized, returns a string
     * @param words
     * @return String
     */
    public static String multiWordCapitalize(String words) {
        //take the word and use regex to find all "spaces" and "-"
        // and get each word. maybe use stream to get each word and uppercase them.
        String wordsArray[]=words.split("[\\s-]");
        String capitalizeWord="";
        for(String w:wordsArray){
            String first=w.substring(0,1);
            String afterFirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterFirst+" ";
        }
        return capitalizeWord.trim();
    }
}
