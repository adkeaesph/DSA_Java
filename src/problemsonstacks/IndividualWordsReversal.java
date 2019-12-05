package problemsonstacks;

import customexceptions.EmptyStackException;
import datastructures.StackUsingLL;

public class IndividualWordsReversal {

	public static String reverseIndividualWords(String str) throws EmptyStackException {
		String result="";
		int len=str.length();
		StackUsingLL<Character> stack=new StackUsingLL<>();
		
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ') {
				while(stack.getSize()!=0) {
					result+=stack.pop();
				}
				result+=" ";
			}else {
				stack.push(str.charAt(i));
			}
		}
		
		if(stack.getSize()!=0) {
			while(stack.getSize()!=0) {
				result+=stack.pop();
			}
		}
		return result;
	}
	public static void main(String[] args) throws EmptyStackException {
		String str="I am Ramesh";
		String res=reverseIndividualWords(str);
		System.out.println(str);
		System.out.println(res);
	}

}
