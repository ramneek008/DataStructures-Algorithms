//Insertion in Singly Linked List


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

    static linkedList removeDuplicates(linkedList list)
    {
        Node temp = list.head;
        if(temp==null || temp.next==null)
        {
            return list;
        }
        else
        {
            Node temp2= temp;
            while(temp.next!=null)
            {
                Node temp1=temp;
                while(temp1.data==temp1.next.data && temp1.next.next!=null)
                {
                    temp1=temp1.next;
                }
                temp.next=temp1.next;
                temp2=temp;
                temp=temp.next;
                
            }
            if(temp.data==temp2.data)
           {
               
               temp2.next=null;
           }
            return list;
        }

    }


    static void display(linkedList l)
    {
        Node temp= l.head;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
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
        l = removeDuplicates(l);
        display(l);
        sc.close();
        
    }
}