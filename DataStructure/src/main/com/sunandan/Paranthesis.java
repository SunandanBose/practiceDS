package com.sunandan;

import java.util.Stack;

public class Paranthesis 
{
    static int count =0;
	static boolean isMatchingPair(char character1, char character2)
    {
       if (character1 == '(' && character2 == ')')
         return true;
       else
         return false;
    }
    static boolean areParenthesisBalanced(char exp[])
    {
       Stack<Character> s = new Stack<>();
       for(int i=0;i<exp.length;i++)
       {
           
          
          if (exp[i] == '(')
            s.push(exp[i]);
          if ( exp[i] == ')' )
          {
             if (s.isEmpty())
               {
                   return false;
               } 
             else if ( !isMatchingPair(s.pop(), exp[i]) )
               {
                   return false;
               }
             	count++;
          }
           
       }
       if (s.isEmpty())
         return true; 
       else
         return false;
    } 

    public static void main(String[] args) 
    {
    	
    	String str= "(())";
        char exp[] = str.toCharArray();
         /* if (areParenthesisBalanced(exp))
            System.out.println("Balanced "+count);
          else
            System.out.println("Not Balanced "); */
          
          System.out.println(balancedParanthesis(str));
    }
	private static int balancedParanthesis(String str) {
		char exp[] = str.toCharArray();
		Stack<Character> s = new Stack<>();
	       for(int i=0;i<exp.length;i++)
	       {
	          if (exp[i] == '(')
	            s.push(exp[i]);
	          if ( exp[i] == ')' )
	          {
	             if (s.isEmpty())
	               {
	                   return -1;
	               } 
	             /*else if ( !isMatchingPair(s.pop(), exp[i]) )
	               {
	                   return -1;
	               }*/
	             else if (s.pop() == '(' && exp[i] == ')')
	                 count++;
	               else
	                 return -1;
	          }
	           
	       }
	       if (s.isEmpty())
	         return count; 
	       else
	         return -1;
	    } 

 
}
