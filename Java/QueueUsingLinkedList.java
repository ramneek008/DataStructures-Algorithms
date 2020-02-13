import java.util.*;

class LinkList
{
    int data;
    LinkList next;
    LinkList(int d)
    {
        data=d;
        next=null;
    }
}

class LinkQueue
{
    LinkList first,rear;
    public LinkQueue()
    {
        first=null;
        rear=null;
    }
    public void enqueue(int d)
    {
        LinkList list = new LinkList(d);
        if(first==null)
        {
            list.next=first;
            first=list;
            rear=list;
        }
        else
        {
            rear.next=list;
            rear=list;
        }
        System.out.println(d + " enqued to queue");
    }

    public int dequeue()
    {
        if(first==null)
        {
            System.out.println("Underflow");
            return -1;
        }
        else if(first==rear)
        {
            first=null;
            rear=null;
            System.out.println("Queue is emptied");
            return -1;
        }
        else
        {
            LinkList temp = first;
            first=first.next;
            System.out.println(temp.data + " dequeued from queue");
            return temp.data;
        }
    }

}

class Main
{
    public static void main(String args[])
    {
    LinkQueue lq = new LinkQueue();
    lq.enqueue(11);
    lq.enqueue(12);
    lq.dequeue();
    lq.enqueue(13);
    lq.enqueue(14);
    lq.dequeue();
    }

}