package drivers;

import java.util.Scanner;

import datastructures.StackUsingSingleQueue;

public class DriverSUSQ {
	public static void main(String[] args) {
		StackUsingSingleQueue<Integer> stack = new StackUsingSingleQueue<>();
		Scanner scanner = new Scanner(System.in);
		int choice;
		while (true) {
			System.out.println("Press 1 to push an element onto stack");
			System.out.println("Press 2 to pop an element from stack");
			System.out.println("Press 3 to display contents of stack");
			System.out.println("Press 4 to peek on the top element");
			System.out.println("Press 0 to exit");
			choice = scanner.nextInt();
			Integer data;
			if (choice == 0)
				break;
			else if (choice == 1) {
				System.out.println("Enter integer to be pushed:");
				data=scanner.nextInt();
				stack.push(data);
			} else if (choice == 2) {
				try {
					System.out.println("Popped element : " + stack.pop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 3) {
				try {
					stack.displayStackContents();
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (choice == 4) {
				try {
					System.out.println("Element at stack top : " + stack.peek());
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
