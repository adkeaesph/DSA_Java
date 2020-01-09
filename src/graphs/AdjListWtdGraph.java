package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjListWtdGraph<T> implements WeightedGraph<T> {

	private List<GraphNode<T>>[] adjList;
	private static int noOfNodes;
	private static boolean directed;
	
	@SuppressWarnings("unchecked")
	public AdjListWtdGraph(GraphNode<T>[] nodes) {
		noOfNodes=nodes.length;
		directed=true;
		adjList=new ArrayList[noOfNodes];
		for(int i=0;i<noOfNodes;i++) {
			adjList[i]=new ArrayList<>();
			adjList[i].add(nodes[i]);
		}
	}

	public AdjListWtdGraph(GraphNode<T>[] nodes,boolean directed) {
		this(nodes);
		AdjListWtdGraph.directed=directed;
	}
	
	@Override
	public void addEdge(T source, T destination, int weight) {
		for(int i=0;i<noOfNodes;i++) {
			if(adjList[i].get(0).getNode().equals(source)) {
				adjList[i].add(new GraphNode<>(destination, weight));
			}
		}
		
		if(!directed) {
			for(int i=0;i<noOfNodes;i++) {
				if(adjList[i].get(0).getNode().equals(destination)) {
					adjList[i].add(new GraphNode<>(source, weight));
				}
			}
		}
	}

	@Override
	public void deleteEdge(T source, T destination) {
		GraphNode<T> toBeRemoved=new GraphNode<>();
		toBeRemoved.setNode(destination);
		for(int i=0;i<noOfNodes;i++) {
			if(adjList[i].get(0).getNode().equals(source)) {
				adjList[i].remove(toBeRemoved);
			}
		}
		
		if(!directed) {
			toBeRemoved=new GraphNode<>();
			toBeRemoved.setNode(source);
			for(int i=0;i<noOfNodes;i++) {
				if(adjList[i].get(0).getNode().equals(destination)) {
					adjList[i].remove(toBeRemoved);
				}
			}
		}
	}

	@Override
	public void displayGraph() {
		for(int i=0;i<noOfNodes;i++) {
			for(GraphNode<T> node:adjList[i])
				System.out.print(node+" ");
			System.out.println();
		}
	}

}
