import java.util.*;

class Tree
{

    static class Node
    {
        int data;
        Node child1, child2, child3;
        Node(int val)
        {
            data=val;
        }
    }

    public static void main(String args[])
    {
        Node root = new Node(0);
        root.child1 = new Node(1);
        root.child2 = new Node(2);
        root.child3 = new Node(3);
        System.out.println("Root node is: " + root.data);
        System.out.println("Child1 is: " + root.child1.data);
        System.out.println("Child2 is: " + root.child2.data);
        System.out.println("Child3 is: " + root.child3.data);
    }
}