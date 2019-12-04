package problemsonstack;

import java.util.Scanner;

import datastructures.InvalidInputException;
import datastructures.LLStack;
import datastructures.StackEmptyException;

public class TowerOfHanoiProblem {
	
	public static void TowerOfHanoi(int noOfDisks, LLStack<Integer> sourceStack, LLStack<Integer> destinationStack,  LLStack<Integer> auxiliaryStack) throws StackEmptyException, InvalidInputException {
		if(noOfDisks==1) {
			destinationStack.push(sourceStack.pop());
			System.out.println("Disk "+noOfDisks+" moved from "+sourceStack.getStackId()+" to "+destinationStack.getStackId()+".");
			return;
		} else if(noOfDisks>1){
			TowerOfHanoi(noOfDisks-1, sourceStack, auxiliaryStack, destinationStack);
			destinationStack.push(sourceStack.pop());
			System.out.println("Disk "+noOfDisks+" moved from "+sourceStack.getStackId()+" to "+destinationStack.getStackId()+".");
			TowerOfHanoi(noOfDisks-1, auxiliaryStack, destinationStack, sourceStack);
		} else {
			throw new InvalidInputException("Number of disks need to be 1 or more than 1");
		}
	}
	
	public static void main(String[] args) throws StackEmptyException, InvalidInputException {
		LLStack<Integer> srcStack=new LLStack<>();
		srcStack.setStackId("A");
		LLStack<Integer> auxStack=new LLStack<>();
		auxStack.setStackId("B");
		LLStack<Integer> dstnStack=new LLStack<>();
		dstnStack.setStackId("C");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of disks for TOH puzzle : ");
		int noOfDisks=sc.nextInt();
		for(int i=noOfDisks;i>=1;i--)
			srcStack.push(i);
		
		TowerOfHanoi(noOfDisks, srcStack, dstnStack, auxStack);
		
		System.out.println();
		try {
			srcStack.displayStackContents();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			auxStack.displayStackContents();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dstnStack.displayStackContents();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
