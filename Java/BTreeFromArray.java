//Create a binary tree from array

import java.util.Scanner;
class Node
{
  int data; 
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


  static Node insert(int t[], Node p, int i, int len)
  {
    if(i<len)
    {
      Node temp = new Node(t[i]);
      temp.leftChild=null;
      temp.rightChild=null;
      p=temp;
      p.leftChild=insert(t,p.leftChild,(2*i)+1 , len);
      p.rightChild=insert(t,p.rightChild,(2*i)+2 , len);
    }
    return p;
  }
  
  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insert(t, node , 0 ,n);
    
    return node;
  }


  public static void main(String[] args)
  {
    int a[]=new int[10];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = Integer.parseInt(s.nextLine());
    Node root = null;
    root = buildTree(a, n);
    inOrder(root);
  }
}