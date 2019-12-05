package datastructures;

import customexceptions.EmptyStackException;

public class QueueUsingStack2<T> {
	private LLStack<T> mainStk;
	private LLStack<T> auxStk;
	
	public QueueUsingStack2(){
		mainStk=new LLStack<>();
		auxStk=new LLStack<>();
	}
	
	public void enqueue(T data) throws EmptyStackException {
		if(mainStk.getSize()!=0) {
			while(mainStk.getSize()!=0) {
				auxStk.push(mainStk.pop());
			}
		}
		
		auxStk.push(data);
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
	}
	
	public T dequeue() throws EmptyStackException {
		return mainStk.pop();
	}
	
	public T peekFront() throws EmptyStackException {
		return mainStk.peek();
	}
	
	public T peekRear() throws EmptyStackException {
		while(mainStk.getSize()!=0) {
			auxStk.push(mainStk.pop());
		}
		
		T rear=auxStk.peek();
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
		return rear;
	}
	
	public void displayQueueContents() throws EmptyStackException {
		System.out.println("Queue contents from front to rear : ");
		mainStk.displayStackContents();
	}
}
