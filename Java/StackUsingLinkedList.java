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

class LinkStack
{
    LinkList first;
    public LinkStack()
    {
        first=null;
    }

    public boolean isEmpty()
    {
        return (first==null);
    }
    
    public void push(int d)
    {
        LinkList list = new LinkList(d);
        list.next=first;
        first=list;
        System.out.println(d+ "pushed to stack");
    }

    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Underflow");
            return -1;
        }
        else{
            LinkList temp =  first;
            first = first.next;
            System.out.println(temp.data + "popped from stack");
            return temp.data;
        }

    }
}

class Main
{
    public static void main(String args[])
    {
        LinkStack theStack = new LinkStack();
        theStack.push(1);
        theStack.push(2);
        theStack.pop();
        theStack.push(3);
        theStack.push(4);
        theStack.pop();
    
    }
}