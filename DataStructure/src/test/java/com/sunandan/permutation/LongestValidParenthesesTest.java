package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {

    LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

    @Test
    public void longestValidParentheses() {
        String input = "()())(())()(";
        int actual = longestValidParentheses.longestValidParentheses(input);
        assertEquals(6, actual);


    }
}