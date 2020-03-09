package com.sunandan.permutation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateTest {

    private Validate v;
    @Before
    public void setUp() throws Exception {
        v = new Validate();
    }

    @Test
    public void checkForValidCase() {
        String result = v.validateBraces("}([]{");
        String expectedValue = "{}([]{})";
        assertEquals(result,expectedValue);
    }


    @Test
    public void checkForInvalidCase(){
        String result = v.validateBraces("{]}([]{");
        assertNull(result);
    }

    @Test
    public void checkForBlankString(){
        String result = v.validateBraces("");
        assertEquals(result,"");
    }


}