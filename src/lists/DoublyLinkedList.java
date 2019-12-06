package lists;

public class DoublyLinkedList {

    public class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data=data;
            prev=null;
            next=null;
        }
    }

    public Node createList(){
        return null;
    }

    public int size(Node head){
        int length=0;
        if(head==null)
            return length;

        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    public Node insertAtStart(Node head, int data){
        Node node=new Node(data);
        if(head==null)
            return node;

        node.next=head;
        head.prev=node;
        head=node;
        return head;
    }

    public Node insertAtEnd(Node head, int data){
        Node node=new Node(data);
        if(head==null)
            return node;

        Node last=head;
        while(last.next!=null){
            last=last.next;
        }

        last.next=node;
        node.prev=last;

        return head;
    }

    public Node insertAtPosition(Node head, int position, int data){
        int lcount=size(head);

        if(position>lcount || position<0){
            System.out.println("Invalid Position");
            return head;
        }
        if(position==0){
            return insertAtStart(head, data);
        }else if(position==lcount){
            return insertAtEnd(head, data);
        }
        lcount=0;
        Node temp=head;
        Node node=new Node(data);
        while(temp != null){
            lcount++;
            if(lcount==position){
                node.prev=temp;
                node.next=temp.next;
                temp.next=node;
                node.next.prev=node;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public int findPosition(Node head, int data){
        if(head==null)
            return -2;

        Node temp=head;
        int len=0;
        while(temp!=null){
            if(temp.data==data) {
                return len;
            }
            temp=temp.next;
            len++;
        }
        return -1;
    }

    public Node deleteFirst(Node head){
        if(head==null) {
            System.out.println("List is empty!!! No deletion happened.");
            return null;
        }

        head=head.next;
        head.prev=null;
        return head;
    }

    public Node deleteLast(Node head){
        if(head==null) {
            System.out.println("List is empty!!! No deletion happened.");
            return null;
        }
        Node secondLast=head;
        while(secondLast.next.next!=null)
            secondLast=secondLast.next;

        secondLast.next=null;
        return head;
    }

    public Node deleteAt(Node head, int position){
        if(head==null){
            System.out.println("List is empty!!! No deletion happened.");
            return null;
        }

        int len=size(head);
        if(position<0 || position>=len){
            System.out.println("Invalid Position");
            return head;
        }

        if(position==0)
            return deleteFirst(head);
        else if(position==len-1)
            return deleteLast(head);

        len=0;
        Node temp=head;
        while(temp!=null){
            if(len==(position-1)){
                temp.next=temp.next.next;
                temp.next.prev=temp;
                break;
            }
            temp=temp.next;
            len++;
        }
        return head;
    }

    public Node delete(Node head,int data){
        int pos=findPosition(head,data);
        if(pos==-2){
            System.out.println("List is empty!!! Element not found.");
            return null;
        }else if(pos==-1){
            System.out.println("Element not found!!!");
            return head;
        }
        return deleteAt(head,pos);
    }

    public Node deleteAll(Node head,int data){
        int pos=findPosition(head,data);
        boolean flag=false;
        while(pos>=0){
            flag=true;
            head=deleteAt(head,pos);
            pos=findPosition(head,data);
        }

        if(!flag){
            if(pos==-2)
                System.out.println("List is empty!!! Element not found.");
            else if(pos==-1)
                System.out.println("Element not found!!!");
        }

        return head;
    }

    public Node reverse(Node head){
        if(head==null || head.next==null)
            return head;

        Node prev=null;
        Node temp=head;
        Node next;

        while(temp!=null){
            next=temp.next;
            temp.next=prev;
            temp.prev=next;
            prev=temp;
            temp=next;
        }

        return prev;
    }

    public void displayList(Node head){
        System.out.print("[");
        if(head==null) {
            System.out.print("]");
            System.out.println();
            return;
        }

        if(head.next==null) {
            System.out.print(head.data+"]");
            System.out.println();
            return;
        }

        while(head.next!=null){
            System.out.print(head.data+" <-> ");
            head=head.next;
        }
        System.out.print(head.data+"]");
        System.out.println();
    }

    public void reverseDisplayList(Node head){
        System.out.print("[");
        if(head==null) {
            System.out.print("]");
            System.out.println();
            return;
        }

        if(head.next==null) {
            System.out.print(head.data+"]");
            System.out.println();
            return;
        }

        Node last=head;
        while(last.next!=null){
            last=last.next;
        }

        Node temp=last;
        while(temp.prev!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.prev;
        }
        System.out.print(temp.data+"]");
        System.out.println();
    }
}
