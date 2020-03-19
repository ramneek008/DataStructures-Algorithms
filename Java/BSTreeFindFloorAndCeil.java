/*
Find the floor and ceil of a key in binary search tree

Given a binary search tree, find the floor and ceil of an key in the tree. They are defined as below:

floor value of k: largest node value which is smaller than or equal to k.
ceil value of k: smallest node value which is greater than or equal to k.
*/


import java.util.Scanner;


 class Result {
    static int a[] = new int[30], i=0;
    static void inorder(Node p)
    {
      if(p!=null)
      {
      inorder(p.leftChild);
      a[i++]=p.data;
      inorder(p.rightChild);
      }
    }
    static int floorOf(Node root, int key) {
      inorder(root);
      int res=-1;
      for(int j=0;j<i;j++)
      {
        if(a[j]<=key)
          res=a[j];
      }
      return res;
    }
  
    static int ceilOf(Node root, int key) {
      inorder(root);
      int res=-1;
      for(int j=0;j<i;j++)
      {
        if(a[j]>=key)
        {  res=a[j];
        break;
        }
      }
      return res;
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
  public static void main(String[] args)
  {
    int a[]=new int[50];
    int n, m, i, k1, k2;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    k1 = s.nextInt();
    Node root = null;
    if(n>0)
      root = buildTree(a, n);
    System.out.println(Result.floorOf(root, k1) + " " + Result.ceilOf(root, k1));
  }
}