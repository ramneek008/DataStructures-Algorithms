#include <stdio.h>
#include <stdlib.h>

struct BTree
{
    int data;
    struct BTree *left;
    struct BTree *right;
};

struct BTree *newtree(int val)
{
    struct BTree *temp = (struct BTree*)malloc(sizeof(struct BTree));
    temp->data=val;
    temp->left=NULL;
    temp->right=NULL;
    return temp;
}

int main()
{
    struct BTree *root = newtree(0);
    root->left=newtree(1);
    root->right=newtree(2);
    root->left->left=newtree(3);
    root->left->right=newtree(4);
    printf("Root node is: %d\n",root->data);
    printf("Left of root is: %d\n",root->left->data);
    printf("Right of root is: %d\n",root->right->data);
    printf("Left of left of root is: %d\n",root->left->left->data);
    printf("Right of left of root is: %d\n",root->left->right->data);
}