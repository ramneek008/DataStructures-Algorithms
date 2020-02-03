//Swap Two Nodes of Doubly Linked List


import java.util.Scanner;
// Other imports go here
// Do NOT change the class name
class LinkList
{
  int data;
  LinkList next;
  LinkList prev;
  LinkList(int d)
  {
    data=d;
  }
}

class Main
{
  // Insert in end
  static LinkList insertEnd(LinkList head, int data)
  {
    LinkList newLink = new LinkList(data);
    LinkList last = head;
    newLink.next = null;   // link new node to NULL as it is last node
    if (head == null)  // if list is empty add in beginning.
    {
      head = newLink;
      newLink.prev = null;
      return head;
    }
    while (last.next != null)  // Find the last node
      last = last.next;
    last.next = newLink;  // Add the node after the last node of list
    newLink.prev = last;
    return head;
  }

  static void traverse(LinkList first)
  {
    while (first != null)
    {
      System.out.print(first.data + " ");
      first = first.next;
    }
  }


  static void swapNodes(LinkList head, int x, int y)
  {
    LinkList temp = head;
    int count =0;
    while(temp!=null)
    {
      count++;
      temp=temp.next;
    }
    if(head==null)
    {}
    else
    {
    if(x>count || y>count)
    {}
    else
    {
      temp = head;
      for(int i=0;i<x-1;i++)
      {temp=temp.next;}
      LinkList temp1 = temp;
      temp=head;
      for(int i=0;i<y-1;i++)
      {temp=temp.next;}
      int p = temp.data;
      temp.data=temp1.data;
      temp1.data=p;
    }
    }
  
  }

  public static void main(String[] args)
  {
    int t,n,m,x,y;
    Scanner s = new Scanner(System.in);
    t=Integer.parseInt(s.nextLine());
    while(t>0)
    {
      LinkList head = null;
      n=Integer.parseInt(s.nextLine());
      while(n>0)
      {
        m=Integer.parseInt(s.nextLine());
        head = insertEnd(head, m);
        n--;
      }
      x=Integer.parseInt(s.nextLine());
      y=Integer.parseInt(s.nextLine());
      swapNodes(head, x, y);
      traverse(head);
      System.out.println();
      t--;
    }
    s.close();
  }
}