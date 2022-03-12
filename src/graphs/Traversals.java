package graphs;

import java.util.LinkedList;
import java.util.List;

public class Traversals extends EasyGraph {
	
	//not for disconnected graph
	public static List<Integer> bfsTraversal(List<Integer>[] grph, int nodes,int startNode) {
		boolean[] visited = new boolean[nodes];
		for (int i = 0; i < nodes; i++)
			visited[i] = false;

		List<Integer> q = new LinkedList<>();
		visited[startNode] = true;
		q.add(startNode);
		//boolean visitedAll;
		int j = 0;
		while (j < q.size()) {
			//visitedAll = true;

			List<Integer> list = grph[q.get(j)];
			for (Integer node : list) {
				if (visited[node] == false) {
					visited[node] = true;
					q.add(node);
				}
			}
			/*	whether this part minimises time complexity slightly is debatable....
			for (int i = 0; i < nodes; i++) {
				if (!visited[i]) {
					visitedAll = false;
					break;
				}
			}
			if (visitedAll)
				break;
				*/
			j++;
		}
		return q;
	}
	
	
	public static List<Integer> dfsTraversal(List<Integer>[] grph, int nodes,int startNode){
		boolean[] visited=new boolean[nodes];
		for(int i=0;i<nodes;i++)
			visited[i]=false;
		
		List<Integer> q = new LinkedList<>();
		visited[startNode] = true;
		q.add(startNode);
		int i = 0;
		int j;
		
		return q;
	}
	
	public static void main(String[] args) {
		int nodes = 6;
		List<Integer>[] grph = createGraph(nodes);
		addEdge(grph, 2, 0, true);
		addEdge(grph, 2, 1, true);
		addEdge(grph, 1, 3, true);
		addEdge(grph, 3, 0, true);
		addEdge(grph, 1, 2, true);
		addEdge(grph, 3, 3, true);
		
		List<Integer> q = bfsTraversal(grph, nodes, 2);
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.get(i) + " ");
		}
		
		System.out.println();
		q = dfsTraversal(grph, nodes, 2);
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.get(i) + " ");
		}
	}
}
