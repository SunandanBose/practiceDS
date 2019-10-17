import java.util.*;
class Sort {
    public void bubble(List<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                if (list.get(j) > list.get(j+1)){
                    swap(list, j+1, j);
                }
            }
        }
    }

    public void insertion(LinkedList<Integer> list) {
        // Run loop from 1 to n
        for(int i=1; i < list.size(); i++){
            // Run loop from 0 to i - 1
            for(int j=0;j<=i-1;j++){
                // if selected element is less than any element in the inside loop
                if(list.get(i) < list.get(j)){
                    //insert at index of the element that is greater
                    list.add(j, list.get(i));
                    // remove element from original position
                    list.remove(i+1);
                    break;
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
        System.out.println("Bubble Sort Result : "+list);
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.addAll(Arrays.asList(12,2,1,3));
        sorter.insertion(list1);
        System.out.println("Insertion Sort Result : "+list1);
    }
}
