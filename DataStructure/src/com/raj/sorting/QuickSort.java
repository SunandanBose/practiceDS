import java.util.*;

class QuickSort{

	public static void main(String args[]){
		System.out.println("Quick Sort");
		List<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(12, 2,1,3, 9,13, 4,5,39, 11));
		new QuickSort().quickSort(list,0,list.size());
		System.out.println(list);
	}
	private void quickSort(List<Integer> list, int firstElementIndex, int lastElementIndex){
			if(firstElementIndex>=lastElementIndex) return;
			int pivot = list.get(firstElementIndex);
			int pivot_index = firstElementIndex;
			for(int i = firstElementIndex+1;i< lastElementIndex ; i++){
				if(list.get(i)<pivot){
					list.add(pivot_index++,list.remove(i));
				}
			}
		
			quickSort(list,firstElementIndex,pivot_index);
			quickSort(list,pivot_index+1,lastElementIndex);
	}
}
