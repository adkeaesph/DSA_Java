package sets;

import java.util.ArrayList;
import java.util.List;

public class SetUsingLinearProbing<T> implements Set<T> {

	private Item<T>[] arr;
	private static int CAPACITY;
	private static int filled=0;
	
	@SuppressWarnings("unchecked")
	public SetUsingLinearProbing() {
		CAPACITY=10;
		arr=new Item[CAPACITY];
	}
	
	@Override
	public boolean contains(T object) {
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		int i=index;
		while(i<CAPACITY) {
			if(arr[i]==null)
				return false;
			else {
				if(!arr[i].isDeleted() && arr[i].getData().equals(object))
						return true;
			}
			i++;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(T object) {
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		int i=index;
		while(i<CAPACITY) {
			if(arr[i]==null) {
				arr[i]=new Item<>(false,object);
				filled++;
				return;
			}else {
				if(arr[i].isDeleted()) {
					arr[i]=new Item<>(false,object);
					filled++;
					return;
				}else {
					if(arr[i].getData().equals(object))
						return;
				}
			}
			i++;
			
		}
		
		Item<T>[] arr2=new Item[CAPACITY+10];
		for(int j=0;j<CAPACITY;j++)
			arr2[j]=arr[j];
		arr=arr2;
		CAPACITY+=10;
		add(object);
	}

	@Override
	public void remove(T object) {
		int index=(object.hashCode() & 0x7FFFFFFF)%CAPACITY;
		int i=index;
		while(i<CAPACITY) {
			if(arr[i]==null) {
				return;
			}else {
				if(!arr[i].isDeleted() && arr[i].getData().equals(object)) {
					arr[i].setDeleted(true);
					return;
				}
			}
			i++;
		}
	}

	@Override
	public List<T> toList() {
		List<T> list=new ArrayList<>();
		for(int i=0;i<CAPACITY;i++) {
			if(arr[i]!=null) {
				if(!arr[i].isDeleted())
					list.add(arr[i].getData());
			}
		}
		return list;
	}

	@Override
	public void display() {
		List<T> list=toList();
		int len=list.size();
		for(int i=0;i<len;i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
