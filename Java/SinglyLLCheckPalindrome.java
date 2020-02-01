//Check the list for Palindrome


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

    static void display(Node temp)
    {
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    
    
    static int checkPalindrome(Node head) {
      int count=0,m=0;
      Node temp = head;
      if(head==null)
        return 0;
      else
      {
      while(temp!=null)
      {
        count++;
        temp = temp.next;
      }
      temp = head;
      for(int i=0;i<count/2;i++)
      {
        Node temp1=head;
        for(int j=0;j<count-i-1;j++)
        {
          temp1 = temp1.next;
        }
        if(temp.data==temp1.data)
        {m++;}
        temp=temp.next;
      }
      if(m==count/2)
        return 1;
      else
        return 0;
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
        
        display(l.head);

        int r = checkPalindrome(l.head);

        if(r==1)
        System.out.println("List is Palindrome.");
        else
        System.out.println("List is Not Palindrome.");

        sc.close();
        
    }
}