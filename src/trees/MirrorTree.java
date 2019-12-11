package trees;

public class MirrorTree {

	public static BinaryTreeNode<Integer> findMirrorTree(BinaryTreeNode<Integer> originalRoot) {
		if(originalRoot==null)
			return null;
		
		BinaryTree<Integer> mbt=new BinaryTree<Integer>();
		mbt.setRoot(new BinaryTreeNode<Integer>(originalRoot.getData()));
		BinaryTreeNode<Integer> mirrorRoot=mbt.getRoot();
		
		if(originalRoot.getLeft()!=null) {
			mirrorRoot.setRight(findMirrorTree(originalRoot.getLeft()));
		}
		
		if(originalRoot.getRight()!=null) {
			mirrorRoot.setLeft(findMirrorTree(originalRoot.getRight()));
		}
		return mirrorRoot;
	}
	
	public static boolean mirrorOfEachOther(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if(root1==null && root2==null)
			return true;
		else if(root1==null)
			return false;
		else if(root2==null)
			return false;
		
		if(root1.getData()!=root2.getData())
			return false;
		else {
			BinaryTreeNode<Integer> left1=root1.getLeft();
			BinaryTreeNode<Integer> right1=root1.getRight();
			
			BinaryTreeNode<Integer> left2=root2.getLeft();
			BinaryTreeNode<Integer> right2=root2.getRight();
			return left1.getData()==right2.getData() && right1.getData()==left2.getData();
		}
	}
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>(20);
		BinaryTreeNode<Integer> root = bt.getRoot();
		root.setLeft(new BinaryTreeNode<>(12));
		BinaryTreeNode<Integer> rootLeft = bt.getRoot().getLeft();
		root.setRight(new BinaryTreeNode<>(36));
		BinaryTreeNode<Integer> rootRight = bt.getRoot().getRight();
		rootLeft.setLeft(new BinaryTreeNode<>(8));
		//rootLeft.setRight(new BinaryTreeNode<>(16));
		rootRight.setLeft(new BinaryTreeNode<>(24));
		rootRight.setRight(new BinaryTreeNode<>(60));
		//*/ 
		bt.inOrderTraversal();
		
		BinaryTreeNode<Integer> mirrorRoot = findMirrorTree(bt.getRoot());
		BinaryTree<Integer> mbt = new BinaryTree<>();
		mbt.setRoot(mirrorRoot);
		System.out.println();
		mbt.inOrderTraversal();
		
		System.out.println("\n"+mirrorOfEachOther(bt.getRoot(),mbt.getRoot()));
		System.out.println(mirrorOfEachOther(bt.getRoot(),bt.getRoot()));
	}

}
