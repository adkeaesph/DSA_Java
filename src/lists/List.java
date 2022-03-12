package lists;
import customexceptions.ListException;

public interface List<T> {
	void add(T data);
	void add(T data, int position) throws ListException;
	void removeObject(T data) throws ListException;
	void removeAt(int position) throws ListException;
	void removeAllObjects(T data) throws ListException;
	T get(int position) throws ListException;
	boolean isEmpty();
	int getSize();
	int getPositionOf(T data);
}
