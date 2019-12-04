package problemsonlinkedlists;

import datastructures.SinglyLinkedList;
import datastructures.SinglyNode;

public class Sort0s1s2s {

	public static SinglyNode<Integer> sort0s1s2s(SinglyNode<Integer> head) {
		SinglyNode<Integer> prev = null, temp = head;

		SinglyNode<Integer> last = head;
		int twos=0;
		
		while (last.getNext() != null) {
			last = last.getNext();
		}

		while (temp != null) {
			if (temp.getData().equals(0)) {
				if (temp != head) {
					if (temp == last) {
						last = prev;		
					}
					prev.setNext(temp.getNext());
					temp.setNext(head);
					head = temp;
					temp = prev.getNext();
				}
			} else if(temp.getData()==Integer.valueOf(2)) {
				twos++;
				prev = temp;
				temp = temp.getNext();
			} else {
				prev = temp;
				temp = temp.getNext();
			}
		}
		
		/*System.out.println(twos);
		SinglyLinkedList<Integer> sll=new SinglyLinkedList<Integer>();
		sll.setHead(head);
		sll.displayList();
		*/
		temp=head;
		prev=null;
		last = head;
		while (last.getNext() != null)
			last = last.getNext();
		
		while(temp!=null) {
			if (temp.getData().equals(2) && twos!=0) {
				if (temp != last) {
					if(temp!=head) {
						prev.setNext(temp.getNext());
						last.setNext(temp);
						last = last.getNext();
						last.setNext(null);
						temp = prev.getNext();
					} else {
						head = temp.getNext();
						last.setNext(temp);
						last = last.getNext();
						last.setNext(null);
						temp = head;					
					}
				}
				twos--;
			} else {
				prev = temp;
				temp = temp.getNext();
			}
		}
		return head;
	}

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll=new SinglyLinkedList<Integer>();
		sll.insertAtEnd(2);
		sll.insertAtEnd(2);
		sll.insertAtEnd(0);
		sll.insertAtEnd(0);
		sll.insertAtEnd(1);
		sll.insertAtEnd(0);
		sll.insertAtEnd(2);
		sll.insertAtEnd(1);
		sll.insertAtEnd(1);
		sll.displayList();
		
		sll.setHead(sort0s1s2s(sll.getHead()));
		sll.displayList();
	}

}
