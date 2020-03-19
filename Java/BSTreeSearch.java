
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

   static int search(Node p,int s)
   {
       if(p==null)
       return 0;
       else if(p.data==s)
       {
       return 1;
       }
       else if(s>p.data)
       {
           return search(p.right,s);
       }
       else
       {
           return search(p.left,s);
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
       int x= search(root,s);
       if(x==1)
       System.out.println(s+ " found");
       else
       System.out.println(s+ " not found");

       
   }


}


