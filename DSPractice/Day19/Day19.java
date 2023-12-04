import java.util.*;

/**
 * Day19
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day19 {

    public static void main(String[] args) {
        Day19 day19 = new Day19();
        System.out.println(day19.calculate("3*25-10"));
        System.out.println(day19.longestCommonSubsequence("abcde", "ace"));
        int[] height = { 4, 2, 0, 3, 2, 5 };
        System.out.println(day19.trappingRainWater(height));
        int[][] grid = { { 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 1 } };
        System.out.println(day19.countIsland(grid));
        Node root = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        print(root);
        root = day19.reverse(root);
        print(root);
    }

    private Node reverse(Node root) {
        if(root.next == null){
            return root;
        }
        Node presentElem = root;
        Node nextElem = root.next;
        presentElem.next = null;
        Node reverse = reverse(nextElem);
        nextElem.next = presentElem;
        return reverse;
    }

    private static void print(Node root) {
        while(root != null){
            System.out.print(root.data + "  ");
            root = root.next;
        }
        System.out.println();
    }

    private static Node createLinkedList(List<Integer> list) {
        Node root = new Node(list.get(0));
        Node prev = root;
        for (int i = 1; i < list.size(); i++) {
            Node node = new Node(list.get(i));
            prev.next = node;
            prev = node;
        }
        return root;
    }

    int[] xdir = { 1, 0, -1, 0 };
    int[] ydir = { 0, 1, 0, -1 };

    private int countIsland(int[][] grid) {
        int islands = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    visited[i][j] = true;
                    grid[i][j] = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        visited = markNeighboursVisited(grid, visited, i + xdir[dir], j + ydir[dir]);
                    }
                }
            }

        }
        return islands;
    }

    private boolean[][] markNeighboursVisited(int[][] grid, boolean[][] visited, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1
                && !visited[row][col]) {
            visited[row][col] = true;
            grid[row][col] = 0;
            for (int dir = 0; dir < 4; dir++) {
                visited = markNeighboursVisited(grid, visited, row + xdir[dir], col + ydir[dir]);
            }
        }
        return visited;
    }

    private int trappingRainWater(int[] height) {
        int result = 0;
        int totalLength = height.length;
        int[] leftMax = new int[totalLength];
        int[] rightMax = new int[totalLength];
        leftMax[0] = height[0];
        rightMax[totalLength - 1] = height[totalLength - 1];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = totalLength - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < totalLength; i++) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return result;
    }

    private int longestCommonSubsequence(String str1, String str2) {
        int totalLength1 = str1.length();
        int totalLength2 = str2.length();
        int[][] dp = new int[totalLength1 + 1][totalLength2 + 1];
        for (int i = 0; i < totalLength1; i++) {
            for (int j = 0; j < totalLength2; j++) {
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[totalLength1][totalLength2];
    }

    private int calculate(String str) {
        int result = 0;
        int totalLength = str.length();
        char operator = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < totalLength; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                num = num * 10 + ch - '0';
            if ((!Character.isDigit(ch) && ch != ' ') || i == totalLength - 1) {
                if (operator == '-')
                    stack.push(-num);
                if (operator == '+')
                    stack.push(num);
                if (operator == '*')
                    stack.push(stack.pop() * num);
                if (operator == '/')
                    stack.push(stack.pop() / num);
                num = 0;
                operator = ch;
            }
        }
        result = stack.stream().reduce(0, (a, b) -> a + b);
        return result;
    }

}