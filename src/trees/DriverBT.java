package trees;

import customexceptions.EmptyStackException;

public class DriverBT {

	public static void main(String[] args) throws EmptyStackException {
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
		BinaryTreeNode<Integer> rootRightLeft = rootRight.getLeft();
		rootRightLeft.setLeft(new BinaryTreeNode<>(22));
		//*/ 
		bt.inOrderTraversal();

		System.out.println("\n");
		bt.preOrderTraversal();

		System.out.println("\n");
		bt.postOrderTraversal();

		System.out.println("\n");
		bt.levelOrderTraversal();
		
		System.out.println("\n");
		bt.levelOrderTraversalUsingQueue();
		
		System.out.println("\n");
		bt.levelOrderTraversalWithLevelsDisplayedSeparately();
		
		System.out.println("\n");
		bt.reverseLevelOrderTraversalWithLevelsDisplayedSeparately();
		
		System.out.println("\n");
		System.out.println("Height = "+bt.findHeightOfTree());
	}

}
