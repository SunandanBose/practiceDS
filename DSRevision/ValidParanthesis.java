import java.util.Stack;

/**
 * ValidParanthesis
 */
public class ValidParanthesis {

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chArray = s.toCharArray();
        for(char ch : chArray) {
            if(isOpenBracket(ch))
                stack.push(ch);
            else {
                if(stack.empty())
                    return false;
                char peekChar = stack.peek();
                if(isPair(ch, peekChar))
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

    private boolean isPair(char closingBracket, char openingBracket){
        if(openingBracket == '(' && closingBracket == ')')
            return true;
        if(openingBracket == '[' && closingBracket == ']')
            return true;
        if(openingBracket == '{' && closingBracket == '}')
            return true;
        return false;
    }

    private boolean isOpenBracket(char bracket){
        char[] openBrackets = {'(','[','{'};
        boolean openBracket = false;
        for(char ch: openBrackets) {
            if (bracket == ch)
                openBracket = true;
        }
        return openBracket;
    }
}