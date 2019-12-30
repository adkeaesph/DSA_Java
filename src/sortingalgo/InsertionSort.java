package sortingalgo;

import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int n=arr.length;
		int key;
		int j;
		for(int i=1;i<n;i++) {
			key=arr[i];
			for(j=i-1;j>=0;j--) {
				if(key>=arr[j])
					break;
				else 
					arr[j+1]=arr[j];
			}
			arr[j+1]=key;
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
		
		insertionSort(a);
		
		System.out.println("\nSorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		sc.close();
	}
}
