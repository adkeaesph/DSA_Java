package graphs;

public class GraphDriver {
	
	public static void main(String[] args) {
		Integer[] nodes= new Integer[5];
		for(int i=0;i<5;i++)
			nodes[i]=i;
		UnweightedGraph<Integer> graph=new AdjListUnWtdGraph<Integer>(nodes);
		graph.addEdge(0, 1); 
		graph.addEdge(0, 4); 
		graph.addEdge(1, 2); 
		graph.addEdge(1, 3); 
		graph.addEdge(1, 4); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4);
		graph.displayGraph();
		
		@SuppressWarnings("unchecked")
		GraphNode<Integer>[] gnodes= new GraphNode[5];
		for(int i=0;i<5;i++) {
			gnodes[i]=new GraphNode<>();
			gnodes[i].setNode(i);
		}
		
		WeightedGraph<Integer> graph2=new AdjListWtdGraph<Integer>(gnodes);
		graph2.addEdge(0, 1, 10); 
		graph2.addEdge(0, 4, 20); 
		graph2.addEdge(1, 2, 30); 
		graph2.addEdge(1, 3, 40); 
		graph2.addEdge(1, 4, 50); 
		graph2.addEdge(2, 3, 60); 
		graph2.addEdge(3, 4, 70);
		graph2.displayGraph();
	}
}
