//Deletion in Singly Linked List


import java.util.*;

class linkedList
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next=null;
        }
    }

    static linkedList insertBeg(linkedList list, int val)
    {
        Node temp = new Node(val);
        temp.next = list.head;
        list.head = temp;
        return list;
    }

    static linkedList insertEnd(linkedList list, int val)
    {
        Node temp = new Node(val);
        if(list.head == null)
        {
            list.head= temp;
        }
        else
        {
            Node temp1 = list.head;
            while(temp1.next!=null)
            {
                temp1 = temp1.next;
            }
            temp1.next = temp;
        }
        return list;
        
    }

    static linkedList deleteBeg(linkedList list)
    {
        if(list.head == null)
        System.out.println("Not available");
        else
        {
            Node temp1 = list.head;
            temp1 = temp1.next;
            list.head = temp1;
        }
        return list;
    }

    static linkedList deleteEnd(linkedList list)
    {
        if(list.head == null)
        System.out.println("Not available");
        else if(list.head.next==null)
        {
            list.head = null;
            return list;
        }
        else
        {
            Node temp1 = list.head;
            while(temp1.next.next!=null)
            {
                temp1 = temp1.next;
            }
            temp1.next = null;

        }
        return list;
    }

    static void display(linkedList l)
    {
        Node temp= l.head;
        int sum =0,c=0;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            sum += temp.data;
            temp = temp.next;
            c++;
        }
        System.out.println("Sum = " + sum + ", Average = " + (double)sum/c);
    }

    public static void main(String args[])
    {
        linkedList l = new linkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total numbers to enter: ");
        int n = sc.nextInt();
        System.out.println("Select the following:\n1. Insert at beginning. \n2. Insert at end.");
        int cs = sc.nextInt();
        switch(cs)
        {
            case 1:
            {
                for(int i=0;i<n;i++)
                {
                    int val = sc.nextInt();
                    l = insertBeg(l,val);
                }
                break;
            }
            case 2:
            {
                for(int i=0;i<n;i++)
                {
                    int val = sc.nextInt();
                    l = insertEnd(l,val);
                }
                break;
            }
            default:
                System.out.println("Enter valid number");
                break;
        }
        
        // l = insertBeg(l,10);
        // l = insertBeg(l,20);
        // l= insertEnd(l,30);
        display(l);

        cs = sc.nextInt();
        switch(cs)
        {
            case 1:
                l = deleteBeg(l);
                break;
            
            case 2:    
                l = deleteEnd(l);
                break;
        }
        display(l);
        sc.close();
    }
}