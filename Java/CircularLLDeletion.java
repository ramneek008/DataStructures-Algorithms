//Deletion in Circular Linked List


import java.util.*;

class linkedList
{
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    Node last;

    static linkedList insertAtBegin(linkedList list, int val)
    {
        Node temp = new Node(val);
        if(list.last == null)
        {
            list.last=temp;
            temp.next = temp;
        }
        else
        {
            Node temp1 = list.last;
            temp.next = temp1.next;
            temp1.next = temp;
        }
        return list;
    }

    static linkedList insertAtEnd(linkedList list, int val)
    {
        Node temp = new Node(val);
        if(list.last == null)
        {
            list.last = temp;
            temp.next = temp;
        }
        else
        {
            Node temp1 = list.last;
            temp.next = temp1.next;
            temp1.next = temp;
            list.last = temp;
        }

        return list;
    }

    static linkedList deleteAtBegin(linkedList list)
    {
        Node temp = list.last;
        if(temp == null)
        {
            System.out.println("List is empty");
        }
        else if(temp.next == temp)
        {
            list.last = null;
            System.out.println("List got empty");
        }
        else
        {
            temp.next = temp.next.next;
        }
        return list;
    }

    static linkedList deleteAtEnd(linkedList list)
    {
        Node temp = list.last;
        if(temp == null)
        {
            System.out.println("List is empty");
        }
        else if(temp.next == temp)
        {
            list.last = null;
            System.out.println("List got empty");
        }
        else
        {
            do
            {
                temp = temp.next;
            }
            while(temp.next!=list.last);
            temp.next = list.last.next;
            list.last = temp; 
        }
        return list;
    }

    static void display(linkedList list)
    {
        Node temp = list.last;
        do
        {
            System.out.print(temp.next.data + " ");
            temp=temp.next;
        }
        while(temp!=list.last);
        System.out.println();

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

        System.out.println("Select any of the following:\n 1. Delete from beginning.\n 2. Delete from end.");
        cs = sc.nextInt();
        switch(cs)
        {
            case 1:
                l = deleteAtBegin(l);
                break;

            case 2:
                l = deleteAtEnd(l);
                break;

        }
        display(l);
        sc.close();
    }
}