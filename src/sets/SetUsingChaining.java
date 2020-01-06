package sets;

import java.util.ArrayList;
import java.util.List;

public class SetUsingChaining<T> implements Set<T>{
	private SetCell<T>[] arr;
	private static final int CAPACITY=5;
	
	public SetUsingChaining() {
		arr=new SetCell[CAPACITY];
		for(int i=0;i<CAPACITY;i++) {
			arr[i]=new SetCell<T>(new ArrayList<T>());
		}
	}
	
	@Override
	public boolean contains(T object) {
		// TODO Auto-generated method stub
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		List<T> list=arr[index].getList();
		int size=arr[index].getSize();
		for(int i=0;i<size;i++) {
			if(list.get(i).equals(object))
				return true;
		}
		return false;
	}

	@Override
	public void add(T object) {
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		List<T> list=arr[index].getList();
		int size=arr[index].getSize();
		for(int i=0;i<size;i++) {
			if(list.get(i).equals(object))
				return;
		}
		list.add(object);
	}

	@Override
	public void remove(T object) {
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		List<T> list=arr[index].getList();
		int size=arr[index].getSize();
		boolean found=false;
		for(int i=0;i<size;i++) {
			if(list.get(i).equals(object)) {
				found=true;
				break;
			}
		}
		if(found)
			list.remove(object);
	}

	@Override
	public List<T> toList() {
		List<T> list=new ArrayList<>();
		int len;
		List<T> tempList;
		for(int i=0;i<CAPACITY;i++) {
			len=arr[i].getSize();
			tempList=arr[i].getList();
			for(int j=0;j<len;j++)
				list.add(tempList.get(j));
		}
		return list;
	}
	
	public void display() {
		List<T> list=toList();
		int len=list.size();
		for(int i=0;i<len;i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
