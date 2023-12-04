package com.sunandan.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionLabelsTest {

    PartitionLabels pl = new PartitionLabels();

    @Test
    public void test1partitionLabels() {
        String input = "ababcbacadefegdehijhklij";
        List<Integer> output = Arrays.asList(9, 7, 8);
        assertEquals(output, pl.partitionLabels(input));
    }

    @Test
    public void test2partitionLabels() {
        String input = "abccaddbeffe";
        List<Integer> output = Arrays.asList(8, 4);
        assertEquals(output, pl.partitionLabels(input));
    }
}