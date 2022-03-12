package problemsonlinkedlists;

import java.util.LinkedHashSet;
import java.util.Set;

import lists.SinglyLinkedList;
import lists.SinglyNode;

public class DuplicatesRemoval {

	public static void removeDuplicatesFromSortedList(SinglyLinkedList<Integer> sll) {
		if (sll.getHead() == null || sll.getHead().getNext() == null)
			return;

		SinglyNode<Integer> temp = sll.getHead();

		while (temp.getNext() != null) {
			if (temp.getData() == temp.getNext().getData()) {
				temp.setNext(temp.getNext().getNext());
			} else
				temp = temp.getNext();
		}
	}

	public static void removeDuplicatesFromUnsortedListBruteForce(SinglyLinkedList<Integer> sll) {
		SinglyNode<Integer> head = sll.getHead();
		if (head == null || head.getNext() == null)
			return;

		SinglyNode<Integer> next, prev;
		while (head != null) {
			next = head.getNext();
			prev = head;
			while (next != null) {
				if (head.getData() == next.getData())
					prev.setNext(next.getNext());
				else
					prev = next;
				next = next.getNext();
			}
			head = head.getNext();
		}
	}

	public static void removeDuplicatesFromUnsortedListOptimised(SinglyLinkedList<Integer> sll) {
		SinglyNode<Integer> head = sll.getHead();
		if (head == null || head.getNext() == null)
			return;

		Set<Integer> distincts = new LinkedHashSet<>();
		distincts.add(head.getData());
		while (head.getNext() != null) {
			if (distincts.contains(head.getNext().getData())) {
				head.setNext(head.getNext().getNext());
			} else {
				distincts.add(head.getNext().getData());
				head = head.getNext();
			}
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(1);
		sll.add(2);
		sll.add(2);
		sll.add(2);
		sll.add(5);
		sll.add(6);
		sll.add(6);
		sll.add(8);
		// sll.insertAtEnd(8);
		// sll.insertAtEnd(8);
		// sll.insertAtEnd(8);
		System.out.println(sll);

		removeDuplicatesFromSortedList(sll);
		System.out.println(sll);

		sll = new SinglyLinkedList<Integer>();
		sll.add(2);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(2);
		sll.add(4);
		sll.add(9);
		sll.add(0);
		sll.add(7);
		sll.add(7);
		sll.add(3);
		sll.add(1);
		sll.add(9);
		System.out.println(sll);

		removeDuplicatesFromUnsortedListBruteForce(sll);
		System.out.println(sll);

		sll = new SinglyLinkedList<Integer>();
		sll.add(2);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		sll.add(2);
		sll.add(4);
		sll.add(9);
		sll.add(0);
		sll.add(7);
		sll.add(7);
		sll.add(3);
		sll.add(1);
		sll.add(9);
		System.out.println(sll);

		removeDuplicatesFromUnsortedListOptimised(sll);
		System.out.println(sll);
	}

}
