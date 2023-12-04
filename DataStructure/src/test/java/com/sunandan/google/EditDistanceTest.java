package com.sunandan.google;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    private EditDistance ed = new EditDistance();

    @Test
    public void test1MethodGetMinSteps(){
        assertEquals(1,ed.getMinSteps("abad","abac"));
    }

    @Test
    public void test2MethodGetMinSteps(){
        assertEquals(4,ed.getMinSteps("abad",""));
    }

    @Test
    public void test3MethodGetMinSteps(){
        assertEquals(4,ed.getMinSteps("","abac"));
    }

    @Test
    public void test4MethodGetMinSteps(){
        assertEquals(0,ed.getMinSteps("abac","abac"));
    }

    @Test
    public void test5MethodGetMinSteps(){
        assertEquals(0,ed.getMinSteps("",""));
    }

    @Test
    public void test6MethodGetMinSteps(){
        assertEquals(4,ed.getMinSteps("adef","ghik"));
    }

    @Test
    public void test7MethodGetMinSteps(){
        assertEquals(2,ed.getMinSteps("Anshuman","Antihuman"));
    }

    @Test
    public void test8MethodGetMinSteps(){
        assertEquals(3,ed.getMinSteps("horse","ros"));
    }

    @Test
    public void test9MethodGetMinSteps(){
        assertEquals(5,ed.getMinSteps("intention","execution"));
    }

    @Test
    public void test10MethodGetMinSteps(){
        assertEquals(7,ed.getMinSteps("dinitrophenylhydrazine","benzalphenylhydrazone"));
    }



}