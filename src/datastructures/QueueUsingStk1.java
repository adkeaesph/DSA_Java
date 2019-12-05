package datastructures;

import customexceptions.EmptyStackException;

/*
 * queue with expensive dequeue operation
 */
public class QueueUsingStk1<T> {
	private StackUsingLL<T> mainStk;
	private StackUsingLL<T> auxStk;
	
	public QueueUsingStk1() {
		mainStk=new StackUsingLL<>();
		auxStk=new StackUsingLL<>();
	}
	
	public int getSize() {
		return mainStk.getSize();
	}

	public void enqueue(T data) {
		mainStk.push(data);
	}
	
	public T dequeue() throws EmptyStackException {
		T popped;
		while(mainStk.getSize()!=0) {
			auxStk.push(mainStk.pop());
		}
		
		popped=auxStk.pop();
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
		return popped;
	}
	
	public T peekFront() throws EmptyStackException {
		T front;
		while(mainStk.getSize()!=0) {
			auxStk.push(mainStk.pop());
		}
		
		front=auxStk.peek();
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
		return front;
	}
	
	public T peekRear() throws EmptyStackException {
		return mainStk.peek();
	}
	
	public void displayQueueContents() throws EmptyStackException {
		while(mainStk.getSize()!=0) {
			auxStk.push(mainStk.pop());
		}
		
		System.out.println("Queue contents from front to rear : ");
		auxStk.displayStackContents();
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
	}

}
