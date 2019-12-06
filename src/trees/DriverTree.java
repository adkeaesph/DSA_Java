package trees;

import java.util.ArrayList;
import java.util.List;

public class DriverTree {
	private static void findAllFactors(TreeNode<Integer> root) {
		List<TreeNode<Integer>> children = new ArrayList<>();
		int i=2;
		int factors=0;
		Integer rootData=root.getData();
		while(i<=rootData/2) {
			if(rootData%i==0) {
				children.add(new TreeNode<Integer>(i));
				factors++;
			}
			i++;
		}
		root.setChildren(children);
		children=root.getChildren();
		for(int j=0;j<factors;j++) {
			findAllFactors(children.get(j));
		}
	}
	
	public static void displayAllFactors(TreeNode<Integer> root) {	//depth first traversal
		if(root==null) 
			return;
		
		int noOfChildren=root.displayAllChildren();
		if(noOfChildren>0)
			System.out.println();
		
		List<TreeNode<Integer>> children=root.getChildren();
		for(int j=0;j<children.size();j++) {
			displayAllFactors(children.get(j));
		}
	}
	public static void main(String[] args) {
		Tree<Integer> t=new Tree<>(400);
		TreeNode<Integer> root=t.getRoot();
		
		findAllFactors(root);
		displayAllFactors(root);
	}

	

}
