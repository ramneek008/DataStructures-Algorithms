// Given two array representing the inorder and postorder traversal of a binary tree, construct the tree and print the preorder of it.

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

class Result
{
  static int postIndex;
  static Node buildTree(int in[], int post[], int N)
  {
    postIndex = N-1;
    Node root = tree(in, post, 0, N-1);
    return root;

  }
  
  static Node tree(int in[], int post[], int inStrt, int inEnd)
  {
    if(inStrt>inEnd)
      return null;
    
    Node node = new Node(post[postIndex]);
    postIndex--;
    
    if(inStrt == inEnd)
      return node;
    
    int iIndex = search(in, inStrt, inEnd, node.data);
    
    node.rightChild = tree(in, post, iIndex+1, inEnd);
    node.leftChild = tree(in,post,inStrt,iIndex-1);
    
    return node;
  }
  
  static int search(int arr[], int strt, int end, int val)
  {
    int i;
    for(i=strt;i<=end;i++)
    {
      if(arr[i]==val)
        break;
    }
    return i;
  }
}

class Main
{
  static void preOrder(Node root)
  {
    if (root != null)
    {
      System.out.print(root.data + " ");
      preOrder(root.leftChild);
      preOrder(root.rightChild);
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
  public static void main(String[] args)
  {
    int a[]=new int[10];
    int b[]=new int[10];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine().trim());
    for(i=0;i<n;i++)
      a[i] = Integer.parseInt(s.nextLine().trim());
    for(i=0;i<n;i++)
      b[i] = Integer.parseInt(s.nextLine().trim());
    Node root = null;
    if(n!=0)
      root = Result.buildTree(a, b, n);
    preOrder(root);
  }
}