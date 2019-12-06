package problemsonstacks;

import java.util.Scanner;

import customexceptions.EmptyStackException;
import stacks.StackUsingLL;

public class BalancedParenthesisProblem {
	public static boolean balancedParenthesis(String str) throws EmptyStackException{
        str=str.replace(" ","");
        int len=str.length();
        StackUsingLL<Character> stk=new StackUsingLL<>();
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
                stk.push(str.charAt(i));
            else if(str.charAt(i)==')'){
                if(stk.peek()!=null && stk.peek().equals('('))
                    stk.pop();
                else
                    return false;
            }else if(str.charAt(i)==']'){
                if(stk.peek()!=null && stk.peek().equals('['))
                    stk.pop();
                else
                    return false;
            }else if(str.charAt(i)=='}'){
                if(stk.peek()!=null && stk.peek().equals('{'))
                    stk.pop();
                else
                    return false;
            }else
                return false;
        }
        return stk.getSize()==0;
    }
	
	public static void main(String[] args) throws EmptyStackException {
		Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(balancedParenthesis(str));
        sc.close();
	}

}
