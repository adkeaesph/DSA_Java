package lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import customexceptions.ListException;
public class SinglyLinkedList<T> implements List<T> {

	private SinglyNode<T> head;
	private SinglyNode<T> tail;
	private int size;

	public SinglyNode<T> getHead() {
		return head;
	}
	
	public void setHead(SinglyNode<T> head) {
		this.head = head;
	}

	public SinglyNode<T> getTail() {
		return tail;
	}
	
	public SinglyLinkedList() {
		head = null;
		tail = head;
		size = 0;
	}

	@Override
	public void add(T data) {
		if (size == 0) {
			head = new SinglyNode<>(data);
			tail = head;
		} else {
			SinglyNode<T> newNode = new SinglyNode<>(data);
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public void add(T data, int position) throws ListException {
		if (position < 0 || position > getSize())
			throw new ListException("Position can be 0 to n where n is the size of the list");

		if (position == 0) {
			if (getSize() == 0)
				add(data);
			else {
				SinglyNode<T> newNode = new SinglyNode<>(data, head);
				head = newNode;
				size++;
			}
		} else if (position == getSize())
			add(data);
		else {
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
			if (size == 1) {
				head = null;
				tail = head;
			} else
				head = head.getNext();
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (nextNode.getData().equals(data)) {
					if (nextNode.equals(tail))
						tail = currentNode;
					currentNode.setNext(nextNode.getNext());
					size--;
					break;
				}
				currentNode = nextNode;
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
			} else
				head = head.getNext();
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (index == position - 1) {
					if (nextNode.equals(tail))
						tail = currentNode;
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
	public void removeAllObjects(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");
		do {
			if (head.getData().equals(data)) {
				head = head.getNext();
				size--;
				if (head == null)
					tail = head;
			} else
				break;
		} while (head != null);

		SinglyNode<T> currentNode = head;
		while (currentNode != null && currentNode.getNext() != null) {
			SinglyNode<T> nextNode = currentNode.getNext();
			if (nextNode.getData().equals(data)) {
				if (nextNode.equals(tail))
					tail = currentNode;
				currentNode.setNext(nextNode.getNext());
				size--;
			} else
				currentNode = nextNode;
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
		SinglyNode<T> currentNode = head;
		while (currentNode != null) {
			result += (currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		return result;
	}
	
	public void reverseAlternateNodes() {
		SinglyNode<T> iteratorNode = getHead();
		SinglyNode<T> temp, prev = null;
		int iteration = 0;
		while (iteratorNode != null && iteratorNode.getNext() != null) {
			iteration++;
			temp = iteratorNode.getNext();
			iteratorNode.setNext(temp.getNext());
			temp.setNext(iteratorNode);
			if (iteration == 1) {
				setHead(temp); // setting the correct head in first iteration
			} else {
				prev.setNext(temp); // connecting the processed list of this iteration
									// with the already processed list of previous iteration
			}
			prev = iteratorNode; // storing the last node of the already processed
									// part of the list.
			iteratorNode = iteratorNode.getNext();
		}
	}
	

	public void deleteAlt() {
		if(head.getNext()==null)
            return;
        
        SinglyNode<T> temp=head;
        while(temp!=null && temp.getNext()!=null){
            temp.setNext(temp.getNext().getNext());
            temp=temp.getNext();
        }
	}
	
	public void replace(int position, T newData) {
		int count = 0;
		SinglyNode<T> temp = head;
		while (temp != null) {
			if (count == position) {
				temp.setData(newData);
				break;
			}
			count++;
			temp = temp.getNext();
		}
	}

	public void replace(T oldData, T newData) {
		SinglyNode<T> temp = head;
		while (temp != null) {
			if (temp.getData() == oldData) {
				temp.setData(newData);
				break;
			}
			temp = temp.getNext();
		}
	}

	public void replaceAll(T oldData, T newData) {
		SinglyNode<T> temp = head;
		while (temp != null) {
			if (temp.getData() == oldData) {
				temp.setData(newData);
			}
			temp = temp.getNext();
		}
	}

	public void createLoop(T data) {
		SinglyNode<T> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}

		SinglyNode<T> temp = head;
		while (temp != null) {
			if (temp.getData() == data) {
				last.setNext(temp);
				break;
			}
			temp = temp.getNext();
		}
	}

	public void createLoop(int position) {
		SinglyNode<T> last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}

		SinglyNode<T> temp = head;
		int len = 0;
		while (temp != null) {
			if (len == position) {
				last.setNext(temp);
				break;
			}
			len++;
			temp = temp.getNext();
		}
	}

	public boolean loopExists() {
		SinglyNode<T> i = head;

		HashSet<SinglyNode<T>> hs = new HashSet<>();
		while (i != null) {
			if (hs.contains(i))
				return true;
			else
				hs.add(i);
			i = i.getNext();
		}
		return false;
	}

	public boolean loopExistsByFloyd() {
		SinglyNode<T> slow = head;
		SinglyNode<T> fast = head;

		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = (fast.getNext()).getNext();
			if (slow == fast)
				return true;
		}
		return false;
	}

	/*
	 * void eliminateLoop(){ SinglyNode i=head;
	 * 
	 * HashMap<SinglyNode,SinglyNode> hm=new HashMap<>(); while(i.getNext()!=null){
	 * if(hm.containsKey(i.getNext())) { i.setNext(null); break; }else
	 * hm.put(i,i.getNext()); i=i.getNext(); } }
	 */
	public boolean findAndEliminateLoop() {// using hashmap
		SinglyNode<T> i = head;

		Map<SinglyNode<T>, SinglyNode<T>> hm = new HashMap<>();
		while (i.getNext() != null) {
			if (hm.containsKey(i.getNext())) {
				i.setNext(null);
				return true;
			} else
				hm.put(i, i.getNext());
			i = i.getNext();
		}
		return false;
	}

	public boolean findAndEliminateLoop1() {// using hashset
		SinglyNode<T> t = head;
		Set<SinglyNode<T>> hs = new HashSet<>();
		SinglyNode<T> prev = null;
		while (t != null) {
			if (hs.contains(t)) {
				prev.setNext(null);
				return true;
			} else {
				hs.add(t);
				prev = t;
				t = t.getNext();
			}
		}
		return false;
	}
	
	public void reverse() {
		SinglyNode<T> prev = null;
		SinglyNode<T> temp = getHead();
		SinglyNode<T> next;
		while (temp != null) {
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		setHead(prev);
	}
}


	

	

//	public void deleteFirst() {
//		if (head == null) {
//			return;
//		}
//		head = head.getNext();
//		size--;
//	}
//
//	public void deleteLast() {
//		if (isEmpty()) {
//			System.out.println("List is empty!!! No deletion happened.");
//			return;
//		}
//		SinglyNode<T> secondLast = head;
//		while (secondLast.getNext().getNext() != null)
//			secondLast = secondLast.getNext();
//
//		secondLast.setNext(null);
//		size--;
//	}
//
//	public void deleteAt(int position) {
//		if (head == null) {
//			System.out.println("List is empty!!! No deletion happened.");
//			return;
//		}
//
//		int len = getSize();
//		if (position < 0 || position >= len) {
//			System.out.println("Invalid Position");
//			return;
//		}
//
//		if (position == 0) {
//			deleteFirst();
//		} else if (position == len - 1) {
//			deleteLast();
//		} else {
//			len = 0;
//			SinglyNode<T> temp = head;
//			while (temp != null) {
//				if (len == (position - 1)) {
//					temp.setNext(temp.getNext().getNext());
//					break;
//				}
//				temp = temp.getNext();
//				len++;
//			}
//			size--;
//		}
//	}
//
//	public void delete(T data) {
//		int pos = findPosition(data);
//		if (pos == -2) {
//			System.out.println("List is empty!!! Element not found.");
//			return;
//		} else if (pos == -1) {
//			System.out.println("Element not found!!!");
//			return;
//		}
//		deleteAt(pos);
//	}
//
//	public void deleteAll(T data) {
//		int pos = findPosition(data);
//		boolean flag = false;
//		while (pos >= 0) {
//			flag = true;
//			deleteAt(pos);
//			pos = findPosition(data);
//		}
//
//		if (!flag) {
//			if (pos == -2)
//				System.out.println("List is empty!!! Element not found.");
//			else if (pos == -1)
//				System.out.println("Element not found!!!");
//		}
//	}
//
//	public void deleteNode(SinglyNode<T> node) {
//		SinglyNode<T> next = node.getNext();
//		System.out.println(node.getData());
//		node=next;
//		System.out.println(node.getData());
//	}
	
//
//	public void displayList() {
//		System.out.print("[");
//		SinglyNode<T> temp = getHead();
//		if (temp != null) {
//			while (temp.getNext() != null) {
//				System.out.print(temp.getData() + ", ");
//				temp = temp.getNext();
//			}
//			System.out.print(temp.getData());
//		}
//		System.out.print("]");
//		System.out.println();
//	}

	

	

