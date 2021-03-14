import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Day35
 */
public class Day35 {

    public static void main(String[] args) {
        Day35 day35 = new Day35();
        System.out.println(day35.permutationsOfString("ABC"));
    }

    private List<String> permutationsOfString(String input) {
        Queue<String> tempQueue = new LinkedList<>();
        tempQueue.add(input.substring(0, 1));
        int i = 0;
        while (tempQueue.size() > 0 && tempQueue.peek().length() < input.length()) {
            surroundString(tempQueue, input.substring(i, i + 1), input.length());
            i++;
        }
        // tempQueue.stream().collect(Collectors.toList());
        return tempQueue.stream().collect(Collectors.toList());

    }

    private void surroundString(Queue<String> tempQueue, String str, int size) {
        if (tempQueue.size() > 0 && tempQueue.peek().length() <= size) {
            String temp = tempQueue.poll();
            for (int i = 0; i <= temp.length(); i++) {
                tempQueue.add(temp.substring(0, i) + str + temp.substring(i));
            }
        }
    }
}