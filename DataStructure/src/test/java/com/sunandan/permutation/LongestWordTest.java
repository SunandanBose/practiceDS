package com.sunandan.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LongestWordTest {

    private LongestWord longestWord = new LongestWord();

    @Test
    public void getlongestWord() {
        String input = "seotbdg";
        List<String> dictionary = Arrays.asList("toes", "dogs");
        assertEquals(Arrays.asList("toes","dogs"), longestWord.getlongestWord(input, dictionary));
    }
}