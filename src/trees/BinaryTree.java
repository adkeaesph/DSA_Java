package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import customexceptions.EmptyStackException;
import lists.SinglyLinkedList;
import lists.SinglyNode;
import stacks.StackUsingLL;


public class BinaryTree<T> {
	
	private BinaryTreeNode<T> root;

	public BinaryTree() {
		root = new BinaryTreeNode<>();
	}

	public BinaryTree(T data) {
		root = new BinaryTreeNode<>(data);
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public void inOrderTraversal() {
		BinaryTree<T> left = new BinaryTree<>();
		if (root.getLeft() != null) {
			left.setRoot(root.getLeft());
			left.inOrderTraversal();
		}

		System.out.print(root.getData() + " ");

		BinaryTree<T> right = new BinaryTree<>();
		if (root.getRight() != null) {
			right.setRoot(root.getRight());
			right.inOrderTraversal();
		}
	}

	public void preOrderTraversal() {
		System.out.print(root.getData() + " ");

		BinaryTree<T> left = new BinaryTree<>();
		if (root.getLeft() != null) {
			left.setRoot(root.getLeft());
			left.preOrderTraversal();
		}

		BinaryTree<T> right = new BinaryTree<>();
		if (root.getRight() != null) {
			right.setRoot(root.getRight());
			right.preOrderTraversal();
		}
	}

	public void postOrderTraversal() {
		BinaryTree<T> left = new BinaryTree<>();
		if (root.getLeft() != null) {
			left.setRoot(root.getLeft());
			left.postOrderTraversal();
		}

		BinaryTree<T> right = new BinaryTree<>();
		if (root.getRight() != null) {
			right.setRoot(root.getRight());
			right.postOrderTraversal();
		}

		System.out.print(root.getData() + " ");
	}

	public SinglyLinkedList<T> convertTreeToList() {
		SinglyLinkedList<T> list = new SinglyLinkedList<>();
		list.insertAtEnd(root.getData());
		fillList(list);
		return list;
	}

	public void fillList(SinglyLinkedList<T> list) {
		BinaryTree<T> left = new BinaryTree<>();
		boolean leftExists = false;
		if (getRoot().getLeft() != null) {
			leftExists = true;
			list.insertAtEnd(getRoot().getLeft().getData());
			left.setRoot(getRoot().getLeft());
		}

		BinaryTree<T> right = new BinaryTree<>();
		boolean rightExists = false;
		if (getRoot().getRight() != null) {
			rightExists = true;
			list.insertAtEnd(getRoot().getRight().getData());
			right.setRoot(getRoot().getRight());
		}
		if (leftExists)
			left.fillList(list);
		if (rightExists)
			right.fillList(list);
	}

	public void levelOrderTraversal() {
		SinglyLinkedList<T> list = convertTreeToList();
		if (list.getHead() != null) {
			SinglyNode<T> temp = list.getHead();
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
		}
	}
	
	public void levelOrderTraversalWithLevelsDisplayedSeparately() {
		SinglyLinkedList<T> list = convertTreeToList();
		if (list.getHead() != null) {
			SinglyNode<T> temp = list.getHead();
			int limit=1;
			int i=1,j=1;
			while (temp != null) {
				if(i<=limit) {
					System.out.print(temp.getData() + " ");
				}else {
					System.out.println();
					System.out.print(temp.getData() + " ");
					limit+=j*2;
					j++;
				}
				temp = temp.getNext();
				i++;
			}
		} 
	}
	
	public void levelOrderTraversalUsingQueue() {
		Queue<BinaryTreeNode<T>> q=new LinkedList<>();
		q.add(root);
		BinaryTreeNode<T> temp;
		
		while(!q.isEmpty()) {
			temp=q.peek();
			System.out.print(temp.getData()+" ");
			q.remove();
			
			if(temp.getLeft()!=null) 
				q.add(temp.getLeft());
	
			if(temp.getRight()!=null) 
				q.add(temp.getRight());
		}
	}
	
	public List<T> treeToList() {
		Queue<BinaryTreeNode<T>> q=new LinkedList<>();
		q.add(root);
		BinaryTreeNode<T> temp;
		List<T> res=new ArrayList<>();
		while(!q.isEmpty()) {
			temp=q.peek();
			res.add(temp.getData());
			q.remove();
			
			if(temp.getLeft()!=null) 
				q.add(temp.getLeft());
	
			if(temp.getRight()!=null) 
				q.add(temp.getRight());
		}
		return res;
	}
	
	public void reverseLevelOrderTraversalWithLevelsDisplayedSeparately() throws EmptyStackException {
		SinglyLinkedList<T> list = convertTreeToList();
		SinglyLinkedList<T> tempList=new SinglyLinkedList<>();
		StackUsingLL<SinglyLinkedList<T>> stkOfLists=new StackUsingLL<>();
		if (list.getHead() != null) {
			SinglyNode<T> temp = list.getHead();
			int limit=1;
			int i=1,j=1;
			while (temp != null) {
				if(i<=limit) {
					tempList.insertAtEnd(temp.getData());
				}else {
					stkOfLists.push(tempList);
					tempList=new SinglyLinkedList<>();
					tempList.insertAtEnd(temp.getData());
					limit+=j*2;
					j++;
				}
				temp = temp.getNext();
				i++;
			}
			stkOfLists.push(tempList);
		}
		
		while(stkOfLists.getSize()!=0) {
			tempList=stkOfLists.pop();
			tempList.displayList();
		}
	}
	
	public int findHeightOfTree() {
	
		if(root==null)
			return -1;
		
		int leftHeight=-1;
		if(root.getLeft()!=null) {
			BinaryTree<T> leftTree=new BinaryTree<>();
			leftTree.setRoot(root.getLeft());
			leftHeight=leftTree.findHeightOfTree();
		}
		
		int rightHeight=-1;
		if(root.getRight()!=null) {
			BinaryTree<T> rightTree=new BinaryTree<>();
			rightTree.setRoot(root.getRight());
			rightHeight=rightTree.findHeightOfTree();
		}
		
		if (leftHeight > rightHeight)  
            return(leftHeight + 1);  
        else 
        	return(rightHeight + 1);
	}
}
