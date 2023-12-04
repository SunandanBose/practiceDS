
class Day28 {

    public static void main(String[] args) {
        Day28 day28 = new Day28();
        int[] input = { 2, 3, 4, 5, 10, 15, 16 };
        if (day28.checkMinHeap(input, 0)) {
            System.out.println("It is a Min Heap");
        }
    }

    private boolean checkMinHeap(int[] input, int index) {
        if (((2 * index) + 2) > input.length - 1)
            return true;
        boolean left = (input[index] <= input[(2 * index) + 1]) && checkMinHeap(input, (2 * index) + 1);
        boolean right = (input[index] <= input[(2 * index) + 2]) && checkMinHeap(input, (2 * index) + 2);
        return left && right;
    }

}