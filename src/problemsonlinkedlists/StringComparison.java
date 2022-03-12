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
		s1.add('a');
		// s1.add('b');
		// s1.add('f');
		// s1.add('a');
		System.out.println(s1);

		SinglyLinkedList<Character> s2 = new SinglyLinkedList<Character>();
		s2.add('v');
		// s2.add('b');
		// s2.add('c');
		// s2.add('b');
		System.out.println(s2);

		System.out.println(compare(s1, s2));

	}

}
