package problemsonstack;

import java.util.Scanner;

import datastructures.LLStack;
import datastructures.StackEmptyException;

public class BalancedParenthesisProblem {
	public static boolean balancedParenthesis(String str) throws StackEmptyException{
        str=str.replace(" ","");
        int len=str.length();
        LLStack<Character> stk=new LLStack<>();
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
	
	public static void main(String[] args) throws StackEmptyException {
		Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(balancedParenthesis(str));
        sc.close();
	}

}
