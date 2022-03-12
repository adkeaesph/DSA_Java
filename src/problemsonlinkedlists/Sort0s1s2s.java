package problemsonlinkedlists;

import lists.SinglyLinkedList;
import lists.SinglyNode;

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
		sll.add(2);
		sll.add(2);
		sll.add(0);
		sll.add(0);
		sll.add(1);
		sll.add(0);
		sll.add(2);
		sll.add(1);
		sll.add(1);
		System.out.println(sll);
		
		sll.setHead(sort0s1s2s(sll.getHead()));
		System.out.println(sll);
	}

}
