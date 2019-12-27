package greedyalgo;

public class Job implements Comparable<Job>{
	private static int count=0;
	private int id;
	private int deadline;
	private int profit;
	
	public Job(int deadline, int profit) {
		id=++count;
		this.deadline=deadline;
		this.profit=profit;
	}

	public int getId() {
		return id;
	}

	public int getDeadline() {
		return deadline;
	}

	public int getProfit() {
		return profit;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + "\tdeadline=" + deadline + "\tprofit=" + profit + "]";
	}

	@Override
	public int compareTo(Job other) {
		if(this.deadline<other.getDeadline())
			return 1;
		else if(this.deadline>other.getDeadline())
			return -1;
		else {
			if(this.profit<other.getProfit())
				return 1;
			else if(this.profit>other.getProfit())
				return -1;
			else
				return 0;
		}
			
	}
}
