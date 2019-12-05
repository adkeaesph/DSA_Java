package datastructures;

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
			int i=1;
			while (temp != null) {
				if(i<=limit) {
					System.out.print(temp.getData() + " ");
				}else {
					System.out.println();
					System.out.print(temp.getData() + " ");
					limit+=limit*2;
				}
				temp = temp.getNext();
				i++;
			}
		} 
	}
}
