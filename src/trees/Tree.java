package trees;

public class Tree<T> {
	private TreeNode<T> root;

	public Tree() {
		root = new TreeNode<>();
	}

	public Tree(T data) {
		root = new TreeNode<>(data);
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

}
