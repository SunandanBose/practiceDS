package com.sunandan.hanoi;

import java.util.Stack;

public class HanoiRecursion {
	    // Java recursive function to solve tower of hanoi puzzle
	    void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
	    {
	        if (n == 1)
	        {
	            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
	            return;
	        }
	        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
	        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
	        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
	    }
	    //  Driver method
	    public static void main(String args[])
	    {
	        int n = 4; // Number of disks
	        new HanoiRecursion().towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
	        
	    }
}
