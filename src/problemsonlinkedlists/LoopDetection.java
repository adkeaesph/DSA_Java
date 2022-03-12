package problemsonlinkedlists;

import java.util.HashSet;
import java.util.Set;

import lists.SinglyNode;
import customexceptions.ListException;

public class LoopDetection {
	
	public static <T> boolean doesLoopExistsUsingSet(SinglyNode<T> head) {
		Set<SinglyNode<T>> set = new HashSet<>();
		SinglyNode<T> currentNode = head;
		while(currentNode!=null) {
			if(set.contains(currentNode))
				return true;
			
			set.add(currentNode);
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	public static <T> boolean doesLoopExistsUsingPointers(SinglyNode<T> head) {
		SinglyNode<T> slowNode = head;
		SinglyNode<T> fastNode = head;
		
		while(fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
			if(slowNode == fastNode)
				return true;
		}
		return false;
	}
	
	public static <T> SinglyNode<T> findStartNodeOfLoopIfLoopExists(SinglyNode<T> head) {
		SinglyNode<T> slowNode = head;
		SinglyNode<T> fastNode = head;
		
		boolean loopExists = false;
		while(fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
			if(slowNode == fastNode) {
				loopExists = true;
				break;
			}
		}
		
		if(loopExists) {
			slowNode = head;
			while(slowNode != fastNode) {
				slowNode = slowNode.getNext();
				fastNode = fastNode.getNext();
			}
			return slowNode;
		}
		return new SinglyNode<>();
	}
	
	public static <T> int findLengthOfLoopIfLoopExists(SinglyNode<T> head) {
		SinglyNode<T> slowNode = head;
		SinglyNode<T> fastNode = head;
		
		boolean loopExists = false;
		while(fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
			if(slowNode == fastNode) {
				loopExists = true;
				break;
			}
		}
		
		int lengthOfLoop = 0;
		if(loopExists) {
			while(true) {
				fastNode = fastNode.getNext();
				lengthOfLoop++;
				if(fastNode == slowNode)
					break;
			}
			return lengthOfLoop;
		}
		return lengthOfLoop;
	}
	
	public static void main(String[] args) throws ListException {
		SinglyNode<Integer> head = new SinglyNode<>(23);
		head.setNext(new SinglyNode<Integer>(34, new SinglyNode<Integer>(45, new SinglyNode<Integer>(56))));
		
		System.out.println(LoopDetection.doesLoopExistsUsingSet(head));
		System.out.println(LoopDetection.doesLoopExistsUsingPointers(head));
		System.out.println(LoopDetection.findStartNodeOfLoopIfLoopExists(head).getData());
		System.out.println(LoopDetection.findLengthOfLoopIfLoopExists(head));
		
		SinglyNode<Integer> currentNode = head;
		
		while(currentNode.getNext()!= null)
			currentNode = currentNode.getNext();
		
		currentNode.setNext(new SinglyNode<Integer>(67, new SinglyNode<Integer>(78, head.getNext().getNext())));
		System.out.println(LoopDetection.doesLoopExistsUsingSet(head));
		System.out.println(LoopDetection.doesLoopExistsUsingPointers(head));
		System.out.println(LoopDetection.findStartNodeOfLoopIfLoopExists(head).getData());
		System.out.println(LoopDetection.findLengthOfLoopIfLoopExists(head));
		
		//loop with length 1
		SinglyNode<Integer> head2 = new SinglyNode<>(23);
		head2.setNext( head2);
		System.out.println(LoopDetection.doesLoopExistsUsingSet(head2));
		System.out.println(LoopDetection.doesLoopExistsUsingPointers(head2));
		System.out.println(LoopDetection.findStartNodeOfLoopIfLoopExists(head2).getData());
		System.out.println(LoopDetection.findLengthOfLoopIfLoopExists(head2));
		
	}


}
