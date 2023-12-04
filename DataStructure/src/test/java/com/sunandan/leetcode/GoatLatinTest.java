package com.sunandan.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoatLatinTest {

    private  GoatLatin gl = new GoatLatin();

    @Test
    public void test1MethodToGoatLatin() {
        String expected = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
        String input = "I speak Goat Latin";
        assertEquals(expected, gl.toGoatLatin(input));
    }

    @Test
    public void test2MethodToGoatLatin() {
        String expected = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
        String input = "The quick brown fox jumped over the lazy dog";
        assertEquals(expected, gl.toGoatLatin(input));
    }
}