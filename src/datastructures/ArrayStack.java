package datastructures;

public class ArrayStack {
	private int arr_len;
    private int arr[];
    private int top;
    ArrayStack(){
        arr_len=10;
        arr=new int[arr_len];
        top=-1;
    }

    int getCapacity(){
        return arr_len;
    }
    boolean isFull(){
        if(top==arr_len-1)
            return true;
        return false;
    }

    boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    int size(){
        return top+1;
    }

    void push(int data){
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

    void pop(){
        if(isEmpty()){
            System.out.println("Stack empty!!!");
            return;
        }
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
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack empty!!!");
            return -1;
        }
        return arr[top];
    }

    void displayStack(){
        System.out.print("[");
        for(int i=0;i<top;i++)
            System.out.print(arr[i]+" ");
        System.out.print(arr[top]+"]");
        System.out.println();
    }
}
