package problemsonstacks;

import customexceptions.EmptyStackException;
import stacks.StackUsingLL;

public class ConsecutiveWordsDeletion {

	public static String deleteConsecutiveSameWords(String str) throws EmptyStackException {
		int len=str.length();
		String temp="";
		StackUsingLL<String> stk=new StackUsingLL<>();
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ') {
				temp+=str.charAt(i);
			}else {
				if(stk.getSize()==0)
					stk.push(temp);
				else {
					if(stk.peek().equals(temp))
						stk.pop();
					else
						stk.push(temp);
				}
				temp="";
			}
		}
		
		if(!temp.isEmpty()) {
			if(stk.peek().equals(temp))
				stk.pop();
			else
				stk.push(temp);
		}
		
		String result="";
		
		while(stk.getSize()!=1) {
			result=" "+stk.pop()+result;
		}
		result=stk.pop()+result;
		return result;
	}
	public static void main(String[] args) throws EmptyStackException {
		String str="tom jerry jerry harry";
		String res=deleteConsecutiveSameWords(str);
		System.out.println(str+" "+str.length());
		System.out.println(res+" "+res.length());

	}

}
