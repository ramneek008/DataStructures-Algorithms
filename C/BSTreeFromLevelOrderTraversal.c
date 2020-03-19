//Given an array of integer elements representing the level order traversal of a binary search tree, create the binary search tree from this array.


#include<stdio.h>
#include<stdlib.h>

struct Node
{
  int data;
  struct Node *left, *right;
};

struct Node* newNode(int data)
{
  struct Node* node = (struct Node*)malloc(sizeof(struct Node));
  node->data = data;
  node->left = node->right = NULL;
  return (node);
}

void inOrder(struct Node* root)
{
  if (root != NULL)
  {
    inOrder(root->left);
    printf("%d ", root->data);
    inOrder(root->right);
  }
}


struct Node* insert(struct Node* p,int val)
{
  if(p==NULL)
  {
    p=newNode(val);
  }
  else if(val<p->data)
  {
    p->left=insert(p->left,val);
  }
  else
  {
    p->right = insert(p->right,val);
  }
  return p;
}
struct Node* buildSearchTree(int t[], int n)
{
    struct Node* root = NULL;
    // Complete the function body.
  for(int i=0;i<n;i++)
  {
    root=insert(root,t[i]);
  }

    return(root);
}




int main()
{
  int a[50], n, i, k;
  scanf("%d", &n);
  for(i=0;i<n;i++)
    scanf("%d", &a[i]);
  struct Node* root = NULL;
  root = buildSearchTree(a, n);
  inOrder(root);
  return 0;
}
