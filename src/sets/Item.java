package sets;

public class Item<T> {
	private boolean deleted;
	private T data;
	
	public Item(boolean deletedBefore, T data) {
		super();
		this.deleted = deletedBefore;
		this.data = data;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public T getData() {
		return data;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
