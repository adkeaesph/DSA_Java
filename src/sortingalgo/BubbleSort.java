package sortingalgo;

import java.util.Scanner;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n=arr.length;
		int temp;
		boolean swapped;
		for(int i=n-1;i>=0;i--) {
			swapped=false;
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					swapped=true;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(!swapped)
				break;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		System.out.println("Unsorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		
		bubbleSort(a);
		
		System.out.println("\nSorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		sc.close();
	}
}
