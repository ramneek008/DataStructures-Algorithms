//Given a binary tree check if it is binary search tree or not.

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

struct Node* insertLevelOrder(int arr[], struct Node* root, int i, int n)
{
  if (i < n)
  {
    struct Node* temp = newNode(arr[i]);
    root = temp;

    root->left = insertLevelOrder(arr, root->left, 2 * i + 1, n);

    root->right = insertLevelOrder(arr, root->right, 2 * i + 2, n);
  }
  return root;
}

struct Node* buildTree(int t[], int n)
{
  struct Node* root = (struct Node*)malloc(sizeof(struct Node));
  root = insertLevelOrder(t, root, 0, n);
  return(root);
}


static int a[10],i=0;

void inorder(struct Node* p)
{
  if(p!=NULL)
  {
    inorder(p->left);
    a[i++]=p->data;
    inorder(p->right);
  }
}

int isBinarySearchTree(struct Node* t1)
{
  inorder(t1);
  for(int j=0;j<i-1;j++)
  {
    if(a[j]>a[j+1])
    {
      return 0;
    }
  }
  return 1;

}




int main()
{
  int a[10], n, i;
  scanf("%d", &n);
  for(i=0;i<n;i++)
    scanf("%d", &a[i]);
  struct Node* root = NULL;
  root = buildTree(a, n);
  printf("%d", isBinarySearchTree(root));
  return 0;
}
