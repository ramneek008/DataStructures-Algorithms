//Rotate the Doubly Linked List by K elements


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


  
static LinkList rotateByK(LinkList head, int k)
{
  LinkList temp = head;
  int count=0;
  if(temp==null)
  {}
  else if(temp.next==null)
  {}
  else
  {
    
    while(temp!=null)
    {
      count++;
      temp=temp.next;
    }
    k=count-k;
    temp=head;
    if(k<count && k>1)
    {
  for(int i=0;i<k;i++)
  {
    temp=temp.next;
  }
  LinkList temp1=temp.prev;
  temp1.next=null;
  temp.prev=null;
  head=temp;
  while(temp.next!=null)
  {temp=temp.next;}
  while(temp1.prev!=null)
  {
    temp1=temp1.prev;
  }
  temp1.prev=temp;
  temp.next=temp1;
  }
  }
  return head;
}



public static void main(String[] args)
  {
    int t,n,m,x;
    Scanner s = new Scanner(System.in);
    t=Integer.parseInt(s.nextLine());
    while(t>0)
    {
      LinkList head = null, t1;
      n=Integer.parseInt(s.nextLine().trim());
      while(n>0)
      {
        m=Integer.parseInt(s.nextLine().trim());
        head = insertEnd(head, m);
        n--;
      }
      x=Integer.parseInt(s.nextLine().trim());
      t1 = rotateByK(head, x);
      traverse(t1);
      System.out.println();
      t--;
    }
    s.close();
  }
}