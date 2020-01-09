package graphs;

public class GraphNode<T> {
	private T node;
	private Integer weight;
	
	public GraphNode() {
		node=null;
		weight=null;
	}
	public GraphNode(T destination, int weight) {
		super();
		this.node = destination;
		this.weight = weight;
	}

	public T getNode() {
		return node;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setNode(T node) {
		this.node = node;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "["+node+", "+weight+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode<T> other = (GraphNode<T>) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	
	
}
