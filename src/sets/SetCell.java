package sets;

import java.util.List;

public class SetCell<T> {
	private List<T> list;
	
	public SetCell(List<T> list) {
		super();
		this.list = list;
	}
	
	public int getSize() {
		return list.size();
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
}
