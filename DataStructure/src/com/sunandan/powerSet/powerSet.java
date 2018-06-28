package com.sunandan.powerSet;

import java.util.ArrayList;
import java.util.Stack;

public class powerSet
{
	//logic No: 1 to solve the problem
    static void printSubsets(char set[])
    {
        int n = set.length;
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j]+ " ");
            }
            System.out.println("}");
        }
    }
    public static void main(String[] args)
    {
        char set[] = {'a', 'b', 'c' , 'd', 'e'};
        Stack<ArrayList<String>> setList = new Stack<>();
        ArrayList<String> createList = null ;
        //printSubsets(set);
        nonRecursiveSubset(set.length,set,setList);
        setList = recursiveSubset(set.length,set,setList,createList);
        display(setList.peek());
    }
    private static void nonRecursiveSubset(int n, char[] set, Stack<ArrayList<String>> setList) {
    	ArrayList<String> topmostElementList = new ArrayList<>();
    	ArrayList<String> createList ;
    	String startIndex = "";
    	
    	for(int i=0;i<=n;i++) {
    		createList= new ArrayList<>();
    		if(i==0) {
    			topmostElementList.add(startIndex);
    			setList.push(topmostElementList);
    		}
    		else {
    			topmostElementList = setList.peek();
    			for(String currentValue : topmostElementList) {
    				createList.add(currentValue);
    				createList.add(currentValue+set[i-1]);
    			}
    			setList.push(createList);
    		}
    	}
    	display(setList.peek());
    }
	private static void display(ArrayList<String> set) {
		for(String currentValue : set) {
			System.out.println("{ "+currentValue+" }");
		}
		
	}
    
	static String startIndex = "";
	static ArrayList<String> topmostElementList = new ArrayList<>();
	
	
	private static Stack<ArrayList<String>> recursiveSubset(int n, char[] set, Stack<ArrayList<String>> setList,ArrayList<String> createList) {
		createList=new ArrayList<>();
		if(n==0) {
			topmostElementList.add(startIndex);
			setList.push(topmostElementList);
			return setList;
		}
		else {
			recursiveSubset(n-1, set, setList, createList);
			topmostElementList=setList.peek();
			for(String currentValue:topmostElementList) {
				createList.add(currentValue);
				createList.add(currentValue+set[n-1]);
			}
			setList.push(createList);
		}
		return setList;
		
	}
    
  //logic No: 1 to solve the problem
}