package sets;

public class SetDriver {

	public static void main(String[] args) {
		Set<Integer> set=new SetUsingChaining<>();
		int[] arr= {2,1,2,4,6,9,8,6,3,7,5,6,9,1,0};
		int len=arr.length;
		for(int i=0;i<len;i++) {
			set.add(arr[i]);
		}
		set.display();
		
		set.remove(2);
		System.out.println();
		set.display();
		
		System.out.println("\n"+set.contains(5));
		set.remove(200);
		System.out.println(set.contains(800));
	}

}
