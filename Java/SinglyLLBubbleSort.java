//Bublle Sort in Singly Linked List


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

    static linkedList bubbleSort(linkedList list)
    {
        if(list.head == null)
        {
            System.out.println("Empty list");
        }
        else
        {
            Node temp = list.head;
            int count = 0;
            while(temp!=null)
            {
                count++;
                temp = temp.next;
            }
            int p;
            Node temp1 = list.head;
            for(int i=0; i<count; i++)
            {
                Node temp2 = list.head;
                for(int j=0; j<count-1;j++)
                {
                    if(temp1.data<temp2.data)
                    {
                    p = temp1.data;
                    temp1.data= temp2.data;
                    temp2.data=p;
                    }
                    temp2=temp2.next;
                }
                temp1 = temp1.next;
            }
        }
        return list;
    }

    static void display(linkedList l)
    {
        Node temp= l.head;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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

        l = bubbleSort(l);

        display(l);
        sc.close();
    }
}