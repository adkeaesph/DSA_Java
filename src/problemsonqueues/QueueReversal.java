package problemsonqueues;

import customexceptions.EmptyQueueException;
import customexceptions.EmptyStackException;
import queues.QueueUsingLL;
import stacks.StackUsingLL;

public class QueueReversal {

	public static void reverseQueue(QueueUsingLL<Integer> q) throws EmptyQueueException, EmptyStackException {
		StackUsingLL<Integer> stk=new StackUsingLL<>();
		if(q.getSize()<=1) {
			return;
		}
		while(q.getSize()!=0) {
			stk.push(q.dequeue());
		}
		
		while(stk.getSize()!=0) {
			q.enqueue(stk.pop());
		}
	}
	
	public static void reverseQueueUsingRecursion(QueueUsingLL<Integer> q) throws EmptyQueueException{
		while(q.getSize()==0)
			return;
		
		Integer removed = q.dequeue();
		reverseQueueUsingRecursion(q);
		q.enqueue(removed);
	}
	
	public static void main(String[] args) throws EmptyQueueException, EmptyStackException {
		QueueUsingLL<Integer> q=new QueueUsingLL<>();
		q.enqueue(12);
		q.enqueue(23);
		q.enqueue(34);
		q.enqueue(45);
		q.displayQueueContents();
		System.out.println(q.peekFront()+" "+q.peekRear());
		
		reverseQueue(q);
		q.displayQueueContents();
		System.out.println(q.peekFront()+" "+q.peekRear());
		
		//q.dequeue();
		//q.dequeue();
		//q.dequeue();
		//q.dequeue();
		reverseQueueUsingRecursion(q);
		q.displayQueueContents();
		System.out.println(q.peekFront()+" "+q.peekRear());
	}

}
