package problemsonstrings;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class StringPermutations {

	public static Set<String> igS(char c,String s){
		int len=s.length();
		StringBuilder sb;
		Set<String> set=new LinkedHashSet<>();
		for(int i=0;i<=len;i++) {
			sb=new StringBuilder(s);
			sb.insert(i, c);
			set.add(sb.toString());
		}
		return set;
	}
	
	public static Set<String> findPermutations(String s){
		int len=s.length();
		String rest=""+s.charAt(len-1);
		Set<String> cset = new TreeSet<>();
		cset.add(rest);

		String curr;
		Iterator<String> it;
		for(int i=len-2;i>=0;i--) {	
			Set<String> temp=new TreeSet<>();
			temp.addAll(cset);
			cset=new TreeSet<>();
			it=temp.iterator();
			while(it.hasNext()) {
				curr=it.next();
				cset.addAll(igS(s.charAt(i),curr));
			}
		}
		return cset;
	}
	public static void main(String[] args) {
		Set<String> set=findPermutations("ABCDE");
		Iterator<String> it=set.iterator();
		int count=0;
		while(it.hasNext()) {
			count++;
			System.out.println(count+" "+it.next());
		}
	}

}
