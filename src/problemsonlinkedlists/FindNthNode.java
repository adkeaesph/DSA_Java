package problemsonlinkedlists;

import customexceptions.ListException;
import lists.List;
import lists.SinglyNode;

public class FindNthNode {

	public static <T> T findNthNodeFromLast(List<T> list, int n) throws ListException {
		int sizeOfList = list.getSize();
		if (n < 0 || n >= sizeOfList)
			throw new ListException(
					"Size of list is " + sizeOfList + ". Hence, n can be 0 to " + (sizeOfList - 1) + ".");
		return list.get(list.getSize() - 1 - n);
	}

	public static <T> T findNthNodeFromLastEfficiently(SinglyNode<T> head, int n) throws ListException {
		if (n < 0)
			throw new ListException("position of a list can never be negative.");
		SinglyNode<T> fastPointer = head;
		SinglyNode<T> slowPointer = head;
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				if (fastPointer.getNext() == null)
					throw new ListException("n is greater than size - 1");
				else
					fastPointer = fastPointer.getNext();
			}
		}

		while (fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}

		return slowPointer.getData();
	}
	
	public static void main(String[] args) throws ListException {
		SinglyNode<Integer> head = new SinglyNode<>(23);
		head.setNext(new SinglyNode<Integer>(34, new SinglyNode<Integer>(45, new SinglyNode<Integer>(56))));
		
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 0));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 1));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 2));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 3));
		System.out.println(FindNthNode.findNthNodeFromLastEfficiently(head, 4));
	}	

}
