//Given a binary tree check if it is binary search tree or not.


import java.util.Scanner;

 class Result {
    static int a[]=new int[10];
    static int i=0;
    static void inorder(Node p)
    {
      if(p!=null)
      {
        inorder(p.leftChild);
        a[i++]=p.data;
        inorder(p.rightChild);
      }
    }
    static int isBinarySearchTree(Node t1) {
      inorder(t1);
      for(int j=0;j<i-1;j++)
      {
        if(a[j]>a[j+1])
          return 0;
          
      }
      return 1;
    }
  }


class Node {
    int data; // data used as key value
    Node leftChild;
    Node rightChild;
    public Node()  {
      data=0;
    }
    public Node(int d)  {
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
      int a[]=new int[10];
      int n, m, i;
      Scanner s=new Scanner(System.in);
      n = Integer.parseInt(s.nextLine());
      for(i=0;i<n;i++)
        a[i] = s.nextInt();
      Node root = null;
      if(n!=0)
        root = buildTree(a, n);
      System.out.println(Result.isBinarySearchTree(root));
    }
  }