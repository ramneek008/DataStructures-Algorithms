//Split the Circular Linked List in two parts


import java.util.Scanner;

class Result {
    static LinkList listCut(LinkList head) {
      
      if(head==null)
      {
        return head;
      }
      LinkList temp = head;
      int count = 0;
      while(temp.next!=head)
      {
        count++;
        temp=temp.next;
      }
      count++;
      temp = head;
      for(int i=0;i<(count/2)-1;i++)
      {
        temp = temp.next;
      }
      LinkList temp1 = temp.next;
      temp.next=head;
      
      LinkList temp2 = temp1;
      while(temp2.next!=head)
      {
        temp2=temp2.next;
      }
      temp2.next= temp1;
      return temp1;
    }
  }



  class LinkList {
    int data;
    LinkList next;
    LinkList() {}
    LinkList(int d) {
      data=d;
    }
  }
  
  class Main
  {
    // Insert in Beginning
    static LinkList insertBeg(LinkList head, int data)
    {
      LinkList newLink = new LinkList(data);
      LinkList t = head;
      newLink.next = head;   // link new node at beginning of list
      if (head != null)
      {
        while(t.next != head)
          t = t.next;
        t.next = newLink;
      }
      else
        newLink.next = newLink;
      head = newLink;  // Change the head to new node.
      return head;
    }
    // Insert in end
    static LinkList insertEnd(LinkList head, int data)
    {
      LinkList newLink = new LinkList(data);
      LinkList last = head;
      newLink.next = null;   // link new node to NULL as it is last node
      if (head == null)  // if list is empty add in beginning.
      {
        head = newLink;
        return head;
      }
      while (last.next != null)  // Find the last node
        last = last.next;
      last.next = newLink;  // Add the node after the last node of list
      return head;
    }
  
    public static void traverse(LinkList first)
    {
      LinkList temp = first;
      if (first != null)
      {
        // Keep printing nodes till we reach the first node again
        do
        {
          System.out.print(temp.data + " "); // print data
          temp = temp.next;
        }
        while (temp != first);
      }
    }
    public static void main(String[] args)
    {
      int t,n,m;
      Scanner s = new Scanner(System.in);
      t=Integer.parseInt(s.nextLine().trim());
      while(t>0)
      {
        LinkList head = null, t1;
        n = s.nextInt();
        while(n>0)
        {
          m = s.nextInt();
          head = insertBeg(head, m);
          n--;
        }
        t1 = Result.listCut(head);
        traverse(head);
        System.out.println();
        traverse(t1);
        System.out.println();
        t--;
      }
      s.close();
    }
  }