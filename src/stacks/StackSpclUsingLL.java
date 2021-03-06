package stacks;

import customexceptions.EmptyStackException;
import lists.SinglyNode;

public class StackSpclUsingLL extends StackUsingLL<Integer> {
	private SinglyNode<Integer> min;

	public StackSpclUsingLL() {
		super();
		min=new SinglyNode<>();
	}

	@Override
	public void push(Integer data) {
		super.push(data);
		if(min.getData()==null)
			min.setData(data);
		else{
			if(min.getData()>=data) {
				SinglyNode<Integer> nodeToBePushed=new SinglyNode<>(data);
				nodeToBePushed.setNext(min);
				min=nodeToBePushed;
			}
		}
	}

	@Override
	public Integer pop() throws EmptyStackException {
		Integer toBePopped=null;
		try {
			toBePopped=super.pop();
			if(toBePopped.equals(min.getData())) {
				if(min.getNext()!=null)
					min=min.getNext();
			}
		} catch(EmptyStackException exception) {
			min.setData(null);
			throw exception;
		} 
		return toBePopped;
	}
	
	public Integer getMin() throws EmptyStackException {
		if(this.getSize()!=0)
			return this.min.getData();
		else
			throw new EmptyStackException("The special stack is empty!!!");
	}
	
	public void displayAuxiliaryStackContents() {
		if(min.getNext()==null && min.getData()==null)
			System.out.println("The auxiliary stack is empty!!!");
		else {
			SinglyNode<Integer> temp=min;
			System.out.println("The auxiliary stack contains: (top to bottom)");
			while(temp!=null) {
				System.out.println(temp.getData()+" ");
				temp=temp.getNext();
			}
		}
	}
	
	public static void main(String[] args) throws EmptyStackException {
		StackSpclUsingLL stack=new StackSpclUsingLL();
		stack.push(23);
		stack.push(34);
		stack.push(14);
		stack.push(54);
		stack.displayStackContents();
		
		System.out.println("minimum = "+stack.getMin());	//14
		
		System.out.println("popped element ="+stack.pop());
		System.out.println("minimum = "+stack.getMin());	//14
		
		System.out.println("popped element ="+stack.pop());
		System.out.println("minimum = "+stack.getMin());	//23
		
		System.out.println("popped element ="+stack.pop());
		System.out.println("minimum = "+stack.getMin());	//23
		
		System.out.println("popped element ="+stack.pop());
		//System.out.println("minimum = "+stack.getMin());	//
		
		stack.push(12);
		System.out.println("minimum = "+stack.getMin());
		
		stack.push(1);
		stack.push(1);
		stack.displayAuxiliaryStackContents();
		stack.pop();
		stack.displayAuxiliaryStackContents();
		stack.displayStackContents();
		stack.displayAuxiliaryStackContents();
		System.out.println();
		System.out.println("minimum = "+stack.getMin());
		//*/
		
	}
}
