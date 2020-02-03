//Insertion in Doubly Linked List

import java.util.*;

class linkedList 
{
    static class Node
    {
        int data;
        Node prev;
        Node next;
        Node(int d)
        {
            data=d;
            prev=null;
            next=null;
        }
    }
    Node head;

    static linkedList insertAtBegin(linkedList list,int val)
    {
        Node temp = new Node(val);;
        Node temp1 = list.head;
        if(temp1==null)
        {
           list.head = temp;
        }
        else
        {
            temp.next = temp1;
            temp1.prev=temp;
            list.head=temp;
        }
        return list;
    }

    static linkedList insertAtEnd(linkedList list, int val)
    {
        Node temp = new Node(val);
        Node temp1 = list.head;
        if(temp1==null)
        {
            list.head = temp;
        }
        else
        {
            while(temp1.next!=null)
            {
                temp1 = temp1.next;
            }
            temp1.next=temp;
            temp.prev=temp1;
        }
        return list;
    }

    static void display(linkedList list)
    {
        Node temp = list.head;
        System.out.print("Correct order: ");
        while(temp.next!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.print("Reverse order: ");
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    public static void main(String args[])
    {
        linkedList l = new linkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total numbers to enter");
        int n = sc.nextInt();
        System.out.println("Select any of the following:\n 1. Insert at beginning.\n 2. Insert at end.");
        int cs = sc.nextInt();
        switch(cs)
        {
            case 1: 
            {
                for(int i=0;i<n;i++)
                {
                    int val = sc.nextInt();
                    l = insertAtBegin(l,val);
                }
                break;
            }

            case 2: 
            {
                for(int i=0;i<n;i++)
                {
                    int val = sc.nextInt();
                    l = insertAtEnd(l,val);
                }
                break;
            }
        }
        
        display(l);
        sc.close();
    }
}