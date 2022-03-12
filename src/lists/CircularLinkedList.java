package lists;

import customexceptions.ListException;

public class CircularLinkedList<T> implements List<T> {

	private SinglyNode<T> head;
	private SinglyNode<T> preHead; // is null for singleton circular linked list
	private int size;

	public CircularLinkedList() {
		head = null;
		preHead = null;
		size = 0;
	}

	@Override
	public void add(T data) {
		if (head == null) {
			head = new SinglyNode<>(data);
			head.setNext(head);
		} else {
			if (size == 1) {
				preHead = new SinglyNode<>(data);
				head.setNext(preHead);
				preHead.setNext(head);
			} else {
				preHead.setNext(new SinglyNode<>(data));
				preHead = preHead.getNext();
				preHead.setNext(head);
			}
		}
		size++;
	}

	@Override
	public void add(T data, int position) throws ListException {
		if (position < 0 || position > getSize())
			throw new ListException("Position can be 0 to n where n is the size of the list");

		if (position == 0) {
			if (getSize() == 0) {
				head = new SinglyNode<>(data);
				head.setNext(head);
			} else {
				SinglyNode<T> newNode = new SinglyNode<>(data, head);
				head = newNode;
				if (getSize() == 1)
					preHead = head.getNext();
				preHead.setNext(head);
			}
			size++;
		} else if (position == getSize()) {
			add(data);
		} else {
			SinglyNode<T> newNode = new SinglyNode<>(data);
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null) {
				if (index == position - 1) {
					newNode.setNext(currentNode.getNext());
					currentNode.setNext(newNode);
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
			if (getSize() == 1)
				head = null;
			else {
				head = head.getNext();
				if (getSize() == 2)
					preHead = null;
				else
					preHead.setNext(head);
			}
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (nextNode.getData().equals(data)) {
					if (nextNode.equals(preHead)) {
						preHead = currentNode;
						preHead.setNext(head);
					}
					currentNode.setNext(nextNode.getNext());
					size--;
					break;
				}
				currentNode = nextNode;
			}
		}
	}

	@Override
	public void removeAllObjects(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		while (head != null && head.getData().equals(data)) {
			if (getSize() == 1)
				head = null;
			else {
				head = head.getNext();
				if (getSize() == 2)
					preHead = null;
				else
					preHead.setNext(head);
			}
			size--;
		}

		SinglyNode<T> currentNode = head;
		while (getSize() > 0) {
			if(getSize() == 1) {
				if(head.getData().equals(data)) {
					head = null;
					size--;
				} else
					break;
				
			} else if (getSize() == 2) {
				if (preHead.getData().equals(data)) {
					preHead = null;
					head.setNext(head);
					size--;
				}
			} else if (getSize() > 2) {

				if (currentNode != null && currentNode.getNext() != null) {
					SinglyNode<T> nextNode = currentNode.getNext();
					if (nextNode.getData().equals(data)) {
						currentNode.setNext(nextNode.getNext());
						size--;
					} else
						currentNode = nextNode;
				}
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
			if (getSize() == 1)
				head = null;
			else {
				head = head.getNext();
				if (getSize() == 2)
					preHead = null;
				else
					preHead.setNext(head);
			}
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (index == position - 1) {
					if (nextNode.equals(preHead)) {
						preHead = currentNode;
						preHead.setNext(head);
					}
					currentNode.setNext(nextNode.getNext());
					size--;
					break;
				}
				currentNode = nextNode;
				index++;
			}
		}
	}

	@Override
	public T get(int position) throws ListException {
		if (position >= getSize() || position < 0)
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		T dataToBeReturned = null;
		if (position == 0)
			return head.getData();
		else if (position == getSize() - 1)
			return preHead.getData();
		else {
			SinglyNode<T> currentNode = head;
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
		SinglyNode<T> currentNode = head;
		for (int index = 0; index < getSize(); index++) {
			if (currentNode.getData().equals(data))
				return index;
			currentNode = currentNode.getNext();
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String result = "";
		if (size == 1)
			result += head.getData();
		else if (size > 1) {
			SinglyNode<T> currentNode = head;
			while (currentNode != preHead) {
				result += currentNode.getData() + " ";
				currentNode = currentNode.getNext();
			}
			result += preHead.getData();
		}
		return result;
	}

	public String displayRepeatedly(int n) {
		String result = "";
		SinglyNode<T> currentNode = head;
		for (int i = 0; i < n; i++) {
			result += currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}
		return result;
	}

}
