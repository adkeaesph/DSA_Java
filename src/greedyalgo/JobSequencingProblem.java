package greedyalgo;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JobSequencingProblem {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice, deadline, profit,maxDeadline=-1;
		Set<Job> jobs=new TreeSet<>();
		while(true) {
			choice=sc.nextInt();
			if(choice==1) {
				deadline=sc.nextInt();
				if(maxDeadline<deadline)
					maxDeadline=deadline;
				
				profit=sc.nextInt();
				jobs.add(new Job(deadline,profit));
			}else
				break;
		}
		
		Iterator<Job> it=jobs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		int len=jobs.size();
		Job[] sorted=new Job[len];
		for(int i=0;i<len;i++) {
			
		}
		sc.close();
	}
}
