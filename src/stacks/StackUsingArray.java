package stacks;

import customexceptions.EmptyStackException;

public class StackUsingArray {
	private int arr_len;
    private int[] arr;
    private int top;
    public StackUsingArray(){
        arr_len=10;
        arr=new int[arr_len];
        top=-1;
    }

    public int getCapacity(){
        return arr_len;
    }
    
    public boolean isFull(){
        if(top==arr_len-1)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    public int size(){
        return top+1;
    }

    public void push(int data){
        if(isFull()){
            int[] temp=new int[arr_len];
            for(int i=0;i<arr_len;i++)
                temp[i]=arr[i];

            arr_len=arr_len+10;
            arr=new int[arr_len];
            for(int i=0;i<=top;i++)
                arr[i]=temp[i];
        }
        top=top+1;
        arr[top]=data;
    }

    public int pop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException("Stack is empty!!!");
        }
        
        int removed=arr[top];
        top=top-1;
        if((top+1)%10==0){
            int[] temp=new int[top+1];
            for(int i=0;i<=top;i++)
                temp[i]=arr[i];

            arr_len=arr_len-10;
            arr=new int[arr_len];
            for(int i=0;i<=top;i++)
                arr[i]=temp[i];
        }
        return removed;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack empty!!!");
            return -1;
        }
        return arr[top];
    }

    public void displayStack(){
        System.out.print("[");
        for(int i=0;i<top;i++)
            System.out.print(arr[i]+" ");
        System.out.print(arr[top]+"]");
        System.out.println();
    }
}
