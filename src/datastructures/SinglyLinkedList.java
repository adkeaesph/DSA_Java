package datastructures;

import java.util.HashMap;
import java.util.HashSet;

public class SinglyLinkedList<T> {
    private SinglyNode<T> head;
    private static int size;

    public SinglyLinkedList(){
        head=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public SinglyNode<T> getHead(){
        return head;
    }

    public void setHead(SinglyNode<T> head){
        this.head=head;
    }

    public void insertAtStart(T data){
        SinglyNode<T> node=new SinglyNode<>(data);
        if(head!=null){
            node.setNext(head);
        }
        setHead(node);
        size++;
    }

    public void insertAtEnd(T data){
        SinglyNode<T> node=new SinglyNode<>(data);
        if(head==null) {
            head = node;
            size++;
            return;
        }
        SinglyNode<T> last=head;
        while(last.getNext()!=null)
            last=last.getNext();

        last.setNext(node);
        size++;
    }

    public void insertAtPosition(int position, T data){
        int length=getSize();

        if(position>length || position<0){
            System.out.println("Invalid Position");
            return;
        }
        if(position==0){
            insertAtStart(data);
        }else if(position==length){
            insertAtEnd(data);
        }else {
            length = 0;
            SinglyNode<T> temp = head;
            SinglyNode<T> node = new SinglyNode<>(data);
            while (temp != null) {
                length++;
                if (length == position) {
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    break;
                }
                temp = temp.getNext();
            }
            size++;
        }
    }


    public int findPosition(T data){
        if(head==null)
            return -2;

        SinglyNode<T> temp=head;
        int len=0;
        while(temp!=null){
            if(temp.getData()==data) {
                return len;
            }
            temp=temp.getNext();
            len++;
        }
        return -1;
    }

    public void deleteFirst(){
        if(head==null){
            return;
        }
        head=head.getNext();
        size--;
    }

    public void deleteLast(){
        if(isEmpty()) {
            System.out.println("List is empty!!! No deletion happened.");
            return;
        }
        SinglyNode<T> secondLast=head;
        while(secondLast.getNext().getNext()!=null)
            secondLast=secondLast.getNext();

        secondLast.setNext(null);
        size--;
    }

    public void deleteAt(int position){
        if(head==null){
            System.out.println("List is empty!!! No deletion happened.");
            return;
        }

        int len=getSize();
        if(position<0 || position>=len){
            System.out.println("Invalid Position");
            return;
        }

        if(position==0) {
            deleteFirst();
        }else if(position==len-1) {
            deleteLast();
        }else {
            len = 0;
            SinglyNode<T> temp = head;
            while (temp != null) {
                if (len == (position - 1)) {
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                temp = temp.getNext();
                len++;
            }
            size--;
        }
    }

    public void delete(T data){
        int pos=findPosition(data);
        if(pos==-2){
            System.out.println("List is empty!!! Element not found.");
            return;
        }else if(pos==-1){
            System.out.println("Element not found!!!");
            return;
        }
        deleteAt(pos);
    }

    public void deleteAll(T data){
        int pos=findPosition(data);
        boolean flag=false;
        while(pos>=0){
            flag=true;
            deleteAt(pos);
            pos=findPosition(data);
        }

        if(!flag){
            if(pos==-2)
                System.out.println("List is empty!!! Element not found.");
            else if(pos==-1)
                System.out.println("Element not found!!!");
        }
    }

    public void reverse(){
        SinglyNode<T> prev=null;
        SinglyNode<T> temp=getHead();
        SinglyNode<T> next;
        while(temp!=null){
            next=temp.getNext();
            temp.setNext(prev);
            prev=temp;
            temp=next;
        }
        setHead(prev);
    }

    public void reverseAlternateNodes(){
        SinglyNode<T> iteratorNode=getHead();
        SinglyNode<T> temp,prev=null;
        int iteration=0;
        while(iteratorNode!=null && iteratorNode.getNext()!=null){
            iteration++;
            temp=iteratorNode.getNext();
            iteratorNode.setNext(temp.getNext());
            temp.setNext(iteratorNode);
            if(iteration==1) {
                setHead(temp);  //setting the correct head in first iteration
            }else{
                prev.setNext(temp); //connecting the processed list of this iteration
                                    //with the already processed list of previous iteration
            }
            prev=iteratorNode;  //storing the last node of the already processed
                                // part of the list.
            iteratorNode=iteratorNode.getNext();
        }
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void displayList(){
        System.out.print("[");
        SinglyNode<T> temp=getHead();
        if(temp!=null) {
            while (temp.getNext() != null) {
                System.out.print(temp.getData() + ", ");
                temp = temp.getNext();
            }
            System.out.print(temp.getData());
        }
        System.out.print("]");
        System.out.println();
    }

    public void replace(int position,T newData){
        int count=0;
        SinglyNode<T> temp=head;
        while(temp!=null){
            if(count==position){
                temp.setData(newData);
                break;
            }
            count++;
            temp=temp.getNext();
        }
    }

    public void replace(T oldData,T newData){
        SinglyNode<T> temp=head;
        while(temp!=null){
            if(temp.getData()==oldData){
                temp.setData(newData);
                break;
            }
            temp=temp.getNext();
        }
    }

    public void replaceAll(T oldData,T newData){
        SinglyNode<T> temp=head;
        while(temp!=null){
            if(temp.getData()==oldData){
                temp.setData(newData);
            }
            temp=temp.getNext();
        }
    }

    public void createLoop(T data){
        SinglyNode<T> last=head;
        while(last.getNext()!=null){
            last=last.getNext();
        }

        SinglyNode<T> temp=head;
        while(temp!=null){
            if(temp.getData()==data){
                last.setNext(temp);
                break;
            }
            temp=temp.getNext();
        }
    }

    public void createLoop(int position){
        SinglyNode<T> last=head;
        while(last.getNext()!=null){
            last=last.getNext();
        }

        SinglyNode<T> temp=head;
        int len=0;
        while(temp!=null){
            if(len == position){
                last.setNext(temp);
                break;
            }
            len++;
            temp=temp.getNext();
        }
    }

    public boolean loopExists(){
        SinglyNode<T> i=head;

        HashSet<SinglyNode<T>> hs=new HashSet<>();
        while(i!=null){
            if(hs.contains(i))
                return true;
            else
                hs.add(i);
            i=i.getNext();
        }
        return false;
    }

    public boolean loopExistsByFloyd(){
        SinglyNode<T> slow=head;
        SinglyNode<T> fast=head;

        while(slow!=null && fast!=null && fast.getNext()!=null) {
            slow = slow.getNext();
            fast = (fast.getNext()).getNext();
            if (slow == fast)
                return true;
        }
        return false;
    }
    /*
    void eliminateLoop(){
        SinglyNode i=head;

        HashMap<SinglyNode,SinglyNode> hm=new HashMap<>();
        while(i.getNext()!=null){
            if(hm.containsKey(i.getNext())) {
                i.setNext(null);
                break;
            }else
                hm.put(i,i.getNext());
            i=i.getNext();
        }
    }
    */
    public boolean findAndEliminateLoop() {//using hashmap
        SinglyNode<T> i=head;

        HashMap<SinglyNode<T>,SinglyNode<T>> hm=new HashMap<>();
        while(i.getNext()!=null){
            if(hm.containsKey(i.getNext())) {
                i.setNext(null);
                return true;
            }else
                hm.put(i,i.getNext());
            i=i.getNext();
        }
        return false;
    }

    public boolean findAndEliminateLoop1() {//using hashset
        SinglyNode<T> t=head;
        HashSet<SinglyNode<T>> hs = new HashSet<>();
        SinglyNode<T> prev = null;
        while (t != null) {
            if (hs.contains(t)) {
                prev.setNext(null);
                return true;
            }
            else {
                hs.add(t);
                prev = t;
                t = t.getNext();
            }
        }
        return false;
    }
}
