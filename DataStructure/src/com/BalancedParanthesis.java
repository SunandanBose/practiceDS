package com;

import java.util.Stack;


public class BalancedParanthesis 
{
   
    static boolean areParenthesisBalanced(char exp[])
    {
       Stack<Character> st=new Stack<Character>();
       for(int i=0;i<exp.length;i++)
       {
          if (exp[i] == '(' )
            st.push(exp[i]);
          if (exp[i] == ')')
          {
             if (st.isEmpty())
               {
                   return false;
               } 
               else if(!((st.pop() == '(') && (exp[i] == ')')))
               {
                   return false;
               }
          }
           
       }
       
       if (st.isEmpty())
         return true; 
       else
         {
             return false;
         } 
    } 
    public static void main(String[] args) 
    {
        char exp[] = {'(',')','('};
          if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
          else
            System.out.println("Not Balanced ");  
    }
 
}