package lists;

import java.util.Scanner;
public class DriverDLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice,data,pos;
        DoublyLinkedList dll=new DoublyLinkedList();
        DoublyLinkedList.Node dnode=dll.createList();
        while(true){
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("Adios Amigo");
                break;
            }else if(choice==1){
                data=sc.nextInt();
                dnode=dll.insertAtStart(dnode,data);
                dll.displayList(dnode);
            }else if(choice==2){
                data=sc.nextInt();
                dnode=dll.insertAtEnd(dnode,data);
                dll.displayList(dnode);
            }else if(choice==3){
                pos=sc.nextInt();
                data=sc.nextInt();
                dnode=dll.insertAtPosition(dnode,pos,data);
                dll.displayList(dnode);
            }else if(choice==4){
                dnode=dll.deleteFirst(dnode);
                dll.displayList(dnode);
            }else if(choice==5){
                dnode=dll.deleteLast(dnode);
                dll.displayList(dnode);
            }else if(choice==6){
                pos=sc.nextInt();
                dnode=dll.deleteAt(dnode,pos);
                dll.displayList(dnode);
            }else if(choice==7){
                data=sc.nextInt();
                dnode=dll.delete(dnode,data);
                dll.displayList(dnode);
            }else if(choice==8){
                data=sc.nextInt();
                dnode=dll.deleteAll(dnode,data);
                dll.displayList(dnode);
            }else if(choice==9){
                dnode=dll.reverse(dnode);
                dll.displayList(dnode);
            }else if(choice==10){
                dll.reverseDisplayList(dnode);
            }else if(choice==11){
                System.out.println("Size of List = "+dll.size(dnode));
            }else if(choice==12){
                data=sc.nextInt();
                System.out.println(data+" is at "+dll.findPosition(dnode,data));
            }else{
                System.out.println("Invalid choice!!! Try again!!!");
            }
        }
        sc.close();
    }
}