public class LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data) {
        Node newNode = new Node(data);   // time complexity -> O(1)
        size++;
        if(head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data); // time complexity -> O(1)
        size++;
        if(head==null) {
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void print() {    // Time complexity -> O(n)
        if(head==null) {
            System.out.println("LinkedList is empty");
        }
        Node temp=head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    public void add(int idx, int data) {
        if(idx==0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp =head;
        int i=0;
        while(i<idx-1) {
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst() {
        if(size==0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1) {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size==0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1) {
            int val= head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev =head;
        for(int i=0; i<size-2; i++) {
            prev=prev.next;
        }
        int val=prev.next.data; //tail.data
        prev.next=null;
        prev=tail;
        size--;
        return val;
    }

    public int itrSearch(int key) {       // time complexity-> O(n) by iteration search
        Node temp =head;
        int i=0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }


    public int helper(Node head, int key) {
        if(head==null) {
            return -1;
        }
        if(head.data==key) {         // Time and space complexity -> O(n)
            return 0;
        }
        int idx= helper(head.next, key);
        if(idx==-1) {
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head,key);
    }

    public void reverse() {          //3 variable and 4 step with O(n) time complexity
        Node prev= null;
        Node curr = tail = head;
        Node next;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void deleteNthfromend(int n) {
        //calculate size
        Node temp=head;
        int sz=0;
        while(temp!=null) {
            temp=temp.next;
            sz++;
        }
        if(n==sz) {
            head=head.next;
            return;
        }
        //sz-n;
        Node prev=head;
        int i=1;
        int iToFind=sz-n;
        while(i<iToFind) {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
                                        //Slow Fast Approach
    public Node findMid(Node head) {
        Node slow=head;
        Node fast= head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow; // Slow is my mid value
    }

    public boolean palindromeCheck() {
        if(head==null || head.next==null ) {
            return true;
        }
        //step1 find mid value
        Node midNode=findMid(head);

        //step2 2nd half reverse
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev; //right half head
        Node left=head;

        //step3 left half == right half
        while(right!=null) {
            if(left.data != right.data) {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                return true;   //Cycle exists
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect the loop in LinkedList
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) {
            cycle=true;
            break;
        }   
    }
        if(cycle == false) {
            return;
        }
        // find meeting point
        slow=head;
        Node prev=null;
        while(slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //last node ke next ko null kar do
        prev.next=null;
    }

    private Node getMid(Node head) {
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //mid Node for merge sort question isme humne Node fast me change kiya hai bs
    }


    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp =mergedLL;
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null) {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head) {                          //O(nlogn)
        if(head== null || head.next==null) {
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left & right half merge sort
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    public void ZigZag() {
        //find mid
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!= null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverse
        Node curr=mid.next;
        mid.next=null;
        Node prev = null;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node lefthead=head;
        Node righthead=prev;
        Node nextL, nextR;
        //zigzag merge
        while(lefthead!=null && righthead!=null) {
            nextL=lefthead.next;
            lefthead.next=righthead;
            nextR=righthead.next;
            righthead.next=nextL;

            lefthead=nextL;
            righthead=nextR;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2,3 );
        // ll.print();
        // System.out.println(ll.size);

        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print(); 

        // System.out.println(ll.itrSearch(3)); //return index no if found
        // System.out.println(ll.itrSearch(10)); //return index no if found

        // System.out.println(ll.recSearch(3)); 
        // System.out.println(ll.recSearch(10)); 

        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromend(3);
        // ll.print();

        /*these 5 lines are to detect a loop in linked list
        head= new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= head;
        //1->2->3->1
        System.out.println(isCycle());*/

        /* making a loop in LL 
        head = new Node(1);
        Node temp = new Node(2);
        head.next=temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        //1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());*/

        /*ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();*/

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.ZigZag();
        ll.print(); 

    }
}