public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; 

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev= newNode;
        head=newNode;
    }

    public void print() {
        if(head==null) {
            System.out.println("Doubly linkedlist is empty");
            return;
        }
        Node temp =head;
        while(temp!=null) {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    public int removeFirst() {
        size--;
        if(head==null) {
            System.out.println("Linkedlist khali hai bhai");
            return Integer.MIN_VALUE;
        }
        if(size==1) {
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head=head.next;
        head.prev=null;
        return val;
    }

    public void reverse() {
        Node curr=head;
        Node prev = null;
        Node next;
        while(curr !=null) {
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head= prev;
    }
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        // ll.removeFirst();
        ll.reverse();
        ll.print();
        // System.out.println(ll.size);
    }
}
