
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

    static void inorder(Node p)
    {
        if(p!=null)
        {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    static void preorder(Node p)
    {
        if(p!=null)
        {
            System.out.print(p.data+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    static void postorder(Node p)
    {
        if(p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data+" ");
        }
    } 

    public static void main(String args[])
    {
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
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorder(root);
        
    }


 }


