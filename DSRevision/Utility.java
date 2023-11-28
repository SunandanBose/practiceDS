public class Utility {
    
    public static void printASectionOfAnArray(int[] array, int start, int end) {
        for(int i = start; i < end; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
