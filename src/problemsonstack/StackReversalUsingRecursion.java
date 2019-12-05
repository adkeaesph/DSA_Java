package problemsonstack;

import customexceptions.EmptyStackException;
import datastructures.StackUsingLL;

public class StackReversalUsingRecursion {
	
	public static StackUsingLL<Integer> reverseStack(StackUsingLL<Integer> stk) throws EmptyStackException {
		StackUsingLL<Integer> result=new StackUsingLL<>();
		coreReverseStack(stk,result);
		return result;
	}
	
	public static StackUsingLL<Integer> coreReverseStack(StackUsingLL<Integer> stk, StackUsingLL<Integer> res) throws EmptyStackException{
		if(stk.getSize()==0)
			return res;
		
		res.push(stk.pop());
		return coreReverseStack(stk, res);
	}
	public static void main(String[] args) throws EmptyStackException {
		StackUsingLL<Integer> stk=new StackUsingLL<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.displayStackContents();
		stk=reverseStack(stk);
		stk.displayStackContents();
	}
}
