//Given a binary search tree and a number k, print the kth smallest number in tree.

import java.util.Scanner;
class Node
{
  int data; // data used as key value
  Node leftChild;
  Node rightChild;
  public Node()
  {
    data=0;
  }
  public Node(int d)
  {
    data=d;
  }
}

class Main
{
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
  static Node insertLevelOrder(int arr[], Node root, int i, int n)
  {
    if (i < n)
    {
      Node temp = new Node(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }

  
 static int a[] = new int[10], i=0;
 static void inorder(Node p)
 {
   if(p!=null)
   {
     inorder(p.leftChild);
     a[i++]=p.data;
     inorder(p.rightChild);
   }
 }
 
   static int kSmallest(Node t1, int k)
 {
     inorder(t1);
     if(k==0)
     return a[k];
     else
       return a[k-1];
 
 }

  public static void main(String[] args)
  {
    int a[]=new int[10];
    int n, m, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = Integer.parseInt(s.nextLine());
    i = Integer.parseInt(s.nextLine());
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    System.out.println(kSmallest(root, i));
  }
}