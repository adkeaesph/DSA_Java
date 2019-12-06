package trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
	private T data;
	private List<TreeNode<T>> children;

	public TreeNode() {
		data = null;
		children = new ArrayList<TreeNode<T>>();
	}

	public TreeNode(T data) {
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

	public int displayAllChildren() {
		int size=children.size();
		if(size>0)
			System.out.print("Children of "+getData()+" = ");
		
		for(int i=0;i<size;i++)
			System.out.print(children.get(i).getData()+" ");
		return size;
	}
}
