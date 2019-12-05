package datastructures;

import java.util.LinkedList;
import java.util.Queue;

import customexceptions.EmptyStackException;

public class StackUsingSingleQueue<T> {
	private Queue<T> q;
	
	public StackUsingSingleQueue() {
		q=new LinkedList<>();
	}
	
	public void push(T data) {
		q.add(data);
		int len=q.size();
		if(len==1) {
			return;
		}
		
		for(int i=1;i<=len-1;i++) {
			T removed=q.remove();
			q.add(removed);
		}
	}
	
	public T pop() throws EmptyStackException{
		if(q.isEmpty())
			throw new EmptyStackException("Stack is empty!!!");
		return q.remove();
	}
	
	public T peek() throws EmptyStackException {
		if(q.isEmpty())
			throw new EmptyStackException("Stack is empty!!!");
		return q.poll();
	}
	
	public int getSize() {
		return q.size();
	}
	
	public void displayStackContents() throws EmptyStackException {
		if(q.isEmpty())
			throw new EmptyStackException("Stack is empty!!!");
		
		System.out.println("Stack contents from top to bottom: ");
		for(int i=0;i<q.size();i++) {
			T dropped=q.remove();
			System.out.println(dropped);
			q.add(dropped);
		}
	}
}
