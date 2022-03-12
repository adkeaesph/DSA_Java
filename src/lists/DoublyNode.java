package lists;

public class DoublyNode<T> {

	private T data;
	private DoublyNode<T> previous;
	private DoublyNode<T> next;
	
	public DoublyNode() {
		data = null;
		previous = null;
		next = null;
	}
	
	public DoublyNode(T data) {
		this();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoublyNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode<T> previous) {
		this.previous = previous;
	}

	public DoublyNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}

}
