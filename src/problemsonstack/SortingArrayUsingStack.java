package problemsonstack;

import datastructures.LLStack;
import datastructures.StackEmptyException;

public class SortingArrayUsingStack {

	public static Integer[] sortArray(Integer[] arr) throws StackEmptyException {
		LLStack<Integer> sortedStk = new LLStack<Integer>();
		LLStack<Integer> auxStk = new LLStack<Integer>();

		int len = arr.length;
		for (int i = 0; i < len; i++) {	//	another way is maintain only one stack in order; when a number 
										//  comes that cant be stacked, pop and store in the array itself 
										//	until it can be stacked. repeat till all are in order
			if (sortedStk.getSize() == 0)
				sortedStk.push(arr[i]);
			else {
				if (sortedStk.peek() <= arr[i])
					sortedStk.push(arr[i]);
				else {
					while (sortedStk.getSize() != 0 && sortedStk.peek() > arr[i]) {
						auxStk.push(sortedStk.pop());
					}
					sortedStk.push(arr[i]);
					while (auxStk.getSize() != 0) {
						sortedStk.push(auxStk.pop());
					}
				}
			}
		}
		int i=arr.length-1;
		while(sortedStk.getSize()!=0) {
			arr[i]=sortedStk.pop();
			i--;
		}
		return arr;
	}

	public static void main(String[] args) throws StackEmptyException {
		Integer[] arr = { 2, 4, 1, 3, 7, 2, 9, 3 };
		arr=sortArray(arr);
		
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
	}

}
