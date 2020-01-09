package graphs;

public interface WeightedGraph<T> extends Graph<T> {
	void addEdge(T source,T destination,int weight);
}
