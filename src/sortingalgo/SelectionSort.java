package sortingalgo;

import java.util.Scanner;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		int n=arr.length;
		int temp,minIndex;
		for(int i=0;i<n-1;i++) {
			minIndex=i;
			for(int j=i+1;j<n;j++) {
				if(arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	
	public static void selectionSort(Student[] arr) {
		int n=arr.length;
		int minIndex;
		Student temp;
		for(int i=0;i<n-1;i++) {
			minIndex=i;
			for(int j=i+1;j<n;j++) {
				if(arr[minIndex].getHeight()>arr[j].getHeight()) {
					minIndex=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	
	public static void inPlaceSelectionSort(Student[] arr) {
		int n=arr.length;
		int minIndex;
		Student shortest;
		for(int i=0;i<n-1;i++) {
			minIndex=i;
			for(int j=i+1;j<n;j++) {
				if(arr[minIndex].getHeight()>arr[j].getHeight()) {
					minIndex=j;
				}
			}
			shortest=arr[minIndex];
			for(int j=minIndex;j>i;j--) {
				arr[j]=arr[j-1];
			}
			arr[i]=shortest;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		/*n=sc.nextInt();
		
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		System.out.println("Unsorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		
		selectionSort(a);
		
		System.out.println("\nSorted array: ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
		*/
		
		System.out.println("\n----------In place checking--------------\n");
		n=sc.nextInt();
		Student[] studs=new Student[n];
		for(int i=0;i<n;i++) {
			studs[i]=new Student(sc.next(),sc.nextInt());
		}
		
		System.out.println("Unsorted list of students: ");
		for(int i=0;i<n;i++)
			System.out.println(studs[i]);
		
		selectionSort(studs);
		//inPlaceSelectionSort(studs);
		System.out.println("\nSorted list of students: ");
		for(int i=0;i<n;i++)
			System.out.println(studs[i]);
		
		sc.close();
/*
* typical example checking in-place sorting
7
A 2
B 3
C 4 
D 7
E 4
F 7
G 3	

*/
	}

}
