package problemsonstack;

import java.util.Scanner;

import customexceptions.EmptyStackException;
import datastructures.LLStack;

public class InfixToPostfix {

	private static int getPriority(Character c) {
		if(c=='+' || c=='-')
			return 0;
		if(c=='/' || c=='%' || c=='*')
			return 1;
		return -1;
	}
	private static String convertInfixToPostfix(String infixExpression) throws EmptyStackException {
		LLStack<Character> symbolStack=new LLStack<>();
		String postfixExpression="";
		int strlen=infixExpression.length();
		
		for(int i=0;i<strlen;i++) {
			if(infixExpression.charAt(i)>='a' && infixExpression.charAt(i)<='z') {
				postfixExpression+=infixExpression.charAt(i);
			}else {
				if(symbolStack.getSize()==0)
					symbolStack.push(infixExpression.charAt(i));
				else {
					if(getPriority(symbolStack.peek())<getPriority(infixExpression.charAt(i)))
						symbolStack.push(infixExpression.charAt(i));
					else if(getPriority(symbolStack.peek())==getPriority(infixExpression.charAt(i))){
						postfixExpression+=infixExpression.charAt(i+1);
						postfixExpression+=infixExpression.charAt(i);
						i++;
					}else {
						postfixExpression+=symbolStack.pop();
					}
				}
			}
		}
		
		if(symbolStack.getSize()!=0) {
			while(symbolStack.getSize()!=0)
				postfixExpression+=symbolStack.pop();
		}
		return postfixExpression;
	}
	
	public static void main(String[] args) throws EmptyStackException {
		Scanner sc;
		int choice;
		String infixExpression;
		do {
			sc=new Scanner(System.in);
			System.out.println("Enter an infix expression : ");
			infixExpression=sc.next();
			
			System.out.println(convertInfixToPostfix(infixExpression));
			System.out.println("Press any digit to continue. Press 0 to exit.");
			choice=sc.nextInt();
		}while(choice!=0); 
		
		sc.close();
	}
}
