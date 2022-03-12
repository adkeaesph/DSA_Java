package lists;

import customexceptions.ListException;

public class DoublyLinkedList<T> implements List<T> {

	private DoublyNode<T> head;
	private DoublyNode<T> tail;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void add(T data) {
		if (head == null) {
			head = new DoublyNode<>(data);
			tail = head;
		} else {
			DoublyNode<T> newNode = new DoublyNode<>(data);
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public void add(T data, int position) throws ListException {
		if (position < 0 || position > getSize())
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		if (position == 0) {
			if (getSize() == 0) {
				add(data);
			} else {
				DoublyNode<T> newNode = new DoublyNode<>(data);
				newNode.setNext(head);
				head.setPrevious(newNode);
				head = newNode;
				size++;
			}
		} else if (position == getSize())
			add(data);
		else {
			DoublyNode<T> currentNode = head.getNext();
			int index = 1;
			while (currentNode != null) {
				if (index == position) {
					DoublyNode<T> newNode = new DoublyNode<>(data);
					DoublyNode<T> previousNode = currentNode.getPrevious();
					DoublyNode<T> nextNode = currentNode;

					previousNode.setNext(newNode);
					newNode.setNext(nextNode);
					nextNode.setPrevious(newNode);
					newNode.setPrevious(previousNode);
					size++;
					break;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
	}

	@Override
	public void removeObject(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		if (head.getData().equals(data)) {
			if (size == 1) {
				head = null;
				tail = head;
			} else {
				head = head.getNext();
				head.setPrevious(null);
			}
			size--;
		} else {
			DoublyNode<T> currentNode = head;
			while (currentNode != null && currentNode.getNext() != null) {
				DoublyNode<T> nextNode = currentNode.getNext();
				if (nextNode.getData().equals(data)) {
					currentNode.setNext(nextNode.getNext());
					if (nextNode.equals(tail))
						tail = currentNode;
					else
						currentNode.getNext().setPrevious(currentNode);
					size--;
					break;
				}
				currentNode = currentNode.getNext();
			}
		}
	}

	@Override
	public void removeAt(int position) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		if (position < 0 || position >= getSize())
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		if (position == 0) {
			if (size == 1) {
				head = null;
				tail = head;
			} else {
				head = head.getNext();
				head.setPrevious(null);
			}
			size--;
		} else if (position == getSize() - 1) {
			tail = tail.getPrevious();
			tail.setNext(null);
			size--;
		} else {
			DoublyNode<T> currentNode = head.getNext();
			int index = 1;
			while (currentNode != null) {
				if (index == position) {
					DoublyNode<T> previousNode = currentNode.getPrevious();
					DoublyNode<T> nextNode = currentNode.getNext();

					previousNode.setNext(nextNode);
					if (nextNode != null)
						nextNode.setPrevious(previousNode);
					else
						tail = previousNode;
					size--;
					break;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
	}

	@Override
	public void removeAllObjects(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		do {
			if (head.getData().equals(data)) {
				head = head.getNext();
				head.setPrevious(null);
				size--;
				if (head == null)
					tail = head;
			} else
				break;
		} while (head != null);

		DoublyNode<T> currentNode = head.getNext();
		while (currentNode != null) {
			if (currentNode.getData().equals(data)) {
				DoublyNode<T> previousNode = currentNode.getPrevious();
				DoublyNode<T> nextNode = currentNode.getNext();
				previousNode.setNext(nextNode);
				if (nextNode != null)
					nextNode.setPrevious(previousNode);
				else
					tail = previousNode;
				currentNode = previousNode;
				size--;
			} else
				currentNode = currentNode.getNext();
		}
	}

	@Override
	public T get(int position) throws ListException {
		if (position >= getSize() || position < 0)
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		T dataToBeReturned = null;
		if (position == getSize() - 1)
			return tail.getData();
		else {
			DoublyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null) {
				if (position == index) {
					dataToBeReturned = currentNode.getData();
					break;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
		return dataToBeReturned;
	}

	@Override
	public int getPositionOf(T data) {
		DoublyNode<T> currentNode = head;
		int index = 0;
		while (currentNode != null) {
			if (currentNode.getData().equals(data)) {
				return index;
			}
			currentNode = currentNode.getNext();
			index++;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String result = "";
		DoublyNode<T> currentNode = head;
		while (currentNode != null) {
			result += (currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		return result;
	}

	public String reverse() {
		String result = "";
		DoublyNode<T> currentNode = tail;
		while (currentNode != null) {
			result += (currentNode.getData() + " ");
			currentNode = currentNode.getPrevious();
		}
		return result;
	}

}
