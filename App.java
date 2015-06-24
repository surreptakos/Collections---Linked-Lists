import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class App {

	public static void main(String[] args) {

		/*
		 * ArrayLists manage arrays internally
		 * [0][1][2][3][4]....
		 */

		// use ArrayList if you only want to add or remove items at the end of
		// your list
		List<Integer> arrayList = new ArrayList<Integer>();
		
		/*
		 * LinkedLists consists of elements where each element has a reference
		 * to the previous and next element
		 * [0] <-> [1] <-> [2] <-> [3]
		 */
		// use LinkedList to add or remove items from anywhere else
		List<Integer> linkedList = new LinkedList<Integer>();

		doTimings("ArrayList", arrayList);
		doTimings("LinkedList", linkedList);
	}

	// Can pass anything that implements the List interface to this method
	private static void doTimings(String type, List<Integer> list) {
		for (int i = 0; i < 1E5; i++) {
			list.add(i);
		}

		ListIterator<Integer> li = list.listIterator();

		long start = System.currentTimeMillis();

		/*
		 * //Adding items at the end of the list for(int i = 0; i<1E5; i++) {
		 * list.add(i); }
		 */

		// Add items elsewhere in list
		while (li.nextIndex() < list.size() / 2) {
			li.next();
		}

		for (int i = 0; i < 1E5; i++) {
			li.add(i);
			// list.add(list.size()/2, i);
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + "ms for " + type);
	}

}
