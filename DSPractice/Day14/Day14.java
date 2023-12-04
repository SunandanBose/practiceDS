import java.util.HashMap;

/**
 * Day14
 */
public class Day14 {
    public static void main(String[] args) {
        Day14 day14 = new Day14();
        System.out.println(day14.uniquPath(3,2));
        System.out.println(day14.uniquPath(7,3));
    }

    private int uniquPath(int row, int col) {
        cache = new HashMap<>();
        return uniquPath(row, col, 0, 0);
    }

    private HashMap<String, Integer> cache = new HashMap<>();

    private int uniquPath(int row, int col, int rowIndex, int colIndex) {
        String key = rowIndex + " | " + colIndex;
        if(cache.get(key) != null) 
            return cache.get(key);
        if(rowIndex >= row || colIndex >= col) return 0;
        int right = uniquPath(row, col, rowIndex+1, colIndex);
        int down = uniquPath(row, col, rowIndex, colIndex+1);
        cache.put(key, Math.max(1, (right + down)));
        return Math.max(1, (right + down));
    }
}