package miscellaneousproblems;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GreatestSmallerElementOnLeft {

	public static int binarySearch(List<Map.Entry<Integer, Integer>> list, int l, int r, int key) 
	{ 
	    while (l <= r && l>=0 && r<=list.size()-1) { 
	        int m = l + (r - l) / 2; 
	  
	        //go right 
	        if(key<list.get(m).getKey()) {
	        	l=m+1;
	        }else if(key>list.get(m).getKey()) {
	        	if((m-1>=0 && key<list.get(m-1).getKey()) || m==0)
	        		return m;
	        	else
	        		r=m-1;
	        }else
	        	r = m - 1; 
	    }  
	    return -1; 
	} 
	
	public static int[] findGreatestSmallerElementOnLeft(int[] arr) {
		int len=arr.length;
		Map<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
		for(int i=0;i<len;i++) {
			if(map.containsKey(arr[i]))
				map.replace(arr[i], map.get(i)+1);
			else
				map.put(arr[i],1);
		}
		
		int[] res=new int[len];
		
		int num;
		int j=len-1;
		boolean found;
		List<Map.Entry<Integer,Integer>> list=new LinkedList<>();
		Iterator<Map.Entry<Integer, Integer>> it;
		list.addAll(map.entrySet());
		for(int i=len-1;i>=0;i--) {
			num=arr[i];
			if(map.get(num)==1)
				map.remove(num);
			else if(map.get(num)>1)
				map.replace(num, map.get(num)-1);
			
			//list=new LinkedList<>();
			//list.addAll(map.entrySet());
			
			it=map.entrySet().iterator();
			Integer key;
			found=false;
			Map.Entry<Integer,Integer> entry;
			while(it.hasNext()) {	
				entry=it.next();
				key=entry.getKey();
				if(key<num) {
					res[j]=key;
					found=true;
					break;
				}
			}
			if(!found)
				res[j]=-1;
			
			
			res[j]=binarySearch(list, 0, list.size(), num);
			j--;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr= {3,2,4,3,5,7};
		arr=findGreatestSmallerElementOnLeft(arr);
		int len=arr.length;
		for(int i=0;i<len;i++)
			System.out.println(arr[i]);
	}

}
