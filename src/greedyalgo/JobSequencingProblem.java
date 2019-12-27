package greedyalgo;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JobSequencingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, deadline, profit, maxDeadline = -1;
		Set<Job> jobs = new TreeSet<>();
		while (true) {
			choice = sc.nextInt();
			if (choice == 1) {
				deadline = sc.nextInt();
				if (maxDeadline < deadline)
					maxDeadline = deadline;

				profit = sc.nextInt();
				jobs.add(new Job(deadline, profit));
			} else
				break;
		}

		Iterator<Job> it = jobs.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Job job;
		Job[] sequence = new Job[maxDeadline];
		for (int i = maxDeadline - 1; i >= 0; i--) {
			it = jobs.iterator();
			while (it.hasNext()) {
				job = it.next();
				if (job.getDeadline() >= i + 1) {
					if (sequence[i] == null || sequence[i].getProfit() < job.getProfit()) {
						sequence[i] = job;
					}
				}
			}
			if (sequence[i] != null)
				jobs.remove(sequence[i]);
		}

		int totalProfit = 0;
		System.out.println("\nJob Sequence: ");
		for (int i = 0; i < maxDeadline; i++) {
			if (sequence[i] != null) {
				totalProfit += sequence[i].getProfit();
				System.out.println(sequence[i]);
			}
		}
		System.out.println("\nMax Profit : " + totalProfit);
		sc.close();
	}
}
