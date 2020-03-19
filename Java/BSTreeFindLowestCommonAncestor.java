/*
Find a lowest common ancestor of a given two nodes in a binary search tree

The Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST) is defined as the deepest node from the root which lies in the path of both the nodes from the root.
So, given a binary search tree, find the Lowest Common Ancestor of two nodes in it.
*/

import java.util.Scanner;

 class Result {
    static int lowestCommonAncestor(Node root, int k1, int k2) {
      if(root==null)
        return -1;
      else if(root.data>k1 && root.data>k2)
        return lowestCommonAncestor(root.leftChild,k1,k2);
      else if(root.data<k1 && root.data<k2)
        return lowestCommonAncestor(root.rightChild,k1,k2);
      
      return root.data;
  
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
    n = Integer.parseInt(s.nextLine().trim());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    k1 = s.nextInt();
    k2 = s.nextInt();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    System.out.println(Result.lowestCommonAncestor(root,k1,k2));
  }
}