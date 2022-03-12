package lists;

public class SinglyNode<T> {
	private T data;
	private SinglyNode<T> next;
	
	public SinglyNode() {
		data = null;
		next = null;
	}
	
	public SinglyNode(T data) {
		this();
		this.data = data;
	}
	
	public SinglyNode(T data, SinglyNode<T> next) {
		this(data);
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public SinglyNode<T> getNext() {
		return next;
	}
	
	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "SinglyNode [data=" + data + "]";
	}
	
	public void displayListIfThisIsHead() {
		SinglyNode<T> currentNode = this;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + ", ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}
}
