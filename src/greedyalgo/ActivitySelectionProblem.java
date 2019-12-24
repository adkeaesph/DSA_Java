package greedyalgo;

import java.util.*;

public class ActivitySelectionProblem {

	public static List sortByEndTimes(List<Activity> activities){
		Collections.sort(activities, new Comparator<Activity>() {
			@Override
			public int compare(Activity a1, Activity a2) {
				if(a1.getEndTime()<a2.getEndTime())
					return -1;
				else if(a1.getEndTime()<a2.getEndTime())
					return 1;
				else
					return 0;
			}
		});
		return activities;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		int start;
		int end;
		List<Activity> activities=new ArrayList<>();
		while(true) {
			choice = sc.nextInt();
			if (choice == 1) {
				start=sc.nextInt();
				end=sc.nextInt();
				activities.add(new Activity(start,end));
			}else
				break;
		}

		System.out.println("Given Activities : ");
		for(Activity a:activities){
			System.out.println(a.getId()+"\t"+a.getStartTime()+"\t"+a.getEndTime());
		}
		System.out.println();

		activities=sortByEndTimes(activities);

		System.out.println("Feasible Activities : ");
		System.out.println(activities.get(0).getId()+"\t"+
				activities.get(0).getStartTime()+"\t"+
				activities.get(0).getEndTime());
		int i=0;

		int len=activities.size();
		Activity currActivity,prevActivity;
		for(int j=1;j<len;j++){
			currActivity=activities.get(j);
			prevActivity=activities.get(i);
			if(currActivity.getStartTime()>=prevActivity.getEndTime()){
				System.out.println(currActivity.getId()+"\t"+currActivity.getStartTime()+"\t"+currActivity.getEndTime());
				i=j;
			}
		}
		sc.close();
	}

}
