//Given an array of integer elements representing the level order traversal of a binary search tree, create the binary search tree from this array.


import java.util.Scanner;

 class Result {
    static Node insert(Node p,int val)
    {
      if(p==null)
      {
        Node temp = new Node(val);
        temp.leftChild=null;
        temp.rightChild=null;
        p=temp;
      }
      else if(val>p.data)
        p.rightChild=insert(p.rightChild,val);
      else
        p.leftChild=insert(p.leftChild,val);
      return p;
    }
    static Node buildSearchTree(int t[], int n) {
      Node root = null;
      // Complete the function body.
      for(int i=0;i<n;i++)
      {
        root=insert(root,t[i]);
      }
  
      return(root);
    }
  }

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
  public static void main(String[] args)
  {
    int a[]=new int[50];
    int n, m, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    Node root = null;
    if(n!=0)
      root = Result.buildSearchTree(a, n);
    inOrder(root);
  }
}