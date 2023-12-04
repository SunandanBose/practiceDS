package com.sunandan.permutation;


import org.junit.Test;
import static org.junit.Assert.*;

public class CommonChildTest {

    private CommonChild cc = new CommonChild();

    @Test
    public void test1MethodCommonChild(){
        assertEquals(cc.getCommonChild("AA","BB"),0);
    }

    @Test
    public void test2MethodCommonChild(){
        assertEquals(cc.getCommonChild("ABCD","AEAD"),2);
    }

    @Test
    public void test3MethodCommonChild(){
        assertEquals(cc.getCommonChild("HARRY","SALLY"),2);
    }

    @Test
    public void test4MethodCommonChild(){
        assertEquals(cc.getCommonChild("SHINCHAN","NOHARAAA"),3);
    }

    @Test
    public void test5MethodCommonChild(){
        assertEquals(cc.getCommonChild("ABCDEF","FBDAMN"),2);
    }
}