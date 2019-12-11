package problemsonlinkedlists;

import lists.SinglyLinkedList;
import lists.SinglyNode;

public class StringComparison {

	public static int compare(SinglyLinkedList<Character> sl1, SinglyLinkedList<Character> sl2) {
		if (sl1.getHead() == null) {
			if (sl2.getHead() == null)
				return 0;
			else
				return -1;
		} else {
			if (sl2.getHead() == null)
				return 1;
			else {
				SinglyNode<Character> head1 = sl1.getHead(), head2 = sl2.getHead();
				while (head1 != null && head2 != null) {
					if (head1.getData() < head2.getData())
						return -1;
					else if (head1.getData() > head2.getData())
						return 1;

					head1 = head1.getNext();
					head2 = head2.getNext();
				}

				if (head1.getNext() == null) {
					if (head2.getNext() == null)
						return 0;
					else
						return 1;
				} else {
					return -1;
				}

			}
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Character> s1 = new SinglyLinkedList<Character>();
		s1.insertAtEnd('a');
		// s1.insertAtEnd('b');
		// s1.insertAtEnd('f');
		// s1.insertAtEnd('a');
		s1.displayList();

		SinglyLinkedList<Character> s2 = new SinglyLinkedList<Character>();
		s2.insertAtEnd('v');
		// s2.insertAtEnd('b');
		// s2.insertAtEnd('c');
		// s2.insertAtEnd('b');
		s2.displayList();

		System.out.println(compare(s1, s2));

	}

}
