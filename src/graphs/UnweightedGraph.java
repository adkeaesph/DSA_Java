package graphs;

public interface UnweightedGraph<T> extends Graph<T> {
	void addEdge(T source,T destination);
}
