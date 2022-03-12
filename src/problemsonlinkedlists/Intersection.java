package problemsonlinkedlists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import lists.SinglyNode;

public class Intersection {
	
	public static <T> SinglyNode<T> findTheMergingPointOFTwoGivenLists_BruteForce(SinglyNode<T> head1, SinglyNode<T> head2) {
		if(head1 == null || head2 == null)
			return null;
		
		SinglyNode<T> currentNode1 = head1;
		SinglyNode<T> currentNode2;
		
		while(currentNode1 != null) {
			currentNode2 = head2;
			while(currentNode2 != null) {
				if(currentNode1 == currentNode2)
					return currentNode1;
				currentNode2 = currentNode2.getNext();
			}
			currentNode1 = currentNode1.getNext();
		}
		return new SinglyNode<>();
	}
	
	public static <T> SinglyNode<T> findTheMergingPointOFTwoGivenLists_UsingHashSet(SinglyNode<T> head1, SinglyNode<T> head2) {
		if(head1 == null || head2 == null)
			return null;
		
		SinglyNode<T> currentNode1 = head1;
		Set<SinglyNode<T>> setOfNodes = new HashSet<>();
		while(currentNode1 != null) {
			setOfNodes.add(currentNode1);
			currentNode1 = currentNode1.getNext();
		}
		
		SinglyNode<T> currentNode2 = head2;
		while(currentNode2 != null) {
			if(setOfNodes.contains(currentNode2))
				return currentNode2;
			currentNode2 = currentNode2.getNext();
		}
		return new SinglyNode<>();
	}
	
	public static <T> SinglyNode<T> findTheMergingPointOFTwoGivenLists_UsingStacks(SinglyNode<T> head1, SinglyNode<T> head2) {
		if(head1 == null || head2 == null)
			return null;
		
		SinglyNode<T> currentNode1 = head1;
		Stack<SinglyNode<T>> stackOfNodes = new Stack<>();
		while(currentNode1 != null) {
			stackOfNodes.push(currentNode1);
			currentNode1 = currentNode1.getNext();
		}
		
		SinglyNode<T> currentNode2 = head2;
		Stack<SinglyNode<T>> stackOfNodes2 = new Stack<>();
		while(currentNode2 != null) {
			stackOfNodes2.push(currentNode2);
			currentNode2 = currentNode2.getNext();
		}
		
		SinglyNode<T> commonNode = new SinglyNode<>();
		while(!stackOfNodes.isEmpty() && !stackOfNodes2.isEmpty()) {
			if(stackOfNodes.peek() == stackOfNodes2.peek()) {
				commonNode = stackOfNodes.pop();
				stackOfNodes2.pop();
			} else
				break;
		}
		return commonNode;
	}
	
	public static void main(String[] args) {
		SinglyNode<Integer> head = new SinglyNode<>(23);
		head.setNext(new SinglyNode<Integer>(34, new SinglyNode<Integer>(45, new SinglyNode<Integer>(56))));
		head.displayListIfThisIsHead();
		
		SinglyNode<Integer> head2 = new SinglyNode<>(8);
		head2.setNext(new SinglyNode<Integer>(10,head.getNext()));
		head2.displayListIfThisIsHead();
		
		SinglyNode<Integer> head3 = new SinglyNode<>(1);
		head3.setNext(new SinglyNode<Integer>(3, new SinglyNode<Integer>(5, new SinglyNode<Integer>(7))));
		head3.displayListIfThisIsHead();
		
		System.out.println(findTheMergingPointOFTwoGivenLists_BruteForce(head, head2));
		System.out.println(findTheMergingPointOFTwoGivenLists_UsingHashSet(head, head2));
		System.out.println(findTheMergingPointOFTwoGivenLists_UsingStacks(head, head2));
		
		System.out.println(findTheMergingPointOFTwoGivenLists_BruteForce(head, head3));
		System.out.println(findTheMergingPointOFTwoGivenLists_UsingHashSet(head, head3));
		System.out.println(findTheMergingPointOFTwoGivenLists_UsingStacks(head, head3));
	}

}
