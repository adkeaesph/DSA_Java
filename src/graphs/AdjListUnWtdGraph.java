package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjListUnWtdGraph<T> implements UnweightedGraph<T> {
	private List<T>[] adjList;
	private static int noOfNodes;
	private static boolean directed;
	
	@SuppressWarnings("unchecked")
	public AdjListUnWtdGraph(T[] nodes) {
		noOfNodes=nodes.length;
		directed=true;
		adjList=new ArrayList[noOfNodes];
		for(int i=0;i<noOfNodes;i++) {
			adjList[i]=new ArrayList<>();
			adjList[i].add(nodes[i]);
		}
	}
	
	public AdjListUnWtdGraph(T[] nodes,boolean directed) {
		this(nodes);
		AdjListUnWtdGraph.directed=directed;
	}
	
	@Override
	public void addEdge(T source, T destination) {
		for(int i=0;i<noOfNodes;i++) {
			if(adjList[i].get(0).equals(source)) {
				adjList[i].add(destination);
			}
		}
		
		if(!directed) {
			for(int i=0;i<noOfNodes;i++) {
				if(adjList[i].get(0).equals(destination)) {
					adjList[i].add(source);
				}
			}
		}
	}

	@Override
	public void deleteEdge(T source, T destination) {
		for(int i=0;i<noOfNodes;i++) {
			if(adjList[i].get(0).equals(source)) {
				adjList[i].remove(destination);
			}
		}
		
		if(!directed) {
			for(int i=0;i<noOfNodes;i++) {
				if(adjList[i].get(0).equals(destination)) {
					adjList[i].remove(source);
				}
			}
		}
	}

	@Override
	public void displayGraph() {
		for(int i=0;i<noOfNodes;i++) {
			for(T node:adjList[i])
				System.out.print(node+" ");
			System.out.println();
		}
	}
}
