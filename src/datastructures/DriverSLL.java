package datastructures;

import java.util.Scanner;
public class DriverSLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice,pos;
        String data;
        SinglyLinkedList<Character> sll=new SinglyLinkedList<>();
        
        while(true){
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("Adios Amigo");
                break;
            }else if(choice==1){
                data=sc.next();
                sll.insertAtStart(data.charAt(0));
                sll.displayList();
            }else if(choice==2){
                data=sc.next();
                sll.insertAtEnd(data.charAt(0));
                sll.displayList();
            }else if(choice==3){
                pos=sc.nextInt();
                data=sc.next();
                sll.insertAtPosition(pos,data.charAt(0));
                sll.displayList();
            }else if(choice==4){
                sll.deleteFirst();
                sll.displayList();
            }else if(choice==5){
                sll.deleteLast();
                sll.displayList();
            }else if(choice==6){
                pos=sc.nextInt();
                sll.deleteAt(pos);
                sll.displayList();
            }else if(choice==7){
                data=sc.next();
                sll.delete(data.charAt(0));
                sll.displayList();
            }else if(choice==8){
                data=sc.next();
                sll.deleteAll(data.charAt(0));
                sll.displayList();
            }else if(choice==9){
                sll.reverse();
                sll.displayList();
            }else if(choice==10){
                pos=sc.nextInt();
                data=sc.next();
                sll.replace(pos,data.charAt(0));
                sll.displayList();
            }else if(choice==11){
                Character oldData=sc.next().charAt(0);
                Character newData=sc.next().charAt(0);
                sll.replace(oldData,newData);
                sll.displayList();
            }else if(choice==12){
                Character oldData=sc.next().charAt(0);
                Character newData=sc.next().charAt(0);
                sll.replaceAll(oldData,newData);
                sll.displayList();
            }else if(choice==13){
                System.out.println("Size of List = "+sll.getSize());
            }else if(choice==14){
                data=sc.next();
                System.out.println(data+" is at "+sll.findPosition(data.charAt(0)));
            }else if(choice==15){
                System.out.println("Head element = "+sll.getHead().getData());
            }else if(choice==16){
                pos=sc.nextInt();
                sll.createLoop(pos);
                System.out.println("Loop exists : "+sll.loopExistsByFloyd());
            }else if(choice==17){
                char inData=sc.next().charAt(0);
                sll.createLoop(inData);
                System.out.println("Loop exists : "+sll.loopExists());
            }else if(choice==18){
                System.out.println("Loop exists : "+sll.findAndEliminateLoop());
            }else if(choice==19){
                System.out.println("Loop exists : "+sll.findAndEliminateLoop1());
            }else if(choice==20) {
                sll.reverseAlternateNodes();
                sll.displayList();
            }
            else{
                System.out.println("Invalid choice!!! Try again!!!");
            }
        }
        sc.close();
    }
}