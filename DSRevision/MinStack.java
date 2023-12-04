import java.util.*;

public class MinStack {

    int min = Integer.MAX_VALUE;
    int top = 0;
    List<Integer> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        top = val;
        min = Math.min(min, val);
    }
    
    public void pop() {
        int length = stack.size();
        if (length >= 2) {
            int valueRemoved = stack.remove(stack.size() - 1);
            top = stack.get(stack.size() - 1);
            if(valueRemoved == min) {
                min = Integer.MAX_VALUE;
                for(int i = 0; i < stack.size(); i++){
                    min = Math.min(min, stack.get(i));
                }
            }
        } 
        if (length == 1) {
            stack.remove(0);
            min = Integer.MAX_VALUE;
            top = 0;
        }
    }
    
    public int top() {
        return top;
    }
    
    public int getMin() {
        return min;
    }
}