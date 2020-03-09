package com.sunandan.permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/*
Given a String of incorrect braces. Braces can only be added from the front or end of the String.
For such cases: {]}([]{
where it cannot be balanced by adding before and after the string. return null.
For such cases:  }([]{
it should return a balanced string of braces {}([]{})
 */

public class Validate {

    private static Map<Character,Character> bracesPair = new HashMap<>();

    static {
        bracesPair.put('{','}');
        bracesPair.put('[',']');
        bracesPair.put('(',')');
        bracesPair.put(']','[');
        bracesPair.put(')','(');
        bracesPair.put('}','{');
    }

    public String validateBraces(String braces){
        Stack<Character> stack = new Stack<>();
        StringBuffer correctedString=new StringBuffer();
        Character temp;
        for(int i=0;i<braces.length();i++){
            temp = braces.charAt(i);
            correctedString.append(temp);
            stack.add(temp);
            if(temp == '}' || temp == ')' || temp == ']' ){
                if(stack.size()==1){
                    correctedString = addCharacterToString(correctedString,0,temp);
                    stack.pop();
                }else{
                    if(checkForPair(stack,temp,i)){
                        stack.pop();
                    }
                    else return null;
                }
            }
        }
        if(!stack.isEmpty()){
            int stackSize = stack.size();
            for(int i = 0; i< stackSize; i++){
                correctedString = addCharacterToString(correctedString,correctedString.length(),stack.pop());
            }
        }
        return correctedString.toString();
    }

    public boolean checkForPair(Stack<Character> bracesStack , Character singleBraces, int position) {
        Character popChar = bracesStack.pop();
        if(bracesPair.get(singleBraces) == bracesStack.peek()){
            return true;
        }
        else{
            bracesStack.add(popChar);
            return false;
        }
    }

    public StringBuffer addCharacterToString(StringBuffer string, int position, Character braces) {
        return string.insert(position,bracesPair.get(braces));
    }

}
