package problemsonstack;

import customexceptions.EmptyStackException;
import datastructures.LLStack;

public class StackReversalUsingRecursion {
	
	public static LLStack<Integer> reverseStack(LLStack<Integer> stk) throws EmptyStackException {
		LLStack<Integer> result=new LLStack<>();
		coreReverseStack(stk,result);
		return result;
	}
	
	public static LLStack<Integer> coreReverseStack(LLStack<Integer> stk, LLStack<Integer> res) throws EmptyStackException{
		if(stk.getSize()==0)
			return res;
		
		res.push(stk.pop());
		return coreReverseStack(stk, res);
	}
	public static void main(String[] args) throws EmptyStackException {
		LLStack<Integer> stk=new LLStack<>();
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
