package graphs;

import java.util.ArrayList;
import java.util.List;

public class EasyGraph {
	//----------------------------- Weighted graph--------------------------------------
	static class GraphNode{ //for weighted graph
		int node;
		int weight;
		GraphNode(int node,int weight){
			this.node=node;
			this.weight=weight;
		}
		@Override
		public String toString() {
			return "["+node+", "+weight+"]";
		}
	}
	
	@SuppressWarnings("unchecked")
	static List<GraphNode>[] createWeightedGraph(int V){
		List<GraphNode>[] adjList=new List[V];
		for(int i=0;i<V;i++)
			adjList[i]=new ArrayList<>();
		return adjList;
	}
	
	
	
	static void addWeightedEdge(List<GraphNode>[] adjList, int src, int dstn,int wt, boolean directed){
		adjList[src].add(new GraphNode(dstn,wt));
		if(!directed)
			adjList[dstn].add(new GraphNode(src,wt));
	}
	
	static void displayWeightedGraph(List<GraphNode>[] adjList) {
		int len=adjList.length;
		for(int i=0;i<len;i++) {
			System.out.print("Node "+i+" : ");
			for(GraphNode node:adjList[i]) {
				System.out.print(node+" ");
			}
			System.out.println();
		}
	}
	
	//--------------------------------------------Unweighted Graph-----------------------------------
	@SuppressWarnings("unchecked")
	static List<Integer>[] createGraph(int V){
		List<Integer>[] adjList=new List[V];
		for(int i=0;i<V;i++)
			adjList[i]=new ArrayList<>();
		return adjList;
	}
	
	static void addEdge(List<Integer>[] adjList, int src, int dstn, boolean directed){
		adjList[src].add(dstn);
		if(!directed)
			adjList[dstn].add(src);
	}
	
	static void displayGraph(List<Integer>[] adjList) {
		int len=adjList.length;
		for(int i=0;i<len;i++) {
			System.out.print("Node "+i+" : ");
			for(Integer node:adjList[i]) {
				System.out.print(node+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		List<GraphNode>[] wadj=createWeightedGraph(5);
		addWeightedEdge(wadj, 0, 1, 10,false); 
	    addWeightedEdge(wadj, 0, 4, 20,false); 
	    addWeightedEdge(wadj, 1, 2, 30,false); 
	    addWeightedEdge(wadj, 1, 3, 40,false); 
	    addWeightedEdge(wadj, 1, 4, 50,false); 
	    addWeightedEdge(wadj, 2, 3, 60,false); 
	    addWeightedEdge(wadj, 3, 4, 70,false);
	    displayWeightedGraph(wadj);
	    System.out.println();
	    
	    wadj=createWeightedGraph(5);
		addWeightedEdge(wadj, 0, 1, 10,true); 
	    addWeightedEdge(wadj, 0, 4, 20,true); 
	    addWeightedEdge(wadj, 1, 2, 30,true); 
	    addWeightedEdge(wadj, 1, 3, 40,true); 
	    addWeightedEdge(wadj, 1, 4, 50,true); 
	    addWeightedEdge(wadj, 2, 3, 60,true); 
	    addWeightedEdge(wadj, 3, 4, 70,true);
	    displayWeightedGraph(wadj);
		System.out.println();
		
		List<Integer>[] adj=createGraph(5);
		addEdge(adj, 0, 1,false); 
	    addEdge(adj, 0, 4,false); 
	    addEdge(adj, 1, 2,false); 
	    addEdge(adj, 1, 3,false); 
	    addEdge(adj, 1, 4,false); 
	    addEdge(adj, 2, 3,false); 
	    addEdge(adj, 3, 4,false);
	    displayGraph(adj);
	    System.out.println();
	    
	    adj=createGraph(5);
		addEdge(adj, 0, 1,true); 
	    addEdge(adj, 0, 4,true); 
	    addEdge(adj, 1, 2,true); 
	    addEdge(adj, 1, 3,true); 
	    addEdge(adj, 1, 4,true); 
	    addEdge(adj, 2, 3,true); 
	    addEdge(adj, 3, 4,true);
	    displayGraph(adj);
	}
}
