package stacks;

import customexceptions.EmptyStackException;

public class DriverSUA {

	public static void main(String[] args) throws EmptyStackException {
		StackUsingArray stk = new StackUsingArray();
		stk.push(12);
		stk.push(23);
		stk.push(34);
		stk.push(12);
		stk.push(23);
		stk.push(34);
		stk.push(12);
		stk.push(23);
		stk.push(34);
		stk.push(12);
		stk.push(23);
		stk.push(34);
		stk.push(12);
		stk.push(23);
		stk.push(34);
		stk.displayStack();
		System.out.println(stk.peek()+" "+stk.size()+" "+stk.getCapacity());
		stk.push(23);
		stk.push(34);
		stk.push(12);
		stk.push(23);
		stk.push(343);
		System.out.println(stk.peek()+" "+stk.size()+" "+stk.getCapacity());
		stk.push(99);
		System.out.println(stk.peek()+" "+stk.size()+" "+stk.getCapacity());
		stk.pop();
		System.out.println(stk.peek()+" "+stk.size()+" "+stk.getCapacity());
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.displayStack();
		System.out.println(stk.peek()+" "+stk.size()+" "+stk.getCapacity());
	}

}
