package problemsonstack;

import datastructures.LLStack;
import datastructures.StackEmptyException;

public class MiddleElementDeletion {

	public static LLStack<Integer> deleteMidElement(LLStack<Integer> stk) throws StackEmptyException {
		if (stk.getSize() <= 1)
			return new LLStack<Integer>();
		
		int nth=stk.getSize()/2+1;
		return coreDeleteMidElement(stk, nth);
	}

	public static LLStack<Integer> coreDeleteMidElement(LLStack<Integer> stk, int nth) throws StackEmptyException {
		Integer popped = stk.pop();
		System.out.println(nth);
		if(nth!=1) {
			stk=coreDeleteMidElement(stk, nth-1);
			stk.push(popped);
		}
		return stk;
	}

	public static void main(String[] args) throws StackEmptyException {
		LLStack<Integer> stk = new LLStack<>();
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
