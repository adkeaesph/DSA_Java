package trees;

public class ChildrenSumProperty {

	public static boolean ifChildrenSumPropertyExists(BinaryTreeNode<Integer> root) {
		if (root.getLeft() != null) {
			if (root.getRight() != null) {
				if (root.getLeft().getData() + root.getRight().getData() != root.getData())
					return false;
				else {
					return ifChildrenSumPropertyExists(root.getLeft())
							&& ifChildrenSumPropertyExists(root.getRight());
				}
			} else {
				if (root.getLeft().getData() != root.getData())
					return false;
				else
					return ifChildrenSumPropertyExists(root.getLeft());
			}
		} else {
			if (root.getRight() != null) {
				if (root.getRight().getData() != root.getData())
					return false;
				else
					return ifChildrenSumPropertyExists(root.getRight());
			} else {
				return true;
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>(50);
		BinaryTreeNode<Integer> root = bt.getRoot();
		root.setLeft(new BinaryTreeNode<>(20));
		BinaryTreeNode<Integer> rootLeft = bt.getRoot().getLeft();
		root.setRight(new BinaryTreeNode<>(30));
		BinaryTreeNode<Integer> rootRight = bt.getRoot().getRight();
		rootLeft.setLeft(new BinaryTreeNode<>(5));
		rootLeft.setRight(new BinaryTreeNode<>(15));
		rootRight.setLeft(new BinaryTreeNode<>(20));
		rootRight.setRight(new BinaryTreeNode<>(10));
		// */
		bt.inOrderTraversal();
		System.out.println("\n" + ifChildrenSumPropertyExists(root));
	}

}
