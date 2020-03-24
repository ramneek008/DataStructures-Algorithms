
import java.util.*;

class BTree
{
    static class Node
    {
        int data;
        Node left,right;
        Node(int val)
        {
            data=val;
            left=null;
            right=null;
        }
    }

    static void printLevelOrder(Node root)
    {
        ArrayDeque<Node> q = new ArrayDeque<Node>();
    Node temp = root;

    while(temp != null)
    {
      System.out.print(temp.data + " ");

      if (temp.left != null)   
        q.add(temp.left);

      if (temp.right != null)  
        q.add(temp.right);

      temp = q.poll();
    }
}

    public static void main(String args[])
    {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        printLevelOrder(root);
    }
}

