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

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }


  static void printAllPaths(Node root) 
  {
    int path[] = new int[1000];
    printPathsRecur(root,path,0);
    if(count>0)
    System.out.println(count);
  }
static int count=0;
static void printPathsRecur(Node p, int path[], int len)
{
  if(p == null)
    return ;
  
  path[len] = p.data;
  len++;
  
  if(p.leftChild == null && p.rightChild == null)
  {
    printArray(path,len);
    count++;
  }
  else
  {
    printPathsRecur(p.leftChild, path,len);
    printPathsRecur(p.rightChild, path, len);
  }
}

static void printArray(int path[], int len)
{
  int i;
  for(i=0;i<len;i++)
  {
    System.out.print(path[i]+" ");
  }
  System.out.println(i-1);
}

public static void main(String[] args)
  {
    int a[]=new int[10];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine().trim());
    for(i=0;i<n;i++)
      a[i] = Integer.parseInt(s.nextLine().trim());
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    printAllPaths(root);
  }
}