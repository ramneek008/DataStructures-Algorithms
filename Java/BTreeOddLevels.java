//Print nodes at odd levels of the binary tree


import java.util.Scanner;

class Result {
    static void printOdd(Node root) {
      int h = height(root);
      for(int i=1;i<=h;i+=2)
      {
        printGivenLevel(root,i);
      }
    }
    
    static int height(Node p)
    {
      if(p==null)
        return 0;
      else
      {
        int lheight = height(p.leftChild);
        int rheight = height(p.rightChild);
        
        if(lheight>rheight)
          return (lheight+1);
        else
          return (rheight+1);
      }
    }
    
    static void printGivenLevel(Node p, int level)
    {
      if(p==null)
        return ;
      if(level==1)
        System.out.print(p.data + " ");
      else if(level>1)
      {
        printGivenLevel(p.leftChild,level-1);
        printGivenLevel(p.rightChild,level-1);
      }
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
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine().trim());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    Result.printOdd(root);
  }
}