package drivers;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;

public class DriverBT {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>(20);
		BinaryTreeNode<Integer> root = bt.getRoot();
		root.setLeft(new BinaryTreeNode<>(12));
		BinaryTreeNode<Integer> rootLeft = bt.getRoot().getLeft();
		root.setRight(new BinaryTreeNode<>(36));
		BinaryTreeNode<Integer> rootRight = bt.getRoot().getRight();
		rootLeft.setLeft(new BinaryTreeNode<>(8));
		rootLeft.setRight(new BinaryTreeNode<>(16));
		rootRight.setLeft(new BinaryTreeNode<>(24));
		rootRight.setRight(new BinaryTreeNode<>(60));
		//*/
		bt.inOrderTraversal();

		System.out.println();
		bt.preOrderTraversal();

		System.out.println();
		bt.postOrderTraversal();

		System.out.println();
		bt.levelOrderTraversal();
		
		System.out.println();
		bt.levelOrderTraversalWithLevelsDisplayedSeparately();
	}

}
