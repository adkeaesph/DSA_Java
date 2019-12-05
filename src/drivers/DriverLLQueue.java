package drivers;

import java.util.Scanner;

import datastructures.LLQueue;

public class DriverLLQueue {
	public static void main(String[] args) {
		LLQueue<Integer> q = new LLQueue<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		while (true) {
			System.out.println();
			System.out.println("Press 1 to enqueue an element into queue");
			System.out.println("Press 2 to dequeue an element from queue");
			System.out.println("Press 3 to display contents of queue");
			System.out.println("Press 4 to peek at the front element");
			System.out.println("Press 5 to peek at the rear element");
			System.out.println("Press 0 to exit");
			choice = scanner.nextInt();
			if (choice == 0)
				break;
			else if (choice == 1) {
				System.out.println("Enter integer to be enqueued :");
				q.enqueue(scanner.nextInt());
			} else if (choice == 2) {
				try {
					System.out.println("Dequeued element : " + q.dequeue());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 3) {
				try {
					System.out.println("Queue contents from front to rear : ");
					q.displayQueueContents();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 4) {
				try {
					System.out.println("Element at front of queue: " + q.peekFront());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 5) {
				try {
					System.out.println("Element at rear of queue: " + q.peekRear());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else {
				System.out.println("Invalid choice!!! Try again!!!");
			}
		}
		scanner.close();
	}
}
