package sets;

import java.util.List;

public interface Set<T> {
	public boolean contains(T object);
	public void add(T object);
	public void remove(T object);
	public List<T> toList();
	public void display();
}
