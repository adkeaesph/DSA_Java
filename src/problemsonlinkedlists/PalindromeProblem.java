package problemsonlinkedlists;

import datastructures.SinglyLinkedList;
import datastructures.SinglyNode;

public class PalindromeProblem {
	public static <T> boolean isPalindrome(SinglyNode<T> head) {
		if(head==null || head.getData()==null)
			return false;
		if(head.getNext()==null)
			return true;
		
		SinglyNode<T> slow=head;	//searches the mid of the list
		SinglyNode<T> fast=head;
		while(fast!=null && fast.getNext()!=null) {
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		
		SinglyNode<T> tail;
		if(fast==null)
			tail=slow;	//in case of even number of elements
		else
			tail=slow.getNext(); //in case of odd number of elements
		
		SinglyLinkedList<T> sll=new SinglyLinkedList<>();
		sll.setHead(tail);
		sll.reverse();
		tail=sll.getHead();
		while(tail!=null) {
			if(tail.getData()!=head.getData())
				return false;
			tail=tail.getNext();
			head=head.getNext();
		}
		return true;
	}
	
	public static void main(String[] args) {
		SinglyNode<Integer> head=new SinglyNode<>();
		head.setData(13);
		SinglyNode<Integer> temp=head;
		temp.setNext(new SinglyNode<Integer>(23));
		temp=temp.getNext();
		temp.setNext(new SinglyNode<Integer>(43));
		temp=temp.getNext();
		temp.setNext(new SinglyNode<Integer>(23));
		temp=temp.getNext();
		temp.setNext(new SinglyNode<Integer>(13));
		SinglyLinkedList<Integer> sll=new SinglyLinkedList<Integer>();
		sll.setHead(head);
		sll.displayList();
		System.out.println(isPalindrome(head));
	}
}
