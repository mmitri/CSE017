import java.util.ArrayList;

public class MergeSort {
	// Recursive mergeSort method
	public static <E extends Comparable<E>> void mergeSort(ArrayList<Session> list) {
		if (list.size() > 1) { // ==1: base case
			ArrayList<Session> firstHalf = subList(list, 0, list.size() / 2);
			ArrayList<Session> secondHalf = subList(list, list.size() / 2, list.size());
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}
	// merge method
	public static <E extends Comparable<E>> void merge(ArrayList<Session> list1, ArrayList<Session> list2, ArrayList<Session> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while (list1Index < list1.size() && list2Index < list2.size()) {
			if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
				list.set(listIndex++, list1.get(list1Index++));
			else
				list.set(listIndex++, list2.get(list2Index++));
		}
		while (list1Index < list1.size()) {
			list.set(listIndex++, list1.get(list1Index++));
		}

		while (list2Index < list2.size()) {
			list.set(listIndex++, list2.get(list2Index++));
		}
	}
	// subList method used to split list
	public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end) {
		ArrayList<E> newList = new ArrayList<>();
		for (int index = start; index < end; index++) {
			newList.add(list.get(index));
		}
		return newList;
	}
}
