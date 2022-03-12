package problemsonstacks;

import java.util.Stack;

public class NextGreaterElement {

	public static void findNextGreaterElementForEachArrayElement(Integer[] arr) {
		int len = arr.length;

		Stack<Integer> stk;

		boolean greaterFound;
		for (int i = 0; i < len - 1; i++) {
			stk = new Stack<>();
			for (int j = len - 1; j > i; j--)
				stk.push(arr[j]);

			greaterFound = false;
			while (!stk.isEmpty()) {
				if (arr[i] >= stk.peek())
					stk.pop();
				else {
					arr[i] = stk.peek();
					greaterFound = true;
					break;
				}
			}
			if (!greaterFound)
				arr[i] = -1;
		}
		arr[len-1]=-1;
	}

	
	public static void main(String[] args) {
		Integer[] arr = { 5, 1, 9, 2, 5, 1, 7 };

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		findNextGreaterElementForEachArrayElement(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
