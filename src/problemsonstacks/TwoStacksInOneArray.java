package problemsonstacks;

public class TwoStacksInOneArray {
	private Integer[] array;
	private int top1;
	private int top2;
	private int capacity;
	
	public TwoStacksInOneArray(int arraySize) {
		array=new Integer[arraySize];
		top1=-1;
		top2=arraySize;
		capacity=arraySize;
	}
	
	public Integer peek1() {
		if(top1>=0)
			return array[top1];
		else
			return null;
	}

	public Integer peek2() {
		if(top2>=0)
			return array[top2];
		else {
			System.out.println("Stack 1 is empty!!!");
			return null;
		}
	}
	
	public void push1(Integer data) {
		if(top1+1!=top2 && top1+1!=capacity) {
			array[top1+1]=data;
			top1++;
		}else {
			System.out.println("\nNo more cells for Stack 1!!!");
		}
	}
	
	public void push2(Integer data) {
		if(top2-1!=top1 && top2-1!=-1) {
			array[top2-1]=data;
			top2--;
		}else {
			System.out.println("\nNo more cells for Stack 2!!!");
		}
	}
	
	public Integer pop1() {
		Integer toBePopped=null;
		if(top1==-1) {
			System.out.println("\nStack 1 is empty!!!");
		}else {
			toBePopped=array[top1];
			top1--;
		}
		return toBePopped;
	}
	
	public Integer pop2() {
		Integer toBePopped=null;
		if(top2==capacity) {
			System.out.println("\nStack 2 is empty!!!");
		}else {
			toBePopped=array[top2];
			top2++;
		}
		return toBePopped;
	}
	
	public void display1() {
		if(top1==-1)
			System.out.println("\nStack 1 is empty!!!");
		else {
			System.out.println("\nStack 1 contents from top to bottom: ");
			for(int i=top1;i>=0;i--)
				System.out.print(array[i]+" ");
		}
	}
	
	public void display2() {
		if(top2==capacity)
			System.out.println("\nStack 2 is empty!!!");
		else {
			System.out.println("\nStack 2 contents from top to bottom: ");
			for(int i=top2;i<capacity;i++)
				System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		TwoStacksInOneArray twostks=new TwoStacksInOneArray(10);
		twostks.push1(23);
		twostks.push1(34);
		twostks.push1(23);
		twostks.push1(34);
		twostks.push1(23);
		twostks.push1(34);
		twostks.push1(23);
		twostks.push1(34);
		twostks.push1(23);
		twostks.push1(34);
		twostks.display1();
		twostks.display2();
		twostks.push1(23);
		twostks.push2(90);
		
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.push2(10);
		twostks.push2(20);
		twostks.push2(30);
		twostks.push1(60);
		twostks.display1();
		twostks.display2();
		twostks.push1(50);
		twostks.push2(50);
		
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.pop1();
		twostks.display1();
		twostks.display2();
		
		twostks.push2(40);
		twostks.push2(40);
		twostks.push2(40);
		twostks.push2(40);
		twostks.push2(40);
		twostks.push2(40);
		twostks.push2(40);
		twostks.display2();
		twostks.push2(40);
	}
}
