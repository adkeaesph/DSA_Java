package sortingalgo;

import java.util.Scanner;

public class QuickSort {

	public static int partition(int[] arr, int start, int end) {
		if(start<end) {
			int n=end-start+1;
			int[] arr1=new int[n];
			int pivot=arr[end];
			int pivotIndex,j=0;
			for(int i=start;i<end;i++) {
				if(arr[i]<=pivot) {
					arr1[j]=arr[i];
					j++;
				}
			}
			
			pivotIndex=j;
			arr1[pivotIndex]=pivot;
			int k=pivotIndex+1;
			
			for(int i=start;i<end;i++) {
				if(arr[i]>pivot) {
					arr1[k]=arr[i];
					k++;
				}
			}
			
			int m=start;
			for(int i=0;i<n;i++) {
				arr[m]=arr1[i];
				m++;
			}
			
			return pivotIndex;
		}
		return -1;
	}
	
	public static void actualQuickSort(int[] arr,int start,int end,int len) {
		if(start<end) {
			int pivotIndex=partition(arr, start, end);
			actualQuickSort(arr, start, pivotIndex-1,len);
			actualQuickSort(arr, pivotIndex+1,end,len);	
		}
	}
	
	public static void quickSort(int[] arr) {
		int n=arr.length;
		actualQuickSort(arr,0,n-1,n);
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
		
		quickSort(a);
		
		System.out.println("\nSorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		
		sc.close();
	}
	
}
/*
5
3
2
5
9
3
*/
