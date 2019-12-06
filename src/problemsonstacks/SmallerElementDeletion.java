package problemsonstacks;

import customexceptions.EmptyStackException;
import lists.SinglyLinkedList;
import stacks.StackUsingLL;

/* Problem Statement : Given an array arr[] and a number k. The task is to delete k elements which are 
 * smaller than next element (i.e., we delete arr[i] if arr[i] < arr[i+1]) or become 
 * smaller than next because next element is deleted.
 */
public class SmallerElementDeletion {

	public static SinglyLinkedList<Integer> deleteSmallerElements(Integer[] arr, int k) throws EmptyStackException {
		int len = arr.length;
		StackUsingLL<Integer> stk = new StackUsingLL<>();
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (stk.getSize() == 0)
				stk.push(arr[i]);
			else {
				while (stk.getSize() != 0 && stk.peek() < arr[i] && j != k) {
					stk.pop();
					j++;
				}
				stk.push(arr[i]);
			}
		}

		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		while (stk.getSize() != 0) {
			sll.insertAtStart(stk.pop());
		}

		return sll;
	}

	public static void main(String[] args) throws EmptyStackException {
		// Integer[] arr= {3, 100, 1 };
		// int k=1;
		// Integer[] arr = {20, 10, 25, 30, 40};
		// int k = 2;
		Integer[] arr = { 23, 45, 11, 77, 18 };
		int k = 3;

		SinglyLinkedList<Integer> sll = deleteSmallerElements(arr, k);
		sll.displayList();
	}

}
