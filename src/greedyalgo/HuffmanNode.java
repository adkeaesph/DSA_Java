package greedyalgo;

public class HuffmanNode implements Comparable<HuffmanNode> {
	String ch;
	int count;
	HuffmanNode left;
	HuffmanNode right;
	
	public HuffmanNode(String ch, int count) {
		this.ch=ch;
		this.count=count;
		this.left=null;
		this.right=null;
	}

	@Override
	public int compareTo(HuffmanNode o) {
		if(this.count<o.count)
			return -1;
		else if(this.count>o.count)
			return 1;
		else {
			return o.ch.compareTo(this.ch);
		}
	}

	@Override
	public String toString() {
		return "HuffmanNode [ch=" + ch + ", count=" + count + "]";
	}
	
}
