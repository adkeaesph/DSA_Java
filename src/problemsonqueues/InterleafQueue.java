package problemsonqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleafQueue {

	public static void interleaveQueueFirstHalfWithSecondHalf(Queue<Integer> q) {
		int halflen=q.size()/2;
		Stack<Integer> stk=new Stack<>();
		
		Integer removed;
		for(int i=0;i<halflen;i++) {
			removed=q.remove();
			stk.push(removed);
		}
		
		for(int i=0;i<halflen;i++) {
			q.add(stk.pop());
		}
		
		for(int i=0;i<halflen;i++) {
			removed=q.remove();
			q.add(removed);
		}
		
		for(int i=0;i<halflen;i++) {
			removed=q.remove();
			stk.push(removed);
		}
		
		for(int i=0;i<halflen*2;i++) {
			if(i%2==0) {
				q.add(stk.pop());
			}else {
				removed=q.remove();
				q.add(removed);
			}
		}
	}
	public static void main(String[] args) {
		Queue<Integer> q= new LinkedList<>();
		q.add(12);
		q.add(23);
		q.add(34);
		q.add(45);
		interleaveQueueFirstHalfWithSecondHalf(q);
		
		while(q.size()!=0)
			System.out.println(q.remove());
	}

}
