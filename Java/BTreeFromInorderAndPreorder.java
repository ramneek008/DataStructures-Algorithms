//Construct tree from given inorder and post order traversal


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


 class Index { 
    int index; 
} 

class Result
{
  static Node buildTree(int in[], int post[], int N)
  {
    Index pindex = new Index();
    pindex.index=N-1;
    Node p = tree(in, post, 0, N-1, pindex);
    return p;
  }
  
  static Node tree(int in[], int post[], int instart, int inend, Index pindex)
  {
    if(instart>inend)
      return null;
    
    Node temp = new Node(post[pindex.index]);
    (pindex.index)--;
    
    if(instart==inend)
      return temp;
    
    int inindex = search(in, instart, inend, temp.data);
    
    temp.rightChild = tree(in, post, inindex+1, inend, pindex);
    temp.leftChild = tree(in, post, instart, inindex-1, pindex);
    
    return temp;
  }
  
  static int search(int in[], int start, int end, int value)
  {
    int i;
    for(i=start;i<=end;i++)
    {
      if(in[i]==value)
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