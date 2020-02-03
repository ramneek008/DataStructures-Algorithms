//Remove Duplicates from a sorted doubly linked list


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


class Result {
    static LinkList removeDupsDLL(LinkList head) {
      LinkList temp = head;
      if(temp==null)
      {
      }
      else if(temp.next==null)
      {
      }
      else
      {
      temp=temp.next;
      while(temp.next!=null)
      {
        if(temp.data==temp.prev.data)
        {
          temp.prev.next=temp.next;
          temp.next.prev=temp.prev;
        }
        temp=temp.next;
      }
        if(temp.next==null && temp.data==temp.prev.data)
        {
          temp.prev.next=null;
        }
          
      }
      return head;
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
  public static void main(String[] args)
  {
    int t,n,m;
    Scanner s = new Scanner(System.in);
    t = s.nextInt();
    while(t>0)
    {
      LinkList head = null, t1;
      n = s.nextInt();
      while(n>0)
      {
        m = s.nextInt();
        head = insertEnd(head, m);
        n--;
      }
      t1 = Result.removeDupsDLL(head);
      traverse(t1);
      System.out.println();
      t--;
    }
    s.close();
  }
}