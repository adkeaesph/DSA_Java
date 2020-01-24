package miscellaneousproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CollegePairs {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		List<Set<Integer>> grps=new ArrayList<>(); 
		int n=Integer.parseInt(br.readLine().trim());
		boolean[] present=new boolean[n];
		int t=Integer.parseInt(br.readLine().trim());
		String[] strs;
		Set<Integer> members;
		while(t-->0) {
			strs=br.readLine().trim().split("\\s+");
			int a=Integer.parseInt(strs[0]);
			int b=Integer.parseInt(strs[1]);
			present[a]=true;
			present[b]=true;
			if(grps.isEmpty()) {
				members=new HashSet<>();
				members.add(a);
				members.add(b);
				grps.add(members);
			}else {
				int ngrps=grps.size();
				boolean foundGrp=false;
				for(int i=0;i<ngrps;i++) {
					members=grps.get(i);
					if(members.contains(a) || members.contains(b)) {
						members.add(a);
						members.add(b);
						foundGrp=true;
						break;
					}
				}
				if(!foundGrp) {
					members=new HashSet<>();
					members.add(a);
					members.add(b);
					grps.add(members);
				}
			}
		}
		isr.close();
		br.close();
		for(int i=0;i<n;i++) {
			if(!present[i]) {
				members=new HashSet<>();
				members.add(i);
				grps.add(members);
			}
		}
		int ngrps=grps.size();
		Iterator<Integer> it;
		for(int i=0;i<ngrps;i++) {
			members=grps.get(i);
			it=members.iterator();
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}
		
		System.out.println("--------------------------------------");
		int res=0;
		
		for(int i=0;i<ngrps-1;i++) {
			for(int j=i+1;j<ngrps;j++) {
				res+=grps.get(i).size()*grps.get(j).size();
			}
		}
		System.out.println("No of ways = "+res);
	}

}
