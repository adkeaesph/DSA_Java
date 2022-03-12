package utils;

import lists.SinglyNode;

public class ListUtil {
	public static <T> void displayList(SinglyNode<T> head) {
		SinglyNode<T> currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + "\t");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
	
	public static <T> int getSize(SinglyNode<T> head) {
		SinglyNode<T> currentNode = head;
		int size = 0;
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
		return size;
	}
}
