package sets;

public class SetDriver {

	public static void main(String[] args) {
		Set<Integer> set1=new SetUsingChaining<>();
		Set<Integer> set2=new SetUsingLinearProbing<>();
		int[] arr= {13,76,34,905,7345,23,46,34,23,905,64,76,905,12,334,33};
		int len=arr.length;
		for(int i=0;i<len;i++) {
			set1.add(arr[i]);
			set2.add(arr[i]);
		}
		
		set1.display();
		System.out.println();
		
		set2.display();
		System.out.println();
		
		set1.remove(2);
		System.out.println();
		set1.display();
		
		set2.remove(2);
		System.out.println();
		set2.display();
		
		System.out.println("\n"+set1.contains(905));
		set1.remove(905);
		System.out.println(set1.contains(905));
		set1.add(905);
		System.out.println(set1.contains(905));
		
		System.out.println("\n"+set2.contains(905));
		set2.remove(905);
		System.out.println(set2.contains(905));
		set2.add(905);
		System.out.println(set2.contains(905));
	}

}
