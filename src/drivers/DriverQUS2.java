package drivers;

import java.util.Scanner;

import customexceptions.EmptyStackException;
import datastructures.QueueUsingStack2;

public class DriverQUS2 {
	public static void main(String[] args) throws EmptyStackException {
		QueueUsingStack2<Integer> q = new QueueUsingStack2<Integer>();
		Scanner sc = new Scanner(System.in);
		int choice;
		Integer data;
		while (true) {
			choice = sc.nextInt();
			if (choice == 0) {
				break;
			} else if (choice == 1) {
				data = sc.nextInt();
				q.enqueue(data);
			} else if (choice == 2) {
				try {
					System.out.println("Element removed = " + q.dequeue());
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 3) {
				try {
					q.displayQueueContents();
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 4) {
				try {
					System.out.println("Element at front = " + q.peekFront());
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 5) {
				try {
					System.out.println("Element at rear = " + q.peekRear());
				} catch (EmptyStackException e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else
				System.out.println("Invalid choice!!! Try again!!!");
		}
		sc.close();
	}
}
