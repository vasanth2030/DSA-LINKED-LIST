package workout;
import java.util.*;
import java.util.jar.JarOutputStream;

public class linkedList {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next= new Node(30);
        head.next.next.next=new Node(40);
        head=Node.insertBegin(head,0);
        head=Node.insertBegin(head,5);
        Node.insertAtEnd(head,60);
        Node.insertAtEnd(head,70);
        Node.printList(head);
        System.out.println();
        System.out.println("Enter data and pos to insert");
        int data=s.nextInt();
        int pos=s.nextInt();
        Node.insertAtPos(head,pos,data);
        System.out.println("The middle element is");
        System.out.println(Node.getMiddleElement(head));
        System.out.println("Enter element to insert");
        int value=s.nextInt();
        Node.sortedInsert(head,value);
        System.out.println("Enter element to insert");
        int value1=s.nextInt();
        Node.sortedInsert(head,value1);
        System.out.println("To get element from end. Enter n");
        int num=s.nextInt();
        Node.getNthElementFromEnd(head,num);
        System.out.println("Reversing list");
        head= Node.ReverseList(head);
        Node.printList(head);
        System.out.println("Reverse list using recursion");
        head=Node.ReverseListRecursive(head,null);
        Node.printList(head);
        System.out.println("To remove duplicates: ");
        Node.removeDuplicates(head);
    }

}
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
    static Node insertBegin(Node head, int data)
    {
        Node temp=new Node(data);
        temp.next=head;
        return temp;
    }
    static Node insertAtEnd(Node head,int data)
    {
        Node temp=new Node(data);
        if(head==null)
            return temp;
        else{
            Node curr=head;
            while(curr.next!=null)
                curr=curr.next;
            curr.next=temp;
            return head;
        }
    }
    static void printList(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+ " ");
            curr=curr.next;
        }
        System.out.println();
    }
    static Node insertAtPos(Node head,int pos,int data) {
        Node temp = new Node(data);
        if (pos == 1) {
            temp.next = head;
            printList(temp);
            return temp;
        }
        else if (head == null) {
            System.out.print(temp.data);
            return temp;
        }


        else {
            Node curr = head;
            for (int i = 1; i < pos - 1; i++) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
            printList(head);
            return head;
        }
    }
    static int getMiddleElement(Node head)
    {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;

        }
        return slow.data;


    }
    static Node sortedInsert(Node head,int data) {
        Node temp = new Node(data);
        if (head == null) {
            System.out.print(temp.data);
            return temp;
        }
        else if (data < head.data)
        {
            temp.next = head;
            printList(temp);
            return temp;
        }
        else{
            Node curr = head;
            while (curr.next!=null && curr.next.data<data)
                curr=curr.next;
            temp.next=curr.next;
            curr.next=temp;
            printList(head);
            return head;
        }
    }
    static void getNthElementFromEnd(Node head,int n)
    {
        if(head==null)
            return;
        Node first=head;
        for(int i=0;i<n;i++)
        {
            if (first==null)
                return;
            else
                first=first.next;
        }
        Node second= head;
        while(first!=null)
        {
            second=second.next;
            first=first.next;
        }
        System.out.println(second.data);
    }
    static Node ReverseList(Node head)
    {
        if(head==null)
            return head;
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;


    }
    static Node ReverseListRecursive(Node curr, Node prev)
    {
        if(curr==null)
            return prev;
        Node next=curr.next;
        curr.next=prev;
        return ReverseListRecursive(next,curr);
    }
    static void removeDuplicates(Node head)
    {
        if(head==null) {
            System.out.println("List empty");
            return;
        }
        else {
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data == curr.next.data)
                    curr.next = curr.next.next;
                else
                    curr = curr.next;
            }
            printList(head);
        }

    }

}

