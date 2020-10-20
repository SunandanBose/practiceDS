package com.sunandan.permutation;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterInAStringTest {

    private FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();

    @Test
    public void testFirstUniqChar() {
        String input = "loveleetcode";
        assertEquals(2,firstUniqueCharacterInAString.firstUniqChar(input));
    }
}