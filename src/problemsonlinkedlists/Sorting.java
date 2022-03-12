package problemsonlinkedlists;

import lists.SinglyNode;
import utils.ListUtil;

public class Sorting {

	public static SinglyNode<Integer> insertNodeInASortedList(SinglyNode<Integer> head, Integer data) {
		SinglyNode<Integer> nodeToBeInserted = new SinglyNode<>(data);
		if (head == null) {
			head = nodeToBeInserted;
			return head;
		} else {
			if (head.getData() == null) {
				head.setData(data);
				return head;
			} else {
				if (data < head.getData()) {
					nodeToBeInserted.setNext(head);
					head = nodeToBeInserted;
					return head;
				}
			}

		}

		SinglyNode<Integer> previousNode = head;
		SinglyNode<Integer> nextNode = head.getNext();

		while (nextNode != null) {
			if (data < nextNode.getData()) {
				previousNode.setNext(nodeToBeInserted);
				nodeToBeInserted.setNext(nextNode);
				return head;
			}
			previousNode = previousNode.getNext();
			nextNode = nextNode.getNext();
		}
		previousNode.setNext(nodeToBeInserted);
		return head;
	}

	public static <T> SinglyNode<T> reverseList(SinglyNode<T> head) {
		SinglyNode<T> nextNode, previousNode = 	null;

		while (head.getNext() != null) {
			nextNode = head.getNext();
			head.setNext(previousNode);
			previousNode = head;
			head = nextNode;
		}
		head.setNext(previousNode);
		return head;
	}
	
	public static SinglyNode<Integer> mergeTwoSortedLists(SinglyNode<Integer> head, SinglyNode<Integer> head2) {
		if(head == null ) 
			return head2;
		
		if(head2 == null) 
			return head;
		
		SinglyNode<Integer> head3 = null, curr = null;
		if(head.getData() <= head2.getData()) {
			head3 = head;
			curr = head3;
			head = head.getNext();
		} else {
			head3 = head2;
			curr = head3;
			head2 = head2.getNext();
		}
		
		while(head != null && head2 != null) {
			if(head.getData() <= head2.getData()) {	
				curr.setNext(head);
				head = head.getNext();
			} else {
				curr.setNext(head2);
				head2 = head2.getNext();
			}
			curr = curr.getNext();
		}
		
		if(head != null)
			curr.setNext(head);
		if(head2 != null)
			curr.setNext(head2);
	
		return head3;
	}
	
//	public static <T> SinglyNode<T> reverseNnodes(SinglyNode<T> head, int n) {
//		SinglyNode<T> curr = head, curr2;
//		SinglyNode<T> prevNode = head;
//		SinglyNode<T> nextNode = null;
//		while(curr!=null) {
//			curr2 = curr;
//			for(int i=0;i<n-1;i++) {
//				if(curr2!=null)
//					curr2 = curr2.getNext();
//				else
//					break;
//			}
//			
//			nextNode = curr2.getNext();
//			SinglyNode<T> tailOfReversedList = curr;
//			SinglyNode<T> headOfReversedList = reverseList(curr);
//			if(prevNode == head)
//				head = headOfReversedList;
//			else
//				prevNode.setNext(headOfReversedList);
//			tailOfReversedList.setNext(nextNode);
//			curr = nextNode;
//		}
//		return head;
//	}

	public static void main(String[] args) {
		SinglyNode<Integer> head = new SinglyNode<>();
		head = insertNodeInASortedList(head, 45);
		head = insertNodeInASortedList(head, 56);
		head = insertNodeInASortedList(head, 22);
		head = insertNodeInASortedList(head, 54);
		head = insertNodeInASortedList(head, 45);
		ListUtil.displayList(head);
		
		SinglyNode<Integer> head2 = new SinglyNode<>();
		head2 = insertNodeInASortedList(head2, 10);
		head2 = insertNodeInASortedList(head2, 30);
		head2 = insertNodeInASortedList(head2, 49);
//		head2 = insertNodeInASortedList(head2, 90);
		ListUtil.displayList(head2);
		
		SinglyNode<Integer> head3 = mergeTwoSortedLists(head, head2);
		ListUtil.displayList(head3);
		
//		SinglyNode<Integer> head4 = reverseNnodes(head3, 2); 
//		ListUtil.displayList(head4);
	}

}
