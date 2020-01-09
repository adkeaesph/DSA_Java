package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal extends EasyGraph {
	
	public static void main(String[] args) {
		int nodes=4;
		List<Integer>[] grph=createGraph(nodes);
		addEdge(grph,0, 1,true); 
		addEdge(grph,0, 2,true); 
		addEdge(grph,1, 2,true); 
		addEdge(grph,2, 0,true); 
		addEdge(grph,2, 3,true); 
		addEdge(grph,3, 3,true);
		
		boolean[] visited=new boolean[nodes];
		for(int i=0;i<nodes;i++)
			visited[i]=false;
		
		List<Integer> q=new LinkedList<>();
		int startNode=2;
		visited[startNode]=true;
		q.add(startNode);
		boolean visitedAll;
		int j=0;
		while(true) {
			visitedAll=true;
			
			List<Integer> list=grph[q.get(j)];
			for(Integer node:list) {
				if(visited[node]==false) {
					visited[node]=true;
					q.add(node);
				}
			}
		
			for(int i=0;i<nodes;i++) {
				if(!visited[i]) {
					visitedAll=false;
					break;
				}
			}
			if(visitedAll)
				break;
			j++;
		}
		for(int i=0;i<q.size();i++) {
			System.out.print(q.get(i)+" ");
		}
	}
}
