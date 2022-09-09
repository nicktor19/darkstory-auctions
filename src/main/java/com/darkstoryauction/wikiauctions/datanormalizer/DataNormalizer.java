package com.darkstoryauction.wikiauctions.datanormalizer;

public class DataNormalizer {

    public static String upperCaseWord(String word) {
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
