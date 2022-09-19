package com.darkstoryauction.wikiauctions.datanormalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataNormalizerTest {

    @Test
    void multiWordCapitalize() {
        System.out.println(DataNormalizer.upperCaseTitle("hello world-world"));
    }
}