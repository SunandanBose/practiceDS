import java.util.*;
class Sort {
    public void bubble(List<Integer> list) {
        // Pick one element. Compare it with every other element and swap the positions
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) < list.get(j)){
                    swap(list, i, j);
                }
            }
        }
    }

    private void swap(List<Integer> list, int i,  int j){
        int temp;
        temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        Sort sorter = new Sort();
        List list = Arrays.asList(12, 2,1,3, 12);
        sorter.bubble(list);
        System.out.print(list);
    }
}