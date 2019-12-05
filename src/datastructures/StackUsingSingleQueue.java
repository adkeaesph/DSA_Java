package datastructures;

import customexceptions.EmptyQueueException;
import customexceptions.EmptyStackException;

public class StackUsingSingleQueue<T> {
	private QueueUsingLL<T> q;

	public StackUsingSingleQueue() {
		q = new QueueUsingLL<>();
	}

	public void push(T data) throws EmptyQueueException {
		q.enqueue(data);
		int len = q.getSize();
		if (len == 1) {
			return;
		}

		for (int i = 1; i <= len - 1; i++) {
			T removed = q.dequeue();
			q.enqueue(removed);
		}
	}

	public T pop() throws EmptyStackException {
		T popped = null;
		try {
			popped = q.dequeue();
		} catch (EmptyQueueException e) {
			throw new EmptyStackException("Stack is empty!!!");
		}
		return popped;
	}

	public T peek() throws EmptyStackException {
		T peeked = null;
		try {
			peeked = q.peekFront();
		} catch (EmptyQueueException e) {
			throw new EmptyStackException("Stack is empty!!!");
		}
		return peeked;
	}

	public int getSize() {
		return q.getSize();
	}

	public void displayStackContents() throws EmptyStackException {
		try {
			q.displayQueueContents();
		} catch (EmptyQueueException e) {
			throw new EmptyStackException("Stack is empty!!!");
		}
	}
}
