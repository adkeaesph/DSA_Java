package datastructures;

public class QueueUsingStack2<T> {
	private LLStack<T> mainStk;
	private LLStack<T> auxStk;
	
	public QueueUsingStack2(){
		mainStk=new LLStack<>();
		auxStk=new LLStack<>();
	}
	
	public void enqueue(T data) throws StackEmptyException {
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
	
	public T dequeue() throws StackEmptyException {
		return mainStk.pop();
	}
	
	public T peekFront() throws StackEmptyException {
		return mainStk.peek();
	}
	
	public T peekRear() throws StackEmptyException {
		while(mainStk.getSize()!=0) {
			auxStk.push(mainStk.pop());
		}
		
		T rear=auxStk.peek();
		
		while(auxStk.getSize()!=0) {
			mainStk.push(auxStk.pop());
		}
		return rear;
	}
	
	public void displayQueueContents() throws StackEmptyException {
		System.out.println("Queue contents from front to rear : ");
		mainStk.displayStackContents();
	}
}
