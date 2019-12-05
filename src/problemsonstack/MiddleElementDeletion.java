package problemsonstack;

import customexceptions.EmptyStackException;
import datastructures.StackUsingLL;

public class MiddleElementDeletion {

	public static StackUsingLL<Integer> deleteMidElement(StackUsingLL<Integer> stk) throws EmptyStackException {
		if (stk.getSize() <= 1)
			return new StackUsingLL<Integer>();
		
		int nth=stk.getSize()/2+1;
		return coreDeleteMidElement(stk, nth);
	}

	public static StackUsingLL<Integer> coreDeleteMidElement(StackUsingLL<Integer> stk, int nth) throws EmptyStackException {
		Integer popped = stk.pop();
		System.out.println(nth);
		if(nth!=1) {
			stk=coreDeleteMidElement(stk, nth-1);
			stk.push(popped);
		}
		return stk;
	}

	public static void main(String[] args) throws EmptyStackException {
		StackUsingLL<Integer> stk = new StackUsingLL<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		stk = deleteMidElement(stk);
		stk.displayStackContents();

	}

}
