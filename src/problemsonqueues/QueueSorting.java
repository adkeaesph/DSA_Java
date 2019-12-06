package problemsonqueues;

import customexceptions.EmptyQueueException;
import queues.QueueUsingLL;

public class QueueSorting {

	public static QueueUsingLL<Integer> sortQueue(QueueUsingLL<Integer> q) throws EmptyQueueException {
		if(q.getSize()<=1)
			return q;
		
		QueueUsingLL<Integer> sortedQ=new QueueUsingLL<>();
		
		int i,len,count;
		Integer min,popped;
		while(q.getSize()!=1) {
			min=Integer.MAX_VALUE;
			len=q.getSize();
			for(i=1;i<=len;i++) {
				if(min>q.peekFront()) {
					min=q.peekFront();
				}
				q.enqueue(q.dequeue());
			}
			
			//System.out.print("\nLength = "+len);
			
			i=1;
			count=0;
			while(i<=len) {
				popped=q.dequeue();
				if(popped!=min) {
					q.enqueue(popped);
				}else {
					if(count==0) {
						count++;
					}else {
						q.enqueue(popped);
					}
				}
				i++;
			}
			
			//q.displayQueueContents();
			//System.out.println(min+" "+q.getSize());
			
			sortedQ.enqueue(min);
		}
		sortedQ.enqueue(q.dequeue());
		q=null;
		return sortedQ;
	}
	
	public static void main(String[] args) throws EmptyQueueException {
		QueueUsingLL<Integer> q=new QueueUsingLL<>();
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(7);
		q.enqueue(5);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(10);
		
		q.displayQueueContents();
		
		q=sortQueue(q);
		q.displayQueueContents();
	}

}
