package datastructures;

import customexceptions.EmptyStackException;

public class StackUsingLL<T> {
	private String stackId;
	private int size;
	private SinglyNode<T> top;	//stack_top end
	
	public StackUsingLL() {
		top=new SinglyNode<>();
		size=0;
	}
	
	public String getStackId() {
		return stackId;
	}

	public void setStackId(String stackId) {
		this.stackId = stackId;
	}

	public void push(T data) {
		if(top.getData()==null) {
			top.setData(data);
		}else {
			SinglyNode<T> nodeToBePushed=new SinglyNode<>(data);
			nodeToBePushed.setNext(top);
			top=nodeToBePushed;
		}
		size++;
	}
	
	public T pop() throws EmptyStackException {
		T popped=null;
		if(top.getNext()==null) {
			if(top.getData()==null) 
				throw new EmptyStackException("The stack is empty!!!");
			else{
				popped=top.getData();
				top.setData(null);
			}
		}else {
			popped=top.getData();
			top=top.getNext();
		}
		if(size!=0)
			size--;
		return popped;
	}
	
	public void displayStackContents() throws EmptyStackException {
		if(top.getData()==null)
			throw new EmptyStackException("The stack is empty!!!");
		
		SinglyNode<T> temp=top;
		System.out.println();
		System.out.print("[");
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		System.out.print("]");
	}
	
	public int getSize() {
		return size;
	}
	
	public T peek() throws EmptyStackException {
		if(top.getData()==null) {
			throw new EmptyStackException("The stack is empty!!!");
		}
		return top.getData();
	}
}
