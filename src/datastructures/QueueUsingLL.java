package datastructures;

import customexceptions.EmptyQueueException;

public class QueueUsingLL<T> {
	private SinglyNode<T> front;
	private SinglyNode<T> rear;
	private int size;

	public QueueUsingLL() {
		front = new SinglyNode<>();
		rear = front;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public void enqueue(T data) {
		if (front == rear && rear.getData() == null) 
			rear.setData(data);
		else {
			SinglyNode<T> newNode = new SinglyNode<>(data);
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}

	public T dequeue() throws EmptyQueueException {
		T toBeRemoved = null;
		if (front == rear) {
			if (front.getData() == null)
				throw new EmptyQueueException("Queue is empty!!!");
			else {
				toBeRemoved = front.getData();
				front.setData(null);
				size--;
			}
		} else {
			toBeRemoved = front.getData();
			front = front.getNext();
			size--;
		}
		return toBeRemoved;
	}

	public T peekFront() throws EmptyQueueException {
		T peeked = null;
		if (front == rear) {
			if (front.getData() == null)
				throw new EmptyQueueException("Queue is empty!!!");
			else {
				peeked = front.getData();
			}
		} else {
			peeked = front.getData();
		}
		return peeked;
	}

	public T peekRear() throws EmptyQueueException {
		T peeked = null;
		if (front == rear) {
			if (rear.getData() == null)
				throw new EmptyQueueException("Queue is empty!!!");
			else {
				peeked = rear.getData();
			}
		} else {
			peeked = rear.getData();
		}
		return peeked;
	}

	public void displayQueueContents() throws EmptyQueueException {
		if (front.getData() == null)
			throw new EmptyQueueException("Queue is empty!!!");

		SinglyNode<T> temp = front;
		System.out.print("[");
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.print("]");
	}
}
