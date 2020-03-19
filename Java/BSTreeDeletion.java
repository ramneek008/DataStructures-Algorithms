import java.util.*;

class BSTree
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

    static Node insert(Node p,int val)
    {
        if(p==null)
        {
            Node temp = new Node(val);
            p=temp;
        }
        else if(val>p.data)
        {
            p.right=insert(p.right,val);
        }
        else
        {
            p.left=insert(p.left,val);
        }
        return p;
    } 

    static Node minValueNode(Node p)
    {
        Node temp = p;
        while(temp.left!=null)
        {
            temp=temp.left;
        }
        return temp;
    }

    static Node delete(Node p, int val)
    {
        if(p==null)
        {
            System.out.println("Node not found.");
            return p;
        }
        else if(val==p.data)
        {
            Node temp=null;
            if(p.left==null && p.right==null)
            {
                p=null;
                return p;
            }
            else if(p.right==null)
            {
                temp=p.left;
                p=null;
                return temp;
            }
            else if(p.left==null)
            {
                temp=p.right;
                p=null;
                return temp;
            }
            else
            {
                temp=minValueNode(p.right);
                p.data=temp.data;
                p.right=delete(p.right,temp.data);
                return p;
            }
        }
        else if(val>p.data)
        {
            p.right=delete(p.right,val);
        }
        else
        {
            p.left=delete(p.left,val);
        }
        return p;

    }

    static void inorder(Node p)
    {
        if(p!=null)
        {
        inorder(p.left);
        System.out.print(p.data + " ");
        inorder(p.right);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        root=insert(root,5);
        root=insert(root,3);
        root=insert(root,4);
        root=insert(root,1);
        root=insert(root,2);
        root=insert(root,6);
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        int s = sc.nextInt();
        root = delete(root,s);
        System.out.print("Inorder after deletion: ");
        inorder(root);
        System.out.println();

    }
}