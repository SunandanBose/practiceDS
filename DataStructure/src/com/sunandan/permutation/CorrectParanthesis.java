import java.util.*;


public class CorrectParanthesis {
	
	

	public static void main(String[] args){
		String input= "()())()";
		Set<String> result = getCorrectedParenthesis(input);
		for(String s : result)
			System.out.println("result :"+s);
	}


	private static Set getCorrectedParenthesis(String inputString){
		Set<String> result = new HashSet<>();
		String modifiedinput;
		for(int i=0;i<inputString.length();i++){
			modifiedinput = removeCharAtIndex(inputString,i);
			if(checkParanthesis(modifiedinput))
				result.add(modifiedinput);
		}
		return result;
	}

	private static boolean checkParanthesis(String input){
		Stack<Character> stack = new Stack();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i) == '(')
				stack.push('(');
			if(input.charAt(i) == ')'){
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}	

	private static String removeCharAtIndex(String input, int indexToRemove){
		StringBuilder str = new StringBuilder();
		str.append(input);
		str.deleteCharAt(indexToRemove);
		return str.toString();
	}
}


