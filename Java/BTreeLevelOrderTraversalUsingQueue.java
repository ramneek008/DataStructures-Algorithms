
import java.util.Queue;
import java.util.LinkedList;

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

    static void printLevelOrder(Node p)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(p);

        while(!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            
            if(temp.left!=null)
            q.add(temp.left);

            if(temp.right!=null);
            q.add(temp.right);

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

