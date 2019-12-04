package datastructures;

/*
 * queue with expensive dequeue operation
 */
public class QueueUsingStack1<T> {
	private LLStack<T> mainStk;
	private LLStack<T> auxStk;
	
	public QueueUsingStack1() {
		mainStk=new LLStack<>();
		auxStk=new LLStack<>();
	}
	
	public int getSize() {
		return mainStk.getSize();
	}

	public void enqueue(T data) {
		mainStk.push(data);
	}
	
	public T dequeue() throws StackEmptyException {
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
	
	public T peekFront() throws StackEmptyException {
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
	
	public T peekRear() throws StackEmptyException {
		return mainStk.peek();
	}
	
	public void displayQueueContents() throws StackEmptyException {
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
