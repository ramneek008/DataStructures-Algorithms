//Given a binary search tree and a number k, print the kth smallest number in tree.


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


static int a[10], i=0;
void inorder(struct Node* t1)
{
  if(t1!=NULL)
  {
    inorder(t1->left);
    a[i++]=t1->data;
    inorder(t1->right);
  }
}

int kSmallest(struct Node* t1, int k)
{
  i=0;
  inorder(t1);
  return a[k-1];

}


int main()
{
  int a[10], n, i, k;
  scanf("%d", &n);
  for(i=0;i<n;i++)
    scanf("%d", &a[i]);
  scanf("%d", &k);
  struct Node* root = NULL;
  root = buildTree(a, n);
  printf("%d", kSmallest(root, k));
  return 0;
}
