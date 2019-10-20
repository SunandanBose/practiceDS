import java.util.*;

class QuickSort{

	public static void main(String args[]){
		System.out.println("Quick Sort");
		List<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(12, 2,1,3, 9,13, 4,5,39, 11));
		new QuickSort().quickSort(list,0,list.size());
		System.out.println(list);
	}
	private void quickSort(List<Integer> list, int initial, int last){
			if(initial>=last) return;
			int pivot = list.get(initial);
			int pivot_index = initial;
			for(int i = initial+1;i< last ; i++){
				if(list.get(i)<pivot){
					list.add(pivot_index++,list.remove(i));
				}
			}
			System.out.println(list);
			quickSort(list,initial,pivot_index);
			quickSort(list,pivot_index+1,last);
	}
}